package com.facebookweb.dao;

import java.util.List;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;

public interface FacebookDAOInterface {

	int registerUserDAO(FacebookUser fu);

	int loginrUserDAO(FacebookUser fu);

	FacebookUser viewUserDAO(FacebookUser fu);

	int editUserDAO(FacebookUser fu);

	int checkEmailDAO(FacebookUser fu);

	List<Country> loadCountryDAO();

}
