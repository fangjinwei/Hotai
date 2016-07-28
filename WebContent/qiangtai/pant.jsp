<%@ page language="java" pageEncoding="UTF-8"%>
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

		var ver = $("#ver").val();
		if (ver == "" || ver == "请输入短信验证码") {
			DIVAlert('关闭', '请输入短信验证码！');
			return false;
		}

		if (username != "" & username != "请输入姓名" & tel != ""
				& tel != "请输入电话" & reg.test(tel) ) {
			$.post("QianTaiUserPantAction_save", {
				'username' : username,
				'tel' : tel
			}, function(data) {
				if (data == "true") {

					location.href = "${backstage}/QianTaiUserPantAction_pant1?id=<s:property value="#session.project.id"/>";

				} else {		
					location.href = "${backstage}/QianTaiUserPantAction_pant?id=<s:property value="#session.project.id"/>";
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
		    location.href="${backstage}/QianTaiUserPantAction_pant5?id=<s:property value="#session.project.id"/>";
		    }
		 $("#ssss").click(check);
	});
</script>






</head>

<body>
	<s:property value="#session.project.pant" escapeHtml="false"/>
</body>
</html>
