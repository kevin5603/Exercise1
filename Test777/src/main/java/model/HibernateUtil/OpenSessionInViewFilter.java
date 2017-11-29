package model.HibernateUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//使用annotation /*代表所有的程式都會被這濾波器攔截並執行doFilter方法
@WebFilter(urlPatterns = { "/*" })
public class OpenSessionInViewFilter implements Filter {

	private FilterConfig filterConfig;

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			System.out.println("!!!濾波器攔截成功 開啟交易");
			// 代表濾波器第一階段完成 換原本的程式執行它所要做的事情
			chain.doFilter(req, res);
			// 到此行代表原程式已執行完畢再換到濾波器做收尾動作
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			System.out.println("濾波器收尾動作 ˇˇˇ 確認交易");
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
			System.out.println("X處理失敗 退回交易x");
			chain.doFilter(req, res);
		}

	}

	public void destroy() {

	}

}
