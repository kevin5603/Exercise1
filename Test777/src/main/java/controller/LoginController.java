package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.MemberBean;
import model.MemberService;

@Controller
@SessionAttributes(names= {"ans"})
public class LoginController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(path = { "/login/Login.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String ProjLogin(String account, String psd, Model model) {
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		// 判斷資料是否有輸入
		if (account == "" || account.trim().length() == 0) {
			errors.put("account", "帳號必須輸入");
		}
		if (psd == "" || psd.trim().length() == 0) {
			errors.put("psd", "密碼必須輸入");
		}

		// 代表使用者帳密有空白
		if (!errors.isEmpty()) {
			return "login.error";
		}

		// 進入model部分 // 把資料輸入資料庫並回傳給bean
		MemberBean bean = memberService.login(account, psd);
		System.out.println("回到Controller "+bean);
		if (bean == null) {
			errors.put("DB", "帳號密碼不正確");
			return "login.error";
		} else {
			bean.setAccount(account); // 使用Session傳送資料到新頁面 HttpSession session =
			model.addAttribute("ans", bean);
			return "login.success";
		}

	}

}
