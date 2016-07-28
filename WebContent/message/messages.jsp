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
			url : '${backstage}/MessageAction_queryMessage',

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
			
			onLoadSuccess: function (data) {
	            if (data.total == 0||data.rows==null||rows==""||rows==[]) {
	                //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数
	                $(this).datagrid('appendRow', { username: '<div style="text-align:center;color:red">没有相关记录！</div>' }).datagrid('mergeCells', { index: 0, field: 'username', colspan: 4 });
	                //隐藏分页导航条，这个需要熟悉datagrid的html结构，直接用jquery操作DOM对象，easyui datagrid没有提供相关方法隐藏导航条
	                $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();
	            }
	            //如果通过调用reload方法重新加载数据有数据时显示出分页导航容器
	            else $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').show();
	        },
			
			
			
			toolbar : [ {
				text : '审核通过',
				iconCls : 'icon-add',
				handler : function() {
               //删除逻辑
			  var rows=$("#dg").datagrid("getSelections");	//返回数组	
			  		if(rows.length!=1){
			  			$.messager.show({
			  				title:'错误提示',
			  				msg:'只能选则一条记录',
			  				timeout:2000,
			  				showType:'slide'
			  			});

			  		}else{
			  			$.messager.confirm('确认','您确认想要操作这'+rows.length+'条记录吗？',function(r){    
			  			    if (r){    
			  			       //获取被选中的记录，然后从记录中获取相应的id
			  			       var ids="";
			  			       for(var i=0;i<rows.length;i++){
			  			    	   ids+=rows[i].id+",";
			  			       }
			  			       //拼接id发送给后台
			  			       ids=ids.substring(0,ids.lastIndexOf(","));
			  			     var send={ids:ids,
			  			    		   user_status:1,
			  			    		   project_jd_audit_tel:rows[0].project.project_jd_audit_tel,//看看行不行
			  			    		   tel:rows[0].tel,
			  			    		  username:rows[0].username,
			  			    		   registration_time:rows[0].registration_time,
			  			    		   gotasi_time_x:rows[0].gotasi_time_x,
			  			    		  gotasi_adress:rows[0].gotasi_adress,
			  			    		registration_go:rows[0].registration_go
			  			    		  
			  			       };
			  			       $.post("MessageAction_updateMessageByIds",send,function(result){
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
				
				}
			},'-',{
				text : '审核不通过',
				iconCls : 'icon-remove',
				handler : function() {
               //删除逻辑
			  var rows=$("#dg").datagrid("getSelections");	//返回数组	
			  		if(rows.length!=1){
			  			$.messager.show({
			  				title:'错误提示',
			  				msg:'只能选则一条记录',
			  				timeout:2000,
			  				showType:'slide'
			  			});

			  		}else{
			  			$.messager.confirm('确认','您确认想要操作这'+rows.length+'条记录吗？',function(r){    
			  			    if (r){    
			  			       //获取被选中的记录，然后从记录中获取相应的id
			  			       var ids="";
			  			       for(var i=0;i<rows.length;i++){
			  			    	   ids+=rows[i].id+",";
			  			       }
			  			       //拼接id发送给后台
			  			       ids=ids.substring(0,ids.lastIndexOf(","));
			  			       var send={ids:ids,
			  			    		   user_status:2,
			  			    		   project_jd_audit_tel:rows[0].project.project_jd_audit_tel,//看看行不行
			  			    		   tel:rows[0].tel,
			  			    		   username:rows[0].username,
			  			    		   registration_time:rows[0].registration_time,
			  			    		   gotasi_time_x:rows[0].gotasi_time_x,
			  			    		   gotasi_adress:rows[0].gotasi_adress,
			  			    		   registration_go:rows[0].registration_go
			  			    		  
			  			       };
			  			       $.post("MessageAction_updateMessageByIds",send,function(result){
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
				
				}
			}, '-', {
				text : "<input id='ss' name='search'/>",

			} , '-', {
				text : "<input id='dd' type='text'/>",

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
				field : 'gotasi_adress',
				title : '用户乘车地点'
			},{
				field : 'project_address',
				title : '售楼地址',
			    formatter: function(value,row,index){			    	
					return row.project.project_address;
				}
			}, {
				field : 'project_jd_audit_tel',
				title : '接待员电话',
				 formatter: function(value,row,index){
						return row.project.project_jd_audit_tel;
					}
			},{
				field : 'project_kf_audit_tel',
				title : '后台客服电话',
				 formatter: function(value,row,index){
						return row.project.project_kf_audit_tel;
					}
			}, {
				field : 'type_name',
				width : 100,
				title : '所属类别',formatter: function(value,row,index){
					
						return row.project.type.type_name;
					
				}

			} ] ]
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
   
	});
	
</script>

</head>
<body class="easyui-layout">

	
	<div data-options="region:'center'" id="tt">
		<table id="dg"></table>
	</div>




</body>
</html>