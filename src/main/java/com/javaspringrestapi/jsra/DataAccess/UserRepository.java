package com.javaspringrestapi.jsra.DataAccess;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringrestapi.jsra.Entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

 
	User findByUsername(String username);

}

 