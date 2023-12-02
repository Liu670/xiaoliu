package Listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class LoginListener implements HttpSessionListener {
	// session创建后调用
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// 创建servletContext对象
		ServletContext ctx = event.getSession().getServletContext();
		// 获取共享数据（登录的用户人数）
		Integer userCount = (Integer) ctx.getAttribute("userCount");
		if (null != userCount) {
			userCount = 1;
		} else {
			userCount = userCount + 1;
		}
		System.out.println("---HttpSessionListener---人数加1:" + userCount);
		ctx.setAttribute("userCount", userCount);
	}

	// session销毁前调用
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// 创建servletContext对象
		ServletContext ctx = event.getSession().getServletContext();
		// 获取共享数据（登录的用户数）
		Integer userCount = (Integer) ctx.getAttribute("userCount");
		if (null != userCount) {
			userCount = 0;
		} else {
			userCount = userCount - 1;
		}
		System.out.println("---HttpSessionListener---人数减1:" + userCount);
		ctx.setAttribute("userCount", userCount);
	}

}
