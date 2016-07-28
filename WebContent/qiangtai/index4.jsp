<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/qiangtai/public/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<meta name="format-detection" content="address=no" />
<link href="${backstage}/qiangtai/css/Style4.css" rel="stylesheet" type="text/css" />
<title><s:property value="#session.user.registration_go" /></title>
<script type="text/javascript">
  $(function(){
	  var username= $("#username ").val();
	     var phone= $("#phone ").val();
	     
	    if(username==null||username==""||phone==null||phone==""){
	       location.href='QianTaiUserAction_index1?id=<s:property value="#session.project.id"/>';
	    }
	  
  });
</script>
</head>

<body>
<input type="hidden" value="<s:property value="#session.user.username"/>" id="username">
<input type="hidden" value="<s:property value="#session.user.tel"/>" id="phone"></input>
<div align="center" class="page-app">

<div class="toutu"><img src="${backstage}/<s:property value="#session.project.project_text_pic"/>"></div>
<div class="toutu"><img src="${backstage}/<s:property value="#session.project.project_stauts_pic"/>"></div>
<div class="mian">
	<div class="contain">
    	<s:property value="#session.project.project_text" escape="false"/>
	</div>
</div><!--mian end-->
<div class="toutu"><img src="${backstage}/<s:property value="#session.project.project_weixin_pic"/>"></div>

</div>

</body>
</html>
