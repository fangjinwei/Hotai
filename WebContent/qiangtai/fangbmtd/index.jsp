<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="cn.it.backstag.util.App"%>
<%@include file="/qiangtai/public/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<meta name="format-detection" content="address=no" />
<link href="${backstage}/fangbmtd/css/Style.css" rel="stylesheet" type="text/css" />
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
<title>房天下报名通道</title>
</head>
	<body>
		<form action="QianTaiUserAction_addaaaa" method="post" id="myform" name="myform">
              
			<div align="center" class="page-app">

				<div class="toutu">
					<img src="images/tou.jpg">
				</div>
				<div class="mian">
					<div class="contain">

						<div class="list">
							<div class="icon1">
								<img src="images/name-icon.jpg" width="100%" height="100%" />
							</div>
							<div class="icon2">
								<input id="username" type="text" name="username" value="请输入姓名"
									onfocus="javascript:if(this.value=='请输入姓名')this.value='';"
									style="border: 0; color: #CCC; font-family: '微软雅黑'; font-size: 15px;" />
							</div>
						</div>
						<div class="list">
							<div class="icon1">
								<img src="images/number-icon.jpg" width="100%" height="100%" />
							</div>
							<div class="icon2">
								<input id="tel" type="text" name="tel" value="请输入电话"
									onfocus="javascript:if(this.value=='请输入电话')this.value='';"
									style="border: 0; color: #CCC; font-family: '微软雅黑'; font-size: 15px;" />
							</div>
						</div>
						


					</div>
				</div>
				<!--mian end-->
				<div class="button">
					<span class="STYLE1"><input id="ssss" class="button1" type="button" value="提交"></input> </span>
				</div>

				

		  </div>
		</form>
	</body>
</html>
