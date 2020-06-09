package com.hoaxify.backendRestAPI.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.hoaxify.backendRestAPI.Entities.User;
import com.javacourse.project.hibernateAndJpa.Entities.City;

public class UserDal implements IUserDal {

	private EntityManager entityManager;
	
	public UserDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// AOP -Aspect Oriented Programing
	@Override
	@Transactional
	public List<User> GetAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		List<User> users = session.createQuery("from Users",User.class).getResultList();
		return users;
	}

	@Override
	public void add(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
		
	}

	@Override
	public void update(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
		
	}

	@Override
	public void delete(User user) {
		Session session = entityManager.unwrap(Session.class);
		User userToDelete = session.get(User.class, user.getId());
		session.delete(userToDelete);
		
	}

	@Override
	public User getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

}
