package com.jsp.tmr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.tmr.dao.UserRepository;
import com.jsp.tmr.entities.UserEntity;
import com.jsp.tmr.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImplementation implements UserServiceDeclaration
{
	@Autowired
	UserRepository repo;

	@Override
	public UserEntity saveUser(UserEntity userEntity) 
	{
		return repo.save(userEntity);
	}

	@Override
	public Object login(String UsernameorEmail, String password) 
	{
		UserEntity user=repo.findByuserNameorEmail(UsernameorEmail, UsernameorEmail);
		if(user!=null)
		{
			if(password.equals(user.getPassword()))
			{
				return user;
			}
			else 
			{
				try
				{
					throw new ResourceNotFoundException("Error 404: the given password ", password," is incorrect or you have not entered any password");
				}
				catch(ResourceNotFoundException e)
				{
					System.out.println(e);
					return e.getMessage();
				}
			}
		}	
		else 
		{
			try
			{
				throw new ResourceNotFoundException("Error 404: the given Username or Email ", UsernameorEmail," is incorrect or you have not entered any Username or Email" );
			}
			catch (ResourceNotFoundException e) 
			{
				System.out.println(e);
				return e.getMessage();
			}
			
		}
		
	}

}
