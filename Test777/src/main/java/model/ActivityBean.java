package model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITY")
public class ActivityBean {

	//行程規畫 主表
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer activityID;
	private java.util.Date actStartDate; 
	private String actRegion;
	private String actTitle;
	private String introduction;
	//預設public
	private boolean privacy=false;
	private byte[] actPhoto;
	private Integer memberID;
	
	
	
	
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
				+ ", actTitle=" + actTitle + ", introduction=" + introduction + ", privacy=" + privacy + ", actPhoto="
				+ Arrays.toString(actPhoto) + ", memberID=" + memberID + "]";
	}
	

}
