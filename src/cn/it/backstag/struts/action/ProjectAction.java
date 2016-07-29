package cn.it.backstag.struts.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.backstag.model.Project;
import cn.it.backstag.model.Types;
import cn.it.backstag.service.ProjectService;
import cn.it.backstag.service.TypesService;
import cn.it.backstag.util.Createdatetime;
import cn.it.backstag.util.Pant;
import cn.it.backstag.util.Pic;

@Controller
@Scope("prototype")
public class ProjectAction extends BaseAction<Project> {
	@Resource(name="projectService")
	private ProjectService ProjectService;
	@Resource
	private TypesService typeService;

	private List<Types> typelist;

	public File picture;// 和页面的name 一样
	public String pictureFileName;// 组合模式 picture+"FileName"【固定写法】
	private String pic;// 判断上传的是哪张图片

	private int typeid;// 得到前台的外键

	private Pic oldpic;

	/*
	 * 分页join查询Project+时间查询+用户和电话查询
	 */
	public String query() {

		pageMap = new HashMap<>();
		ispant=Pant.getfenlei(model.getIspant());
		System.out.println(ispant);
		/*
		 * 时间查询+分页
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<Project> list = ProjectService.findAllProjectDate(page, rows,
					datetime,ispant);
			pageMap.put("rows", list);
			pageMap.put("total", ProjectService.getProjectCountDate(datetime,ispant));
			return "jsonMap";
		}

		/*
		 * 用户和电话查询+分页+默认初始化页面
		 */

		List<Project> list = ProjectService.findAllProject(page, rows, "%"
				+ nametype.trim() + "%",ispant);
		pageMap.put("rows", list);
		if(nametype==null){
			nametype="";
			}else{
				nametype=nametype.trim();
			}
		pageMap.put("total", ProjectService.getProjectCount(nametype,ispant));

		return "jsonMap";

	}
	/*
	 * 冻结
	 */
	public String updatestauts() {
		ProjectService.updatestauts(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/**
	 * 删除用户（一条或多条）
	 * 
	 * @return 流
	 */
	public String deleteProjectsByIds() {

		ProjectService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/*
	 * 去修改页面，通过id
	 */
	public String toudpate() {
		pageMap = new HashMap<>();
		pageMap.put("types", typeService.findTypeAll());
		model = ProjectService.findById(model.getId());
		pageMap.put("project", model);
		return "jsonMap";
	}

	/**
	 * 修改
	 */
	public String update() {
		model.setType(typeService.findById(typeid));
		ProjectService.update(model);
		return "jsonproject";
	}

	public String sava() {
		model.setType(typeService.findById(typeid));
		model.setProject_createtime(Createdatetime.getdatetime());
		model = ProjectService.sava(model);
		model.setProject_web("/QianTaiUserAction_index1?id="
				+ model.getId());
		ProjectService.update(model);
		typeService.updatenum(model.getType().getType_id());
		return "jsonproject";
	}
  //模版2的保存
	public String add2(){
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		//model.setType(typeService.findById(typeid));
		model.setProject_createtime(Createdatetime.getdatetime());
		model.setIspant("标准2");
      if(picture==null){
    	Project p=  (Project) mySession.get("addmodel");
			if(p!=null){
				 model.setProject_pic(p.getProject_pic());
				   ProjectService.sava(model);
				   model.setProject_web("/QianTaiUserAction_indexmoban?id="
							+ model.getId());
				    ProjectService.update(model);
				   model=model;
				   mySession.put("addmodel", model);
			}else{
				status=2;
				  return "adderror";
			
			}
		}else if(picture!=null){
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
				  model.setProject_pic(pp);
				   ProjectService.sava(model);
				   model.setProject_web("/QianTaiUserAction_indexmoban?id="
							+ model.getId());
				    ProjectService.update(model);
				   model=model;
				   mySession.put("addmodel", model);
				} catch (Exception e) {
					status=2;
				  return "adderror";
			
				}

		}
	
		 
		status=1;

		return "addsuccess";
	}
	
	//模版2去修改
	public String toupdate2(){
		model = ProjectService.findById(model.getId());
		if(model!=null){
			mySession.put("updatemodel2", model);
		}
		return "update";
	}
	
	public String update2(){
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		model.setIspant("标准2");
		
		if(picture==null){
		Project p=	(Project) mySession.get("updatemodel2");
		 model.setProject_pic(p.getProject_pic());
		   ProjectService.update(model);
		   status=1;

		   return "update";
		}
		
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
				   model.setProject_pic(pp);
				   ProjectService.update(model);
				} catch (Exception e) {
					status=2;
				  return "update";
			
				}

				status=1;

		return "update";
	}
	//模版3的保存
	public String add3(){
		try {
			model.setProject_createtime(Createdatetime.getdatetime());
			model.setIspant("标准3");
			 ProjectService.sava(model);
			 model.setProject_web("/QianTaiUserAction_indexmobanaaaa?id="
						+ model.getId());
			 ProjectService.update(model);
			
		} catch (Exception e) {
			status=2;
			 return "update";
		}
		 status=1;
	 return "update";
	}
	public String toupdate3(){
		model = ProjectService.findById(model.getId());
		if(model!=null){
			mySession.put("updatemodel3", model);
		}
		return "update2";
	}
	
	//模版3的修改
	 public String update3(){		
			model.setIspant("标准3");
			 ProjectService.update(model);
			  status=1;
			   return "update";
	}
			
			
	// 图片
		public String upload() {
			ServletContext servletContext = ServletActionContext
					.getServletContext();

			boolean flag = oldpic.deletepic(servletContext, oldpic);// 如果是修改，就删除旧图片
			// 进行图片上传
			boolean uploadflag = oldpic.upload(picture, pictureFileName,
					servletContext, ProjectService, model, pic);
			inputStream = new ByteArrayInputStream(pic.getBytes());

			return "stream";
		}
	

	public String delete() {
		ProjectService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/*
	 * 修改所以审核员电话
	 */
	public String updatetel() {
		if(model.getId()==90){
		ProjectService.updatetel(model.getProject_kf_audit_tel());
		}else if(model.getId()==100){
	    ProjectService.updatemoban2tel(model.getProject_kf_audit_tel());
		}else if(model.getId()==110){
			ProjectService.updatezidingyitel(model.getProject_kf_audit_tel());
		}
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/******************************************************************/
	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public List<Types> getTypelist() {
		return typelist;
	}

	public void setTypelist(List<Types> typelist) {
		this.typelist = typelist;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public Pic getOldpic() {
		return oldpic;
	}

	public void setOldpic(Pic oldpic) {
		this.oldpic = oldpic;
	}

}
