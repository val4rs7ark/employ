package com.basic.emp.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationProviderImpl implements AuthenticationProvider {
//로그인 시도한 계정의 권한을 확인해야 할 때 불려지는 시큐리티-라이프사이클
//이 때 로그인 시도한 id가 db에 있는지 확인하기 때문에 여기서 UserDetailsService를 부른다
	private Logger logger = Logger.getLogger(AuthenticationProviderImpl.class); 

	@Autowired
    private UserDetailsServiceImpl userDeSer;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String member_id = (String) authentication.getPrincipal(); //화면에서 유저가 입력한 id
        String member_pw = (String) authentication.getCredentials(); //화면에서 유저가 입력한 pw
        logger.info("*********************** Authentication.getCredentials 으로 받아오는 패스워드 --> "+member_pw);
        UserDetailsImpl member = (UserDetailsImpl) userDeSer.loadUserByUsername(member_id); // 화면에서 유저가 입력한 id로 vo생성
        
        if(!matchPassword(member_pw, member.getPassword())) {
            throw new BadCredentialsException(member_id);//비밀번호 불일치
        }
 
        if(!member.isEnabled()) {
            throw new DisabledException(member_id);//계정 비활성화
        }

		return new UsernamePasswordAuthenticationToken(member_id, member_pw, member.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }

}
