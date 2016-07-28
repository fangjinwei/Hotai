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
<link href="${backstage}/qiangtai/css/Style1.css" rel="stylesheet"
	type="text/css" />
<title><s:property value="#session.user.registration_go" /></title>




<script type="text/javascript">
	
		    $(function(){
		     for(var i=0; i<1;i++){ //初始化select
		    var date=   document.getElementById("publishdate");
		    date.options.add(new Option(showTime(i),showTime(i)));
		     if(i==0){
		     date.options.selected = true;
		     }
		     }
		    });
		
		</script>
<script type="text/javascript">

 //验证表单的方法
		 function check(){
		     var date = $("#publishdate").val();
			 if(date==""){
			  DIVAlert('关闭','时间不能为空！');
			 return false;
			 }
			 
			
			 
			 var adress = $("#adress").val();
			 
			 if(adress==""||adress=="上车地点"){
			   DIVAlert('关闭','上车地点不能为空！');
			 return false;
			 }
			 var  ch=null;
			  var radio = document.getElementById("radio").checked;
			   if(radio){
			      ch="";
			   }else{
			    DIVAlert('关闭','请先阅读看房须知！');
			  // alert("请先阅读看房须知！");
			   }
			
			 
			   if(adress!=""&&adress!=null&&date!=""&&date!=null&&ch==""&&ch!=null){
			     var h= $("#time ").val();
			     var f= $("#branch ").val();
			     var username= $("#username ").val();
			     var phone= $("#phone ").val();
			     
			    if(username==null||username==""||phone==null||phone==""){
			    DIVAlert('关闭','请先输入姓名，电话');
			       location.href='QianTaiUserAction_index1?id=<s:property value="#session.project.id"/>';
			    }else{
     		       $.ajax({
     		       type: "post",
     		       url:"QianTaiUserAction_save",
     		       data:{'time':date,'adress':adress,'h':h,'f':f},
     		       success:function(data){	  			         		
		  			         		if(data == 0){
		  			         		DIVAlert('关闭','时间必须大于半小时');
		  			         		 
		  			         		}else if(data == 3){
		  			         		DIVAlert('关闭','未填写用户姓名电话');
		  			         		     location.href='QianTaiUserAction_index1?id=<s:property value="#session.project.id"/>';
		  			         		}else if(data == 2){
		  			         		DIVAlert('关闭','系统错误！');
		  			         		}else{
		  			         			location.href='QianTaiUserAction_index4?id=<s:property value="#session.project.id"/>';
		  			         		};
		  			         		
		  			         }
		  			         });  
     		     };
     		      
     		 return false;
     		};
			 return false;
		 };
		 
		  //调用方法
		 $(function(){
			 var username= $("#username ").val();
		     var phone= $("#phone ").val();
		     
		    if(username==null||username==""||phone==null||phone==""){
		       location.href='QianTaiUserAction_index1?id=<s:property value="#session.project.id"/>';
		    }
		      $("#ssss").click(check);
		     
		 });
  
</script>


<body>

	<form action="" method="post" id="myform" name="myform">
		<div align="center" class="page-app">
			<input type="hidden" value="<s:property value="#session.user.username"/>" id="username">
			<input type="hidden" value="<s:property value="#session.user.tel"/>" id="phone"></input>
			<div class="toutu">
				<img src="${backstage}/<s:property value="#session.project.project_pic"/>">
			</div>
			<div class="mian">
				<div class="contain">
					<div class="list">
						<div class="icon1">
							<img src="${backstage}/qiangtai/images/date-icon.jpg" width="100%" height="100%" />
						</div>
						<div class="icon3">
							<span class="STYLE4">用车日期</span>

						</div>
						

						<select id="publishdate" name="publishdate">

						</select>

					</div>
					<div class="list">
						<div class="icon1">
							<img src="${backstage}/qiangtai/images/time-icon.jpg" width="100%" height="100%" />
						</div>
						<div class="icon3">
							<span class="STYLE4">请选择时间</span>
						</div>


						<span class="STYLE4" style="margin-left: 10px;"> <select
							id="time"
							style="border: 0; background-image: url(${backstage}/qiangtai/images/xiala1.jpg); width: 55px; height: 30px; -webkit-appearance: none;">
								<c:forEach var="s" begin="10" end="17">
									<option value="${s}">${s}</option>
								</c:forEach>
						</select>时
						</span> <span class="STYLE4" style="margin-left: 10px;"> <select
							id="branch"
							style="border: 0; background-image: url(${backstage}/qiangtai/images/xiala1.jpg); width: 55px; height: 30px; -webkit-appearance: none;">
								<c:forEach var="s" begin="1" step="10" end="60">
									<option value="${s}">${s-1}</option>
								</c:forEach>
						</select>分
						</span>
					</div>
					<div class="list">
						<div class="icon1">
							<img src="${backstage}/qiangtai/images/site-icon.jpg" width="100%" height="100%" />
						</div>
						<div class="icon3">
							<div class="icon2">
								<input id="adress" type="text" value="上车地点"
									onfocus="javascript:if(this.value=='上车地点')this.value='';"
									style="border: 0; line-height: 30px; color: #787878; font-family: '微软雅黑'; font-size: 16px;" />
							</div>
						</div>
					</div>
					<div class="list">
						<div class="icon1">
							<img src="${backstage}/qiangtai/images/site-icon.jpg" width="100%" height="100%" />
						</div>
						<div class="icon3">
							<span class="STYLE4">售楼处地址：</span>
						</div>
						<div class="icon4">
							<span class="STYLE6"><s:property value="#session.project.project_address"/></span>
						</div>

					</div>
				</div>
			</div>
			<!--mian end-->
			<div class="renshu">
				<form>
					<div class="notice">
						<span class="STYLE2"><input id="radio" type="checkbox"
							class="danxuan" style="width: 17px; height: 17px;" /> </span> <span
							class="STYLE2">我已阅读并同意<a href="${backstage}/QianTaiUserAction_index3?id=<s:property value='#session.project.id'/>">《看房专车免费看房须知》</a>
						</span>
					</div>
				</form>
			</div>

			<div class="button">
				<span class="STYLE1"><input id="ssss" class="button1"
					type="button" value="专车看房预约"></input> </span>
			</div>


		</div>
	</form>
</body>
</html>
