package Listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class DataSourceListener implements ServletContextListener {
	// servlet上下文对象销毁时调用
	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	// servlet上下文对象初始化时调用
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// 获取servletContext对象
		ServletContext sc = event.getServletContext();
		try {
			// 初始化上下文
			Context ctx = new InitialContext();
			// 获取与逻辑名相关联的数据源对象
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/news");
			// 将查询到的数据源保存到ServletContext上下文中
			sc.setAttribute("DS", ds);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
