package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service 只需負責 business logic 部分 不需要撰寫任何資料庫相關程式 
@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDao;
	//private MemberDAO memberDao=new MemberDAOHibernate(HibernateUtil.getSessionFactory());
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
