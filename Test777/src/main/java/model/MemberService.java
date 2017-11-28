package model;

import model.HibernateUtil.HibernateUtil;
import model.dao.MemberDAOHibernate;

//Service 只需負責 business logic 部分 不需要撰寫任何資料庫相關程式 
public class MemberService {

	private MemberDAO memberDao=new MemberDAOHibernate(HibernateUtil.getSessionFactory());
	//private MemberDAO memberDao=new MemberDAOjdbc();
	public MemberBean login(String account, String psd) {

		MemberBean bean = memberDao.select(account);
		if (bean != null) {
			if (psd != null && psd.trim().length() != 0) {
				if (bean.getPsd().equals(psd)) {
					return bean;
				}
			}
		}
		return null;
	}
}
