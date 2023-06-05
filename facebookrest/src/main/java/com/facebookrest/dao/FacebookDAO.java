package com.facebookrest.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.facebookrest.entity.FacebookUser;
@Repository
public class FacebookDAO extends JdbcDaoSupport implements FacebookDAOInterface {
	
	@Autowired
	DataSource ds;
	
	@PostConstruct
	private void initialize() {
		setDataSource(ds);
	}

	//@Override
	public void insertRecard(FacebookUser fu) {
		String query="insert into facebookuser values(?,?,?,?)";
		getJdbcTemplate().update(query,new Object[] {fu.getName(),fu.getPassword(),fu.getEmail(),fu.getAddress()});

	}

	//@Override
	public List<FacebookUser> viewAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
