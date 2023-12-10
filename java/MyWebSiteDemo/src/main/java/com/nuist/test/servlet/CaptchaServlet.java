package com.nuist.test.servlet;
// CaptchaServlet.java

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuist.test.util.CaptchaImageUtil;
import com.nuist.test.util.CaptchaUtil;

@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String captcha = CaptchaUtil.generateCaptcha();

		// 将验证码存储到Session中，用于后续验证
		request.getSession().setAttribute("captcha", captcha);

		// 将验证码图片返回给客户端
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		CaptchaImageUtil.writeCaptchaImage(response.getOutputStream(), captcha);
	}
}
