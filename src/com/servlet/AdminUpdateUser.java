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
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.test.LibConnection;

public class AdminUpdateUser extends HttpServlet{

	
	HttpSession session = null;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//防止中文乱码问题
		session = request.getSession();
		ResultSet rs = null;
		Admin admin =(Admin)session.getAttribute("admin");
		rs = admin.ShowAllUser();
		String id = null;
		try {
			while (rs.next()) {
				id = rs.getString("id");
				String check1 = id+"_id";
				String check2 = id+"_name";
				String check3 = id+"_idcard";
				String check4 = id+"_phonenumber";
				String check5 = id+"_nationality";
				String check7 = id+"_club";
				String check8 = id+"_pwd";
				System.out.println(check2);
				System.out.println(request.getParameter(check2));
				if(!((request.getParameter(check1)==rs.getString("id"))&&(request.getParameter(check2)==rs.getString("name"))&&(request.getParameter(check3)==rs.getString("idcard"))&&(request.getParameter(check4)==rs.getString("phonenumber"))&&(request.getParameter(check5)==rs.getString("nationality"))&&(request.getParameter(check7)==rs.getString("club"))&&(request.getParameter(check8)==rs.getString("pwd")))){
					admin.updateUser(id,(request.getParameter(check1)),(request.getParameter(check2)),(request.getParameter(check3)),(request.getParameter(check4)),(request.getParameter(check5)),(request.getParameter(check7)),(request.getParameter(check8)));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   request.getRequestDispatcher("/admin/showalluser.jsp").forward(request, response);
	
	}

}
