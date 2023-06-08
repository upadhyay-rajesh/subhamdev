package com.facebookrest.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.facebookrest.dao.FacebookDAOInterface;
import com.facebookrest.entity.FacebookUser;
import com.facebookrest.exception.UserNotFoundException;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED,readOnly = true,timeout=5000)
public class FacebookService implements FacebookServiceInterface{
	
	@Autowired
	private FacebookDAOInterface fd;
	
	

	@Override
	public void createProfile(FacebookUser fb) {
		//fd.save(fb);
		//log.info("inside service class create profile method at "+new java.util.Date());
		fd.insertRecard(fb);
		
		
	}

	@Override
	public List<FacebookUser> viewAllService() {
		// TODO Auto-generated method stub
		//return fd.findAll();
		return null;
	}

	@Override
	public FacebookUser viewProfileService(String em)throws UserNotFoundException {
		/*Optional<FacebookUser> ff=fd.findById(em);
		if(ff.isPresent()) {
			FacebookUser d=ff.get();
			return d;
		}
		else {
			throw new UserNotFoundException("user is not valid");
		}
		
		*/
		return null;
		
	}

	@Override
	public void editprofile(FacebookUser fb) {
		//fd.saveAndFlush(fb);
		
	}

	@Override
	public void deleteprofile(String email) {
		//fd.deleteById(email);
		
	}

}



















