package com.facebookweb.service;

import com.facebookweb.entity.FacebookUser;

public interface FacebookServiceInterface {

	int registerUserService(FacebookUser fu);

	int loginUserService(FacebookUser fu);

}
