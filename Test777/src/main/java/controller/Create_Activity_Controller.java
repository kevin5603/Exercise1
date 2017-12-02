package controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.ActivityBean;
import model.ActivityService;
import model.MemberBean;

@Controller
public class Create_Activity_Controller {
	@Autowired
	private ActivityService activityService;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.lang.Integer.class,
				new CustomNumberEditor(java.lang.Integer.class,true));
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}

	@RequestMapping(path= {"/activity/ActivityController.do"},method= {RequestMethod.POST,RequestMethod.GET})
	public String xxx(ActivityBean bean,BindingResult bindingResult,Model model,HttpSession session) {
		
		MemberBean member=(MemberBean)session.getAttribute("ans");
		System.out.println(member);
		
		bean.setMemberID(member.getMemberID());
		
		if(bindingResult.hasErrors()) {
			System.out.println("轉換出錯GG");
		}
		
		System.out.println("bean:"+bean);

		//判斷 先跳過
		
		//新增
		System.out.println("新增結果:"+activityService.Create_Schedule(bean));
		
		
//		//查詢
//		List<ActivityBean> beans=activityService.Schedule(1);
//		if(!beans.isEmpty()) {
//			System.out.println("成功取值");
//			Iterator<ActivityBean> ite=beans.iterator();
//			while(ite.hasNext()) {
//				System.out.println(ite.next());
//			}
//		}else {
//			System.out.println("取值失敗");
//		}
		
		return "actDetail";
		
		
	}

}
