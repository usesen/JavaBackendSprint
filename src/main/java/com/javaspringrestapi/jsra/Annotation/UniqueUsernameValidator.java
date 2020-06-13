package com.javaspringrestapi.jsra.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.springframework.beans.factory.annotation.Autowired;

import com.javaspringrestapi.jsra.DataAccess.UserRepository;
import com.javaspringrestapi.jsra.Entities.User;


public class UniqueUsernameValidator implements ConstraintValidator<UniqUsername, String>{
     
     @Autowired
     UserRepository userRepository;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
	
		   try {
				User user = userRepository.findByUsername(username);
				 
				if(user != null) {
					return false;
				}
			
		    }
		    catch (Exception e){

		    }
		 
		   return true;
	}
}
