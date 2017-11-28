package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.MemberService;

@WebServlet("/login/Login.do")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberservice;

	@Override
	public void init() throws ServletException {
		memberservice = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得輸入參數
		String account = request.getParameter("account");
		String psd = request.getParameter("psd");

		Map<String, String> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		// 判斷資料是否有輸入
		if (account == null || account.trim().length() == 0) {
			errors.put("account", "帳號必須輸入");
		}
		if (psd == null || psd.trim().length() == 0) {
			errors.put("psd", "密碼必須輸入");
		}

		// 代表使用者帳密有空白
		if (!errors.isEmpty()) {
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			return;
		}

		// 進入model部分
		// 把資料輸入資料庫並回傳給bean
		MemberBean bean = memberservice.login(account, psd);

		if (bean == null) {
			errors.put("DB", "帳號密碼不正確");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		} else {
			bean.setAccount(account);
			// 使用Session傳送資料到新頁面
			HttpSession session = request.getSession();
			session.setAttribute("ans", bean);

			String path = request.getContextPath();
			response.sendRedirect(path + "/login/success.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
