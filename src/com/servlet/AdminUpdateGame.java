package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;
import com.entity.LibSystem;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.test.LibConnection;

public class AdminUpdateGame extends HttpServlet{

	
	HttpSession session = null;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//防止中文乱码问题
		session = request.getSession();
		ResultSet rs = null;
		Admin admin =(Admin)session.getAttribute("admin");
		LibSystem libSystem = new LibSystem();
		rs = libSystem.ShowAllGames();
		String id = null;
		try {
			while (rs.next()) {
				id = rs.getString("id");
				String check1 = id+"_id";
				String check2 = id+"_name";
				String check3 = id+"_signtime";
				String check4 = id+"_signdeadline";
				String check5 = id+"_starttime";
				String check6 = id+"_deadline";
				String check7 = id+"_holder";
				String newgameid = request.getParameter("id");
				String newgamename = request.getParameter("name");
				String newgamesigntime = request.getParameter("signtime");
				String newgamesigndeadline = request.getParameter("signdeadline");
				String newgamestarttime = request.getParameter("starttime");
				String newgamedeadline = request.getParameter("deadline");
				String newgameholder = request.getParameter("holder");
				String one = request.getParameter(check1);
				String two = request.getParameter(check2);
				Date date1 = new Date(request.getParameter(check3));
				Date date2 = new Date(request.getParameter(check4));
				Date date3 = new Date(request.getParameter(check5));
				Date date4 = new Date(request.getParameter(check6));
				String seven = request.getParameter(check7);
				if(admin.Isnewgame(newgameid)){
					admin.creatgame(newgameid,newgamename,newgamesigntime,newgamesigndeadline,newgamestarttime,newgamedeadline,newgameholder);
				}
				else if(!((one==rs.getString("id"))&&(two==rs.getString("name"))&&(request.getParameter(check3)==rs.getString("signtime"))&&(request.getParameter(check4)==rs.getString("signdeadline"))&&(request.getParameter(check5)==rs.getString("starttime"))&&(request.getParameter(check6)==rs.getString("deadline"))&&(seven==rs.getString("holder")))){
				admin.updateGame(one,two,date1,date2,date3,date4,seven);	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   request.getRequestDispatcher("/admin/showallgames.jsp").forward(request, response);
	
	}

}
