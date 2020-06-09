package com.hoaxify.backendRestAPI.Business;

import java.util.List;

import com.hoaxify.backendRestAPI.Entities.User;

public interface IUserService {

	List<User> GetAll();
	void add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
}
