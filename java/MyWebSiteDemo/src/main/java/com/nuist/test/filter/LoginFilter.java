package com.nuist.test.filter;

import java.io.IOException;

/**
 * 功能：拦截未登录用户访问
 */
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/pages/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 初始化过滤器
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// 获取当前会话
		HttpSession session = httpRequest.getSession();
		// 检查会话中是否存在登录用户
		boolean isLoggedIn = (session != null && session.getAttribute("username") != null);

		// 如果未登录，则重定向到登录页面
		if (!isLoggedIn) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
			return;
		}
		// 登录用户正常访问，继续处理请求
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// 销毁过滤器
	}
}
