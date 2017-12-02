package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MemberBean;
import model.MemberDAO;
@Repository
public class MemberDAOspring implements MemberDAO{
		@Autowired
		private SessionFactory sessionFactory;
		
		
		public Session getSession() {
			return sessionFactory.getCurrentSession();
		}
		
		@Override
		public MemberBean select(String account) {
			//因為OpenSessionInViewFilter 會幫我們 啟動  送出交易  退回交易
			MemberBean bean=null;
			Session session=getSession();
			//因為主key是流水號 無法用
			Query query=session.createQuery("from model.MemberBean where account=?");
			query.setParameter(0, account);
			
			List list=query.list();
			
			bean=(MemberBean)list.iterator().next();
//			System.out.println("BEAN值:"+bean);
			return bean;
		}

		@Override
		public boolean update(String psd, String phone) {
			return false;
		}
		
}
