package cn.it.backstag.util;

import java.util.Random;

import cn.it.backstag.util.HttpSender;

public class HttpSend {
	private final static String url = "http://222.73.117.156/msg/";// 应用地址
	private final static String account = "whssfw";// 账号
	private final static String pswd = "Whssfw123";// 密码
	private final static boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
	private final static String product = null;// 产品ID
	private final static String extno = null;// 扩展码

	// 得到随机数
	public static String suiji() {
		Random r = new Random();
		int int1 = r.nextInt(10);
		int int2 = r.nextInt(10);
		int int3 = r.nextInt(10);
		int int4 = r.nextInt(10);
		String i = int1 + "" + int2 + "" + int3 + "" + int4;
		return i;
	}

	// 发送发送验证短信
	public static void send(String mobile, String num) {
		String msg = "【专车看房】亲爱的用户，您的验证码是" + num + "，5分钟内有效。";// 短信内容
		try {
			String returnString = HttpSender.batchSend(url, account, pswd,
					mobile, msg, needstatus, product, extno);
			// System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}

	// 标准一审核通过
	public static void sendgood(String mobile, String username, String tel,
			String adress, String date, String datetime, String project) {
		String msg = "【专车看房】"+project + "看房客户：" + username + "电话：" + tel + " 将于" + date
				+ " " + datetime + "（预约时间）乘坐房天下看房专车抵达售楼部，请提前安排接待。房天下感谢您的支持！";

		try {
			String returnString = HttpSender.batchSend(url, account, pswd,
					mobile, msg, needstatus, product, extno);
			// System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
	// 模版2审核通过
		public static void sendgood2(String mobile, String username, String tel,
				String adress, String date, String datetime, String project) {
			String msg = "【特卖场】"+project + "看房客户：" + username + "电话：" + tel +"乘坐房天下看房专车抵达售楼部，请提前安排接待。房天下感谢您的支持！";

			try {
				String returnString = HttpSender.batchSend(url, account, pswd,
						mobile, msg, needstatus, product, extno);
				// System.out.println(returnString);
				// TODO 处理返回值,参见HTTP协议文档
			} catch (Exception e) {
				// TODO 处理异常
				e.printStackTrace();
			}
		}
	// 自定义发送客服
	public static void sendgoodpants(String mobile, String username,
			String tel, String project) {
		String msg = "客户：" + username + "电话:" + tel  + "预约项目：" + project
				+ "请及时完成专车看房预约。";
		try {
			String returnString = HttpSender.batchSend(url, account, pswd,
					mobile, msg, needstatus, product, extno);
			// System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
   
	// 模版2发送客服
		public static void sendmoban(String mobile, String username,
				String tel, String project) {
			String msg = "【特卖场】客户：" + username + "电话:" + tel  + "报名项目：" + project
					+ "请及时联系特卖报名客户。";
			try {
				String returnString = HttpSender.batchSend(url, account, pswd,
						mobile, msg, needstatus, product, extno);
				// System.out.println(returnString);
				// TODO 处理返回值,参见HTTP协议文档
			} catch (Exception e) {
				// TODO 处理异常
				e.printStackTrace();
			}
		}
	// 发送客服
	public static void sendgoods(String mobile, String username, String tel,
			String date, String datetime, String adress, String project) {
		String msg = "【专车看房】客户：" + username + "电话:" + tel + "用车时间：" + date + " "
				+ datetime + "上车地点：" + adress + "预约项目：" + project
				+ "请及时完成专车看房预约。";
		try {
			String returnString = HttpSender.batchSend(url, account, pswd,
					mobile, msg, needstatus, product, extno);
			// System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}

	// 审核不通过发送短信给报名者
	public static void sendNO(String mobile, String registration_go) {
		String msg = "尊敬的房天下网友，很抱歉通知您，您预约的【" + registration_go
				+ "】专车看房服务未通过审核！详情可致电客服：02782226311";// 短信内容
		try {
			String returnString = HttpSender.batchSend(url, account, pswd,
					mobile, msg, needstatus, product, extno);
			// System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}

	// 系统错发送短信给主办方
	public static void senderr(String mobile) {
		String msg = "你的报名系统出错了！";// 短信内容
		try {
			String returnString = HttpSender.batchSend(url, account, pswd,
					mobile, msg, needstatus, product, extno);
			// System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
}
