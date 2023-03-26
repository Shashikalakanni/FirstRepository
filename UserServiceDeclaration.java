package com.jsp.tmr.service;

import com.jsp.tmr.entities.UserEntity;

public interface UserServiceDeclaration 
{
	public UserEntity saveUser(UserEntity userEntity);
	
	public Object login(String UsernameorEmail, String password);

}
