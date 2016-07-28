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
  
    window.editor1 = KindEditor.create('#content1',{
              resizeType:1,      
    });
    window.editor2 = KindEditor.create('#content2',{
        resizeType:1,      
});
    window.editor3 = KindEditor.create('#content3',{
        resizeType:1,      
});
    
    
  //通过ajax来加载数据
	 $.get("${backstage}/TypeAction_findAll", function(data){
				  //类别下拉框
				  for(var i=0;i<data.types.length;i++){
					  var id=data.types[i].type_id;
					  var name=data.types[i].type_name;
					 $("#types").append("<option value='"+id+"'>"+name+"</option>"); 
				 }
			   
			  });
    
////////////////////////////////////////////////////////////////////
    $('#btn').bind('click', function(){    
    	
    	  var project_name=$("input[name='project_name']").val();//项目名
		  var project_jd_audit_tel=$("input[name='project_jd_audit_tel']").val();//接待员电话
		  var project_address=$("input[name='project_address']").val();//售楼地址
		  var project_kf_audit_tel=$("input[name='project_kf_audit_tel']").val();//审核员电话
		  var project_notice=$(document.getElementsByTagName('iframe')[0].contentWindow.document.body).html();//看房须知文本内容
		  var project_text=$(document.getElementsByTagName('iframe')[1].contentWindow.document.body).html();//成功提示文本
		  var project_state=$('input:radio[name="project_state"]:checked').val();//项目状态
		  var typeid=$('#types option:selected') .val();//选中的值                 
		  if(project_name=="")alert("项目名不能为空！");
		  else if(project_jd_audit_tel=="")alert("接待员电话不能为空！");
		  else if(project_address=="")alert("售楼地址不能为空！");
		  else if(project_kf_audit_tel=="")alert("审核员电话不能为空！");
		  else if(project_notice=="")alert("看房须知文本内容不能为空！");
		  else if(project_text=="")alert("成功提示文本不能为空！");
		  else{
			  //提交修改
			  var project={project_text:project_text,
					      project_notice:project_notice,
					      project_name:project_name,
					      project_jd_audit_tel:project_jd_audit_tel,
					      project_address:project_address,
					      project_kf_audit_tel:project_kf_audit_tel,
						  project_state:project_state,
						  typeid:typeid
			              };
			  $.ajax({
				   type: "POST",
				   url: "${backstage}/ProjectAction_sava",
				   data: project,
				   success: function(data){
				     parent.parent.$("#win").window("close");
				     parent.parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg").datagrid("reload");
				     //去添加图片页面
				     parent.parent.$('#win').window({
							title:'编辑项目',
							width: 890,
							height: 600,
							content :'<iframe title="编辑项目" src="${backstage}/project/upload_pc_project.jsp?projectid='+data.id+'&& project_pic='+null+'&& project_stauts_pic='+null+
							'&&project_weixin_pic='+null+'&& project_notice_pic='+null+
							'&& project_text_pic='+null+
							'" frameborder="0" scrolling="no" width="100%" height="100%" />',
							modal:true

						});
		             //parent.parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
   
	<div id="tt" class="easyui-tabs" data-options="fit:true" >   
	<!-- 分成俩部分三块（要上传的字段太多了|>_<|） -->
	<!-- ==================================第一部分第一块=====================================================-->
    <div title="页面一" data-options="fit:true" style="padding:20px;display:none;">   
         <div>   
        <label for="name">项目名:</label>   
        <input class="easyui-validatebox"  type="text" name="project_name" data-options="required:true" /> 
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <label for="name">接待员电话:</label>
          <input class="easyui-validatebox" type="text" name="project_jd_audit_tel" data-options="required:true" /> 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <label for="name">审核员电话:</label>
          <input class="easyui-validatebox" type="text" name="project_kf_audit_tel" data-options="required:true" /> 
        </div>    
        <br><br>
        
        
        <label for="name">看房须知文本内容:</label>
        <textarea id="content1" name="project_notice"  style="width:700px; height:300px;"></textarea>
     
    </div>   
    
     <!--==================================第一部分第二块=====================================================  -->
    <div title="页面二" data-options="fit:true" style="overflow:auto;padding:20px;display:none;">  
    
   
        <div >   
        <label for="name">售楼地址:</label>   
        <input class="easyui-validatebox" style="width:400px" type="text" name="project_address" data-options="required:true" /> 
         
        </div>    
        <br>
        <label for="name">项目类别:</label>
          <select name="typid" id="types">
            
          </select>
          
        <br>
        <label for="name">报名成功提示文本:</label> 
     <textarea id="content2" name="project_text"  style="width:700px; height:300px;">
      
     </textarea>  
     <br><br><br>
             上线<input type="radio" name="project_state" value="1" checked="checked"/>
             冻结 <input type="radio" name="project_state" value="0"/>
             <br>
        
     <div align="center">
      <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a> 
      </div>
    </div>   

     </div> 

</body>
</html>