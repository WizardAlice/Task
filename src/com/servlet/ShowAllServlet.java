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
import javax.sound.midi.MidiDevice.Info;

import com.entity.*;
import com.test.*;
import com.util.*;



public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		HttpSession session = null;
		ResultSet resultSet = null;//用于存放搜索结果
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User(123);
		resultSet = user.ShowAllInfo();
		String suibian = null;
		try {
			while(resultSet.next()){
				System.out.println(resultSet.getString("name"));
				request.setAttribute("info",resultSet);
				RequestDispatcher view =request.getRequestDispatcher("info.jsp");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
