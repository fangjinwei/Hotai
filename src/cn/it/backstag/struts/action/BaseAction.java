package cn.it.backstag.struts.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T>, Preparable, SessionAware {

	private static final long serialVersionUID = 1L;

	public T model;// 用SessionAware可以用通过的Map对象来注入session
	protected Map mySession;
	protected Map<String, Object> pageMap;// 用来装分页信息
	protected Integer page = 1;
	protected Integer size = 10;
	protected InputStream inputStream;
	protected String nametype = "";
	protected String datetime = null;

	protected String ids;// 获取要删除的id
	protected int status;// 操作状态

	public void prepare() throws Exception {
	}

	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*************************************/
	public void setSession(Map session) {
		this.mySession = session;
	}

	public T getModel() {
		return model;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getNametype() {
		return nametype;
	}

	public void setNametype(String nametype) {
		this.nametype = nametype;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
