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
<link rel="stylesheet" href="<%=path%>/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet"
    href="<%=path%>/css/bootstrap/bootstrap-theme.min.css" />
<link rel="stylesheet" href="<%=path%>/css/menu/menu.css" />
<link rel="stylesheet" href="<%=path%>/css/menu/style.css" />
<script type="text/javascript" src="<%=path%>/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
    src="<%=path%>/js/bootstrap/bootstrap.min.js"></script>

<!-- Custom JS -->

</head>
<body>
    <!-- 1. navbar -->
    <div id="menu">
        <script type="text/javascript" charset="UTF-8">
        $(function(){
            $("#menu").load('<%=path%>/page/header.jsp', {'basePath':'<%=basePath%>', 'path':'<%=path%>'});
        })
        </script>
    </div>
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container-fluid">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or
                informational website. It includes a large callout
                called a jumbotron and three supporting pieces of
                content. Use it as a starting point to create something
                more unique.</p>
            <p>
                <a class="btn btn-primary btn-lg" role="button">Learn
                    more &raquo;</a>
            </p>
            <div class="container"></div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <ul class="nav nav-pills">
                                <li class="active"><a href="#">Task 01
                                        <span class="badge">42</span>
                                </a></li>
                                <li class=""><a href="#">Home <span
                                        class="badge">33</span></a></li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <p>Donec sed odio dui. Cras justo odio,
                                dapibus ac facilisis in, egestas eget
                                quam. Vestibulum id ligula porta felis
                                euismod semper. Fusce dapibus, tellus ac
                                cursus commodo, tortor mauris
                                condimentum nibh, ut fermentum massa
                                justo sit amet risus.</p>
                            <p style="vertical-align: bottom;">
                                <a class="btn btn-default" href="#"
                                    role="button">View details
                                    &raquo;</a>
                            </p>
                        </div>
                    </div>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title 02</h3>
                        </div>
                        <div class="panel-body">
                            <p>Donec sed odio dui. Cras justo odio,
                                dapibus ac facilisis in, egestas eget
                                quam. Vestibulum id ligula porta felis
                                euismod semper. Fusce dapibus, tellus ac
                                cursus commodo, tortor mauris
                                condimentum nibh, ut fermentum massa
                                justo sit amet risus.</p>
                            <p style="vertical-align: bottom;">
                                <a class="btn btn-default" href="#"
                                    role="button">View details
                                    &raquo;</a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- /.col-sm-4 -->
                <div class="col-sm-4">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title 03</h3>
                        </div>
                        <div class="panel-body">
                            <p>Donec sed odio dui. Cras justo odio,
                                dapibus ac facilisis in, egestas eget
                                quam. Vestibulum id ligula porta felis
                                euismod semper. Fusce dapibus, tellus ac
                                cursus commodo, tortor mauris
                                condimentum nibh, ut fermentum massa
                                justo sit amet risus.</p>
                            <p style="vertical-align: bottom;">
                                <a class="btn btn-default" href="#"
                                    role="button">View details
                                    &raquo;</a>
                            </p>
                        </div>
                    </div>
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title 04</h3>
                        </div>
                        <div class="panel-body">
                            <p>Donec sed odio dui. Cras justo odio,
                                dapibus ac facilisis in, egestas eget
                                quam. Vestibulum id ligula porta felis
                                euismod semper. Fusce dapibus, tellus ac
                                cursus commodo, tortor mauris
                                condimentum nibh, ut fermentum massa
                                justo sit amet risus.</p>
                            <p style="vertical-align: bottom;">
                                <a class="btn btn-default" href="#"
                                    role="button">View details
                                    &raquo;</a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- /.col-sm-4 -->
                <div class="col-sm-4">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title 05</h3>
                        </div>
                        <div class="panel-body">
                            <p>Donec sed odio dui. Cras justo odio,
                                dapibus ac facilisis in, egestas eget
                                quam. Vestibulum id ligula porta felis
                                euismod semper. Fusce dapibus, tellus ac
                                cursus commodo, tortor mauris
                                condimentum nibh, ut fermentum massa
                                justo sit amet risus.</p>
                            <p style="vertical-align: bottom;">
                                <a class="btn btn-default" href="#"
                                    role="button">View details
                                    &raquo;</a>
                            </p>
                        </div>
                    </div>
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title 06</h3>
                        </div>
                        <div class="panel-body">
                            <p>Donec sed odio dui. Cras justo odio,
                                dapibus ac facilisis in, egestas eget
                                quam. Vestibulum id ligula porta felis
                                euismod semper. Fusce dapibus, tellus ac
                                cursus commodo, tortor mauris
                                condimentum nibh, ut fermentum massa
                                justo sit amet risus.</p>
                            <p style="vertical-align: bottom;">
                                <a class="btn btn-default" href="#"
                                    role="button">View details
                                    &raquo;</a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- /.col-sm-4 -->
            </div>
        </div>
    </div>
    <!-- footer -->
    <div id="footer">
        <script type="text/javascript">
        $(function(){
            $("#footer").load("<%=path%>/page/footer.html");
        })
        </script>
    </div>
    <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <%-- <script src="<%=path%>/js/jquery.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script> --%>
</body>
</html>
