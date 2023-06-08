package com.facebookrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facebookrest.entity.FacebookUser;
import com.facebookrest.exception.UserNotFoundException;
import com.facebookrest.service.FacebookServiceInterface;

@RestController
public class FacebookController {
	
	@Autowired
	private FacebookServiceInterface fs;
	
	@GetMapping("viewprofile/{id}/{pass}")
	public FacebookUser view(@PathVariable("id") String em,@PathVariable("pass") String password)throws UserNotFoundException {
		
		try {
			FacebookUser ff=fs.viewProfileService(em);
		//if(ff!=null) {
			return ff;
		//}
		
		}
		catch(UserNotFoundException uu) {
			throw uu;
		}
	}
	
	
	@GetMapping("viewAllprofile")
	public List<FacebookUser> viewall() {
		return fs.viewAllService();
	}
	
	@PostMapping("createprofile")
	public String create(@Valid @RequestBody FacebookUser fb) {
		
		fs.createProfile(fb);
		
		return "profile created";
	}
	@DeleteMapping("deleteprofile/{id}")
	public String delete(@PathVariable("id") String email) {
		fs.deleteprofile(email); 
		return "profile deleted";
	}
	@PutMapping("editprofile/{id}")
	public String edit(@PathVariable("id") String email,@RequestBody FacebookUser fb) {
		fb.setEmail(email);
		fs.editprofile(fb);
		return "profile edited";
	}
}













