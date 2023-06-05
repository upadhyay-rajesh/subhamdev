package com.facebookrest.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.facebookrest.entity.FacebookUser;

public interface FacebookDAOInterface {//extends JpaRepository<FacebookUser, String>{
	
	void insertRecard(FacebookUser fu);
	List<FacebookUser> viewAll();

}
