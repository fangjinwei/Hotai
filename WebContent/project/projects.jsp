<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@include file="/public/head.jsp"%>
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
      var projectid=null;
	$('#dg').datagrid({
		url : '${backstage}/ProjectAction_query',

		//queryParams : {},

		loadMsg : '数据加载验证中，请等待.....',

		pagination : true,

		striped : true,

		nowrap : false,
		idField : 'id',
		toolbar : [ {
			text : '编辑项目',
			iconCls : 'icon-edit',
			handler : function() {
				  var rows=$("#dg").datagrid("getSelections");	//返回数组	
				  if(rows.length!=1){
			  			$.messager.show({
			  				title:'错误提示',
			  				msg:'一次只能更新一条',
			  				timeout:2000,
			  				showType:'slide'
			  			});
			}else{
				projectid=rows[0].id;
				var ispant=rows[0].ispant;		
				//更新
				parent.$('#win').window({
					title:'编辑项目',
					width: 890,
					height: 600,
					content :'<iframe title="编辑项目" src="${backstage}/project/updateproject.jsp?projectid='+projectid+'='+ispant+'" frameborder="0" scrolling="no" width="100%" height="100%" />',
				    modal:true   
				});
			
			}
			}
		}, '-', {
			text : '添加项目',
			iconCls : 'icon-add',
			handler : function() {
				parent.$('#win').window({
					title:'添加项目',
					width: 300,
					height: 200,
					
					content :'<iframe src="${backstage}/project/ispantproject.jsp" frameborder="0" scrolling="no" width="100%" height="100%" />',
				    modal:true   
				});
				
				
			}
		}, '-', {
			text : '冻结项目',
			iconCls : 'icon-remove',
			handler : function() {
           //删除逻辑
		  var rows=$("#dg").datagrid("getSelections");	//返回数组	
		  		if(rows.length==0){
		  			$.messager.show({
		  				title:'错误提示',
		  				msg:'至少选则一条记录',
		  				timeout:2000,
		  				showType:'slide'
		  			});

		  		}else{
		  			$.messager.confirm('确认','您确认想要冻结这'+rows.length+'记录吗？',function(r){    
		  				 if (r){    
			  			       //获取被选中的记录，然后从记录中获取相应的id
			  			       var ids="";
			  			       for(var i=0;i<rows.length;i++){
			  			    	   ids+=rows[i].id+",";
			  			       }
			  			       //拼接id发送给后台
			  			       ids=ids.substring(0,ids.lastIndexOf(","));
		  			      
		  			       $.post("ProjectAction_updatestauts",{ids:ids},function(result){
		  			    	   if(result=="true"){
		  			    		   alert("操作成功！");
		  			    		   //取消选中所以行
		  			    		    $('#dg').datagrid('uncheckAll');
		  			    		   //从新加载当前页
		  			    		 $('#dg').datagrid('reload');
		  			    	   }else{
		  			    		 $.messager.show({
		 			  				title:'操作异常',
		 			  				msg:'操作出现问题请检查！',
		 			  				timeout:2000,
		 			  				showType:'slide'
		 			  			});
		  			    	   }
		  			    	   
		  			       },"text");//ajax,返回流
		  			    }    
		  			});  

		  		}
			
			}
		}, '-', {
			text : '删除项目',
			iconCls : 'icon-remove',
			handler : function() {
           //删除逻辑
		  var rows=$("#dg").datagrid("getSelections");	//返回数组	
		  		if(rows.length==0){
		  			$.messager.show({
		  				title:'错误提示',
		  				msg:'至少选则一条记录',
		  				timeout:2000,
		  				showType:'slide'
		  			});

		  		}else{
		  			$.messager.confirm('确认','您确认想要删除这'+rows.length+'记录吗？',function(r){    
		  			    if (r){    
		  			       //获取被选中的记录，然后从记录中获取相应的id
		  			       var ids="";
		  			       for(var i=0;i<rows.length;i++){
		  			    	   ids+=rows[i].id+",";
		  			       }
		  			       //拼接id发送给后台
		  			       ids=ids.substring(0,ids.lastIndexOf(","));
		  			       $.post("ProjectAction_delete",{ids:ids},function(result){
		  			    	   if(result=="true"){
		  			    		   alert("删除成功！");
		  			    		   //取消选中所以行
		  			    		    $('#dg').datagrid('uncheckAll');
		  			    		   //从新加载当前页
		  			    		 $('#dg').datagrid('reload');
		  			    	   }else{
		  			    		 $.messager.show({
		 			  				title:'删除异常',
		 			  				msg:'删除出现问题请检查！',
		 			  				timeout:2000,
		 			  				showType:'slide'
		 			  			});
		  			    	   }
		  			    	   
		  			       },"text");//ajax,返回流
		  			    }    
		  			});  

		  		}
			
			}
		}, '-', {
			text : "<input id='ss' name='search'/>",

		} , '-', {
			text : "<input id='dd' type='text'/>",

		}, '-', {
			text : '一键修改审核员电话',
			iconCls : 'icon-mini-edit',
			handler : function() {
				parent.$('#win').window({
					title:'修改审核员电话',
					width: 230,
					height: 200,
					content :'<iframe src="${backstage}/project/updatetel.jsp" frameborder="0" scrolling="no" width="100%" height="100%" />',
				    modal:true   
				});
			
			}
		} ],

		fitColumns : true,
		columns : [ [ {
			field : 'cks',
			checkbox : true
		}, {
			field : 'project_name',
			 width : 70,
			title : '项目名'
		}, {
			field : 'project_createtime',
			title : '创建时间',
		}, {
			field : 'project_kf_audit_tel',
			title : '后台客服电话',
		}, {
			field : 'project_address',
			title : '售楼地址',
		    width : 100
		}, {
			field : 'project_jd_audit_tel',
			title : '接待员电话',
		}, {
			field : 'project_num',
			title : '项目报名人数',
		}, {
			field : 'project_state',
			title : '项目状态',
		    formatter: function(value,row,index){
				if (value==1){
					return '<span style="color:red">上线中</span>';
				} else {
					return '<span style="color:green">禁用中</span>';
				}
			}

		}, {
			field : 'type_name',
			title : '所属项目别类',
		    formatter: function(value,row,index){
				return row.type.type_name;
			}

		}, {
			field : 'ispant',
			title : '类型',
			width : 15
		  

		}, {
			field : 'project_web',
			title : 'webroot',
		    width : 100,
		    styler: function(value,row,index){
					return 'background-color:#ffee00;color:red;';
			}

		}] ]
	});

	//把一个普通的文本框转换为搜索文本框
	$('#ss').searchbox({
		searcher : function(value, name) {
	    	//查询
		  $('#dg').datagrid('load',{
			nametype:value
			});

		},
		prompt : '项目名或接待员电话'
	});
	
	//把一个普通的文本框转换为搜索时间框
	$('#dd').datebox({    
	    required:false,
	    prompt : '项目创建时间',
	    //时间选中查询事件
	    onSelect: function(date){
	     
	    	//查询
		  $('#dg').datagrid('load',{
				datetime:new Date(date).format("yyyy-MM-dd")
			});
	    }

	});  

});
</script>
</head>
<body>
	<div data-options="region:'center'" id="tt">
		<table id="dg"></table>
	</div>
	
</body>
</html>