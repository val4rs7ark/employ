package com.basic.emp.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.basic.emp.service.BoardService;

public class HandlerInterceptorImpl implements HandlerInterceptor {
	private Logger logger = Logger.getLogger(HandlerInterceptorImpl.class);
	@Autowired
	BoardService boardService;
	
	// controller로 보내기 전에 처리하는 인터셉터
	// 반환이 false라면 controller로 요청을 안함
	// 매개변수 Object는 핸들러 정보를 의미한다. ( RequestMapping , DefaultServletHandler ) 
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		return true;
	}

	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav)
			throws Exception {
		logger.info("++++++++++++++++postHandle+++++++++++++++++");
		List<Map<String,Object>> menuList = boardService.getMyMenu();
		if(menuList != null && mav != null) {
			mav.addObject("menuList", menuList);
		}
		String uri = request.getRequestURI();
		if("/main".equals(uri)) {
			List<List<Map<String, Object>>> mainList = boardService.getMainList();
			mav.addObject("mainList",mainList);
		}
	}

	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, Exception e)
			throws Exception {
	}
}
