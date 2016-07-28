<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@include file="/public/head.jsp"%>
<title>Insert title here</title>

<script type="text/javascript">
$(function(){
   
      
       ////////////////////////////////////////////////////////////////////
        $('#btn').bind('click', function(){    
        	
			  var project_kf_audit_tel=$("input[name='project_kf_audit_tel']").val();//审核员电话
			  
			     if(project_kf_audit_tel==""||project_kf_audit_tel==null){
			    	 alert("电话不能为空");
			     }else{
			    	var sv= $("#se option:selected").val();
			       var	data={'id':sv,'project_kf_audit_tel':project_kf_audit_tel};
				  $.ajax({
					   type: "POST",
					   url: "${backstage}/ProjectAction_updatetel",
					   data: data,
					   success: function(data){
					     parent.parent.$("#win").window("close");
					     parent.parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg").datagrid('uncheckAll');
					     parent.parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg").datagrid("reload");
					    
					
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
     <select name="id" id="se">
       <option value="90">标准一</option>
       <option value="100">标准二</option>
       <option value="110">自定义</option>
     </select>
	  <label for="name">电话:</label>   
        <input class="easyui-validatebox"  type="text" name="project_kf_audit_tel" data-options="required:true" /> 
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <br>
      <div align="center">
      <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a> 
      </div>

</body>
</html>