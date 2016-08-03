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
	 * ��ҳjoin��ѯUser+ʱ���ѯ+�û��͵绰��ѯ
	 */
	public String queryJoinAccount() {

		pageMap = new HashMap<>();

		/*
		 * ʱ���ѯ+��ҳ
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<User> list = userService.findAllJoinProjectDate(page, size,
					datetime,type);
			pageMap.put("rows", list);
			pageMap.put("total", userService.getUserCountDate(datetime,type));
			return "jsonMap";
		}

		/*
		 * �û��͵绰��ѯ+��ҳ+Ĭ�ϳ�ʼ��ҳ��
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
		 * ʱ���ѯ+��ҳ
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<User> list = userService.findAllJoinProjectDate2(page, size,
					datetime,type,project_name);
			pageMap.put("rows", list);
			pageMap.put("total", userService.getUserCountDate2(datetime,type,project_name));
			return "jsonMap";
		}

		/*
		 * �û��͵绰��ѯ+��ҳ+Ĭ�ϳ�ʼ��ҳ��
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
////////////////////
	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

}
