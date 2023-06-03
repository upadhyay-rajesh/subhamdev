package com.facebookrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebookrest.entity.FacebookUser;

public interface FacebookDAOInterface extends JpaRepository<FacebookUser, String>{

}
