package com.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.jar.Attributes.Name;

import com.test.LibConnection;

/**
 * 
 * @author ZM
 *
 */
public class Admin {
	public static String id;
	static Connection connection = null;
	public Admin(String username){
		this.id = username;
		connection = LibConnection.getConnection();
	}

	public static ResultSet showusenum(){
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT count(`id`) from user";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
			
	public  ResultSet ShowAllUser(){
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "SELECT * FROM user;";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateUser(String id2, String check1, String check2, String check3, String check4, String check5,
			String check7, String check8) {
		// TODO Auto-generated method stub
		String sql = "UPDATE user SET id= '"+check1+"', name='"+check2+"',idcard='"+check3+"',phonenumber='"+check4+"',nationality='"+check5+"',club= '"+check7+"',pwd='"+check8+"' WHERE `id`='"+id2+"'";
		System.out.println(sql);
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateGame(String parameter, String parameter2, java.util.Date date1, java.util.Date date2, java.util.Date date3,
			java.util.Date date4, String parameter7) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `task`.`game` SET `id`='"+parameter+"', `name`='"+parameter2+"', `signtime`='"+date1+"', `signdeadline`='"+date2+"', `starttime`='"+date3+"', `deadline`='"+date4+"', `holder`='"+parameter7+"' WHERE `id`='"+parameter+"';";
		System.out.println(sql);
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean Isnewgame(String a) {
		ResultSet resultSet = null;
		Statement statement = null;
		String sql = "select * from `game` where `id` = "+a;
		System.out.println(sql);
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(!resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void main(String args[]){
		Admin admin = new Admin("Eric");
		System.out.println(admin.Isnewgame("324"));
	}

	public void creatgame(String newgameid, String newgamename, String newgamesigntime, String newgamesigndeadline,
			String newgamestarttime, String newgamedeadline, String newgameholder) {
		// TODO Auto-generated method stub
		Date date1 =null;
		Date date2 =null;
		Date date3 =null;
		Date date4 =null;
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
		    date1 = (Date) sdf.parse(newgamesigntime); 
		    date2 = (Date) sdf.parse(newgamesigndeadline); 
		    date3 = (Date) sdf.parse(newgamestarttime); 
		    date4 = (Date) sdf.parse(newgamedeadline); 
		}  
		catch (ParseException e)  
		{  
		    System.out.println(e.getMessage());  
		}  
		String sql = "INSERT INTO `task`.`game` (`id`, `name`, `signtime`, `signdeadline`, `starttime`, `deadline`, `holder`) VALUES ('"+newgameid+"', '"+newgamename+"', '"+date1+"', '"+date2+"', '"+date3+"', '"+date4+"', '"+newgameholder+"')";
		System.out.println(sql);
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
