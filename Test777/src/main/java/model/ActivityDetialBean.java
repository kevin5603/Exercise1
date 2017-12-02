package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITYDETAIL")
public class ActivityDetialBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer actDetail;
	@Id
	private Integer activityID;
	private String note;
	private Integer budget;
	private String kinds;
	

}
