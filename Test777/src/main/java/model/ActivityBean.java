package model;

public class ActivityBean {

	//行程規畫 主表
	private Integer activityID;
	private java.util.Date actStartDate; 
	private String actRegion;
	private String actTitle;
	private String introduction;
	private boolean privacy;
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
	

}
