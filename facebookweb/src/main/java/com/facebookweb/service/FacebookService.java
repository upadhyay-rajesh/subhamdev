package com.facebookweb.service;

import java.util.List;

import com.facebookweb.dao.FacebookDAOFactory;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int registerUserService(FacebookUser fu) {
		FacebookDAOInterface fd=FacebookDAOFactory.createObject();
		return fd.registerUserDAO(fu);
	}

	public int loginUserService(FacebookUser fu) {
		FacebookDAOInterface fd=FacebookDAOFactory.createObject();
		return fd.loginrUserDAO(fu);
	}

	public FacebookUser viewUserService(FacebookUser fu) {
		FacebookDAOInterface fd=FacebookDAOFactory.createObject();
		return fd.viewUserDAO(fu);
	}

	public int editUserService(FacebookUser fu) {
		FacebookDAOInterface fd=FacebookDAOFactory.createObject();
		return fd.editUserDAO(fu);
	}

	public int checkEmailService(FacebookUser fu) {
		FacebookDAOInterface fd=FacebookDAOFactory.createObject();
		return fd.checkEmailDAO(fu);
	}

	public List<Country> loadCountryService() {
		FacebookDAOInterface fd=FacebookDAOFactory.createObject();
		return fd.loadCountryDAO();
	}

}
