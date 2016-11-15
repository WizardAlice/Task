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

import com.entity.*;
import com.test.LibConnection;
import com.util.LogInCheck;

public class RigisterUser extends HttpServlet{
HttpSession session = null;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");// 防止中文乱码问题
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		String phonenumber = request.getParameter("phonenumber");
		String nationality = request.getParameter("nationality");
		String club = request.getParameter("club");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		if(!pwd1.equals(pwd2)){
			System.out.println(pwd1);
			System.out.println(pwd2);
			request.getRequestDispatcher("rigisteragain.jsp").forward(request,response);
		}
		else {
			LibSystem.insertUser(id, name, idcard, phonenumber, nationality, pwd1,club);
			request.getRequestDispatcher("newlogin.jsp").forward(request,response);
		}
		}
	

}
