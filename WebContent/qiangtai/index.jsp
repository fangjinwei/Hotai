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
<link href="${backstage}/qiangtai/css/Style.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
#suji {
	display: none;
}

<
style type ="text /css">#code {
	font-family: Arial;
	font-style: italic;
	font-weight: bold;
	border: 0;
	letter-spacing: 2px;
	color: blue;
}
</style>

<title><s:property value="#session.project.project_name" /></title>
<script type="text/javascript">
    var countdown=60;
     var time= function settime(obj) { 
	    if (countdown == 0) { 
	        obj.removeAttribute("disabled");    
	        obj.value="免费获取验证码"; 
	        countdown = 60; 
	        return;
	    } else { 
	        obj.setAttribute("disabled", true); 
	        obj.value="重新发送(" + countdown + ")"; 
	        countdown--; 
	    } 
	setTimeout(function() { 
	    settime(obj) }
	    ,1000) 
     };
	function yanzheng(obj) {
	        time(obj);
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

					} else if(data==2){
						DIVAlert('关闭', '状态码异常，发送失败！');
					}else {
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

		var ver = $("#ver").val();
		if (ver == "" || ver == "请输入短信验证码") {
			DIVAlert('关闭', '请输入短信验证码！');
			return false;
		}

		if (username != "" & username != "请输入姓名" & tel != ""
				& tel != "请输入电话" & reg.test(tel) & ver != ""
				& ver != "请输入验证码") {
			$.post("QianTaiUserAction_usernameandtel", {
				'username' : username,
				'tel' : tel,
				'suiji' : ver
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
		//var now = new Date();
		 //  var hours=now.getHours();
		 //   if(hours>=17){		    
		//   location.href="${backstage}/QianTaiUserAction_index7?id=<s:property value="#session.project.id"/>";
		//    }
		$("#ssss").click(check);
	});
</script>






</head>

<body>
	<form action="UserServlet" method="post" id="myform" name="myform">

		<div align="center" class="page-app">

			<div class="toutu">
				<img
					src="${backstage}/<s:property value="#session.project.project_pic"/>">
			</div>
			<div class="mian">
				<div class="contain">

					<div class="list">
						<div class="icon1">
							<img src="${backstage}/qiangtai/images/name-icon.jpg"
								width="100%" height="100%" />
						</div>
						<div class="icon2">
							<input id="username" type="text" name="username" value="请输入姓名"
								onfocus="javascript:if(this.value=='请输入姓名')this.value='';"
								style="border: 0; color: #CCC; font-family: '微软雅黑'; font-size: 15px;" />
						</div>
					</div>
					<div class="list">
						<div class="icon1">
							<img src="${backstage}/qiangtai/images/number-icon.jpg"
								width="100%" height="100%" />
						</div>
						<div class="icon2">
							<input id="tel" type="text" name="tel" value="请输入电话"
								onfocus="javascript:if(this.value=='请输入电话')this.value='';"
								style="border: 0; color: #CCC; font-family: '微软雅黑'; font-size: 15px;" />
						</div>
					</div>
					<div class="list">
						<div class="icon1">
							<img src="${backstage}/qiangtai/images/code-icon.jpg"
								width="100%" height="100%" />
						</div>
						<div class="icon2">
							<input id="ver" type="text" name="ver" value="请输入短信验证码"
								onfocus="javascript:if(this.value=='请输入短信验证码')this.value='';"
								style="border: 0; color: #CCC; font-family: '微软雅黑'; font-size: 15px;" />
						</div>
						<div class="icon3">
							<input class="button2" onclick="yanzheng(this)"
								type="button" value="获取验证码"></input>
						</div>
					</div>


				</div>
			</div>
			<!--mian end-->
			<div class="button">
				<span class="STYLE1"><input id="ssss" class="button1"
					type="button" value="专车看房预约"></input> </span>
			</div>

			<div class="renshu">
				<div class="">
					<span class="STYLE2">已有<span class="STYLE3"> <%
 	App.upNumber();
 %> <%=App.getShowNumber()%>
					</span>人通过专车看房免费看房
					</span>
				</div>
			</div>
			<div class="number">
				<a href="tel:02782226311"><img
					src="${backstage}/qiangtai/images/number.jpg" /> </a>
			</div>

		</div>
	</form>
</body>
</html>
