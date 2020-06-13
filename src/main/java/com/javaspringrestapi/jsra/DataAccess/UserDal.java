package com.javaspringrestapi.jsra.DataAccess;


import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaspringrestapi.jsra.Entities.User;

@Repository
public class UserDal implements IUserDal {

	private EntityManager entityManager;
	
	@Autowired 
	public UserDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// AOP -Aspect Oriented Programing
	@Override
	@Transactional
	public List<User> GetAll() {

		Session session = entityManager.unwrap(Session.class);
		List<User> users = session.createQuery("from User",User.class).getResultList();
		return users;
	}

	@Override
	@Transactional
	public void add(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
		
	}

	@Override
	@Transactional
	public void delete(User user) {
		Session session = entityManager.unwrap(Session.class);
		User userToDelete = session.get(User.class, user.getId());
		session.delete(userToDelete);
		
	}

	@Override
	@Transactional
	public User getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}
 

}
