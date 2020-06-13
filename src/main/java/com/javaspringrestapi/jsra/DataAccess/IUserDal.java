package com.javaspringrestapi.jsra.DataAccess;

import java.util.List;


import com.javaspringrestapi.jsra.Entities.User;


public interface IUserDal {
	List<User> GetAll();
	void add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
	 
}