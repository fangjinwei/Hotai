package cn.it.backstag.struts.action;

import java.io.ByteArrayInputStream;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.backstag.model.User;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware {

	private String loginname;
	private String password;

	public String login() {
		if (!loginname.equals("admin") && !password.equals("fangwh")) {

			inputStream = new ByteArrayInputStream("false".getBytes());
			return "stream";
		}
		mySession.put("u", "ok");
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/**********************************/
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
