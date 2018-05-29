<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="PYRAMID Platform By L.M. On July 2014">
<meta name="author" content="L.M.">
<title>PYRAMID</title>
<link rel="icon" href="<%=path%>/img/PYRAMID.ico" />
<link rel="stylesheet" href="<%=path%>/css/jquery/jquery-ui.css" />
<link rel="stylesheet" href="<%=path%>/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet"
    href="<%=path%>/css/bootstrap/bootstrap-theme.min.css" />
<link rel="stylesheet" href="<%=path%>/css/carousel.css" />
<script type="text/javascript" src="<%=path%>/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
    src="<%=path%>/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
    src="<%=path%>/js/highcharts/highcharts.js"></script>
<script type="text/javascript"
    src="<%=path%>/js/highcharts/modules/exporting.js"></script>
<script type="text/javascript" src="<%=path%>/js/login/login.js"></script>
<script type="text/javascript" src="<%=path%>/js/login/login-slides.js"></script>
</head>
<body>
    <!-- 1. navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top"
        role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle"
                    data-toggle="collapse"
                    data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=basePath%>"
                    style="margin-top: -10px;"> <img alt="PYRAMID"
                    src="<%=path%>/img/PYRAMID.png"> PYRAMID
                </a>
            </div>
            <div class="navbar-collapse collapse">
                <form id="loginForm" method="post" action=""
                    login-form="login-form"
                    class="navbar-form navbar-right" role="form">
                    <div class="form-group">
                        <input input-email="input-email" type="text"
                            placeholder="E-Mail / 用户名"
                            class="form-control">
                    </div>
                    <div class="form-group">
                        <input input-password="input-password"
                            type="password" placeholder="登录密码"
                            class="form-control">
                    </div>
                    <button button-login="button-login" type="submit"
                        class="btn btn-info">登录</button>
                    <button button-register="button-register"
                        type="submit" class="btn btn-warning">注册</button>
                </form>
            </div>
            <!--/.navbar-collapse -->
        </div>
    </div>
    <!-- 2. Main jumbotron for a primary marketing message or call to action -->
    <div class="container-fluid" style="height: 515px; margin-top: 65px;">
        <div class="carousel slide" id="login-carousel"
            data-ride="carousel">
            <ol class="carousel-indicators">
                <li class="active" data-target="#login-carousel"
                    data-slide-to="0"></li>
                <li data-target="#login-carousel" data-slide-to="1"></li>
                <li data-target="#login-carousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <div id="slide_one" align="center">
                        <%-- <img alt="hello" src="<%=path%>/img/01.jpg"> --%>
                    </div>
                    <div class="carousel-caption">
                        <h4>第一个滑动页</h4>
                        <p style="font-size: 15px;">Nulla vitae elit
                            libero, a pharetra augue mollis interdum.</p>
                    </div>
                </div>
                <div class="item">
                    <img alt="900x500"
                        src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI5MDAiIGhlaWdodD0iNTAwIj48cmVjdCBmaWxsPSIjNjY2IiB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgLz48dGV4dCBzdHlsZT0iZm9udC1mYW1pbHk6IEFyaWFsLEhlbHZldGljYSxzYW5zLXNlcmlmOyBmb250LXNpemU6IDU2cHg7IGZvbnQtd2VpZ2h0OiBib2xkOyBkb21pbmFudC1iYXNlbGluZTogY2VudHJhbDsgZmlsbDogIzY2NjsiIHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjQ1MCIgeT0iMjUwIj45MDB4NTAwPC90ZX"
                        data-src="holder.js/900x500/auto/#666:#666">
                    <div class="carousel-caption" abp="3316">
                        <h4>第二个滑动页</h4>
                        <p style="font-size: 15px;">Lorem ipsum
                            dolor sit amet, consectetur adipiscing elit.</p>
                    </div>
                </div>
                <div class="item">
                    <div align="center">
                        <img alt="hello" src="<%=path%>/img/01.jpg"
                            data-src="holder.js/400x300/auto/#3e3e3e:#000000">
                    </div>
                    <div class="carousel-caption">
                        <h4>第三个滑动页</h4>
                        <p style="font-size: 15px;">Praesent commodo
                            cursus magna, vel scelerisque nisl
                            consectetur.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control left" role="button"
                href="#login-carousel" data-slide="prev"> <span
                class="glyphicon glyphicon-chevron-left"></span>
            </a> <a class="carousel-control right" role="button"
                href="#login-carousel" data-slide="next"> <span
                class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </div>
    <!-- 3. footer -->
    <div class="footer" align="center">
        <div class="container-fluid">
            <p class="text-muted">&copy; PYRAMID Platform By L.M. On
                2014.July</p>
        </div>
    </div>
    <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <%-- <script src="<%=path%>/js/jquery/jquery.min.js"></script>
    <script src="<%=path%>/js/bootstrap/bootstrap.min.js"></script> --%>
</body>
</html>