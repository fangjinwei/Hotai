<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@include file="/public/head.jsp"%>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		
		//得到项目编号，通过这个来得到数据
		var projectid = (parent.$("iframe[title='编辑项目']").get(0).src)
				.split("=")[1].split("&&")[0];
		var old_project_pic = (parent.$("iframe[title='编辑项目']").get(0).src)
		        .split("=")[2].split("&&")[0];
		var old_project_stauts_pic = (parent.$("iframe[title='编辑项目']").get(0).src)
                .split("=")[3].split("&&")[0];
		var old_project_weixin_pic = (parent.$("iframe[title='编辑项目']").get(0).src)
                .split("=")[4].split("&&")[0];
		var old_project_notice_pic = (parent.$("iframe[title='编辑项目']").get(0).src)
                .split("=")[5].split("&&")[0];
		var old_project_text_pic = (parent.$("iframe[title='编辑项目']").get(0).src)
                .split("=")[6].split("&&")[0];
		
		//111111111////////////////////////////////////////上传项目图片封面
		$("#project_pic1").uploadify({
			'height' : 30,
			'width' : 120,
			'swf' : '${backstage}/uploadify/uploadify.swf',
			'cancel' : '${backstage}/uploadify/uploadify-cancel.png',
			'uploader' : 'ProjectAction_upload',
			'buttonText' : '项目图片封面',
			'auto' : true,
			'fileObjName' : 'picture',
			'formData' : {
				'id' : projectid,
				'pic': 'project_pic',
				'oldpic.old_project_pic':old_project_pic

			},
			'onUploadSuccess' : function(file, data, response) {
				if(data!=null){
					alert($("#"+data).attr("title")+"上传成功！");
					$("#"+data).hide(1000);
				}else{
					alert("上传失败！");
				}
			},
			'onSelectError' : function(file, errorCode, errorMsg){
				alert("异常"+errorMsg);
			}
		});
          //22222222222////////////////////////////////////////上传项目审核状态图片
		$("#project_stauts_pic1").uploadify({
			'height' : 30,
			'width' : 120,
			'swf' : '${backstage}/uploadify/uploadify.swf',
			'cancel' : '${backstage}/uploadify/uploadify-cancel.png',
			'uploader' : 'ProjectAction_upload',
			'buttonText' : '项目审核状态图片',
			'auto' : true,
			'fileObjName' : 'picture',
			'formData' : {
				'id' : projectid,
				'pic': 'project_stauts_pic',
			    'oldpic.old_project_stauts_pic':old_project_stauts_pic

			},
			'onUploadSuccess' : function(file, data, response) {
				if(data!=null){
					alert($("#"+data).attr("title")+"上传成功！");
					$("#"+data).hide(1000);
				}else{
					alert("上传失败！");
				}
			},
			'onSelectError' : function(file, errorCode, errorMsg){
				alert("异常"+errorMsg);
			}
		});
		//333333333333333////////////////////////////////////////上传项目微信图片
		$("#project_weixin_pic1").uploadify({
			'height' : 30,
			'width' : 120,
			'swf' : '${backstage}/uploadify/uploadify.swf',
			'cancel' : '${backstage}/uploadify/uploadify-cancel.png',
			'uploader' : 'ProjectAction_upload',
			'buttonText' : '项目微信图片',
			'auto' : true,
			'fileObjName' : 'picture',
			'formData' : {
				'id' : projectid,
				'pic': 'project_weixin_pic',
				'oldpic.old_project_weixin_pic':old_project_weixin_pic

			},
			'onUploadSuccess' : function(file, data, response) {
				if(data!=null){
					alert($("#"+data).attr("title")+"上传成功！");
					$("#"+data).hide(1000);
				}else{
					alert("上传失败！");
				}
			},
			'onSelectError' : function(file, errorCode, errorMsg){
				alert("异常"+errorMsg);
			}
		});
		//44444444444444////////////////////////////////////////上传看房须知图片
		$("#project_notice_pic1").uploadify({
			'height' : 30,
			'width' : 120,
			'swf' : '${backstage}/uploadify/uploadify.swf',
			'cancel' : '${backstage}/uploadify/uploadify-cancel.png',
			'uploader' : 'ProjectAction_upload',
			'buttonText' : '看房须知图片',
			'auto' : true,
			'fileObjName' : 'picture',
			'formData' : {
				'id' : projectid,
				'pic': 'project_notice_pic',
				'oldpic.old_project_notice_pic':old_project_notice_pic

			},
			'onUploadSuccess' : function(file, data, response) {
				if(data!=null){
					alert($("#"+data).attr("title")+"上传成功！");
					$("#"+data).hide(1000);
				}else{
					alert("上传失败！");
				}
			},
			'onSelectError' : function(file, errorCode, errorMsg){
				alert("异常"+errorMsg);
			}
		});
		//55555555555555555////////////////////////////////////////上传报名成功提示图片
		$("#project_text_pic1").uploadify({
			'height' : 30,
			'width' : 120,
			'swf' : '${backstage}/uploadify/uploadify.swf',
			'cancel' : '${backstage}/uploadify/uploadify-cancel.png',
			'uploader' : 'ProjectAction_upload',
			'buttonText' : '报名成功提示图片',
			'auto' : true,
			'fileObjName' : 'picture',
			'formData' : {
				'id' : projectid,
				'pic': 'project_text_pic',
				'oldpic.old_project_text_pic':old_project_text_pic

			},
			'onUploadSuccess' : function(file, data, response) {
				if(data!=null){				
					alert($("#"+data).attr("title")+"上传成功！");
					$("#"+data).hide(1000);
				}else{
					alert("上传失败！");
				}
			},
			'onSelectError' : function(file, errorCode, errorMsg){
				alert("异常"+errorMsg);
			}
		});
	});
</script>
</head>
<body>
	 <div id="project_pic" title="项目图片封面"><input type="file" name="picture" id="project_pic1" /></div> 
	 <div id="project_stauts_pic" title="项目审核状态图片"><input type="file" name="picture" id="project_stauts_pic1" /></div> 
	 <div id="project_weixin_pic" title="项目微信图片"><input type="file" name="picture" id="project_weixin_pic1" /></div>
	 <div id="project_notice_pic" title="看房须知图片"><input type="file" name="picture" id="project_notice_pic1" /></div>
	 <div id="project_text_pic" title="报名成功提示图片"><input type="file" name="picture" id="project_text_pic1" /></div>





</body>
</html>