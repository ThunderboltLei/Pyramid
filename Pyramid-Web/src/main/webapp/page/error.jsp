<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="PYRAMID Platform By L.M. On July 2014">
<meta name="author" content="L.M.">
<title>PYRAMID</title>
<link rel="icon" href="<%=path%>/img/PYRAMID.ico">

<!-- Bootstrap core CSS -->
<link href="<%=path%>/css/bootstrap/bootstrap.min.css" rel="stylesheet">

<!-- CUSTOM STYLES -->
<link href="<%=path%>/css/error.css" rel="stylesheet" />
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="header-div">
        <div class="overlay">
            <div class="container-fluid">
                <div class="row text-center">
                    <!--                     <div class="col-md-4"> -->
                    <%--                         <img src="<%=path%>/img/PYRAMID.png" alt="" /> --%>
                    <!--                     </div> -->
                    <div class="col-md-8">
                        <h1>
                            Sorry, we Found Error <strong>404 !
                            </strong>
                        </h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- HEADER END -->
    <section class="section-text">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <h3>Possible Causes Of this Error</h3>
                    <ul>
                        <li>The resouce you are looking for is not
                            here or moved.</li>
                        <li>Somebody or admin has deleted the page
                            for some reason.</li>
                        <li>There are also some other reasons that
                            can't be disclosed here so you shoould
                            contact admin at <strong>help@admindomain.com</strong>
                        </li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <div class="alert alert-info">
                        In case of emergency you can call us at <strong>+86-010-110</strong>
                        and reach us at our headquarter located : <strong>BeiJing,
                            China.</strong>
                    </div>
                </div>
                <div class="col-md-3 text-center">
                    <h2>Quick Links</h2>
                    <hr />
                    <a href="<%=basePath%>" class="btn btn-info">Navigate
                        to Home Page</a>
                    <hr />
                    <a
                        href="mailto:help@admindomain.com?Subject=Hello%20Subject"
                        class="btn  btn-warning">Launch a Qucik
                        e-mail</a>
                </div>
            </div>
        </div>
    </section>
    <!-- TEXT SECTION END -->
    <!--     <div class="header-div"> -->
    <!--         <div class="overlay"> -->
    <!--             <div class="container"> -->
    <!--                 <div class="row text-center"> -->
    <!--                     <div class="col-md-12"> -->
    <!--                         <h1> -->
    <!--                             Sorry, <strong>For Inconvenience </strong> -->
    <!--                         </h1> -->
    <!--                     </div> -->
    <!--                 </div> -->
    <!--             </div> -->
    <!--         </div> -->
    <!--     </div> -->
    <!-- HEADER DIV REPLICATE END -->
    <!-- 3. footer -->
    <div id="footer">
        <script type="text/javascript">
        $(function(){
        	$("#footer").load("<%=path%>/page/footer.html");
        })
        </script>
    </div>
    <!-- FOOTER SECTION END -->
    <!-- REQUIRED SCRIPTS FILES -->
    <!-- CORE JQUERY FILE -->
    <script src="<%=path%>/js/jquery/jquery.min.js"></script>
    <!-- REQUIRED BOOTSTRAP SCRIPTS -->
    <script src="<%=path%>/js/bootstrap/bootstrap.min.js"></script>

</body>

</html>

