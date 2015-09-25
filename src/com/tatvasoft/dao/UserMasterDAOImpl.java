package com.tatvasoft.dao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tatvasoft.model.Usermaster;

@Repository
public class UserMasterDAOImpl implements UsermasterDAO {

	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

    private static int noOfRecords;
	
	@Override
	public int authenticateUser(String usernamearg, String passwordarg) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Usermaster.class);
		criteria.add(Restrictions.eq("username", usernamearg));
		criteria.add(Restrictions.eq("password", passwordarg));
		criteria.setProjection(Projections.rowCount());
		int count = Integer.parseInt(criteria.uniqueResult().toString());

		//sessionFactory.getCurrentSession().cre

		return count;
	}

	@Override
	public Usermaster checkactiveuser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		Query query1 = session.createQuery("from Usermaster where username = :uname AND password = :password");
		query1.setParameter("uname",username);
		query1.setParameter("password",password);

		List list =  query1.list();
		Usermaster usermaster2 = new Usermaster();
		for(int i = 0 ; i<list.size() ; i++)
		{
			usermaster2 = (Usermaster)list.get(i);
		}
		return usermaster2;

	}

	@Override
	public void addUser(Usermaster usermaster) {
		// TODO Auto-generated method stub
		sessionFactory.openSession().save(usermaster);

	}

	@Override
	public List<Usermaster> listUser() {

		return sessionFactory.openSession().createQuery("from Usermaster").list();

	}

	@Override
	public void deleteUser(Integer id) {
		Usermaster um = (Usermaster) sessionFactory.openSession().load(
				Usermaster.class, id);
		if (null != um) {
			sessionFactory.openSession().delete(um);
			// TODO Auto-generated method stub

		}
	}

	@Override
	public Usermaster updateUser(Integer id) {
		
		Usermaster um = (Usermaster) sessionFactory.openSession().get(
				Usermaster.class, id);
		return um;
	}

	@Override
	public Usermaster editUser(HttpServletRequest request) {
		HttpSession sessions = request.getSession();
		
		Usermaster um = (Usermaster) sessionFactory.openSession().get(
				Usermaster.class,(Integer)sessions.getAttribute("userid_s"));
		// TODO Auto-generated method stub
		return um;
	}

	@Override
	public void updateselecteduser(Usermaster usermaster) {
		
		Usermaster um = (Usermaster) sessionFactory.openSession().get(
				Usermaster.class,usermaster.getUserid());
		um.setFirstname(usermaster.getFirstname());
		um.setLastname(usermaster.getLastname());
		um.setUsername(usermaster.getUsername());
		um.setPassword(usermaster.getPassword());
		um.setRoleid(usermaster.getRoleid());
		sessionFactory.openSession().update(um);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usermaster> listUsers(int pageSize, int page, String sidx,
			String sord) {
		// sessionFactory.getCurrentSession().createQuery("from Usermaster").list();
		
		List<Usermaster> ls = null;
		Query query = sessionFactory.openSession().createQuery("from Usermaster order by "+sidx+" "+sord);
		noOfRecords = query.list().size();
		query.setFirstResult((page - 1)*pageSize);
		query.setMaxResults(pageSize);
		ls = (List<Usermaster>)query.list();
		
		// TODO Auto-generated method stub
		return ls;
	}

	@Override
	public int getNoOfRecords() {
		// TODO Auto-generated method stub
		return noOfRecords;
	}

	@Override
	
	public void deleteUser1(Integer userid) {
		// TODO Auto-generated method stub
		Usermaster usermaster = getUser(userid);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(usermaster);
		transaction.commit();
		session.close();
		
	}
	
	
	@Override
	public Usermaster getUser(Integer userid) {
		
		Session session1 = sessionFactory.openSession();
		
		Query q1 = session1.createQuery("from accountattribute where akey= : userid");
		Session session = sessionFactory.openSession();
		List<Usermaster>ls = null;
		
		Query query = session.createQuery("from Usermaster  where userid= :userid");
		query.setParameter("userid",userid);
		ls = (List<Usermaster>)query.list();
		return ls.size()>0?ls.get(0):null;
	}

	@Override
	public void addUser1(Usermaster usermaster) {
		
		sessionFactory.openSession().save(usermaster);
	}

	@Override
	public Usermaster updateUser1(Usermaster usermaster) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(usermaster);
		transaction.commit();
		session.close();
		// TODO Auto-generated method stub
		return null;
	}

}
