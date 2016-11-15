<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh-cn">
<head>
<%@page import="java.sql.*" import="com.entity.*"   import="com.test.LibConnection"%>
<% User user = null;%>

<%user = (User)session.getAttribute("user");
  %>
  <% 
  ResultSet rs = null;
  rs = user.ShowAllInfo();
   %>

    <meta charset="UTF-8">
    <title>test</title>
    <script type="text/javascript" src="/Library/assets/js/jquery-1.8.3.min.js"></script>

    <link rel="stylesheet" href="/Library/assets/css/bootstrap.css">

    <script type="text/javascript" src="/Library/assets/js/bootstrap.js"></script>
     <link rel="stylesheet" href="/Library/assets/css/animate.css">
    <link rel="stylesheet" href="/Library/assets/css/flexslider.css">
     <script type="text/javascript" src="/Library/assets/js/jquery.flexslider.js"></script>

</head>
<body>
<form method="post" action="../ChangeInfo">
<div id="banner">
    <div id="container">
    
        <%while(rs.next()){ %>
        <div id="header" class="gray" >
            <h1 class="animated fadeInDown"><%= rs.getString("name")%></h1>
            
        </div>
        <div id="maincontainer" class="juzhong">
        
           姓名：<input class="animated fadeInRight"  type="text" name="name" value="<%= rs.getString("name")%>" readonly="readonly">
            <br>身份证号：<input class="animated fadeInLeft"  type="text" name="idcard" value="<%= rs.getString("idcard")%>" readonly="readonly">
        	  <br>俱乐部：<input class="animated fadeInRight"  type="text" name="club" value="<%= rs.getString("club")%>" readonly="readonly">
          
        	 <br>电话号码：<input class="animated fadeInRight"  type="text" name="phonenumber" value="<%= rs.getString("phonenumber")%>" readonly="readonly">
         <br>国籍:<input class="animated fadeInLeft"  type="text" name="nationality" value="<%= rs.getString("nationality")%>" readonly="readonly">
         <br>密码：<input class="animated fadeInRight"  type="text" name="pwd" value=<%= rs.getString("pwd")%> readonly="readonly">
         
          <br><input type="button" value="修改" class="btn btn-danger animated fadeInUp">&nbsp&nbsp&nbsp
          <button class="btn btn-primary animated fadeInUp" type="submit">修改个人信息</button>
       </div>
       <%} %>
    </div>
</div>
</form>
<style type="text/css">
    .gray{
        background-color: #2a2017;
        padding-top: 1px;
        padding-bottom: 1px;
    }
    .gray h1{
        color: #c7ddef
    }
   	.juzhong{
    text-align:center;
    font-size:30px;
    }
    input[type="checkbox"]{
    width:30px;
	height:30px;
    }
</style>
<script type="text/javascript">
$(document).ready(function(){
  $('input[type="button"]').click(function(){ 
    if(typeof($("input").attr("readonly"))!="undefined"){
         $("input").removeAttr("readonly");
         $(this).val("完成");
    }
    else{
       $("input").attr("readonly","readonly");  
        $(this).val("修改");
    };
  });
});
</script>   
</body>
</html>