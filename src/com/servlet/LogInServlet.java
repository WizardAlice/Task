package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;
import com.entity.User;
import com.test.LibConnection;
import com.util.LogInCheck;

public class LogInServlet extends HttpServlet{
HttpSession session = null;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");// 防止中文乱码问题
		session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		System.out.println(username);
		System.out.println(password);
		String loginresult = LogInCheck.isLogin(identity, username, password);
		session.setAttribute("loginresult", loginresult);
		System.out.println(loginresult);
		if (loginresult.equals("VALIDUSER") && identity.equals("admin")) {
			System.out.println(username);
			session.setAttribute("admin", new Admin(username));
			System.out.println("跳转到Admin界面");
			request.getRequestDispatcher("/admin/initialmodel.jsp").forward(request,
					response);
		} else if (loginresult.equals("VALIDUSER") && identity.equals("user")) {
			request.getRequestDispatcher("/vip/initialmodel.jsp").forward(request,
					response);
			User user = new User(username);
			session.setAttribute("user", user);
			System.out.println("跳转到User界面");
		} else {
			request.getRequestDispatcher("LogResult.jsp").forward(request,
					response);
		}
	}

}
