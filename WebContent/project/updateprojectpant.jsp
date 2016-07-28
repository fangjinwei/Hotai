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
	  //不用回显的数据但是修改需要的剩余对象数据
	   var project_createtime=null;//项目创建时间
	   var project_pic=null;//项目图片封面
	   var project_stauts_pic=null;//项目审核状态图片
	   var project_weixin_pic=null;//项目微信图片;
	   var project_text_pic=null;//报名成功提示图片;
	   var project_notice_pic=null;//看房须知图片
	   var project_state=null;//项目状态
	   var project_web=null;//项目生成网站
	   var project_num=null;//项目报名人数
	  
	//得到项目编号，通过这个来得到数据
	var projectid=(parent.$("iframe[title='编辑项目']").get(0).src).split("=")[1];
	//通过ajax来加载数据
	 $.get("ProjectAction_toudpate",
			  {
			   id : projectid
			  },
			  function(data){
				  //回显数据
				  $("input[name='project_name']").val(data.project.project_name);//回显项目名
				  $("input[name='project_jd_audit_tel']").val(data.project.project_jd_audit_tel);//回显接待员电话
				  $("input[name='project_address']").val(data.project.project_address);//回显售楼地址
				  $("input[name='project_kf_audit_tel']").val(data.project.project_kf_audit_tel);//回显审核员电话
				  $(document.getElementsByTagName('iframe')[0].contentWindow.document.body).text(data.project.pant);//回显看房须知文本内容
				 //保存不用回显的数据
				  project_createtime=data.project.project_createtime;
				  project_pic=data.project.project_pic;
				  project_stauts_pic=data.project.project_stauts_pic;
				  project_weixin_pic=data.project.project_weixin_pic;
				  project_text_pic=data.project.project_text_pic;
				  project_notice_pic=data.project.project_notice_pic;
				  project_state=data.project.project_state;
				  project_web=data.project.project_web;
				  project_num=data.project.project_num;
				 
				  
				  
				  //回显状态
				   if(project_state==1){
			        	 $("input[name='project_state'][value=1]").attr("checked",true);
			         }else{
			        	 $("input[name='project_state'][value=0]").attr("checked",true); 
			         }
				  //类别下拉框
				  for(var i=0;i<data.types.length;i++){
					  var id=data.types[i].type_id;
					  var name=data.types[i].type_name;
					 $("#types").append("<option value='"+id+"'>"+name+"</option>"); 
				 }
			   
			  });
	
    
    window.editor1 = KindEditor.create('#content1',{
              resizeType:1,      
    });

   
      
       ////////////////////////////////////////////////////////////////////
        $('#btn').bind('click', function(){    
        	
        	  var project_name=$("input[name='project_name']").val();//项目名
			  var project_jd_audit_tel=$("input[name='project_jd_audit_tel']").val();//接待员电话
			  var project_address=$("input[name='project_address']").val();//售楼地址
			  var project_kf_audit_tel=$("input[name='project_kf_audit_tel']").val();//审核员电话
			  var pant=$(document.getElementsByTagName('iframe')[0].contentWindow.document.body).text();//看房须知文本内容
			  var project_state=$('input:radio[name="project_state"]:checked').val();//项目状态
			  var typeid=$('#types option:selected') .val();//选中的值      
			  if(project_name=="")alert("项目名不能为空！");
			  else if(project_jd_audit_tel=="")alert("接待员电话不能为空！");
			  else if(project_address=="")alert("售楼地址不能为空！");
			  else if(project_kf_audit_tel=="")alert("审核员电话不能为空！");
			  else if(pant=="")alert("文本内容不能为空！");
			  else{
				  //提交修改
				  var project={pant:pant,
						       ispant:'自定义',
						      id:projectid,
						      project_name:project_name,
						      project_jd_audit_tel:project_jd_audit_tel,
						      project_address:project_address,
						      project_kf_audit_tel:project_kf_audit_tel,
						      project_createtime:project_createtime,
				              project_text_pic:project_text_pic,
							  project_state:project_state,
							  project_web:project_web,
							  project_state:project_state,
							  project_num:project_num,
							  typeid:typeid
				              };
				  $.ajax({
					   type: "POST",
					   url: "${backstage}/ProjectPantAction_update",
					   data: project,
					   success: function(data){
					     parent.parent.$("#win").window("close");
					     parent.parent.$("iframe[title='自定义模版']").get(0).contentWindow.$("#dg").datagrid("reload");
					     parent.parent.$("iframe[title='自定义模版']").get(0).contentWindow.$("#dg").datagrid('uncheckAll');
					     
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
  <div id="tt" class="easyui-tabs" data-options="fit:true">
		<div title="页面" data-options="fit:true"
			style="padding: 20px; display: none;">
			<div>
				<label for="name">项目名:</label> <input class="easyui-validatebox"
					type="text" name="project_name" data-options="required:true" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label for="name">接待员电话:</label>
				<input class="easyui-validatebox" type="text"
					name="project_jd_audit_tel" data-options="required:true" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br> <label
					for="name">审核员电话:</label> <input class="easyui-validatebox"
					type="text" name="project_kf_audit_tel"
					data-options="required:true" />
			</div>
			<br>
			<br>
			<br> 上线<input type="radio" name="project_state" value="1"
				checked="checked" /> 冻结 <input type="radio" name="project_state"
				value="0" /> <br>
			<div>
				<label for="name">售楼地址:</label> <input class="easyui-validatebox"
					style="width: 400px" type="text" name="project_address"
					data-options="required:true" />

			</div>
			<br> <label for="name">项目类别:</label> <select name="typid"
				id="types">
			</select>
			 <br><br>
			 <label for="name">模版文本内容:</label>
			<textarea id="content1" name="project_notice"
				style="width: 700px; height: 300px;">
        </textarea>

			<div align="center">
				<a id="btn" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'">提交</a>
			</div>
		</div>
</body>
</html>