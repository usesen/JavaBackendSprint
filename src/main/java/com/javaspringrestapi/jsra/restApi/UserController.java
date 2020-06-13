package com.javaspringrestapi.jsra.restApi;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
 
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringrestapi.jsra.ApiError.ApiError;
import com.javaspringrestapi.jsra.Business.UserManager;
import com.javaspringrestapi.jsra.Entities.User;
import com.javaspringrestapi.jsra.shared.GenericResponse;


@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserManager userManager;

	public UserController(UserManager userManager) {
	
		this.userManager = userManager;
	}
	
	@GetMapping("/users")
	public List<User> get(){
	 return userManager.GetAll();
	}
	
	@PostMapping("/add")
	public GenericResponse add(@Valid @RequestBody User user)throws EntityNotFoundException {
	 
	  userManager.add(user);
	  return new GenericResponse("user created");
	 
	}
	
	@PostMapping("/update")
	public void update(@RequestBody User user){
		userManager.update(user);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody User user){
		userManager.delete(user);
	}
	
	@GetMapping("/users/{id}")
	public User getById(@PathVariable int id){
	 return userManager.getById(id);
	}
	
	
	@GetMapping("/test")
	public String test(){
	 return "API Test çalışıyor";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleValidationException(MethodArgumentNotValidException exception) {
		ApiError error = new ApiError(400,"Validation error","Api/Add");
		Map<String,String> validationErrors = new HashMap<>();
		for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validationErrors);
		return error;
	}
}