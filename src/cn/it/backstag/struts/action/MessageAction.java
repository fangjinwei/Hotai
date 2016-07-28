package cn.it.backstag.struts.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.backstag.model.User;
import cn.it.backstag.service.UserService;
import cn.it.backstag.util.HttpSend;

@Controller
@Scope("prototype")
public class MessageAction extends BaseAction<User> {
	@Resource
	private UserService userService;

	private String project_jd_audit_tel;
	
	

	/*
	 * ��ҳjoin��ѯUser+ʱ���ѯ+�û��͵绰��ѯ
	 */
	public String queryMessage() {

		pageMap = new HashMap<>();

		/*
		 * ʱ���ѯ+��ҳ
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<User> list = userService.findAllMessagedate(page, size,
					datetime);
			pageMap.put("rows", list);
			pageMap.put("total", userService.getMessagedateCountDate(datetime));
			return "jsonMap";
		}

		/*
		 * �û��͵绰��ѯ+��ҳ+Ĭ�ϳ�ʼ��ҳ��
		 */

		List<User> list = userService.findAllMessage(page, size,
				"%" + nametype.trim() + "%");
		pageMap.put("rows", list);
		pageMap.put("total", userService
				.getMessageCount(nametype == null ? nametype = "" : nametype.trim()));

		return "jsonMap";

	}

	/**
	 * ����û���һ���������
	 * 
	 * @return ��
	 */
	public String updateMessageByIds() {
		int user_status = model.getUser_status();
		if (user_status == 1) {
			HttpSend.sendgood(project_jd_audit_tel, model.getUsername(),
					  model.getTel(), model.getGotasi_adress(),
					model.getRegistration_time(), model.getGotasi_time_x(),
					model.getRegistration_go());
		} else {
			HttpSend.sendNO(model.getTel(), model.getRegistration_go());
		}

		userService.pdateMessageByids(user_status, ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/****************************************/
	public String getProject_jd_audit_tel() {
		return project_jd_audit_tel;
	}

	public void setProject_jd_audit_tel(String project_jd_audit_tel) {
		this.project_jd_audit_tel = project_jd_audit_tel;
	}

}
