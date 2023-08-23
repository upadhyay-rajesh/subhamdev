package com.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.entity.Employee;

public interface EmployeeDAO {
	public void init();
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory);

	public boolean insert(Employee e);

	public boolean checklogin(Employee e);

	public Employee serchByEmail(String email);

	public List<Employee> serchByFname(String fname);

	public List<Employee> serchByLname(String lname);

	public boolean updateEmployee(Employee e);

	public List<Employee> selectAll();

	public Employee serchByEmailAndPwd(String email, String pwd);

	public Employee searchByEmpid(long empid);
	public boolean checkrefid(String a);
}
