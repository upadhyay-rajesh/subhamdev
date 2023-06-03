package com.facebookrest.service;

import java.util.List;

import com.facebookrest.entity.FacebookUser;
import com.facebookrest.exception.UserNotFoundException;

public interface FacebookServiceInterface {

	void createProfile(FacebookUser fb);

	List<FacebookUser> viewAllService();

	FacebookUser viewProfileService(String em)throws UserNotFoundException;

	void editprofile(FacebookUser fb);

	void deleteprofile(String email);

}
