package cn.it.backstag.struts.action;

import java.text.SimpleDateFormat;
import java.util.Date;

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
@Controller("qianTaiUserAction")
@Scope("prototype")
public class QianTaiUserAction extends BaseAction<User> {
	@Resource
	private UserService userService;
	@Resource
	private ProjectService projectService;

	private Project p;
	private String suiji;

	// 时间
	private String now;
	private String time;
	private String adress;
	private String h;
	private String f;
  
	

	/*
	 * 第二模版登入报名第一页
	 */
	public String  indexmoban() {
		long id = model.getId();
		Integer idd = (int) id;
		p=(Project) mySession.get("project");
		if(p==null){//判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null) {status=3; return "moban2";}//判断是否已经删除
			mySession.put("project", p);
		}
		if(p.getId()!=id){//判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null){status=4; return "moban2";}//判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0){status=5; return "moban2";}// 判断活动是否关闭
		
		return "moban2";
	}
	
	
	public String add(){
		try {
		 if(model.getUsername()!=null&&!model.getUsername().equals("")&&model.getTel()!=null&&!model.getTel().equals("")){
			
					p = (Project) mySession.get("project");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String format = sdf.format(new Date().getTime());
					model.setRegistration_time(format);
					model.setRegistration_go(p.getProject_name());
				
					model.setProject(p);
				
				HttpSend.sendmoban(p.getProject_kf_audit_tel(), model.getUsername(), model.getTel(), p.getProject_name());
				userService.save(model);
				HttpSend.sendmoban(p.getProject_jd_audit_tel(), model.getUsername(),model.getTel(), p.getProject_name());
				   
				userService.pdateMessageByids(1,Long.toString( model.getId()));
				status=2;
		 }
		} catch (Exception e) {
			status=5;
		    return "moban2";
		}
		
		return "moban2";
	}

	
	
	
	/*
	 * 登入报名第一页
	 */
	public String index1() {
		long id = model.getId();
		Integer idd = (int) id;
		p=(Project) mySession.get("project");
		if(p==null){//判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if(p.getId()!=id){//判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)return "guanbi";// 判断活动是否关闭
		return "success";
	}

	public String index2() {
		long id = model.getId();
		Integer idd = (int) id;
		p=(Project) mySession.get("project");
		if(mySession.get("project")==null){//判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if(p.getId()!=id){//判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)return "guanbi";// 判断活动是否关闭
		return "index2";
	}

	public String index3() {
		long id = model.getId();
		Integer idd = (int) id;
		p=(Project) mySession.get("project");
		if(mySession.get("project")==null){//判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if(p.getId()!=id){//判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)return "guanbi";// 判断活动是否关闭
		return "index3";
	}

	public String index4() {
		long id = model.getId();
		Integer idd = (int) id;
		p=(Project) mySession.get("project");
		if(mySession.get("project")==null){//判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if(p.getId()!=id){//判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)return "guanbi";// 判断活动是否关闭
		return "index4";
	}

	public String index7() {
		long id = model.getId();
		Integer idd = (int) id;
		p=(Project) mySession.get("project");
		if(mySession.get("project")==null){//判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if(p.getId()!=id){//判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null)return "shanchu";//判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0)return "guanbi";// 判断活动是否关闭
		return "index7";
	}

	/**
	 * 
	 * 得到短信验证码
	 */
	public String getMessage() {
		String suiji = HttpSend.suiji();
		System.out.println(suiji);
		HttpSend.send(model.getTel(), suiji);
		mySession.put("suiji", suiji);
		status = 1;
		return "jsonstatus";

	}

	/***
	 * 验证得到的第一页数据，判断是否可以跳转第二页
	 */
	public String usernameandtel() {
		String sj = (String) mySession.get("suiji");
		if (!sj.equals(suiji)) {
			status = 0;// 验证码不正确
			return "jsonstatus";
		}
		model.setRegistration_go(((Project) mySession.get("project"))
				.getProject_name());
		mySession.put("user", model);// 先不添加吧用户名和电话保存到session
		mySession.put("deng", "deng");// 用来辨别是否已经登入过第一页并且已经验证过
		status = 1;
		return "jsonstatus";
	}

	/****
	 * 添加用户
	 * 
	 */
	public String save() {
		String month = null;
		String day = null;
		String year = null;
		String[] strings = time.split("-");
		year = strings[0];
		month = strings[1];
		day = strings[2];
		int year2 = Integer.parseInt(year);// 选中年
		int parseInt = Integer.parseInt(h);// 选中时
		int month2 = Integer.parseInt(month);// 选中月
		int day2 = Integer.parseInt(day);// 选中天
		int ff = Integer.parseInt(f);// 选中分
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-H-m-s");
		String format = sdf.format(new Date().getTime());
		String[] string2 = format.split("-");
		int years = Integer.parseInt(string2[0]);// 当前年
		int months = Integer.parseInt(string2[1]);// 当前月
		int days = Integer.parseInt(string2[2]);// 当前天
		int hours = Integer.parseInt(string2[3]);// 当前时
		int fen = Integer.parseInt(string2[4]);
		int zhi = parseInt - hours;
		if (ff == 1)
			ff = 0;
		int nowdate = hours * 60 + fen;
		int godate = parseInt * 60 + ff;

		if (Integer.parseInt(f) == 1) {
			f = "0";
		}
		/*************************************/
		if (godate - nowdate < 30) {
			status = 0;
			return "jsonstatus";
		} else if (godate - nowdate >= 30) {
			p = (Project) mySession.get("project");
			model = (User) mySession.get("user");

			if (model.getUsername() == null || model.getUsername().equals("")) {
				status = 3;
				return "jsonstatus";
			}

			String date = h + "时" + f + "分";
			model.setGotasi_adress(adress);
			model.setGotasi_time_x(date);
			model.setRegistration_time(time);
			model.setProject(p);
			new Thread(new MyThread(projectService, userService, model, p))
					.start();
			return "jsonuser";
		} else {
			status = 2;
			return "jsonstatus";
		}
	}
 
	
	
	
	
	////////模版3进入
  public String	indexmobanaaaa(){
	  long id = model.getId();
		Integer idd = (int) id;
		p=(Project) mySession.get("project");
		if(p==null){//判断是否是第一次登入
			p = projectService.findById(idd);
			if (p == null) {status=3; return "moban2";}//判断是否已经删除
			mySession.put("project", p);
		}
		if(p.getId()!=id){//判断是否是不同的项目
			p = projectService.findById(idd);
			if (p == null){status=4; return "moban2";}//判断是否已经删除
			mySession.put("project", p);
		}
		if (p.getProject_state() == 0){status=5; return "moban2";}// 判断活动是否关闭
		
		return "moban3";
  }
  
  public String addaaaa(){
	  try {
			 if(model.getUsername()!=null&&!model.getUsername().equals("")&&model.getTel()!=null&&!model.getTel().equals("")){
				
						p = (Project) mySession.get("project");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String format = sdf.format(new Date().getTime());
						model.setRegistration_time(format);
						model.setRegistration_go(p.getProject_name());
					
						model.setProject(p);
					
					HttpSend.sendmoban(p.getProject_kf_audit_tel(), model.getUsername(), model.getTel(), p.getProject_name());
					userService.save(model);
					HttpSend.sendmoban(p.getProject_jd_audit_tel(), model.getUsername(),model.getTel(), p.getProject_name());
					   
					userService.pdateMessageByids(1,Long.toString( model.getId()));
					status=2;
			 }
			} catch (Exception e) {
				status=5;
			    return "moban3";
			}
	  return "moban3";
  }
  
	/********************************************************************************/
	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public String getSuiji() {
		return suiji;
	}

	public void setSuiji(String suiji) {
		this.suiji = suiji;
	}

	public String getNow() {
		return now;
	}

	public void setNow(String now) {
		this.now = now;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getF() {
		return f;
	}

	public void setF(String f) {
		this.f = f;
	}




}
