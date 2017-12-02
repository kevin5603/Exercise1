package model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
	@Autowired
	private ActivityDAO activityDAO;
	
	public List<ActivityBean> Schedule(int memberID){
		System.out.println("剛進入Service:"+memberID);
		List<ActivityBean> beans=activityDAO.select(memberID);
		if(beans!=null) {
		return beans;
		}else {
			return null;
		}		
	}
	
	public boolean Create_Schedule(ActivityBean bean) {
		System.out.println("進入service 創建行程");
		return activityDAO.insert(bean);
		
	}
	
	

}
