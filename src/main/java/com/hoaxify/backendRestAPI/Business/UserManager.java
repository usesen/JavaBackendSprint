package com.hoaxify.backendRestAPI.Business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hoaxify.backendRestAPI.DataAccess.IUserDal;
import com.hoaxify.backendRestAPI.Entities.User;


public class UserManager implements IUserService{

	private IUserDal userDal;
	
	public UserManager(IUserDal userDal) {
		this.userDal = userDal;
	}

	@Override
	@Transactional
	public List<User> GetAll() {
		// TODO Auto-generated method stub
		return this.userDal.GetAll();
	}

	@Override
	public void add(User user) {
		//Business code'ları burada yazılır
		 this.userDal.add(user);
		
	}

	@Override
	public void update(User user) {
		 
		 this.userDal.update(user);
	}

	@Override
	public void delete(User user) {
		this.userDal.update(delete);
	}

	@Override
	public User getById(int id) {
	 
		return this.cityDal.getById(id);
	}

}
