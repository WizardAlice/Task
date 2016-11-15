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
<%
    ResultSet rs=null;
    Admin admin =(Admin)session.getAttribute("admin");
    rs = admin.ShowAllUser();
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
            <h1 class="animated fadeInLeft">所有用户信息</h1>
        </div>
       <div id="search">
            <button class="animated fadeInLeft" class="btn" type="submit"><img src="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1476430764&di=f14b848067e7b96866870a9b17e5d51c&src=http://pic.58pic.com/58pic/14/64/63/96u58PICfAj_1024.jpg" width="20px"></button>
            <input class="input-medium search-query " type="text" name="" id="">
        </div>
        <div id="maincontainer">
        <form action="../UpdateUser" method="post">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr  class="suibian">
                    <th class="animated fadeInLeft">ID</th>
                    <th class="animated fadeInLeft">姓名</th>
                    <th class="animated fadeInLeft">身份证号</th>
                    <th class="animated fadeInLeft">电话</th>
                    <th class="animated fadeInDown">国籍</th>
                    <th class="animated fadeInRight">俱乐部</th>
                    <th class="animated fadeInRight">密码</th>
                    <th class="animated fadeInRight">是否修改</th>
                </tr>
                </thead>
                <tbody id="testmain">

<%while(rs.next()){
	%>
	<tr>
		<td><input class="animated fadeInLeft" id="<%= rs.getString("id")%>" type="text" name="<%= rs.getString("id")%>_id" value="<%= rs.getString("id")%>" readonly="readonly"></td>
        <td><input class="animated fadeInLeft" id="<%= rs.getString("id")%>" type="text" name="<%= rs.getString("id")%>_name" value="<%= rs.getString("name")%>" readonly="readonly"></td>
        <td><input class="animated fadeInLeft" id="<%= rs.getString("id")%>" type="text" name="<%= rs.getString("id")%>_idcard" value="<%= rs.getString("idcard")%>" readonly="readonly"></td>
        <td><input class="animated fadeInLeft" id="<%= rs.getString("id")%>" type="text" name="<%= rs.getString("id")%>_phonenumber" value="<%= rs.getString("phonenumber")%>" readonly="readonly"></td>
        <td><input class="animated fadeInUp" id="<%= rs.getString("id")%>" type="text" name="<%= rs.getString("id")%>_nationality" value="<%= rs.getString("nationality")%>" readonly="readonly"></td>
        <td><input class="animated fadeInRight" id="<%= rs.getString("id")%>" type="text" name="<%= rs.getString("id")%>_club" value="<%= rs.getString("club")%>" readonly="readonly"></td>
        <td><input class="animated fadeInRight" id="<%= rs.getString("id")%>" type="text" name="<%= rs.getString("id")%>_pwd" value="<%= rs.getString("pwd")%>" readonly="readonly"></td>
        <td><input class="animated fadeInRight" id="<%= rs.getString("id")%>" type="button" value="修改" name="<%= rs.getString("id")%>_anniu"></td>
		</tr>
<%}%>
                </tbody>
            </table>
            <button  type="submit" class="btn btn-primary btn-lg active fadeInLeft animated">更新用户信息</button>
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
</style>
<script type="text/javascript">
$(document).ready(function(){

  $('input[type="button"]').click(function(){  
    var mark = $(this).attr("id");
    if(typeof($("input[id='"+mark+"']"+"[type='text']").attr("readonly"))!="undefined"){
         $("input[id='"+mark+"']"+"[type='text']").removeAttr("readonly");
         $(this).val("完成");
    }
    else{
       $("input[id='"+mark+"']"+"[type='text']").attr("readonly","readonly");  
        $(this).val("修改");
    };
       
        /*if(typeof($("input[id='"+mark+"']"+"[type='text']").attr("readonly"))=="undefined"){
            $("input[id='"+mark+"']"+"[type='text']").attr("readonly",readonly);
        }*/
        
        /*else if (typeof($("input[id='"+mark+"']"+"[type='text']").attr("readonly"))=="undefined") {
            $("input[id='"+mark+"']"+"[type='text']").attr("readonly",readonly);
        };*/
        
        //$('input').removeAttr("readonly");
        //$('#input').attr("value","hahah");
        //$('#12').attr("readonly",true);
       
        //$('#12').removeAttr("readonly");
   
  });
});
</script>

</body>
</html>