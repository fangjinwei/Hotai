<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/public/head.jsp"%>
<title>专车看房</title>
<style type="text/css">
#menu {
	width: 190px;
}

#menu ul {
	list-style: none;
	padding: 0px;
	margin: 0px;
}

#menu ul li {
	border-bottom: 1px solid red;
}

#menu ul li a {
	display: block;
	background-color: #008792;
	color: white;
	padding: 5px;
	text-decoration: none;
}

#menu ul li a:HOVER {
	background-color: #00a6ac;
}
</style>
<script type="text/javascript">
 

	
	$(function() {
		//判断是否登入
		if("${sessionScope.u}"==''){
			window.location.href='${backstage}/main/login.jsp';
		//登入窗口
		// parent.$('#win').window({
		//	  title:'登入',
		//	  width: 600,
		//	  height: 400,
		//	  content :'<iframe src="${backstage}/main/login.jsp" frameborder="0" scrolling="no" width="100%" height="100%" />',
		//     modal:false 
		//  });
		}
		//点击跳转页面
		$("a[title]").click(function() {
			var text = $(this).text();
			var href = $(this).attr("title");
			//1:判断当前后边是否已有 相应的tab
			if ($("#tt").tabs("exists", text)) {
				//存在切换到当前
				$("#tt").tabs("select", text);
			} else {
				//不存在创建新tab
				// 添加一个选中状态的选项卡面板
				//href:默认同url地址，加载远程页面,但是仅仅是body部分
				$('#tt').tabs('add',{
					title: text,
					closable:true, 
					content:'<iframe title='+text+' src='+href+' frameborder="0" scrolling="yes" width="100%" height="100%" />'
				});


			}
		});
	});
</script>
</head>

<body class="easyui-layout">

	<div data-options="region:'north',title:'欢迎来到专车看房后台管理系统',split:true"
		style="height: 100px;width: 100%; background-repeat: no-repeat; background-position: center top; background-image:url('${backstage}/main/logo1.jpg');">
		     <div align="right" style="padding-top: 30px;padding-right: 40px;font-size: 16px"> 欢迎</div>
		</div>
	<div data-options="region:'west',title:'系统操作',split:true"
		style="width: 200px;">
		<div id="aa" class="easyui-accordion" data-options="fit:true">
			<div title="基本操作"
				data-options="iconCls:'icon-large-clipart',selected:true">
				<div id="menu">
					<ul>
						<li><a href="#" title="${backstage}/users/users.jsp">用户详细管理</a></li>
						<li><a href="#" title="${backstage}/project/projects.jsp">项目管理</a></li>
						<li><a href="#" title="${backstage}/type/types.jsp">项目类别管理</a></li>
						<li><a href="#" title="${backstage}/message/messages.jsp">短信管理</a></li>
						<li><a href="#" title="${backstage}/project/pants.jsp">自定义模版</a></li>
					</ul>
				</div>
			</div>
			<div title="标题2" data-options="iconCls:'icon-reload'"></div>
			<div title="标题3"></div>
			<div title="标题4"></div>
			<div title="标题5"></div>
			<div title="标题6"></div>
		</div>
	</div>
	<div data-options="region:'center',title:'后台操作界面'"
		style="padding: 1px; background: #fff;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统缺省页面" style="padding: 10px;">
			 
			</div>
		</div>
	</div>
	<div id="win" data-options="collapsible:false,minimizable:false,maximizable:false"></div>
</body>

</html>