package cn.it.backstag.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Createdatetime {
	 static SimpleDateFormat sdf=null; 
	 static{
	 sdf = new SimpleDateFormat("yyyy-MM-dd HH:hh:ss");
	}
	public static String getdatetime() {
		
		return sdf.format(new Date());
	}
}
