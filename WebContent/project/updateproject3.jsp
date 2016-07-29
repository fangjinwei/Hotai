<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@include file="/public/head.jsp"%>
<title>Insert title here</title>
   <script type="text/javascript">
     $(function(){
    	 var status="${status}";
    	
    	 if(status=='1'){
    		 parent.parent.$("#win").window("close");
		     parent.parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg").datagrid("reload");
    	 }
    	 if(status=='2'){
    		 parent.parent.$("#win").window("close");
		     parent.parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg").datagrid("reload");
		     parent.parent.$.messager.show({
  				title:'错误提示',
  				msg:'修改失败！',
  				timeout:2000,
  				showType:'slide'
  			});
    	 }
    	 
    	 
    	 //通过ajax来加载数据
    	 $.get("${backstage}/TypeAction_findAll", function(data){
    				  //类别下拉框
    				  var typeid='${model.type.type_id}';
    				
    				  for(var i=0;i<data.types.length;i++){
    					  var name=data.types[i].type_name;
    					  var tid=data.types[i].type_id;
    					  if(typeid==tid){
    						  $("#types").append("<option value='"+tid+"' selected='selected'>"+name+"</option>"); 
    					  }else{
    					 $("#types").append("<option value='"+tid+"'>"+name+"</option>"); 
    					  }
    				 }
    			   
    			  });
     });
   </script>
</head>
<body>
	<div id="tt" class="easyui-tabs" data-options="fit:true" >   
    <div title="页面一" data-options="fit:true" style="padding:20px;display:none;">   
    <form action="${backstage}/ProjectAction_update3" method="post" >
    <input type="hidden" name="id" value="<s:property value="model.id"/>"/>
    <input type="hidden" name="project_web" value="<s:property value="model.project_web"/>"/>
     
        <label for="name">项目名:</label>   
        <input class="easyui-validatebox"  type="text" name="project_name" value="<s:property value="model.project_name"/>"  />
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <label for="name">接待员电话:</label>
          <input class="easyui-validatebox" type="text" name="project_jd_audit_tel"  value="<s:property value="model.project_jd_audit_tel"/>"/> 

        <label for="name">项目类别:</label>
          <select name="type.type_id" id="types">
            
          </select>
          
        <br>
        
     <br><br><br>
             上线<input type="radio" name="project_state" value="1" checked="checked"/>
             冻结 <input type="radio" name="project_state" value="0" <s:if test="model.project_state==0">checked="checked"</s:if>/>
             <br>
     <div align="center">
     <input type="submit" value="提交" class="easyui-linkbutton"/>
      </div>
      </form>
    </div>     
          
    </div>   
  

</body>
</html>