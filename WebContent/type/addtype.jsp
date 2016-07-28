<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@include file="/public/head.jsp"%>

<script type="text/javascript">
$(function(){

////////////////////////////////////////////////////////////////////
    $('#btn').bind('click', function(){    
    	
    	  var type_name=$("input[name='type_name']").val();//类别名
		  var type_status=$('input:radio[name="type_status"]:checked').val();//项目状态
		                    
		  if(type_name=="")alert("类别名不能为空！");
		  else{
			  //提交修改
			  var project={type_name:type_name,
					  type_status:type_status
			              };
			  $.ajax({
				   type: "POST",
				   url: "TypeAction_sava",
				   data: project,
				   success: function(data){
					   if(data==null){
						   alert("异常！");
					   }else{
				     parent.parent.$("#win").window("close");
				     parent.parent.$("iframe[title='项目类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
				   }
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