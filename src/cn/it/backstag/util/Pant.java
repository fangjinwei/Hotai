package cn.it.backstag.util;

public class Pant {
	
	
	public static String getpant(){
		
		StringBuffer str=new StringBuffer();
		   str.append("������<input type=\"text\" id=\"username\" name=\"username\"/>");
		   str.append("�绰��<input type=\"text\" id=\"tel\" name=\"tel\"/>");
		   str.append("<input type=\"subimt\" value=\"�ύ\" onclick=\"check()\"/>");		
		return str.toString();
	}

}
