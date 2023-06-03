package com.facebookrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facebookrest.dao.FacebookDAOInterface;
import com.facebookrest.entity.FacebookUser;
import com.facebookrest.exception.UserNotFoundException;

@Service
@Transactional
public class FacebookService implements FacebookServiceInterface{
	
	@Autowired
	private FacebookDAOInterface fd;

	@Override
	public void createProfile(FacebookUser fb) {
		fd.save(fb);
		
		
	}

	@Override
	public List<FacebookUser> viewAllService() {
		// TODO Auto-generated method stub
		return fd.findAll();
	}

	@Override
	public FacebookUser viewProfileService(String em)throws UserNotFoundException {
		Optional<FacebookUser> ff=fd.findById(em);
		if(ff.isPresent()) {
			FacebookUser d=ff.get();
			return d;
		}
		else {
			throw new UserNotFoundException("user is not valid");
		}
		
		
		
	}

	@Override
	public void editprofile(FacebookUser fb) {
		fd.saveAndFlush(fb);
		
	}

	@Override
	public void deleteprofile(String email) {
		fd.deleteById(email);
		
	}

}



















