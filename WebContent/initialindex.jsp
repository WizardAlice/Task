<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>运动会</title>
    <link rel="stylesheet" href="/Library/assets/css/bootstrap.css">

    <link rel="stylesheet" href="/Library/assets/css/animate.css">
    <link rel="stylesheet" href="/Library/assets/css/flexslider.css">

    <script type="text/javascript" src="/Library/assets/js/jquery-1.11.0.min.js"></script>

    <script src="/Library/assets/js/3d_js.js" type="text/javascript"></script>

    <script type="text/javascript" src="/Library/assets/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="/Library/assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="/Library/assets/js/jquery.hover3d.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a href="http://www.baidu.com"><img
                        src="/Library/assets/img/logo.png" alt="" class="animated fadeInLeft"></a>
                </div>
                <div class="collapse navbar-collapse fadeInDown animated" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav animated fadeInDown">
                        <li class="active">
                            <a href="/Library/gameview.jsp">近期赛事</a>
                        </li>
 
                        <li>
                            <a href="/Library/newlogin.jsp">我的信息</a>
                        </li>
                        <li>
                            <a href="/Library/newlogin.jsp">已参加赛事</a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left " role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" />
                        </div> <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                    <a href="/Library/newlogin.jsp"><button name="login" style="position: absolute;margin-top: 10px;margin-left: 370px" >登陆</button></a>
                    <a href="/Library/rigister.jsp"><button name="rigister" style="position: absolute;margin-top: 40px;margin-left: 370px">注册</button></a>
                </div>
            </nav>
            <div class="jumbotron">
                <div id="div_01" class="flexslider animated wow swing pic">
                    <ul class="slides">
                        <li class="layer-1"><img src="/Library/assets/img/运动会1.jpg" height=auto width="1000px"></li>
                        <li class="layer-2"><img src="/Library/assets/img/运动会2.jpg" height=auto width="1000px"></li>
                        <li class="layer-3"><img src="/Library/assets/img/运动会3.jpg" height=auto width="1000px"></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <h2>
                运动的好处？
            </h2>
            <p>
                在骨头生长旺盛时期，合理的体育锻炼能促进血液循环，增加对骨的血液供应，使正处于旺盛造骨时期的骨组织获得更多原料，从而加速造骨过程;在参加各种体育活动过程中，使骨骼受到各种刺激，对骨骼的生长十分有益。经调查研究证明，经常参加体育锻炼的10-14岁的学生要比同龄的不经常锻炼的学生身高高出4-8厘米。     </p>
            <p>
                <a class="btn" href="#">View details »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                Heading
            </h2>
            <p>
                Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
            </p>
            <p>
                <a class="btn" href="#">View details »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                Heading
            </h2>
            <p>
                Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
            </p>
            <p>
                <a class="btn" href="#">View details »</a>
            </p>
        </div>
    </div>
</div>
<script src="../src/js/wow.min.js"  rel="stylesheet"></script>
<script>
    new WOW().init();
</script>
<script>
    $(document).ready(function(){
        $(".pic").hover3d({
            selector: ".slides",
            shine: true,
            sensitivity: 300,
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.flexslider').flexslider({
            animation : "fade",
            animationLoop : "true",
            slideshowSpeed : "7000"
        });
    })
</script>

</body>
</html>