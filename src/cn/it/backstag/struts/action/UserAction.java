package cn.it.backstag.struts.action;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.backstag.model.User;
import cn.it.backstag.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	@Resource
	private UserService userService;

	/*
	 * ��ҳjoin��ѯUser+ʱ���ѯ+�û��͵绰��ѯ
	 */
	public String queryJoinAccount() {

		pageMap = new HashMap<>();

		/*
		 * ʱ���ѯ+��ҳ
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<User> list = userService.findAllJoinProjectDate(page, size,
					datetime);
			pageMap.put("rows", list);
			pageMap.put("total", userService.getUserCountDate(datetime));
			return "jsonMap";
		}

		/*
		 * �û��͵绰��ѯ+��ҳ+Ĭ�ϳ�ʼ��ҳ��
		 */

		List<User> list = userService.findAllJoinProject(page, size,
				"%" + nametype.trim() + "%");
		pageMap.put("rows", list);
		pageMap.put("total", userService.getUserCount(nametype == null ? nametype = ""
				: nametype.trim()));

		return "jsonMap";

	}

	/**
	 * ɾ���û���һ���������
	 * 
	 * @return ��
	 */
	public String deleteUsersByIds() {

		userService.deleteByids(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	/*
	 * �û��ϳ�ȷ��
	 */
	public String  gototimeByIds(){
		
		userService.gototimeByIds(model.getUser_status(),new Date(),ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public String gotoendByIds(){
		userService.gotoendByIds(model.getUser_status(),ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

}
