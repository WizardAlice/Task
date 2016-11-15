package com.entity;
/**
 * @author Բ��
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.test.LibConnection;

public class LibSystem {
	static Connection connection = null;
static{
			connection = LibConnection.getConnection();
}
public ResultSet ShowAllGames(){
	ResultSet resultSet = null;
	Statement statement = null;
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sql = "Select * from game";
	try {
		resultSet = statement.executeQuery(sql);
		return resultSet;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultSet;
}
public static void insertUser(String id,String name,String idcard,String phonenumber,
String nationnality,String pwd1,String club ) {
	Statement statement = null;
	try {
		statement = connection.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		String sql = "select * from user where id =" + id;
		
		ResultSet res = null;
		try {
			res = statement.executeQuery(sql);
			if (res.next()){
				System.out.println("id已经被注册了");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		sql = "INSERT INTO `user` VALUES ('"+id+"','"+name+"','"+idcard+" ','"+phonenumber+"','"+nationnality+"',null,'"+pwd1+"','"+club+"')";
		System.out.println(sql);
		
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public ResultSet ShowThisGames(String gameid){
	ResultSet resultSet = null;
	Statement statement = null;
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sql = "Select name from game where `id`='"+gameid+"'";
	try {
		resultSet = statement.executeQuery(sql);
		return resultSet;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultSet;
}
public ResultSet ShowAllEvent(String gameid){
	ResultSet resultSet = null;
	Statement statement = null;
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sql = "Select * from event where `game_id` = '"+gameid+"'";
	try {
		resultSet = statement.executeQuery(sql);
		return resultSet;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultSet;
}

public ResultSet eventname(String index,String game_id) {
	ResultSet resultSet = null;
	Statement statement = null;
	String sql = "SELECT * FROM `event` where `index` = "+index+" and `game_id` = "+game_id;
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
public ResultSet gamename(String id) {
	ResultSet resultSet = null;
	Statement statement = null;
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sql = "SELECT * FROM game where id ="+id;
	try {
		resultSet = statement.executeQuery(sql);
		return resultSet;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultSet;
}

public static void  main(String args[]) {
	LibSystem libSystem = new LibSystem();
	ResultSet resultSet = libSystem.ShowAllGames();
	try {
		while (resultSet.next()) {
			try {
				System.out.println(resultSet.getString("signtime"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}