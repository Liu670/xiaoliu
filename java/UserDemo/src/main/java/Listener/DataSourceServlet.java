package Listener;

import java.io.IOException;

import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DataSourceServlet extends HttpServlet {

	//
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从ServletContext上下文对象中读取DataSource对象
		DataSource ds = (DataSource) getServletContext().getAttribute("DS");
		System.out.println(ds);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从ServletContext上下文对象中读取DataSource对象
		DataSource ds = (DataSource) getServletContext().getAttribute("DS");
		System.out.println(ds);
	}
}
