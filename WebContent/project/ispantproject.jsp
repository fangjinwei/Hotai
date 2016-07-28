<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@include file="/public/head.jsp"%>
<title>Insert title here</title>
<!--引入引入kindeditor编辑器相关文件-->
<link rel="stylesheet" href="${backstage}/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="${backstage}/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" src="${backstage}/kindeditor/lang/zh-CN.js"></script>
<script type="text/javascript">
$(function(){
	var content;
	  $('#bbb').bind('click', function(){
		  //判断选择类型
		  var cc= $("#cc").find("option:selected").text();
		 
		     
		  //
		  if(cc=="标准"){
			  content='<iframe src="${backstage}/project/addproject.jsp" frameborder="0" scrolling="no" width="100%" height="100%"/>';
		  }else{
			  content='<iframe src="${backstage}/project/addproject2.jsp" frameborder="0" scrolling="no" width="100%" height="100%"/>';
		  }
		  parent.parent.$('#win').window({
				title:'添加项目',
				width: 890,
				height: 600,
				left:250,
				top:53,
		        content :content,
			    modal:true   
			});
		  
	  });

   
   
  
    
 });
</script>
</head>
<body>
<br><br>
<div align="center">
    <label>类型</label>
   <select id="cc" >   
    <option value="标准">标准</option>   
    <option value="标准2">标准2</option>   
   </select> 
   <br>
   <button id="bbb">确认</button> 
</div>  
</body>
</html>