package cn.it.backstag.util;

public class Pant {
	
	
	public static String getpant(){
		
		StringBuffer str=new StringBuffer();
		   str.append("������<input type=\"text\" id=\"username\" name=\"username\"/>");
		   str.append("�绰��<input type=\"text\" id=\"tel\" name=\"tel\"/>");
		   str.append("<input type=\"subimt\" value=\"�ύ\" onclick=\"check()\"/>");		
		return str.toString();
	}

	
	public static String getfenlei(String ispant){
		if(ispant.equals("1")){
			return "��׼2";
		}else if(ispant.equals("2")){
			return "��׼3";
		}
		else if(ispant.equals("3")){
			return "��׼4";
		}else if(ispant.equals("4")){
			return "�Զ���";
		}else if(ispant.equals("��׼")){
			return "��׼";
		}
		 else{
			return "";
		}
	}
}
