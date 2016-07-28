package cn.it.backstag.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.it.backstag.model.Project;
import cn.it.backstag.service.ProjectService;

public class Pic {
	private String  old_project_pic;//旧的项目审核状态图片
	private String old_project_stauts_pic;//旧的项目审核状态图片
	private String old_project_weixin_pic;//旧的项目微信图片
	private String old_project_notice_pic;//旧的看房须知图片
	private String old_project_text_pic;//旧的报名成功提示图片
	public String getOld_project_pic() {
		return old_project_pic;
	}
	public void setOld_project_pic(String old_project_pic) {
		this.old_project_pic = old_project_pic;
	}
	public String getOld_project_stauts_pic() {
		return old_project_stauts_pic;
	}
	public void setOld_project_stauts_pic(String old_project_stauts_pic) {
		this.old_project_stauts_pic = old_project_stauts_pic;
	}
	public String getOld_project_weixin_pic() {
		return old_project_weixin_pic;
	}
	public void setOld_project_weixin_pic(String old_project_weixin_pic) {
		this.old_project_weixin_pic = old_project_weixin_pic;
	}
	public String getOld_project_notice_pic() {
		return old_project_notice_pic;
	}
	public void setOld_project_notice_pic(String old_project_notice_pic) {
		this.old_project_notice_pic = old_project_notice_pic;
	}
	public String getOld_project_text_pic() {
		return old_project_text_pic;
	}
	public void setOld_project_text_pic(String old_project_text_pic) {
		this.old_project_text_pic = old_project_text_pic;
	}
	
	
	
	
	
	
	//对旧图片进行删除
	public static boolean deletepic(ServletContext servletContext,Pic oldpic){
	    boolean	flag=false;		
		if(oldpic.getOld_project_pic()!=null){
			String old_project_pic_filePath = servletContext.getRealPath("/")+oldpic.getOld_project_pic().replaceAll("/", "\\\\");
			System.out.println("old_project_pic_filePath:"+old_project_pic_filePath);
			File delete_old_project_pic_filePath=new File(old_project_pic_filePath);
			flag = delete_old_project_pic_filePath.delete();
			
		}
		if(oldpic.getOld_project_stauts_pic()!=null){
			String old_project_stauts_pic_filePath = servletContext.getRealPath("/")+oldpic.getOld_project_stauts_pic().replaceAll("/", "\\\\");
			File delete_old_project_stauts_pic_filePath=new File(old_project_stauts_pic_filePath);
			flag =delete_old_project_stauts_pic_filePath.delete();
		}
		if(oldpic.getOld_project_weixin_pic()!=null){
			String old_project_weixin_pic_filePath = servletContext.getRealPath("/")+oldpic.getOld_project_weixin_pic().replaceAll("/", "\\\\");
			File delete_old_project_weixin_pic_filePath=new File(old_project_weixin_pic_filePath);
			flag =delete_old_project_weixin_pic_filePath.delete();
		}
		if(oldpic.getOld_project_notice_pic()!=null){
			String old_project_notice_pic_filePath = servletContext.getRealPath("/")+oldpic.getOld_project_notice_pic().replaceAll("/", "\\\\");
			File delete_old_project_notice_pic_filePath=new File(old_project_notice_pic_filePath);
			flag =delete_old_project_notice_pic_filePath.delete();
		}
		if(oldpic.getOld_project_text_pic()!=null){
			String old_project_text_pic_filePath = servletContext.getRealPath("/")+oldpic.getOld_project_text_pic().replaceAll("/", "\\\\");
			File delete_old_project_text_pic_filePath=new File(old_project_text_pic_filePath);	
			flag =delete_old_project_text_pic_filePath.delete();
		}
		System.out.println("flag:"+flag);
		return flag;
	}
	@Override
	public String toString() {
		return "Oldpic [old_project_pic=" + old_project_pic + ", old_project_stauts_pic=" + old_project_stauts_pic
				+ ", old_project_weixin_pic=" + old_project_weixin_pic + ", old_project_notice_pic="
				+ old_project_notice_pic + ", old_project_text_pic=" + old_project_text_pic + "]";
	}
	
	
	
	
	
	
	
	public static boolean upload(File picture,String pictureFileName,ServletContext servletContext,ProjectService ProjectService, Project model,String pic){
		 boolean flag=true;   
		// 进行copy
				try {
					// 定义位置：
					String pp = "";
					String path = servletContext.getRealPath(
							"/upload");
					String str = UUID.randomUUID().toString();
					int code = str.hashCode();
					char[] array = (code + "").toCharArray();
					for (int i = 0; i < array.length; i++) {
						pp = pp + "/" + array[i];
					}
					pp = pp + "/" + str + "_" + pictureFileName;
					path = path + "/" + pp;

					File destFile = new File(path);
					FileUtils.copyFile(picture, destFile);
					ProjectService.upload("upload" + pp, model.getId(), pic);
				} catch (Exception e) {
					flag=false;
				}
		
		
		return true;
	}
}
