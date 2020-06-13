package com.javaspringrestapi.jsra.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.javaspringrestapi.jsra.Annotation.UniqUsername;

//import lombok.Data;

@Entity
@Table(name = "User")
public class User{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@NotNull(message = "{hoaxify.constraints.username.NotNull.message}")
	@Size(min = 4, max=255)
	@UniqUsername
	private String username;
	
	
	@Size(min = 4, max=255)
	@NotNull
	private String displayname;
	
	@NotNull
	@Size(min = 8, max=255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="{Şifre büyük ve küçük harfler , sayıdan oluşmalı}")
	private String password;

	public User(int id, String username, String displayname, String password) {
		super();
		this.id = id;
		this.username = username;
		this.displayname = displayname;
		this.password = password;
	}
	
	public User() {	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}