package com.servlet;

import java.io.IOException;
import java.sql.Connection;
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
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.test.LibConnection;

public class UserSelfChange extends HttpServlet{

	
	HttpSession session = null;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//防止中文乱码问题
		session = request.getSession();
		System.out.println("hello");
		User user = (User)session.getAttribute("user");
		System.out.println("hello"+user.id);
		user.updateUser(user.id, request.getParameter("name"), request.getParameter("idcard"), request.getParameter("phonenumber"), request.getParameter("nationality"), request.getParameter("pwd"),request.getParameter("club"));
		request.getRequestDispatcher("/vip/changeinfo.jsp").forward(request, response);
		
	}

}

