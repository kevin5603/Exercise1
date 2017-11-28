package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

import model.hibernateutil.HibernateUtil;

@Entity
@Table(name = "Activity")
public class ActivityBean {

	// 行程規畫 主表
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer activityID;
	private java.util.Date actStartDate;
	private String actRegion;
	private String actTitle;
	private String introduction;
	//對應DB 沒輸入預設是true
	private boolean privacy=true;
	private byte[] actPhoto;
	private Integer memberID;

	public static void main(String[] args) {
		
		//設定日期格式
		String date="1990-12-4";
		java.util.Date Date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date=sdf.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		
		//目標讀取檔案
		File file1=new File("C:\\Users\\Student\\Desktop\\book\\dog.jpg");
		byte[] img=null;
		//真有此檔案才進行
		if(file1.exists()) {		
			img=new byte[(int)file1.length()];
			try (FileInputStream fis=new FileInputStream(file1)){
				//寫入圖片
				fis.read(img);
			}catch(IOException e) {
				e.printStackTrace();
			}			
		}
		
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			//insert
			ActivityBean insert=new ActivityBean();
			insert.setActPhoto(img);
			insert.setActRegion("新竹");
			insert.setActTitle("清大參觀");
			insert.setActStartDate(Date);
			insert.setIntroduction("我們要去參觀清大 看看清大和交大合併以後變成怎麼樣 也請大家踴躍參加 ㄏㄏ我們要去參觀清大 看看清大和交大合併以後變成怎麼樣 也請大家踴躍參加"
					+ "我們要去參觀清大 看看清大和交大合併以後變成怎麼樣 也請大家踴躍參加 ㄏㄏ我們要去參觀清大 看看清大和交大合併以後變成怎麼樣 也請大家踴躍參加"
					+ "我們要去參觀清大 看看清大和交大合併以後變成怎麼樣 也請大家踴躍參加 ㄏㄏ我們要去參觀清大 看看清大和交大合併以後變成怎麼樣 也請大家踴躍參加");
			session.save(insert);		
			//select
//			ActivityBean select=session.get(ActivityBean.class,4);
//			System.out.println("查詢結果"+select);
			//update
//			ActivityBean update=session.get(ActivityBean.class,4);
//			update.setIntroduction("略");
			//delete
//			ActivityBean delete=session.get(ActivityBean.class,4);
//			session.delete(delete);
			
			
			
			//利用Select 把圖片從資料庫取出並輸出到指定位置
//			File file2=new File("C:\\Users\\Student\\Desktop\\book\\newpic.jpg");
//			byte[] result=null;		
//			result=select.getActPhoto();		
//			try(FileOutputStream fos=new FileOutputStream(file2)){
//				fos.write(result);
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	public Integer getActivityID() {
		return activityID;
	}

	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}

	public java.util.Date getActStartDate() {
		return actStartDate;
	}

	public void setActStartDate(java.util.Date actStartDate) {
		this.actStartDate = actStartDate;
	}

	public String getActRegion() {
		return actRegion;
	}

	public void setActRegion(String actRegion) {
		this.actRegion = actRegion;
	}

	public String getActTitle() {
		return actTitle;
	}

	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public byte[] getActPhoto() {
		return actPhoto;
	}

	public void setActPhoto(byte[] actPhoto) {
		this.actPhoto = actPhoto;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	@Override
	public String toString() {
		return "ActivityBean [activityID=" + activityID + ", actStartDate=" + actStartDate + ", actRegion=" + actRegion
				+ ", actTitle=" + actTitle + ", introduction=" + introduction + ", privacy=" + privacy + ", actPhoto=略"
			+", memberID=" + memberID + "]";
	}
	

}
