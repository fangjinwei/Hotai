package cn.it.backstag.model;

public class Types {
	private int type_id;
	private String type_name;
	private String type_create_date;
	private int type_status=1;
	private int type_admin_id=1;// 类别所属管理员编号
	private String type_admin="admin";// 类别所属管理员
	private int type_num=0;// 类别下项目的个数
	private String type_developer="";// 类别所属开发商

	/****************************************/
	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getType_create_date() {
		return type_create_date;
	}

	public void setType_create_date(String type_create_date) {
		this.type_create_date = type_create_date;
	}

	public int getType_status() {
		return type_status;
	}

	public void setType_status(int type_status) {
		this.type_status = type_status;
	}

	public int getType_admin_id() {
		return type_admin_id;
	}

	public void setType_admin_id(int type_admin_id) {
		this.type_admin_id = type_admin_id;
	}

	public String getType_admin() {
		return type_admin;
	}

	public void setType_admin(String type_admin) {
		this.type_admin = type_admin;
	}

	public int getType_num() {
		return type_num;
	}

	public void setType_num(int type_num) {
		this.type_num = type_num;
	}

	public String getType_developer() {
		return type_developer;
	}

	public void setType_developer(String type_developer) {
		this.type_developer = type_developer;
	}

	@Override
	public String toString() {
		return "Type [type_id=" + type_id + ", type_name=" + type_name
				+ ", type_create_date=" + type_create_date + ", type_status="
				+ type_status + ", type_admin_id=" + type_admin_id
				+ ", type_admin=" + type_admin + ", type_num=" + type_num
				+ ", type_developer=" + type_developer + "]";
	}

}
