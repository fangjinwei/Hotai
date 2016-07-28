package cn.it.backstag.interceptor;

import cn.it.backstag.struts.action.BaseAction;
import cn.it.backstag.struts.action.LoginAction;
import cn.it.backstag.struts.action.QianTaiUserAction;
import cn.it.backstag.struts.action.QianTaiUserPantAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation ac) throws Exception {
		BaseAction baseAction = (BaseAction) ac.getAction();
		 if(baseAction instanceof LoginAction ||baseAction instanceof QianTaiUserAction ||baseAction instanceof QianTaiUserPantAction){
			 return ac.invoke();
		 }else{
			String str= (String) ac.getInvocationContext().getSession().get("u");
			  if(str==null){
				  return "gotodlogin";
			  }else{
				   
				  return ac.invoke();
			  }
		 }
	}

}
