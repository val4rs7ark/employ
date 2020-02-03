package com.basic.emp.dao;

import com.basic.emp.security.UserDetailsImpl;

public interface UserAuthDAO {

	public UserDetailsImpl getUserById(String member_id);
}
