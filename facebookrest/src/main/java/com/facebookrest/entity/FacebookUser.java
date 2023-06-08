package com.facebookrest.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facebookrestservice")
*/
public class FacebookUser {

	@NotNull
	@Size(min = 3 , max = 10 ,message = "Name should be atleast 3 characre long and max length should be 10 character")
	private String name;
	//@Pattern(regexp = "")
	private String password;
//	@Id
	@Email(message = "email should be in abc@yahoo.com")
	private String email;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
