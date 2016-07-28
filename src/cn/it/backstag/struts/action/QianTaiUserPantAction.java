package cn.it.backstag.struts.action;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.backstag.model.Project;
import cn.it.backstag.model.User;
import cn.it.backstag.service.ProjectService;
import cn.it.backstag.service.UserService;
import cn.it.backstag.util.Createdatetime;
import cn.it.backstag.util.HttpSend;
import cn.it.backstag.util.MyThread;

/**
 * @author Administrator
 * 
 */
@Controller("qianTaiUserPantAction")
@Scope("prototype")
public class QianTaiUserPantAction extends BaseAction<User> {
	@Resource
	private UserService userService;
	@Resource
	private ProjectService projectService;

	private Project p;



	/*
	 * ���뱨����һҳ
	 */
	public String pant() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (p == null) {// �ж��Ƿ��ǵ�һ�ε���
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getId() != id) {// �ж��Ƿ��ǲ�ͬ����Ŀ
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)return "pant4";// �жϻ�Ƿ�ر�
		return "pant";
	}

	public String pant1() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (p == null) {// �ж��Ƿ��ǵ�һ�ε���
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getId() != id) {// �ж��Ƿ��ǲ�ͬ����Ŀ
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "pant4";// �жϻ�Ƿ�ر�
		return "pant1";
	}

	public String pant2() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// �ж��Ƿ��ǵ�һ�ε���
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getId() != id) {// �ж��Ƿ��ǲ�ͬ����Ŀ
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "pant4";// �жϻ�Ƿ�ر�
		return "pant2";
	}

	public String pant3() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// �ж��Ƿ��ǵ�һ�ε���
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getId() != id) {// �ж��Ƿ��ǲ�ͬ����Ŀ
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "guanbi";// �жϻ�Ƿ�ر�
		return "pant3";
	}

	public String pant4() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// �ж��Ƿ��ǵ�һ�ε���
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getId() != id) {// �ж��Ƿ��ǲ�ͬ����Ŀ
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "guanbi";// �жϻ�Ƿ�ر�
		return "pant4";
	}

	public String pant5() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// �ж��Ƿ��ǵ�һ�ε���
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getId() != id) {// �ж��Ƿ��ǲ�ͬ����Ŀ
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// �ж��Ƿ��Ѿ�ɾ��
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "guanbi";// �жϻ�Ƿ�ر�
		return "pant5";
	}

	
	/****
	 * ����û�
	 * 
	 */
	public String save() {
		try {
			if (model.getUsername() == null || model.getTel() == null) {
				status=0;
			}
			p = (Project) mySession.get("project");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(new Date().getTime());
		model.setRegistration_time(format);
		model.setRegistration_go(p.getProject_name());
		model.setProject(p);
		} catch (Exception e) {
			inputStream = new ByteArrayInputStream("false".getBytes());
			return "stream";
		}
		HttpSend.sendgoodpants(p.getProject_kf_audit_tel(), model.getUsername(), model.getTel(), p.getProject_name());
		userService.save(model);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
		
	}

	/********************************************************************************/
	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}



}
