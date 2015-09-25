package com.tatvasoft.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tatvasoft.model.Usermaster;

public interface UsermasterService {
	public int authenticateUser(String uname , String pwd);
	public Usermaster checkactiveuser(String uname , String pwd);
	public void addUser(Usermaster usermaster);
	public List<Usermaster> listUser();
	public void deleteUser(Integer id);
	public Usermaster updateUser(Integer id);
	public Usermaster editUser(HttpServletRequest request);
	public void updateselecteduser(Usermaster usermaster);
}
