package model;

import org.hibernate.Session;

import model.HibernateUtil.HibernateUtil;

public class MemberBean {
	
	private Integer memberid;
	private String account;
	private String psd;
	private String phone;

	//只能在一般java專案測試
	public static void main(String[] args) {
		try {
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();

		//insert
		MemberBean insert=new MemberBean();
		
		
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberBean [memberid=" + memberid + ", account=" + account + ", psd=" + psd + ", phone=" + phone + "]";
	}
	
	

}
