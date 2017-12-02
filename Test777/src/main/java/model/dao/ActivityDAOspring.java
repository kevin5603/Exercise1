package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.ActivityBean;
import model.ActivityDAO;

@Repository
public class ActivityDAOspring implements ActivityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ActivityBean> select(int memberID) {
		System.out.println("進入Select方法");
		List<ActivityBean> beans = null;
		Session session = getSession();
		Query query=session.createQuery("from model.ActivityBean where memberID=?");
		query.setParameter(0,memberID);
		beans=query.list();
		return beans;
	}

	@Override
	public boolean insert(ActivityBean bean) {
		System.out.println("進入Insert方法");
		
		if(bean.getMemberID()!=null) {
			ActivityBean insert=new ActivityBean();
			insert.setActStartDate(bean.getActStartDate());
			insert.setActRegion(bean.getActRegion());
			insert.setActTitle(bean.getActTitle());
			insert.setIntroduction(bean.getIntroduction());
			insert.setMemberID(bean.getMemberID());
			Session session=getSession();
			session.save(insert);
			return true;
		}else {
			return false;
		}
	}
	
	

}
