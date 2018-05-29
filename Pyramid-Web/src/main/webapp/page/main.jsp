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
</head>
<body>
    <!-- 1. navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top"
        role="navigation">
        <div class="container-fluid">
            <div class="menu style-1">
                <ul class="menu">
                    <li><a href="<%=basePath%>">Home</a></li>
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
                    <li><a href="http://sc.chinaz.com/?contactus/">Contact
                            Us</a></li>
                    <li><a
                        href="http://sc.chinaz.com/?social-share/"
                        class="arrow">Follow Us</a>
                        <ul>
                            <li><a
                                href="http://sc.chinaz.com/?karachicorner"
                                class="rss" title="Subscribe to RSS">RSS</a></li>
                            <li><a href="http://sc.chinaz.com"
                                class="twitter"
                                title="Follow us on Twitter">Twitter</a></li>
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
                    <li><a
                        href="http://sc.chinaz.com/?categories-archives/"
                        class="arrow">Temp 01</a>
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
                        </div></li>
                    <li><a
                        href="http://sc.chinaz.com/?categories-archives/"
                        class="arrow">Temp 02</a>
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
    <!-- 2. content -->
</body>
</html>