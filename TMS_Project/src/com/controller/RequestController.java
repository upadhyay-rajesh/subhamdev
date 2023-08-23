package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.*;
import com.entity.*;

@Controller
@RequestMapping("/*")
public class RequestController {
	
	@Autowired
	EmployeeDAO empDAO;

	@RequestMapping("Validate.htm")
	public ModelAndView handleValidateRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		String email =req.getParameter("email");
		String pwd =req.getParameter("password");
		
		if(email.equals("admin") && pwd.equals("admin"))
		{
			return new ModelAndView("adminResp","message",email);	
		}	
	
		
	
		Employee u=empDAO.serchByEmailAndPwd(email, pwd);
		if(u==null)
		{
		return new ModelAndView("loginResp","message","null");
		}
		else
		{
			return new ModelAndView("loginResp","message",u);	
		}
}
	@RequestMapping("emailGeneration.htm")
	public ModelAndView handleEmailGenerationRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		String fname =req.getParameter("fname");
		String lname =req.getParameter("lname");
		System.out.println(fname+" "+lname);
		
		Integer i=0; 
		Employee emp;
		String email;
		do{
			i++;
			email=fname+"_"+lname+i+"@taskflick.com";
			
			emp=empDAO.serchByEmail(email);
		}while(emp!=null);
		
		
		return new ModelAndView("EmailGenerationResp","message",email);
		
}
	@RequestMapping("SaveReg.htm")
	public ModelAndView handleRegistrationRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		String fname =req.getParameter("fname");
		String lname =req.getParameter("lname");
		String password=req.getParameter("password");
		String phoneNo=req.getParameter("phoneNo");
		String imgpath=req.getParameter("imgpath");
		System.out.println(imgpath);
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		
		
		Employee emp=new Employee();
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setEmailid(email);
		emp.setImgpath(imgpath);
		emp.setPassword(password);
		emp.setAddress(address);
		emp.setPhno(phoneNo);
		boolean result=empDAO.insert(emp);
		String message="Registration Failed";
		String filename="RegisterFail";
		if(result==true)
		{
			message="Registration Successfull";
			filename="RegisterSuccess";
		}
		return new ModelAndView(filename,"message",message);
		
}
	
	@RequestMapping("updateProfile.htm")
	public ModelAndView handleUpdateProfileRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		String password=req.getParameter("nPwd");
		String phoneNo=req.getParameter("nPhno");
		String imgpath=req.getParameter("nPic");
		String address=req.getParameter("nAdd");
		System.out.println(password+"  "+phoneNo+"  "+imgpath+"  "+address);
		
		HttpSession hs=req.getSession();
		Employee e=(Employee)hs.getAttribute("emp");
		//System.out.println("hi"+imgpath +"hello");
		//System.out.println(e.getImgpath());
		if(imgpath.isEmpty())
			imgpath=e.getImgpath();
		System.out.println(imgpath);
		
	
		
		if(!(imgpath.isEmpty()))
		   e.setImgpath(imgpath);
		System.out.println(e.getImgpath());
		e.setPassword(password);
		e.setAddress(address);
		e.setPhno(phoneNo);
		boolean result=empDAO.updateEmployee(e);
		String message="Updation Failed";
		
		if(result==true)
		{
			message="Updated Your Profile Successfully";
			
		}
		
		
		return new ModelAndView("updateDetails","message",message);
		
}
	
	@RequestMapping("searchlist.htm")
	public ModelAndView handleSearchRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		String value =req.getParameter("searchtype");
		String fir=req.getParameter("fir");
		
		
		List<Employee> emp=new ArrayList<Employee>();
		Employee e;
		String message="NOT FOUND";
		ModelAndView mv=new ModelAndView();
		mv.setViewName("search");
		if(value.equals("emailid")){
				
				e=empDAO.serchByEmail(fir);
				emp.add(e);
				mv.addObject("message",emp);
		}
		else if(value.equals("fname")){
				emp=(List<Employee>)empDAO.serchByFname(fir);
				mv.addObject("message", emp);
		}
		else if(value.equals("lname")){
			emp=(List<Employee>)empDAO.serchByLname(fir);
			mv.addObject("message",emp);
			
		}
		if(emp.size()==0)
		{
			mv.addObject("type","notfound");
		}
		else
		{
			mv.addObject("type", "list");
		}
		return mv;
		
}
	@RequestMapping("check_referal_id.htm")
	public ModelAndView handledaytoday(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		String res1="checkreffail";
		String a=req.getParameter("rid");
		System.out.println(a);
		
		boolean b=empDAO.checkrefid(a);
		if(b){
			res1="checkrefsuccess";
			return new ModelAndView(res1,"result","valid");
		}
		
		return new ModelAndView(res1,"result","invalid");
	}
	
	
	
	@RequestMapping("logout.htm")
	public ModelAndView handleLogOutRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		return (new ModelAndView("logout","message","You are logged out"));
	}
	
	@RequestMapping("getEmpForReport.htm")
	public ModelAndView handlegetEmpForReport(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		
		List<? extends Employee> emplist=(List<? extends Employee>)empDAO.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", emplist);
		mv.setViewName("menuReport");
		return mv;
	}
	
	/*@RequestMapping("generateReport.htm")
	public ModelAndView handlegetgenerateReport(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		Long empid=null;
		if(req.getParameter("empid")==null)
		{
			HttpSession sess=req.getSession(true);
		    Employee emp=(Employee)sess.getAttribute("emp");
		    empid=emp.getEmpid();
		}
		else
		    empid =Long.parseLong(req.getParameter("empid"));
		
		String edate=req.getParameter("edate");
		String sdate=req.getParameter("sdate");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date eDate=null;
	
		Date endDate=null;
		java.util.Date sDate=null;
		
			Date startDate=null;
		try
		{
			
			eDate = df.parse(edate); 
			
			endDate=new Date(eDate.getTime());
			sDate = df.parse(sdate); 
			
			startDate=new Date(sDate.getTime());
		} 
		catch (ParseException e)
	    {
			e.printStackTrace();
		
		}
		
		Resource  res = new FileSystemResource("e:/SpringMvcMo-servlet.xml"); 
	    BeanFactory  factory = new XmlBeanFactory(res);
		TaskDAO obj=(TaskDAOImpl)factory.getBean("taskDAO");
		List<? extends Task> tasklist=obj.TaskByEmpDuringPeriod(empid, startDate, endDate);
		ModelAndView mv = new ModelAndView();
		mv.addObject("tasklist", tasklist);
		mv.addObject("message", "report");
		mv.setViewName("report");
		return mv;
		
	}*/

}
