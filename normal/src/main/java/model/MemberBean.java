package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

import model.hibernateutil.HibernateUtil;

@Entity
@Table(name="MEMBER")
public class MemberBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer memberid;
	private String account;
	private String psd;

	//只能在一般java專案測試
	public static void main(String[] args) {
		try {
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();

		//insert
//		MemberBean insert=new MemberBean();
//		insert.setAccount("java小王子");
//		insert.setPsd("a123");
//		session.save(insert);
		//update
//		MemberBean update=session.get(MemberBean.class,3);
//		update.setPsd("qq789");
		//select
//		MemberBean select=session.get(MemberBean.class, 3);
//		System.out.println(select);
		//delete
//		MemberBean delete=session.get(MemberBean.class,3);
//		session.delete(delete);
		
		
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

	@Override
	public String toString() {
		return "MemberBean [memberid=" + memberid + ", account=" + account + ", psd=" + psd + "]";
	}
	
	

}
