package cn.it.backstag.util;

public class Pant {
	
	
	public static String getpant(){
		
		StringBuffer str=new StringBuffer();
		   str.append("姓名：<input type=\"text\" id=\"username\" name=\"username\"/>");
		   str.append("电话：<input type=\"text\" id=\"tel\" name=\"tel\"/>");
		   str.append("<input type=\"subimt\" value=\"提交\" onclick=\"check()\"/>");		
		return str.toString();
	}

	
	public static String getfenlei(String ispant){
		if(ispant.equals("1")){
			return "标准2";
		}else if(ispant.equals("2")){
			return "标准3";
		}
		else if(ispant.equals("3")){
			return "标准4";
		}else if(ispant.equals("4")){
			return "自定义";
		}else if(ispant.equals("标准")){
			return "标准";
		}
		 else{
			return "";
		}
	}
}
