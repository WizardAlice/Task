package com.entity;
/**
 * @author ��ͨ
 */

import java.sql.*;
import java.util.Calendar;

import com.test.LibConnection;

import java.sql.*;

public class User {
	public static String id;
	static Connection connection = null;
	public User(String username){
		this.id = username;
		connection = LibConnection.getConnection();
		}
	
	public ResultSet ShowAllInfo(){
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		String sql = "select * from user where id = "+id;
		try {
			resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return null;
	}
	
	public ResultSet ShowAllMyEvent() {
		ResultSet resultSet = null;
		Statement statement = null;
		String sql = "SELECT * FROM `report` where `signUpid` = "+id;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static void deleteUser() {
		//delete from user where id = '4'
			Statement sta = null;
			try {
				sta = connection.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql = "delete from user where id = " + id;
			try {
				if (sta.execute(sql)){
					System.out.println("删除成功");
				};
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public static void updateUser(String id,String name,String idcard,String phonenumber,
			String nationnality,String pwd,String club){
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		String sql = "UPDATE user SET name='"+name+"',idcard='"+idcard+"',phonenumber='" +phonenumber+ "',nationality='"+nationnality+"',club='"+club+"',club= '"+club+"',pwd='"+pwd+"' WHERE `id`='"+id+"'";
		System.out.println(sql);
		 try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void main(String args[]){
		User user = new User("123");
		ResultSet resultSet = null;
		resultSet = user.ShowAllMyEvent();
		String a= null;
		String b = null;
		
		try {
			while ( resultSet.next()) {

				System.out.println(resultSet.getString("bievent"));
				System.out.print(resultSet.getString("game_id"));
				a= resultSet.getString("bievent");
				b= resultSet.getString("game_id");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		LibSystem libSystem = new LibSystem();
		  ResultSet resultSet2 = libSystem.eventname(a, b);
		  try {
			while (resultSet2.next()) {
				  System.out.println(resultSet2.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
	
}
