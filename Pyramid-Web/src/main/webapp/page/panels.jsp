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
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="menu style-1">
            <ul class="menu">
                <li><a href="<%=basePath%>"><span
                        class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a
                    href="http://sc.chinaz.com/?categories-archives/"
                    class="arrow">Categories</a> <!-- <div class="mega-menu full-width"> full-width设置菜单为页面宽度-->
                    <div class="mega-menu">
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?category/graphics-design/">Graphic
                                    Design</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/graphics-design/">Design</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/logos/">Logo
                                        Design</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/tutorials/">Tutorials</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/mehndi-designs/">Mehndi
                                        Designs</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/vector-graphics/">Vector
                                        Graphics</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/wallpapers/">Wallpapers</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?category/website-designing/">Web
                                    Design</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/website-designing/">Website
                                        Design</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/html5-css3/">HTML5
                                        &amp; CSS3</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/jquery/">jQuery</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/javascript-2/">Javascript</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/code/">Coding</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?tag/freebie/">Freebies</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/fonts/">Free
                                        Fonts</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/icons/">Icons</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/psd-files/">Free
                                        PSD Files</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/free-templates/">PSD
                                        Templats</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/software-utilities/">Software
                                        &amp; Utilities</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?tag/inspiration/">Inspiration</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/business-cards/">Business
                                        Cards</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/photography-2/">Photography</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/poster-design/">Poster
                                        Design</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/typography/">Typography</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/illustration-art/">Illustration
                                        Art</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?category/wordpress/">Wordpress</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/wordpress-themes/">Wordpress
                                        Themes</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/wordpress-plugins/">Wordpress
                                        Plugins</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?category/technology/">Technology</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/apple/">Apple</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/google/">Google</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/facebook/">Facebook</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/iphone-games/">iPhone
                                        Games</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/mobile-app-software/">iPhone
                                        Apps</a></li>
                            </ol>
                        </div>
                    </div></li>
                <li><a href="http://sc.chinaz.com/?social-share/"
                    class="arrow">Follow Us</a>
                    <ul>
                        <li><a
                            href="http://sc.chinaz.com/?karachicorner"
                            class="rss" title="Subscribe to RSS">RSS</a></li>
                        <li><a href="http://sc.chinaz.com"
                            class="twitter" title="Follow us on Twitter">Twitter</a></li>
                        <li><a href="http://sc.chinaz.com"
                            class="facebook"
                            title="Follow us on Facebook">Facebook</a></li>
                        <li><a href="https://sc.chinaz.com"
                            class="googleplus"
                            title="Follow us on Google+">Google+</a></li>
                        <li><a href="http://sc.chinaz.com/"
                            class="pinterest"
                            title="Follow us on Pinterest">Pinterest</a></li>
                        <li><a href="http://sc.chinaz.com"
                            class="stumbleupon"
                            title="Follow us on Stumbleupon">Stumbleupon</a></li>
                    </ul></li>
                <li><a href="#" class="arrow">Algorithms</a>
                    <div class="mega-menu">
                        <div class="col-1">
                            <h4>
                                <a href="#">Sorting</a>
                            </h4>
                            <ol>
                                <li><a href="#">Quick Sorting</a></li>
                                <li><a href="#">Bubble Sorting</a></li>
                                <li><a href="#">Merge Sorting</a></li>
                                <li><a href="#">Selection
                                        Sorting</a></li>
                                <li><a href="#">Insertion
                                        Sorting</a></li>
                                <li><a href="#">Shell Sorting</a></li>
                                <li><a href="#">Heap Sorting</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a href="#">Clusterings</a>
                            </h4>
                            <ol>
                                <li><a href="#">Design</a></li>
                                <li><a href="#">Logo Design</a></li>
                                <li><a href="#">Tutorials</a></li>
                                <li><a href="#">Mehndi Designs</a></li>
                                <li><a href="#">Vector Graphics</a></li>
                                <li><a href="#">Wallpapers</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a href="#">Classifications</a>
                            </h4>
                            <ol>
                                <li><a href="#">Website Design</a></li>
                                <li><a href="#">HTML5 &amp;
                                        CSS3</a></li>
                                <li><a href="#">jQuery</a></li>
                                <li><a href="#">Javascript</a></li>
                                <li><a href="#">Coding</a></li>
                            </ol>
                        </div>
                    </div></li>
                <li><a href="#" class="arrow"><span
                        class="glyphicon glyphicon-question-sign"></span>
                        Help</a>
                    <div class="mega-menu">
                        <div class="col-1">
                            <h4>
                                <a href="#">Follow Us</a>
                            </h4>
                            <ol>
                                <li><a href="#"><span
                                        class="glyphicon glyphicon-usd"></span>
                                        Donations</a></li>
                                <li><a href="#"><span
                                        class="glyphicon glyphicon-earphone"></span>
                                        Connect To Me</a></li>
                                <li><a href="#">New Trends</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a href="#">Help</a>
                            </h4>
                            <ol>
                                <li><a href="#"><span
                                        class="glyphicon glyphicon-book"></span>
                                        Docs</a></li>
                                <li><a href="#">APIs</a></li>
                            </ol>
                        </div>
                    </div></li>
                <li class="right" style="margin-right: 10px;">
                    <div id="sidesearch">
                        <form class="navbar-form navbar-right"
                            role="form">
                            <div class="form-group">
                                <input id="s" name="s"
                                    class="form-control sidesearch_input"
                                    type="text"
                                    style="height: 30px; background-color: #fff;"
                                    value="e.g: 查询信息"
                                    onfocus="if (this.value == 'e.g: 查询信息') {this.value = '';}"
                                    x-webkit-speech=""
                                    onwebkitspeechchange="transcribe(this.value)"
                                    onblur="if (this.value == '') {this.value = 'e.g: 查询信息';}">
                                <input type="image"
                                    class="sidesearch_submit"
                                    src="<%=path%>/img/sidesearchsubmit.png" />
                            </div>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </div>
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
