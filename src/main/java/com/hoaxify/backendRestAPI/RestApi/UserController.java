package com.hoaxify.backendRestAPI.RestApi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.backendRestAPI.Business.IUserService;
import com.hoaxify.backendRestAPI.Entities.User;

 

@RestController
@RequestMapping("/api")
public class UserController {
   
	private IUserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	//@PostMapping("/api/users")
	//public void createUser(@RequestBody User user  ) {
	//	log.info(user.toString());
	//}
	
	@Autowired
	public UserController(IUserService userService) {
	 
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> get(){
	 return userService.GetAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody User user){
	  userService.add(user);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody User user){
	  userService.update(user);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody User user){
	   userService.delete(user);
	}
	
	@GetMapping("/users/{id}")
	public User getById(@PathVariable int id){
	 return userService.getById(id);
	}
	
	
	@GetMapping("/test")
	public String test(){
	 return "API Test çalışıyor";
	}
}
