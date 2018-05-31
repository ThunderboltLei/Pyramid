<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
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
            $("#menu").load('<%=path%>/page/header.jsp', {
            		'basePath':'<%=basePath%>',
            		'path':'<%=path%>'
            	});
        })
        </script>
    </div>
    <!-- 2. content -->
    <div class="jumbotron">
        <div class="container-fluid">
            <div>
                <h1>Hello, world!</h1>
                <p>This is a template for a simple marketing or
                    informational website. It includes a large callout
                    called a jumbotron and three supporting pieces of
                    content. Use it as a starting point to create
                    something more unique.</p>
                <p>
                    <a class="btn btn-primary btn-lg" role="button">Learn
                        more &raquo;</a>
                </p>
            </div>
            <div class="container"></div>
        </div>
    </div>
    <!-- 3.footer -->
    <div id="footer">
        <script type="text/javascript">
        $(function(){
            $("#footer").load("<%=path%>/page/footer.html");
		})
		</script>
    </div>
</body>
</html>