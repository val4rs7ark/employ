package com.basic.emp.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import lombok.Data;

@Data
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
//로그인 성공 시 실행되는 시큐리티-라이프사이클
	Logger logger = Logger.getLogger(AuthenticationSuccessHandlerImpl.class);
    private String userId;
    private String defaultUrl = "main?succ";
    
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		clearAuthenticationAttributes(request);
		resultRedirectStrategy(request, response, authentication);

	}
	
	/**
	 * 로그인을 성공했으니 에러 세션을 지운다.
	 */
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        if(session==null) return;
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);//로그인 실패 시 저장되는 세션이름
	}

	/**
	 * 먼저 인증 권한이 필요한 페이지에 접근하게 되면, 로그인 화면을 띄우기 전에 필요한 정보들을 세션에 저장하게 된다
	 * 이 때 사용자의 요청을 저장하고 꺼낼 수 있는 RequestCache-interface 를 이용해
	 * 사용자 요청 정보들이 들어 있는 SavedRequest 클래스 객체를 세션에 저장하게 된다.
	 * 즉 직접 로그인 페이지로 접근했을 때는 세션에 저장되지 않기 때문에 null로 분기가 가능하다.
	 */
	 protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
	            Authentication authentication) throws IOException, ServletException {
	        
	        SavedRequest savedRequest = requestCache.getRequest(request, response);
	        
	        Collection<? extends GrantedAuthority> collGranted = authentication.getAuthorities();
        	Iterator it = collGranted.iterator();
        	String authority = null;
        	while(it.hasNext()) {
        		authority = it.next().toString();
        		logger.info("***************************** 권한 --> "+authority);
        		HttpSession session = request.getSession(true);
        		session.setAttribute("s_userLVL", authority);
        		logger.info("***************************** 세션에 담은 s_userLVL --> "+session.getAttribute("s_userLVL"));
        	}
	        
	        if(savedRequest!=null) {//null로 분기하여 url을 분기 또 여기서 권한에 따른 url분기도 가능하다
	            String targetUrl = savedRequest.getRedirectUrl();
	            //redirectStratgy.sendRedirect(request, response, targetUrl); <<<< targetUrl을 쓰면 가려던 곳으로
	            redirectStratgy.sendRedirect(request, response, defaultUrl);
	        } else {
	            redirectStratgy.sendRedirect(request, response, defaultUrl);
	        }
	        
	}

}
