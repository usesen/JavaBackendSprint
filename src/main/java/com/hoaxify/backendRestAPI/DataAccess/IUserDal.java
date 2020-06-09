package com.hoaxify.backendRestAPI.DataAccess;

import java.util.List;

import com.hoaxify.backendRestAPI.Entities.User;
 

public interface IUserDal {
	List<User> GetAll();
	void add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
}
