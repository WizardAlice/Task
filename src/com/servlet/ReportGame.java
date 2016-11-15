package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.*;
import com.test.LibConnection;
import com.util.LogInCheck;

public class ReportGame extends HttpServlet{
HttpSession session = null;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");// 防止中文乱码问题
		User user = null;
		user = (User)session.getAttribute("user");
		String[] xiangmu = request.getParameterValues("event");
		String type = request.getParameter("identity");
		for(int i = 0;i < xiangmu.length;i++){
			user.Report(xiangmu[i],type);
		}
			request.getRequestDispatcher("/vip/initialmodel.jsp").forward(request,response);
	}
	

}
