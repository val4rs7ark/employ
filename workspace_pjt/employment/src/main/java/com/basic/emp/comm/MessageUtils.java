package com.basic.emp.comm;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class MessageUtils {
    private static MessageSourceAccessor msAcc = null;
    
	public void setMessageSourceAccessor(MessageSourceAccessor msAcc) {
		MessageUtils.msAcc = msAcc;
	}
	
	public static String getMessage(String code) {
		return msAcc.getMessage(code, Locale.getDefault());
		//   HttpServletRequest httpRequest =
		//((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// return msAcc.getMessage(code, httpRequest.getLocale());
	}
	
	public static String getMessage(String code, Object[] objs) {
		return msAcc.getMessage(code, objs, Locale.getDefault());
	}
}
