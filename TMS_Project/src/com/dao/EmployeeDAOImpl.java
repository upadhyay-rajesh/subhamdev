package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.*;
@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	private EntityManager em;
	EntityTransaction t;

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void init() {

		em = entityManagerFactory.createEntityManager();
		t = em.getTransaction();
	}

	public boolean insert(Employee e) {
		boolean b = false;
		init();
		t.begin();
		em.persist(e);
		t.commit();

		b = true;
		return b;
	}

	public boolean checklogin(Employee e) {
		boolean b = false;
		init();
		Employee ent = (Employee) em.find(Employee.class, e.getEmpid());
		System.out.println(ent.getAddress() + "  " + ent.getPassword() + "  "
				+ ent.getFname());

		b = true;
		return b;
	}

	public Employee serchByEmail(String email) {
		init();
		Query que = em
				.createQuery("Select e from Employee e where e.emailid= ?1");
		que.setParameter(1, email);
		Employee emp;
		try {
			emp = (Employee) que.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			emp = null;
		}
		return emp;
	}

	public Employee serchByEmailAndPwd(String email, String pwd) {
		init();
		Query que = em
				.createQuery("Select e from Employee e where e.emailid= ?1 and e.password=?2");
		que.setParameter(1, email);
		que.setParameter(2, pwd);
		Employee emp;
		try {
			emp = (Employee) que.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			emp = null;
		}
		return emp;
	}

	public List<Employee> serchByFname(String fname) {
		init();
		Query que = em
				.createQuery("Select e from Employee e where e.fname= ?1");
		que.setParameter(1, fname);
		List<Employee> emp;
		try {
			emp = (List<Employee>) que.getResultList();
		} catch (javax.persistence.NoResultException e) {
			emp = null;
		}
		return emp;
	}

	public List<Employee> serchByLname(String lname) {
		init();
		Query que = em
				.createQuery("Select e from Employee e where e.lname= ?1");
		que.setParameter(1, lname);
		List<Employee> emp;
		try {
			emp = (List<Employee>) que.getResultList();
		}

		catch (javax.persistence.NoResultException e) {
			emp = null;
		}
		return emp;
	}

	public boolean updateEmployee(Employee e) {
		boolean b = false;
        init();
		t.begin();
		em.merge(e);
		t.commit();

		b = true;
		return b;
	}

	public List<Employee> selectAll() {

		init();
		Query q = em.createQuery("from Employee e");
		return ((List<Employee>) q.getResultList());

	}

	@Override
	public Employee searchByEmpid(long empid) {
		init();
		Query que = em
				.createQuery("Select e from Employee e where e.empid= ?1");
		que.setParameter(1, empid);
		Employee emp;
		try {
			emp = (Employee) que.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			emp = null;
		}
		return emp;
	}
	@Override
	public boolean checkrefid(String a) {
		init();
		Query que = em.createQuery("select e from Referal e where  e.refid="+a);
		List ts = que.getResultList();
		if(ts.size()>0){
			return true;
		}
		return false;
	}

}
