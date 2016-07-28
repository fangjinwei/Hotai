<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@include file="/public/head.jsp"%>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {

		$('#dg').datagrid({
			url : '${backstage}/UserAction_queryJoinAccount',

			queryParams : {
				type:'',
				datetime:'',
				time :''
			},

			loadMsg : '数据加载验证中，请等待.....',

			pagination : true,

			striped : true,

			nowrap : true,
			idField : 'id',
			toolbar : [ {
				text : '编辑用户',
				iconCls : 'icon-edit',
				handler : function() {
					alert('编辑按钮');
				}
			}, '-', {
				text : '添加用户',
				iconCls : 'icon-add',
				handler : function() {
					alert('添加按钮');
				}
			}, '-', {
				text : '删除用户',
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
			  			       $.post("UserAction_deleteUsersByIds",{ids:ids},function(result){
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

			} , '-', {
				text : "<a href='javascript:void(0)' id='sb' >用户活动确认</a>",

			} ],

			fitColumns : true,
			columns : [ [ {
				field : 'cks',
				checkbox : true
			}, {
				field : 'username',
				title : '用户名'
			}, {
				field : 'tel',
				title : '用户联系'
			}, {
				field : 'registration_time',
				title : '用户报名时间',
				order : 'desc'
			}, {
				field : 'registration_go',
				title : '报名活动来源（项目）',formatter: function(value,row,index){
					if(value!=null||value!=''){
						return value;
					}else{
						return "无";
					}
				}

			}, {
				field : 'gotasi_time_x',
				title : '上车时间详细时间'
			}, {
				field : 'gotasi_time_z',
				title : '用户真正上车时间详细时间',formatter: function(value,row,index){
					if(value==0||value==null){
						return '<span style="color:#CD9B1D">未上车</span>';
					}else{
						return value;
					}
				}
			}, {
				field : 'gotasi_adress',
				title : '用户乘车地点'
			}, {
				field : 'message_status',
				title : ' 短信状态',formatter: function(value,row,index){
					if(value==0){
						return '<span style="color:red">未发送</span>';
					}else{
						return '<span style="color:red">已发送</span>';
					}
				}
			}, {
				field : 'user_status',
				title : '用户状态',
				formatter: function(value,row,index){
					if(value==0){
						return '<span style="color:#CD0000">未审核</span>';
					}else if(value==1){
						return '<span style="color:red">通过审核</span>';
					}else if(value==2){
						return '<span style="color:green">未通过审核</span>';
					}else if(value==3){
						return '<span style="color:#76EE00">正在看房中</span>';
					}else{
						return '<span style="color:red">用户结束</span>';
					}
				}
			}, {
				field : 'sum',
				title : '报名次数',
				

			},{
				field : 'type_name',
				width : 100,
				title : '所属类别',formatter: function(value,row,index){
					
						return row.project.type.type_name;
					
				}

			}] ]
		});

		//把一个普通的文本框转换为搜索文本框
		$('#ss').searchbox({
			searcher : function(value, name) {
				//查询
				$('#dg').datagrid('load',{
					type:value
				});

			},
			prompt : '用户名或联系方式'
		});
		
		//把一个普通的文本框转换为搜索时间框
		$('#dd').datebox({    
		    required:false,
		    prompt : '用户报名时间',
		    //时间选中查询事件
		    onSelect: function(date){
		    	//查询
			  $('#dg').datagrid('load',{
					datetime:new Date(date).format("yyyy-MM-dd")
				});
		    }

		}); 
		
		
		
		//把一个普通的a标签转换为下拉菜单
		$('#sb').splitbutton({    
		    iconCls: 'icon-large-smartart',    
		    menu: '#mm'   
		});  
		
		
		//用户已上车
		$('#gg').bind('click',function(){
			 var rows=$("#dg").datagrid("getSelections");//返回数组
			 if(rows.length==0){
		  			$.messager.show({
		  				title:'错误提示',
		  				msg:'至少选则一条记录',
		  				timeout:2000,
		  				showType:'slide'
		  			});

		  		}else{
		  			$.messager.confirm('确认','您确认想要操作这'+rows.length+'记录吗？',function(r){    
		  			    if (r){    
		  			       //获取被选中的记录，然后从记录中获取相应的id
		  			       var ids="";
		  			       for(var i=0;i<rows.length;i++){
		  			    	   ids+=rows[i].id+",";
		  			    	 if(rows[i].user_status==3){
		  			    		   alert("用户  :"+rows[i].username+"  已经上车");
		  			    		   return false;
		  			    	   }else if(rows[i].user_status==4){
		  			    		 alert("用户  :"+rows[i].username+"  已经结束");
		  			    		   return false;
		  			    	   }else if(rows[i].user_status==2){
		  			    		 alert("用户  :"+rows[i].username+"  未通过审核");
		  			    		   return false;
		  			    	   }else if(rows[i].user_status==0){
			  			    		 alert("用户  :"+rows[i].username+"  未审核");
			  			    		   return false;
			  			    	   }
		  			       }
		  			       //拼接id发送给后台
		  			       ids=ids.substring(0,ids.lastIndexOf(","));
		  			       $.post("UserAction_gototimeByIds",{ids:ids,user_status:3},function(result){
		  			    	   if(result=="true"){
		  			    		   alert("操作成功！");
		  			    		   //取消选中所以行
		  			    		    $('#dg').datagrid('uncheckAll');
		  			    		   //从新加载当前页
		  			    		 $('#dg').datagrid('reload');
		  			    	   }else{
		  			    		 $.messager.show({
		 			  				title:'异常',
		 			  				msg:'出现问题请检查！',
		 			  				timeout:2000,
		 			  				showType:'slide'
		 			  			});
		  			    	   }
		  			    	   
		  			       },"text");//ajax,返回流
		  			    }    
		  			});  

		  		}
		});
		
      
		
		//用户看房结束
		$('#jj').bind('click',function(){
			 var rows=$("#dg").datagrid("getSelections");//返回数组
			 if(rows.length==0){
		  			$.messager.show({
		  				title:'错误提示',
		  				msg:'至少选则一条记录',
		  				timeout:2000,
		  				showType:'slide'
		  			});

		  		}else{
		  			$.messager.confirm('确认','您确认想要操作这'+rows.length+'记录吗？',function(r){    
		  			    if (r){    
		  			       //获取被选中的记录，然后从记录中获取相应的id
		  			       var ids="";
		  			       for(var i=0;i<rows.length;i++){
		  			    	   ids+=rows[i].id+",";
		  			    	   if(rows[i].user_status==4){
		  			    		 alert("用户  :"+rows[i].username+"  已经结束");
		  			    		   return false;
		  			    	   }else if(rows[i].user_status==2){
		  			    		 alert("用户  :"+rows[i].username+"  未通过审核");
		  			    		   return false;
		  			    	   }else if(rows[i].user_status==0){
			  			    		 alert("用户  :"+rows[i].username+"  未审核");
			  			    		   return false;
			  			    	}else if(rows[i].user_status==1){
			  			    		 alert("用户  :"+rows[i].username+"  未确定上车");
			  			    		   return false;
			  			    	}
		  			       }
		  			       //拼接id发送给后台
		  			       ids=ids.substring(0,ids.lastIndexOf(","));
		  			       $.post("UserAction_gotoendByIds",{ids:ids,user_status:4},function(result){
		  			    	   if(result=="true"){
		  			    		   alert("操作成功！");
		  			    		   //取消选中所以行
		  			    		    $('#dg').datagrid('uncheckAll');
		  			    		   //从新加载当前页
		  			    		 $('#dg').datagrid('reload');
		  			    	   }else{
		  			    		 $.messager.show({
		 			  				title:'异常',
		 			  				msg:'出现问题请检查！',
		 			  				timeout:2000,
		 			  				showType:'slide'
		 			  			});
		  			    	   }
		  			    	   
		  			       },"text");//ajax,返回流
		  			    }    
		  			});  

		  		}
		});
		
		
	});
	
</script>

</head>
<body class="easyui-layout">

	
	<div data-options="region:'center'" id="tt">
		<table id="dg"></table>
	</div>
	
<!-- 下拉菜单显示的内容 -->	
<div id="mm" style="width:100px;">   
<div data-options="iconCls:'icon-ok'" id="gg">用户已上车</div>     
<div data-options="iconCls:'icon-cancel'" id="jj">用户看房结束</div>    
</div>  



</body>
</html>