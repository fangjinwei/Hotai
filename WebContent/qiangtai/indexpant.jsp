<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="cn.it.backstag.util.App"%>
<%@include file="/qiangtai/public/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<meta name="format-detection" content="address=no" />



<title><s:property value="#session.project.project_name" /></title>
<script type="text/javascript">

	function yanzheng() {

		var tel = $("#tel").val();
		var reg = /^1\d{10}$/;
		//var reg=/^(13[0-9]{9})|(15[89][0-9]{8})$/;
		if (tel == "" || tel == "请输入电话") {
			DIVAlert('关闭', '电话不能为空！');

		}

		if (!reg.test(tel) && tel != "" && tel != "请输入电话") {
			DIVAlert('关闭', '手机号码格式不正确，例如13888888888，必须11位！');

		}

		if (tel != "请输入电话" && reg.test(tel) && tel != "") {
			$.ajax({
				type : "POST",
				url : "QianTaiUserAction_getMessage",
				data : {
					tel : tel
				},
				success : function(data) {
					if (data == 1) {
						DIVAlert('关闭', '您的验证码已发送，5分钟内有效！');
						flag = 1;

					} else {
						DIVAlert('关闭', '异常');
					}
				},

				error : function() {
					alert("出错了！");
				}
			});

		}

	};

	//验证表单的方法
	function check() {
		var username = $("#username").val();
		if (username == "" || username == "请输入姓名") {
			DIVAlert('关闭', '姓名不能为空！');
			return false;
		}

		var tel = $("#tel").val();
		var reg = /^1\d{10}$/;
		if (tel == "" || tel == "请输入电话") {
			DIVAlert('关闭', '电话不能为空！');
			return false;
		}

		if (!reg.test(tel)) {
			DIVAlert('关闭', '手机号码格式不正确，例如13888888888，必须11位！');
			return false;
		}

		//var ver = $("#ver").val();
		//if (ver == "" || ver == "请输入短信验证码") {
	//		DIVAlert('关闭', '请输入短信验证码！');
		//	return false;
	//	}

		if (username != "" & username != "请输入姓名" & tel != ""
				& tel != "请输入电话" & reg.test(tel) //& ver != ""
				//& ver != "请输入验证码"
				) {
			$.post("QianTaiUserAction_usernameandtel", {
				'username' : username,
				'tel' : tel,
				//'suiji' : ver
			}, function(data) {
				if (data == 1) {

					location.href = "${backstage}/QianTaiUserAction_index2?id=<s:property value="#session.project.id"/>";

				} else if (data == 0) {
					DIVAlert('关闭', '短信验证码错误!');
				} else {
					DIVAlert('关闭', '错误!');
				}
			});

			return false;
		}

		return false;
	}

	//调用方法
	$(function() {
		var now = new Date();
		   var hours=now.getHours();
		    if(hours>=17){		    
		    location.href="${backstage}/QianTaiUserAction_index7?id=<s:property value="#session.project.id"/>";
		    }
		$("#ssss").click(check);
	});
</script>






</head>

<body>
	  
</body>
</html>
