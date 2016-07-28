<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="login.css"></link>
<%@include file="/public/head.jsp"%>

<script type="text/javascript">

	$(function() {
		$("#btn").click(function(){
			var loginname=$("input[name=loginname]").val();
			var password=$("input[name=password]").val();
			if(loginname!=""&&password!=""){
				  $.ajax({
					   type: "POST",
					   url: "${backstage}/LoginAction_login",
					   data: {'loginname':loginname,'password':password},
					   success: function(data){
						   if(data=="true"){
							   window.location.href='${backstage}/main/aindex.jsp';
						   }else{
							   alert("登入失败！");
								$("input[name=loginname]").val("").focus();
							    $("input[name=password]").val("");
						   }
					   
					   },
			          
				      error:function(){
				    	  alert("出错了！");
				      }
					});
			}
		});
	});
</script>
</head>

<body>
<div align="center">

	<div  class="bg">
    	<div class="logo"><img src="logo.jpg"/></div>
        <div class="xb"></div>
    </div>
  	<div class="dlbg">
		<div class="wz" style="padding-top:50px;"><span class="STYLE1">用户名</span><input type="text" name="loginname" value=""  style="width:200px; height:30px; border:1px solid #ffbdbd; margin-left:10px;"/></div>
		<div class="wz"><span class="STYLE1">密&nbsp;&nbsp;&nbsp;码</span><input type="password" name="password" value=""  style="width:200px; height:30px; border:1px solid #ffbdbd; margin-left:10px;"/></div>
		<div class="wz1"><input id="btn" type="button" value="登入" style=" width:350px; height:50px; background-color:#ff4848; border:0; color:#FFF; font-family:'微软雅黑'; font-size:17px; letter-spacing:10px;"/></div>
	</div>            
</div>  


</body>

</html>