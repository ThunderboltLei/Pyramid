<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getParameter("path");
	String basePath = request.getParameter("basePath");
%>
<!-- header -->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="menu style-1">
            <ul class="menu">
                <li><a href='<%=basePath%>'><span
                        class="glyphicon glyphicon-home"></span> Home</a></li>
                <li><a
                    href="http://sc.chinaz.com/?categories-archives/"
                    class="arrow">准妈妈孕期信息服务管理系统</a> <!-- <div class="mega-menu full-width"> full-widthè®¾ç½®èåä¸ºé¡µé¢å®½åº¦-->
                    <div class="mega-menu">
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?category/graphics-design/">账号管理</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/graphics-design/">准妈妈</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/logos/">医师</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?category/website-designing/">信息管理</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/website-designing/">准妈妈信息</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/html5-css3/">医师信息</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/jquery/">准妈妈检查报告结果信息</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/javascript-2/">孕检流程信息</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?tag/freebie/">数据管理</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?category/icons/">年龄分布图</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/psd-files/">怀孕周期分布图</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/psd-files/">体重趋势图</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/fonts/">孕检结果综合值趋势图</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/free-templates/">婴儿性别比例分布图</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/software-utilities/">事故统计图</a></li>
                            </ol>
                        </div>
                        <div class="col-1">
                            <h4>
                                <a
                                    href="http://sc.chinaz.com/?tag/inspiration/">系统管理</a>
                            </h4>
                            <ol>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/business-cards/">孕检预约</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?category/photography-2/">检查报告进度提醒</a></li>
                                <li><a
                                    href="http://sc.chinaz.com/?tag/poster-design/">营养建议</a></li>
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
                                <li><a
                                    href="<%=basePath%>/followus/help/apis.fly">APIs</a></li>
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