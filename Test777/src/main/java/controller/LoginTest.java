package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login/Login.do")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得輸入參數
		String account=request.getParameter("account");
		String psd=request.getParameter("psd");
		
		System.out.println("帳號為:"+account+"密碼為:"+psd);
		Map<String,String> errors=new HashMap<>();
		request.setAttribute("errors",errors);
		
		//判斷資料是否有輸入
		if(account==""||account.trim().length()==0) {
			errors.put("account","帳號必須輸入");
		}
		if(psd==""||psd.trim().length()==0) {
			errors.put("psd","密碼必須輸入");
		}
	
		//代表使用者帳密有空白
		if(!errors.isEmpty()) {
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
		//進入model部分
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
