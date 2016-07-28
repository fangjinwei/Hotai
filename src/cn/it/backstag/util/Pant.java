package cn.it.backstag.util;

public class Pant {
	
	
	public static String getpant(){
		
		StringBuffer str=new StringBuffer();
		   str.append("姓名：<input type=\"text\" id=\"username\" name=\"username\"/>");
		   str.append("电话：<input type=\"text\" id=\"tel\" name=\"tel\"/>");
		   str.append("<input type=\"subimt\" value=\"提交\" onclick=\"check()\"/>");		
		return str.toString();
	}

}
