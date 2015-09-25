package com.tatvasoft.dao;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;

import com.tatvasoft.model.Usermaster;

public interface UsermasterDAO {

	public int authenticateUser(String username , String password);
	public Usermaster checkactiveuser(String username , String password);
	 public void addUser(Usermaster usermaster);
	 public void addUser1(Usermaster usermaster);
	 public List<Usermaster> listUser();
	 public List<Usermaster> listUsers(int pageSize,int page , String sidx , String sord);
	 public void deleteUser(Integer id) ;
	 public void deleteUser1(Integer userid);
	 public Usermaster updateUser(Integer id) ;
	 public Usermaster updateUser1(Usermaster usermaster) ;
	 public Usermaster editUser(HttpServletRequest request) ;
	 public void updateselecteduser(Usermaster usermaster);
	 public int getNoOfRecords();
	 public Usermaster getUser(Integer userid); 
	  
}
