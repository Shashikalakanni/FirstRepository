package com.jsp.tmr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.tmr.entities.UserEntity;
import com.jsp.tmr.service.UserServiceDeclaration;
@CrossOrigin
@RestController
public class UserController 
{
	@Autowired
	UserServiceDeclaration usd;
	
	@PostMapping("/saveuserdata")
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity uEntity)
	{
		return new ResponseEntity<UserEntity>(usd.saveUser(uEntity),HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<Object>login(@RequestHeader String usernameorEmail,@RequestHeader String password)
	{
		Object object=usd.login(usernameorEmail, password);
		if(object instanceof UserEntity)
		{
			
			return ResponseEntity.status(200).body(usd.login(usernameorEmail, password));
		}
		return ResponseEntity.status(400).body(usd.login(usernameorEmail, password));
	}
	

}
