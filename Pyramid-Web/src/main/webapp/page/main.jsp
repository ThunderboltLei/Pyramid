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
    <!-- 2. content -->
    <div class="jumbotron">
        <div class="container-fluid">
            <div>
                <h3>出师表</h3>
                <p>- 诸葛亮</p>
                <p>先帝创业未半而中道崩殂，今天下三分，益州疲弊，此诚危急存亡之秋也。然侍卫之臣不懈于内，忠志之士忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气，不宜妄自菲薄，引喻失义，以塞忠谏之路也。</p>
                <p>宫中府中，俱为一体，陟罚臧否，不宜异同。若有作奸犯科及为忠善者，宜付有司论其刑赏，以昭陛下平明之理，不宜偏私，使内外异法也。</p>
                <p>侍中、侍郎郭攸之、费祎、董允等，此皆良实，志虑忠纯，是以先帝简拔以遗陛下。愚以为宫中之事，事无大小，悉以咨之，然后施行，必能裨补阙漏，有所广益。</p>
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