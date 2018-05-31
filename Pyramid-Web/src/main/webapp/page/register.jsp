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
<link rel="stylesheet" href="<%=path%>/css/bootstrap/bootstrap.css" />
<link rel="stylesheet"
    href="<%=path%>/css/bootstrap/bootstrap-theme.min.css" />
<script type="text/javascript" src="<%=path%>/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
    src="<%=path%>/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery/jquery.form.js"></script>
<script type="text/javascript"
    src="<%=path%>/js/jquery/jquery.transit.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#signupForm").submit(function(e) {
			var isValid = true;
			$("#signupForm .validate").each(function(i) {
				var attr = $(this).attr('valid');
				if (!(attr == "true" || attr == "false")) {
					checkFalse("#" + $(this).attr("id"));
					isValid = false;
				}
				if (!checkIsValid("#" + $(this).attr("id"))) {
					checkAlert("#" + $(this).attr("id"));
					isValid = false;
				}
			})
			if (!$("#acceptTerms").hasClass("checked")) {
				showTooltip("#termsMsg")
				isValid = false;
			}
			if (!isValid) {
				e.preventDefault();
			}
		});
		$("#acceptTerms").click(function() {
			hideTooltip("#termsMsg")
		})
		$("#model_Username").keydown(function() {
			thisVal = $(this).val();
			if ((thisVal.length + 1 < 3) || (thisVal.length + 1 > 25)) {
				checkFalse("#model_Username");
			} else {
				checkTrue("#model_Username");
			}
		});
		$("#model_Password").keydown(function() {
			thisVal = $(this).val();
			if ((thisVal.length + 1 <= 6) || (thisVal.length + 1 > 30)) {
				checkFalse("#model_Password");
			} else {
				checkTrue("#model_Password");
			}
		});

		function valEemail(thisVal) {
			if (/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/
					.test(thisVal)) {

				hideTooltip("#inuse");
				checkTrue("#model_Email");

			} else {
				hideTooltip("#inuse");
				checkFalse("#model_Email");
			}
		}
		$("#model_Email").keyup(function() {
			var thisVal = $(this).val();
			valEemail(thisVal);
		});
		$("#model_Email").change(function() {
			var thisVal = $(this).val();
			valEemail(thisVal);
		});
	});
</script>
</head>
<body>
    <center>
        <br> <br>
        </h1>
        <br> <input style="margin: 100px auto; display: block;"
            type="button" onClick="openPopup('#signUp');" value="弹出层注册" />
    </center>
    <div id="signUp" class="popup dark"
        style="height: 355px; width: 315px; margin-left: -150px; margin-top: -170px;">
        <form action="" id="signupForm" method="post" autocomplete="off">
            <div class="topBar">
                <h3>注册新会员</h3>
                <div class="popupClose"></div>
            </div>
            <div class="popupContent">
                <div style="position: relative;">
                    请输入你的用户名：<br />
                    <div class="inputHolder">
                        <input Class="validate" id="model_Username"
                            name="model.Username" style="width: 250px;"
                            type="text" value="" /> <img class="true"
                            src="<%=path%>/img/checkSmall.png" /> <img
                            class="false"
                            src="<%=path%>/img//crossSmall.png" />
                    </div>
                    你的邮箱地址：<br />
                    <div class="inputHolder">
                        <input Class="validate" id="model_Email"
                            name="model.Email" style="width: 250px;"
                            type="text" value="" /> <img class="true"
                            src="<%=path%>/img//checkSmall.png" /> <img
                            class="false"
                            src="<%=path%>/img//crossSmall.png" />
                        <div class="tooltip"
                            style="top: -35px; right: 32px;" id="inuse">
                            <div class="tLeft"></div>
                            <div class="tRight"></div>
                            <div class="text">邮箱已经有人使用</div>
                        </div>
                    </div>
                    密码：<br />
                    <div class="inputHolder">
                        <input Class="validate" id="model_Password"
                            name="model.Password" style="width: 250px;"
                            type="password" value="" /> <img
                            class="true" src="images/checkSmall.png" />
                        <img class="false" src="images/crossSmall.png" />
                    </div>
                </div>
            </div>
            <div class="botBar">
                <div class="popupButtons">
                    <input type="submit" class="button white"
                        value="立即注册" />
                </div>
                <div class="popupBottonText">
                    <div class="checkbox" id="acceptTerms"
                        style="margin-bottom: 0px;">同意注册协议</div>
                </div>
                <div class="tooltipLeft" style="top: -25px; left: 42px;"
                    id="termsMsg">
                    <div class="tLeft"></div>
                    <div class="tRight"></div>
                    <div class="text">请同意注册协议</div>
                </div>
            </div>
        </form>
    </div>
    <div
        style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">
        <p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗.
            不支持IE8及以下浏览器。</p>
        </p>
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
