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
	 * 登入报名第一页
	 */
	public String pant() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (p == null) {// 判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getId() != id) {// 判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)return "pant4";// 判断活动是否关闭
		return "pant";
	}

	public String pant1() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (p == null) {// 判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getId() != id) {// 判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "pant4";// 判断活动是否关闭
		return "pant1";
	}

	public String pant2() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// 判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getId() != id) {// 判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)
				return "pant3";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "pant4";// 判断活动是否关闭
		return "pant2";
	}

	public String pant3() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// 判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getId() != id) {// 判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "guanbi";// 判断活动是否关闭
		return "pant3";
	}

	public String pant4() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// 判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getId() != id) {// 判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "guanbi";// 判断活动是否关闭
		return "pant4";
	}

	public String pant5() {
		long id = model.getId();
		Integer idd = (int) id;
		p = (Project) mySession.get("project");
		if (mySession.get("project") == null) {// 判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getId() != id) {// 判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)
				return "shanchu";// 判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)
			return "guanbi";// 判断活动是否关闭
		return "pant5";
	}

	
	/****
	 * 添加用户
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
