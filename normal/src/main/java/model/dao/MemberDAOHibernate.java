package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.MemberBean;
import model.MemberDAO;

public class MemberDAOHibernate implements MemberDAO {

	private SessionFactory sessionFactory;

	public MemberDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MemberBean select(String memberid) {

		return null;
	}

	@Override
	public boolean update(String String) {

		return false;
	}

}
