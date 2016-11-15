 package com.util;
import java.sql.*;

import com.test.LibConnection;

public class LogInCheck {
 
	static Connection connection = LibConnection.getConnection();
    
    public static String isLogin(String identity,String id,String password){
    	Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	if(identity.equals("user")){
	    ResultSet result = null;
	    try {
		result = statement.executeQuery("select * from user where id ='"+id+"' and pwd ='"+password+"'");
	    if(result.next()==false)  return "用户名或密码错误"; 
	    	else return "VALIDUSER";
	    } catch (SQLException e) {
	    	return e.getMessage();
	    }
	}
	if(identity.equals("admin")){
	    ResultSet result = null;
	    try {
		result = statement.executeQuery("select pwd from admin where id ='"+id+"' and pwd ='"+password+"'");
		System.out.println("cardID:"+id+"password"+password);
		if(result.next()==false)  return "用户名或密码错误"; 
	    	else return "VALIDUSER";
	    } catch (SQLException e) {
	    	return e.getMessage();
	    }
	}
	return "WRONG_LOGIC";
    }
    
    
    
    public static void main(String[] args) throws SQLException {
    	System.out.println(isLogin("user","123", "123"));
    }

    
}
