/**
 * login.js
 */
$(function() {
			// LOGIN
			$("[button-login]").click(function() {
						var email = $("[input-email]").val();
						var password = $("[input-password]").val();
						alert(email + ", " + password);

						var form = document.getElementById("loginForm");
						form.method = "post";
						form.action = "./login/toLogin.fly";
						form.submit();
					});

			// REGISTER
			$("[button-register]").click(function() {
						var form = document.getElementById("loginForm");
						form.method = "post";
						form.action = "./login/toRegister.fly";
						form.submit();
					});
		});