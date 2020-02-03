package com.basic.emp.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Data;
import com.basic.emp.comm.MessageUtils;

@Data
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
//로그인 실패 시 실행되는 시큐리티-라이프사이클	
    private String userId;
    private String userPw;
    private String errormsg;
    private String defaultFailureUrl;
    
    @Autowired
    MessageUtils MessageUtils;
    
	@SuppressWarnings("static-access")
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

        String username = request.getParameter("userId");
        String password = request.getParameter("userPw");
        String errormsg = null;
        
        if(exception instanceof AuthenticationCredentialsNotFoundException) {//계정 인증토큰 없음
            errormsg = MessageUtils.getMessage("error.AuthenticationCredentialsNotFound");
        } else if(exception instanceof InternalAuthenticationServiceException) {// 계정 없음
            errormsg = MessageUtils.getMessage("error.InternalAuthenticationService");
        } else if(exception instanceof DisabledException) {// 계정 비활성화
            errormsg = MessageUtils.getMessage("error.Disaled");
        } else if(exception instanceof BadCredentialsException) {// 비밀번호 불일치
            errormsg = MessageUtils.getMessage("error.BadCredentials");
        }
        
        request.setAttribute("userId", username);
        request.setAttribute("userPw", password);
        request.setAttribute("errormsg", errormsg);
 
        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);

	}

}
