package model;

import java.util.Date;
import java.util.List;

public interface ActivityDAO {

	// 顯示所有行程規劃
	public List<ActivityBean> select(int memberID);

	// 新增行程規劃
	public boolean insert(ActivityBean bean);

//	// 修改行程
//	public boolean update(ActivityBean bean);
//	
//	// 刪除行程  !!刪除指令可能要再研究一下
//	public boolean delete(ActivityBean bean);

}
