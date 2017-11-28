package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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
			return;
		}
		
		//進入model部分
		String url="jdbc:sqlserver://localhost:1433;databaseName=eventloop";
		String user="sa";
		String password="P@ssw0rd";
		
		Map<String,String> ans=new HashMap();
		request.setAttribute("ans", ans);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (Connection conn=DriverManager.getConnection(url, user, password);
				Statement stmt=conn.createStatement();){
			
			ResultSet rs=stmt.executeQuery("select * from member");		
			System.out.println("印出所有帳密");
			while(rs.next()) {
				int count=1;
				ans.put("account",rs.getString("account") );
				ans.put("psd",rs.getString("psd") );
				System.out.println("讀取第"+count+"筆資料");
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String path=request.getContextPath();
		response.sendRedirect(path+"/login/success.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
