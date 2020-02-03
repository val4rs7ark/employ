package com.basic.emp.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({
	@Signature(type = Executor.class, method = "update", args ={MappedStatement.class, Object.class}),
	@Signature(type = Executor.class, method = "query", args ={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
	@Signature(type = Executor.class, method = "query", args ={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class MybatisLogInterceptor implements Interceptor {

	private static final Logger logger = LoggerFactory.getLogger("mybatis.log");

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement)args[0];

        logger.info("=====================================================================");
        logger.info(ms.getId());
        logger.info("=====================================================================");

		return invocation.proceed(); // 쿼리 실행
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

	private List<Object> getColumnValues(StatementHandler handler, BoundSql boundSql) {
		List<Object> columnValues = new ArrayList<Object>();
		Object parameter = handler.getParameterHandler().getParameterObject();
		List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();

		for(int i = 0;i<parameterMappingList.size();i++) {
			try {
				if(PropertyUtils.isReadable(parameter, parameterMappingList.get(i).getProperty())) {
					Object column = PropertyUtils.getProperty(parameter, parameterMappingList.get(i).getProperty());
					columnValues.add(column);
				} else {
					if(parameter instanceof Map) {
						columnValues.add( ((Map<?, ?>) parameter).get(parameterMappingList.get(i).getProperty()) );
					} else {
						columnValues.add(parameter);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return columnValues;
	}

	private Object[] getTypes(List<Object> columnValues) {
		Object[] object = new Object[columnValues.size()];
		for(int i = 0; i < columnValues.size(); i++) {
	    	object[i] = columnValues.get(i);
	    }
	    return object;
	}    

	private String getSql(String sqlStr, Object[] items) {
		int seq = 0;
		StringBuffer buf = new StringBuffer();
		int i;

		while ((i = sqlStr.indexOf("?")) >= 0) {
			if(seq == items.length) break; 

			buf.append(sqlStr.substring(0, i));

			if (items[seq] instanceof String) {
 				buf.append("'" + items[seq] + "'");
			} else if (items[seq] instanceof Integer) {
				buf.append(items[seq]);
			} else if (items[seq] instanceof Long) {
				buf.append(items[seq]);
			} else if (items[seq] == null) {
				buf.append("null");
			} else {
				buf.append(items[seq]);
			}

			sqlStr = sqlStr.substring(i + "?".length());

			seq++;
		}
		buf.append(sqlStr);
		return buf.toString();
	}
}
