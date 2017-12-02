package model.HibernateUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

//使用annotation /*代表所有的程式都會被這濾波器攔截並執行doFilter方法
@WebFilter(urlPatterns = { "/*" })
public class OpenSessionInViewFilter implements Filter {

	private SessionFactory sessionFactory;

	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext application =fConfig.getServletContext();
		ApplicationContext context=(ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.sessionFactory=(SessionFactory)context.getBean("sessionFactory");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {
			sessionFactory.getCurrentSession().beginTransaction();
			// 代表濾波器第一階段完成 換原本的程式執行它所要做的事情
			chain.doFilter(req, res);
			// 到此行代表原程式已執行完畢再換到濾波器做收尾動作
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().getTransaction().rollback();
			chain.doFilter(req, res);
		}

	}

	public void destroy() {

	}

}
