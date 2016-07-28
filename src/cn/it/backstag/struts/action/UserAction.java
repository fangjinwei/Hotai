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
	 * 分页join查询User+时间查询+用户和电话查询
	 */
	public String queryJoinAccount() {

		pageMap = new HashMap<>();

		/*
		 * 时间查询+分页
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<User> list = userService.findAllJoinProjectDate(page, size,
					datetime);
			pageMap.put("rows", list);
			pageMap.put("total", userService.getUserCountDate(datetime));
			return "jsonMap";
		}

		/*
		 * 用户和电话查询+分页+默认初始化页面
		 */

		List<User> list = userService.findAllJoinProject(page, size,
				"%" + nametype.trim() + "%");
		pageMap.put("rows", list);
		pageMap.put("total", userService.getUserCount(nametype == null ? nametype = ""
				: nametype.trim()));

		return "jsonMap";

	}

	/**
	 * 删除用户（一条或多条）
	 * 
	 * @return 流
	 */
	public String deleteUsersByIds() {

		userService.deleteByids(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	/*
	 * 用户上车确认
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
