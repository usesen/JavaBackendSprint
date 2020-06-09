package com.hoaxify.backendRestAPI.Entities;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
    private String username;
    
	@Column(name="displayName")
    private String displayName;
    
	@Column(name="password")
    private String password;
    
	public User(int id, String username, String displayName, String password) {
		super();
		this.id = id;
		this.username = username;
		this.displayName = displayName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", displayName=" + displayName + ", password=" + password
				+ "]";
	}

	public int getId() {
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
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
}
