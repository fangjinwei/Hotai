<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/qiangtai/public/head.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<meta name="format-detection" content="address=no" />
<title><s:property value="#session.project.project_name" /></title>


<script type="text/javascript">
//调用方法
$(function() {
	var username= $("#username ").val();
	 var phone= $("#phone ").val();
	 
	if(username==null||username==""||phone==null||phone==""){
	   location.href='${backstage}/QianTaiUserPantAction_pant?id=<s:property value="#session.project.id"/>';
	}
	var now = new Date();
	   var hours=now.getHours();
	    if(hours>=17){		    
	    location.href="${backstage}/QianTaiUserPantAction_pant5?id=<s:property value="#session.project.id"/>";
	    }
	 
});
</script>
</head>

<body>

<input type="hidden"
		value="<s:property value="#session.user.username"/>" id="username">
	<input type="hidden" value="<s:property value="#session.user.tel"/>"
		id="phone"></input>

	<div class="contain">
    	<span class="STYLE2">尊敬的房天下网友：</span>
		<span class="STYLE2">预约完成！</span>
		<span class="STYLE3">本次活动的最终解释权由武汉搜房网房天下所有。</span>

	</div>


</body>
</html>
