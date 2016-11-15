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
  <% String gameid=  request.getParameter("gameid"); 
   LibSystem libSystem = new LibSystem();
   ResultSet eventname = null;
   eventname = libSystem.ShowAllEvent(gameid);
   ResultSet gamename =null;
   gamename = libSystem.ShowThisGames(gameid);
   ResultSet resultSet = null;
   resultSet = user.ShowAllInfo();
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

<div id="banner">
    <div id="container">
        <div id="header" class="gray" >
        <%while(gamename.next()){ %>
            <h1 class="animated fadeInLeft">报名<%= gamename.getString("name")%></h1>
            <%} %>
        </div>
       
        <div id="maincontainer" class="juzhong">
         <form method="post" action="Report" class="form col-md-12 center-block">
        <div style=" text-align:left;" class="animated fadeInDown"><span style="font-size:22px;">比赛项目：</span></div>
        <div class="animated fadeInLeft"><%while(eventname.next()){ %>
        <input type="checkbox" name="event" value=<%=eventname.getString("id")%>><%=eventname.getString("name")%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
          <%} %>
          </div>
          <div style=" text-align:left;" class="animated fadeInDown"><span style="font-size:22px;">个人信息确认：</span></div>
          <%while(resultSet.next()){ %>
          <div class="animated fadeInRight">ID:<%=user.id%></div>
          <div class="animated fadeInLeft">姓名:<%=resultSet.getString("name")%></div>
             <div class="animated fadeInRight">国籍:<%=resultSet.getString("nationality")%></div>
           <div class="animated fadeInLeft">身份证号:<%=resultSet.getString("idcard")%></div>
           <div class="animated fadeInRight">电话号码:<%=resultSet.getString("phonenumber")%></div>
           <div style=" text-align:left;" class="animated fadeInDown"><span style="font-size:22px;">报名方式：</span></div>
           <div class="animated fadeInUp"><INPUT  type="radio" name="identity" value="personal" >个人&nbsp&nbsp&nbsp
			<INPUT type="radio" name="identity" value="club" >团体（<%=resultSet.getString("club")%>）</div>
             <%} %> 
           <div class="animated fadeInUp"><a href="/Library/vip/changeinfo.jsp"><input type="button" value="修改个人信息"  class="btn btn-danger"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="submit"  class="btn btn-primary">报名</button></div>
       </form>
       </div>
    </div>
</div>

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

     
</body>
</html>