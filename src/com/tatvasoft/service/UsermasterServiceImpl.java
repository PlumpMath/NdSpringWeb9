package com.tatvasoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tatvasoft.dao.UsermasterDAO;
import com.tatvasoft.model.Usermaster;

@Service
public class UsermasterServiceImpl implements UsermasterService{

	@Autowired
	private UsermasterDAO usermasterdao;


	@Transactional
	public int authenticateUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		int count =  usermasterdao.authenticateUser(uname,pwd);

		return count;
	}

	@Transactional
	public Usermaster checkactiveuser(String uname, String pwd) {

		Usermaster umaster = usermasterdao.checkactiveuser(uname,pwd);

		return umaster;
	}

	@Transactional
	public void addUser(Usermaster usermaster) {
		// TODO Auto-generated method stub
		usermasterdao.addUser(usermaster);
	}

	@Transactional
	public List<Usermaster> listUser() {
		
		return usermasterdao.listUser();
	}

	@Transactional
	public void deleteUser(Integer id) {
		
		usermasterdao.deleteUser(id);
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Usermaster updateUser(Integer id){
		// TODO Auto-generated method stub
	return usermasterdao.updateUser(id);
	}

	@Transactional
	public Usermaster editUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	
	return usermasterdao.editUser(request);
	}

	@Transactional
	public void updateselecteduser(Usermaster usermaster) {
		// TODO Auto-generated method stub
		usermasterdao.updateselecteduser(usermaster);
		
	}
}