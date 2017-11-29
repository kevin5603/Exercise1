package model.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionFactoryListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Servers啟動 監聽者執行contextInitialized方法");
		// Servers啟動時取得一個SessionFactory 確保整個Servers只會只有一個SessionFactory
		HibernateUtil.getSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Servers關閉 監聽者執行contextDestroyed方法");
		// 結束應用程式 此時再把SessionFactory關閉
		HibernateUtil.closeSessionFactory();
	}

}
