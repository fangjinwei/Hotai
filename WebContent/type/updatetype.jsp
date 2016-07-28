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
/*
 * 
	
	private String type_create_date;

	private int type_admin_id=1;// 类别所属管理员编号
	private String type_admin="admin";// 类别所属管理员
	private int type_num=0;// 类别下项目的个数
	private String type_developer="";// 类别所属开发商
 */

$(function(){
	  //不用回显的数据但是修改需要的剩余对象数据
	 
	   var type_admin_id=null;//类别所属管理员编号
	   var type_admin=null;//类别所属管理员
	   var type_num=null;//类别下项目的个数
	   var type_developer=null;//类别所属开发商
	   var type_create_date=null;//创建时间
	
	//得到项目编号，通过这个来得到数据
	var type_id=(parent.$("iframe[title='编辑类别']").get(0).src).split("=")[1];
	//通过ajax来加载数据
	 $.get("TypeAction_toudpate",
			  {
		    type_id : type_id
			  },
			  function(data){
				  //回显数据
				  $("input[name='type_name']").val(data.type_name);//回显项目名
				 
				 //保存不用回显的数据
				  type_create_date=data.type_create_date;
				  type_status=data.type_status;
				  type_admin_id=data.type_admin_id;
				  type_admin=data.type_admin;
				  type_num=data.type_num;
				  type_developer=data.type_developer;
				  //回显状态
				   if(project_state==1){
			        	 $("input[name='type_status'][value=1]").attr("checked",true);
			         }else{
			        	 $("input[name='type_status'][value=0]").attr("checked",true); 
			         }
			   
			  });
	
	 

      
      
       ////////////////////////////////////////////////////////////////////
        $('#btn').bind('click', function(){    
        	
        	  var type_name=$("input[name='type_name']").val();//项目名
			  var type_status=$('input:radio[name="type_status"]:checked').val();//项目状态
			                    
			  if(type_name=="")alert("类别名不能为空！");

			  else{
				  //提交修改
				  var type={
						      type_id:type_id,
						      type_name:type_name,
						      type_status:type_status,
						      type_admin_id:type_admin_id,
						      type_admin:type_admin,
						      type_num:type_num,
						      type_developer:type_developer,
						      type_create_date:type_create_date
				              };
				  $.ajax({
					   type: "POST",
					   url: "TypeAction_update",
					   data: type,
					   success: function(data){
					     parent.parent.$("#win").window("close");
					     parent.parent.$("iframe[title='项目类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
					       //取消选中所以行
			    		  parent.parent.$("iframe[title='项目类别管理']").get(0).contentWindow.$("#dg").datagrid('uncheckAll');
					   },
			          
				      error:function(){
				    	  alert("出错了！");
				      }
					});
				  
				  
			  }
            
          
        });    
   
  
    
 });
</script>
</head>
<body>  
  
	  <label for="name">类别名:</label>   
        <input class="easyui-validatebox"  type="text" name="type_name" data-options="required:true" /> 
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <br>
             上线<input type="radio" name="type_status" value="1" checked="checked"/>
             冻结 <input type="radio" name="type_status" value="0"/>
      <div align="center">
      <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a> 
      </div>

</body>
</html>