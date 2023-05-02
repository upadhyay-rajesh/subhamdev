package com.facebookweb.service;

import java.util.List;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;

public interface FacebookServiceInterface {

	int registerUserService(FacebookUser fu);

	int loginUserService(FacebookUser fu);

	FacebookUser viewUserService(FacebookUser fu);

	int editUserService(FacebookUser fu);

	int checkEmailService(FacebookUser fu);

	List<Country> loadCountryService();

}
