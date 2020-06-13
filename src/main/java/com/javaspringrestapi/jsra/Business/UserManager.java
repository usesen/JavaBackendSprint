package com.javaspringrestapi.jsra.Business;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaspringrestapi.jsra.DataAccess.IUserDal;
import com.javaspringrestapi.jsra.Entities.User;
 


@Service
public class UserManager implements IUserService {

	private IUserDal userDal;
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public UserManager(IUserDal userDal) {
		this.userDal = userDal;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
 
	@Override
	@Transactional
	public List<User> GetAll() {
		return this.userDal.GetAll();
	}

	@Override
	@Transactional
	public void add(User user) {
		//Business code'ları burada yazılır
		String encryptedPassword = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		this.userDal.add(user);
				
	}

	@Override
	@Transactional
	public void update(User user) {
		 this.userDal.update(user);
		
	}

	@Override
	@Transactional
	public void delete(User user) {
		 this.userDal.delete(user);
		
	}

	@Override
	@Transactional
	public User getById(int id) {
		return this.userDal.getById(id);
	}
 
	
}