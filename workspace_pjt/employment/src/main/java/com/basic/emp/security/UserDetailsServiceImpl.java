package com.basic.emp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.basic.emp.dao.UserAuthDAO;

public class UserDetailsServiceImpl implements UserDetailsService {
//실질적으로 db에 있는 id인지 체크하는 곳. 있는 계정이라면 UserDetails(유저vo)를 리턴한다
	@Autowired 
	UserAuthDAO userAuthDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl member = userAuthDAO.getUserById(username); // 화면에서 사용자가 입력한 id로 vo생성
		if(member==null) {
			throw new InternalAuthenticationServiceException(username);
		}
		return member;
	}

}
