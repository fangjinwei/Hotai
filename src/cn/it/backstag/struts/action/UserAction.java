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
     
	private String project_name;
	private String type;
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
					datetime,type);
			pageMap.put("rows", list);
			pageMap.put("total", userService.getUserCountDate(datetime,type));
			return "jsonMap";
		}

		/*
		 * 用户和电话查询+分页+默认初始化页面
		 */

		List<User> list = userService.findAllJoinProject(page, size,
				"%" + nametype.trim() + "%",type);
		pageMap.put("rows", list);
		if(nametype == null){
			nametype="";
		}else{
			nametype=nametype.trim();
		}
		pageMap.put("total", userService.getUserCount(nametype,type));

		return "jsonMap";

	}
  
	public String queryJoinAccount2() {
           
		pageMap = new HashMap<>();
		
		String str = (String) mySession.get("hahahah");
		if(str==null&&project_name==null){
    		project_name="";
    	}else if(str!=null&&project_name==null){
    		project_name=str;
    	
    	}else if(str!=null&&project_name!=null){
    		if(!str.equals(project_name)){
    			mySession.put("hahahah", project_name);
    		}
    	
    	}
        
		
		if(!project_name.equals("")){
			mySession.put("hahahah", project_name);
		}
		/*
		 * 时间查询+分页
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<User> list = userService.findAllJoinProjectDate2(page, size,
					datetime,type,project_name);
			pageMap.put("rows", list);
			pageMap.put("total", userService.getUserCountDate2(datetime,type,project_name));
			return "jsonMap";
		}

		/*
		 * 用户和电话查询+分页+默认初始化页面
		 */

		List<User> list = userService.findAllJoinProject2(page, size,
				"%" + nametype.trim() + "%",type,project_name);
		pageMap.put("rows", list);
		if(nametype == null){
			nametype="";
		}else{
			nametype=nametype.trim();
		}
		pageMap.put("total", userService.getUserCount2(nametype,type,project_name));

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
////////////////////
	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

}
