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
import cn.it.backstag.util.Pic;

@Controller
@Scope("prototype")
public class ProjectPantAction extends BaseAction<Project> {
	@Resource(name="projectpantService")
	private ProjectService ProjectService;
	@Resource
	private TypesService typeService;

	private List<Types> typelist;

	

	private int typeid;// �õ�ǰ̨�����


	/*
	 * ��ҳjoin��ѯProject+ʱ���ѯ+�û��͵绰��ѯ
	 */
	public String query() {

		pageMap = new HashMap<>();

		/*
		 * ʱ���ѯ+��ҳ
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<Project> list = ProjectService.findAllProjectDate(page, rows,
					datetime,ispant);
			pageMap.put("rows", list);
			pageMap.put("total", ProjectService.getProjectCountDate(datetime,ispant));
			return "jsonMap";
		}

		/*
		 * �û��͵绰��ѯ+��ҳ+Ĭ�ϳ�ʼ��ҳ��
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

	/**
	 * ɾ���û���һ���������
	 * 
	 * @return ��
	 */
	public String deleteProjectsByIds() {

		ProjectService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/*
	 * ȥ�޸�ҳ�棬ͨ��id
	 */
	public String toudpate() {
		pageMap = new HashMap<>();
		pageMap.put("types", typeService.findTypeAll());
		model = ProjectService.findById(model.getId());
		pageMap.put("project", model);
		return "jsonMap";
	}

	/**
	 * �޸�
	 */
	public String update() {
		model.setType(typeService.findById(typeid));
		ProjectService.update(model);
		return "jsonproject";
	}

	public String sava() {
		model.setIspant("�Զ���");
		model.setType(typeService.findById(typeid));
		model.setProject_createtime(Createdatetime.getdatetime());
		model = ProjectService.sava(model);
		model.setProject_web("/QianTaiUserPantAction_pant?id="
				+ model.getId());
		ProjectService.update(model);
		return "jsonproject";
	}

	

	public String updatestauts() {
		ProjectService.updatestauts(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	public String delete() {
		ProjectService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/*
	 * �޸��������Ա�绰
	 */
	public String updatetel() {
		ProjectService.updatetel(model.getProject_kf_audit_tel());
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/******************************************************************/
	

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



}
