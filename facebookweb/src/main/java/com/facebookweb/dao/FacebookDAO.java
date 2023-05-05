package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int registerUserDAO(FacebookUser fu) {
		int i=0;
		/* using JDBC
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Rev-PG02REP7:1521:xe","system","rajesh");
			
			PreparedStatement ps=con.prepareStatement("insert into facebookuser values(?,?,?,?)");
			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPassword());
			ps.setString(3, fu.getEmail());
			ps.setString(4,fu.getAddress() );
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		//using hibernate
		
		//by default configure method will load hibernate.cfg.xml file
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session ss=sf.openSession();
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
		
			ss.save(fu);
		
		et.commit();
		i=1;
		
		return i;
	}

	public int loginrUserDAO(FacebookUser fu) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Rev-PG02REP7:1521:xe","system","rajesh");
			
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=? and password=?");
			ps.setString(1, fu.getEmail());
			ps.setString(2, fu.getPassword());
			
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public FacebookUser viewUserDAO(FacebookUser fu) {
		FacebookUser ff=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Rev-PG02REP7:1521:xe","system","rajesh");
			
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=?");
			ps.setString(1, fu.getEmail());
						
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				ff=new FacebookUser();
				ff.setName(res.getString(1));
				ff.setPassword(res.getString(2));
				ff.setEmail(res.getString(3));
				ff.setAddress(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

	public int editUserDAO(FacebookUser fu) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Rev-PG02REP7:1521:xe","system","rajesh");
			
			PreparedStatement ps=con.prepareStatement("update facebookuser set name=?, password=?, address=? where email=?");
			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPassword());
			
			ps.setString(3,fu.getAddress() );
			ps.setString(4, fu.getEmail());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int checkEmailDAO(FacebookUser fu) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Rev-PG02REP7:1521:xe","system","rajesh");
			
			//System.out.println(fu.getEmail());
			
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=?");
			ps.setString(1, fu.getEmail());
						
			ResultSet res=ps.executeQuery();
		//	System.out.println(res.next());
			if(res.next()) {
				i=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<Country> loadCountryDAO() {
		List<Country> ff=new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Rev-PG02REP7:1521:xe","system","rajesh");
			
			PreparedStatement ps=con.prepareStatement("select * from country");
			
						
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				Country ff1=new Country();
				ff1.setCountryId(res.getInt(1));
				ff1.setCountryName(res.getString(2));
				
				ff.add(ff1);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

}
