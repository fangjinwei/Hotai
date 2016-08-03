package cn.it.ssh.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.it.backstag.model.User;
import cn.it.backstag.service.UserService;

public class Test {
   @org.junit.Test
	public void TTT() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"bean.xml");
		UserService us = (UserService) ac.getBean("userService");
		List<User> list = us.findAllJoinProject2(1, 10, "%%", "%%", "≤‚ ‘œ¬∞°");
		for (User user : list) {
			System.out.println(user.getProject().getProject_name());
		}
	}

}
