package cn.it.backstag.util;


import cn.it.backstag.model.Project;
import cn.it.backstag.model.User;
import cn.it.backstag.service.ProjectService;
import cn.it.backstag.service.UserService;

public class MyThread implements Runnable {
	private ProjectService projectService;
	private UserService userService;
	private User model;
	private Project p;

	public MyThread(ProjectService projectService,
			UserService userService, User model, Project p) {
		this.projectService = projectService;
		this.userService = userService;
		this.model = model;
		this.p = p;
	}

	@Override
	public void run() {
		HttpSend.sendgoods(p.getProject_kf_audit_tel(), model.getUsername(), model.getTel(),
				model.getRegistration_time(), model.getGotasi_time_x(),
				model.getGotasi_adress(), p.getProject_name());
		userService.save(model);
		projectService.updatenum(p.getId());
	}

}
