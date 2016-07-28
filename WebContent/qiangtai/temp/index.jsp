<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/qiangtai/public/head.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="${backstage}/qiangtai/temp/css/Stylepant2.css">
<title><s:property value="#session.project.project_name" /></title>

  <script type="text/javascript">
     $(function(){
    	 if('${status}'=='2'){
    		 alert("报名成功!");
    	 }else if('${status}'=='3'){
    		 $("body").empty();
    		 alert("项目已取消");
    	 }else if('${status}'=='4'){
    		 $("body").empty();
    		 alert("项目已删除!");
    	 }else if('${tatus}'=='5'){
    		 $("body").empty();
    		 alert("项目已关闭!");
    	 }else if('${status}'=='6'){
    		 $("body").empty();
    		 alert("项目报名失败");
    	 }
    	 
    	 
    	 ///////////////////////////////////
    	
          //提交按钮,所有验证通过方可提交

          $('.anniu').click(function(){
        	  var reg = /^1\d{10}$/;
        	  var ok1=false;
              var ok2=false;
        
              // 验证用户名
             var username= $('input[name="username"]').val();
              if(username==''||username==null){
            	  alert("用户名不能为空！");
            	  ok1=false;
              }else{
            	  ok1=true;
              }

              //验证电话
              var tel=$('input[name="tel"]').val();
               if(tel==null||tel==''){
            	   alert('电话不能为空！');
               }else if(!reg.test(tel)){
            	   alert("手机格式不正确！");
               }else{
            	   ok2=true;
               }
              if(ok1 && ok2){            	 
                  $('form').submit();
              }else{
                  return false;
              }
          });
           
   
    	 
     });
  
  </script>
</head>

<body>


<div class="info">
	<div class="infobg">
    	<div class="left"><img src="${backstage}/upload/<s:property value="#session.project.project_pic" />"/></div>
    	<div class="right">
        	<div class="rightinfo">
            	<div class="biaoti"><s:property value="#session.project.project_name" /></hui></div>
                <div class="youhui">
                	<div class="youhui1">房天下特惠：</div>
                	<div class="youhui2"><s:property value="#session.project.preferential1" /></div>
                	<div class="youhui3"><s:property value="#session.project.preferential2" /></div>
                </div>
                <div class="quyu" style="position:relative;">
                	<div class="aqbz"><img src="${backstage}/qiangtai/temp/images/pw.jpg"/></div>
                	<span class="wz"><hui>区域：</hui><s:property value="#session.project.quyu" /></span>
                	<span class="wz"><hui>房型：</hui><s:property value="#session.project.roottype" />&nbsp;&nbsp;&nbsp;<hui>面积：</hui><s:property value="#session.project.mianji" /></span></span>
                	<span class="wz"><hui>交房时间：</hui><s:property value="#session.project.taunchtime" /></span>
                	<span class="wz"><hui>地址：</hui><s:property value="#session.project.project_address" /></span>
                </div>
                <form action="QianTaiUserAction_add" method="post">
                <div class="xmdh">
                	<div class="xm" align="center">姓名：<input type="text" id="username" name="username" style="width:200px; height:25px;"/></div>
                    <div class="dh" align="center">电话：<input type="text" id="tel" name="tel" style="width:200px; height:25px;"/></div>
                </div>
                 <div class="anniu" >
                <input type="button" class="anniu" style="background-image:url(${backstage}/qiangtai/temp/images/anniu.jpg)">
                </div>
                </form>
                <div class="link">
                	<div class="number"><xiao>Tel :</xiao><s:property value="#session.project.consultanttel" /></div>
                    <div class="shuxian"></div>
                    <div class="zxzx">在线咨询</div>
                    <div class="zxzx1">
                    	<div class="pic"><img src="${backstage}/qiangtai/temp/images/QQ.jpg"/></div>
                        <div class="mz"><s:property value="#session.project.consultant1" /></div>
                        <div class="qqnum">qq:<a href="tencent://message/?uin=<s:property value="#session.project.consultantQQ1" />&Site=<s:property value="#session.project.project_address" />&Menu=yes"><s:property value="#session.project.consultantQQ1" /></a></div>
                    </div>
                    <div class="zxzx2">
                    	<div class="pic"><img src="${backstage}/qiangtai/temp/images/QQ.jpg"/></div>
                        <div class="mz"><s:property value="#session.project.consultant2" /></div>
                        <div class="qqnum">qq:<a href="tencent://message/?uin=<s:property value="#session.project.consultantQQ2" />&Site=<s:property value="#session.project.project_address" />&Menu=yes"><s:property value="#session.project.consultantQQ2" /></a></div>
                    </div>
                </div>
            </div>
    	</div>
	</div>
</div>


</body>
</html>
