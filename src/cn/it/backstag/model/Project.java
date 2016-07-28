package cn.it.backstag.model;

public class Project {
	private int id;
	private String project_name;// 项目活动名
	private String project_createtime;;// 项目创建时间
	private String project_pic;// 项目图片封面
	private String project_stauts_pic;// 项目审核状态图片
	private String project_weixin_pic;// 项目微信图片
	private String project_kf_audit_tel;// 后台客服电话
	private String project_jd_audit_tel;// 接待员电话
	private String project_address;// 售楼地址
	private String project_notice;// 看房须知文本内容
	private String project_notice_pic;// 看房须知图片
	private String project_text;// 报名成功提示文本
	private String project_text_pic;// 报名成功提示图片
	private int project_state = 1;// 项目状态
	private String project_web;// 项目生成网站
	private int project_num = 0;// 项目报名人数,创建默认为0
	private String ispant = "标准";//
	private String pant;//
	private String roottype;// 房型
	private String mianji;// 面积
	private String quyu;// 区域
	private String taunchtime;// 交房时间
	private String consultant1;// 咨询人1
	private String consultantQQ1;// 咨询人1QQ
	private String consultant2;// 咨询人2
	private String consultantQQ2;// 咨询人2QQ
	private String preferential1;// 特惠1
	private String preferential2;// 特惠2
	private String consultanttel;// 咨询电话

	private Types type;// 建立从Project到Type之间的多对一关联关系

	// 建立从Project到User之间的一对多关联关系
	// private Set<User> users = new HashSet<>();
	/****************** set*************get ****************************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_createtime() {
		return project_createtime;
	}

	public void setProject_createtime(String project_createtime) {
		this.project_createtime = project_createtime;
	}

	public String getProject_pic() {
		return project_pic;
	}

	public void setProject_pic(String project_pic) {
		this.project_pic = project_pic;
	}

	public String getProject_stauts_pic() {
		return project_stauts_pic;
	}

	public void setProject_stauts_pic(String project_stauts_pic) {
		this.project_stauts_pic = project_stauts_pic;
	}

	public String getProject_weixin_pic() {
		return project_weixin_pic;
	}

	public void setProject_weixin_pic(String project_weixin_pic) {
		this.project_weixin_pic = project_weixin_pic;
	}

	public String getProject_kf_audit_tel() {
		return project_kf_audit_tel;
	}

	public void setProject_kf_audit_tel(String project_kf_audit_tel) {
		this.project_kf_audit_tel = project_kf_audit_tel;
	}

	public String getProject_jd_audit_tel() {
		return project_jd_audit_tel;
	}

	public void setProject_jd_audit_tel(String project_jd_audit_tel) {
		this.project_jd_audit_tel = project_jd_audit_tel;
	}

	public String getProject_address() {
		return project_address;
	}

	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}

	public String getProject_text() {
		return project_text;
	}

	public void setProject_text(String project_text) {
		this.project_text = project_text;
	}

	public String getProject_notice() {
		return project_notice;
	}

	public void setProject_notice(String project_notice) {
		this.project_notice = project_notice;
	}

	public String getProject_notice_pic() {
		return project_notice_pic;
	}

	public void setProject_notice_pic(String project_notice_pic) {
		this.project_notice_pic = project_notice_pic;
	}

	public String getProject_text_pic() {
		return project_text_pic;
	}

	public void setProject_text_pic(String project_text_pic) {
		this.project_text_pic = project_text_pic;
	}

	public int getProject_state() {
		return project_state;
	}

	public void setProject_state(int project_state) {
		this.project_state = project_state;
	}

	public String getProject_web() {
		return project_web;
	}

	public void setProject_web(String project_web) {
		this.project_web = project_web;
	}

	public int getProject_num() {
		return project_num;
	}

	public void setProject_num(int project_num) {
		this.project_num = project_num;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public String getIspant() {
		return ispant;
	}

	public void setIspant(String ispant) {
		this.ispant = ispant;
	}

	public String getPant() {
		return pant;
	}

	public void setPant(String pant) {
		this.pant = pant;
	}

	public String getRoottype() {
		return roottype;
	}

	public void setRoottype(String roottype) {
		this.roottype = roottype;
	}

	public String getMianji() {
		return mianji;
	}

	public void setMianji(String mianji) {
		this.mianji = mianji;
	}

	public String getQuyu() {
		return quyu;
	}

	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}

	public String getTaunchtime() {
		return taunchtime;
	}

	public void setTaunchtime(String taunchtime) {
		this.taunchtime = taunchtime;
	}

	public String getConsultant1() {
		return consultant1;
	}

	public void setConsultant1(String consultant1) {
		this.consultant1 = consultant1;
	}

	public String getConsultantQQ1() {
		return consultantQQ1;
	}

	public void setConsultantQQ1(String consultantQQ1) {
		this.consultantQQ1 = consultantQQ1;
	}

	public String getConsultant2() {
		return consultant2;
	}

	public void setConsultant2(String consultant2) {
		this.consultant2 = consultant2;
	}

	public String getConsultantQQ2() {
		return consultantQQ2;
	}

	public void setConsultantQQ2(String consultantQQ2) {
		this.consultantQQ2 = consultantQQ2;
	}

	public String getPreferential1() {
		return preferential1;
	}

	public void setPreferential1(String preferential1) {
		this.preferential1 = preferential1;
	}

	public String getPreferential2() {
		return preferential2;
	}

	public void setPreferential2(String preferential2) {
		this.preferential2 = preferential2;
	}

	public String getConsultanttel() {
		return consultanttel;
	}

	public void setConsultanttel(String consultanttel) {
		this.consultanttel = consultanttel;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", project_name=" + project_name
				+ ", project_createtime=" + project_createtime
				+ ", project_pic=" + project_pic + ", project_stauts_pic="
				+ project_stauts_pic + ", project_weixin_pic="
				+ project_weixin_pic + ", project_kf_audit_tel="
				+ project_kf_audit_tel + ", project_jd_audit_tel="
				+ project_jd_audit_tel + ", project_address=" + project_address
				+ ", project_notice=" + project_notice
				+ ", project_notice_pic=" + project_notice_pic
				+ ", project_text=" + project_text + ", project_text_pic="
				+ project_text_pic + ", project_state=" + project_state
				+ ", project_web=" + project_web + "]";
	}

}
