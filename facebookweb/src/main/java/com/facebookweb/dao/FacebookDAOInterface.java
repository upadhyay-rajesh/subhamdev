package com.facebookweb.dao;

import com.facebookweb.entity.FacebookUser;

public interface FacebookDAOInterface {

	int registerUserDAO(FacebookUser fu);

	int loginrUserDAO(FacebookUser fu);

}
