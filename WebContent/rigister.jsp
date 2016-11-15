<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>运动会报名系统</title>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/Library/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/Library/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="/Library/assets/fonts/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="/Library/assets/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="/Library/assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="/Library/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="/Library/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="/Library/assets/js/html5shiv.min.js"></script>
		<script src="/Library/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
<body>
	<div id="loginModal" class="modal show">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close">x</button>
        <h1 class="text-center text-primary">新用户注册</h1>
      </div>
      <div class="modal-body">
        <form method="post" action="Rigister" class="form col-md-12 center-block">
          <div class="form-group">
          <span style="font-size:30px">注册信息</span> <br>
            <input type="text" name = "id" class="form-control input-lg" placeholder="注册ID">
          </div>
          <div class="form-group">
            <input type="text" name = "name" class="form-control input-lg" placeholder="姓名">
          </div>
          <div class="form-group">
            <input type="text" name = "idcard" class="form-control input-lg" placeholder="身份证号">
          </div>
          <div class="form-group">
            <input type="text" name = "phonenumber" class="form-control input-lg" placeholder="电话号码">
          </div>
          <div class="form-group">
            <input type="text" name = "nationality" class="form-control input-lg" placeholder="国籍">
          </div>
               <div class="form-group">
            <input type="text" name = "club" class="form-control input-lg" placeholder="俱乐部">
          </div>
          <div class="form-group">
            <input type="password" name = "pwd1" class="form-control input-lg" placeholder="密码">
          </div>
          <div class="form-group">
            <input type="password" name = "pwd2" class="form-control input-lg" placeholder="确认密码">
          </div>
         
          <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block" type="submit">注册</button>
            <br>
            <br>
            <br>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>
</body>
<style type="text/css">
	body{
 font-family: 'microsoft yahei',Arial,sans-serif;
 margin:10;
 padding:10;
}
</style>
	
</html>
