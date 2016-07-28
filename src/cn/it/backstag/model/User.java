package cn.it.backstag.model;

import java.util.Date;

/**
 * @author �����
 * 
 */
public class User {
	private Long id;
	private String username;// �����û�����
	private String tel;// �����û��ֻ��绰
	private String gotasi_time_x;// �ϳ�ʱ����ϸʱ��
	private Date gotasi_time_z;// �û������ϳ�ʱ����ϸʱ��
	private String gotasi_adress;// �û��˳��ص�
	private String registration_time;// �û�����ʱ��
	private String registration_go;// �������Դ����Ŀ��
	private int message_status;// ����״̬
	private int user_status;// �û�״̬
	private long sum = 1;// �û���������
	// ������User��Project֮��Ķ��һ������ϵ
	private Project project;

	/********************* set************get ***********************************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGotasi_time_x() {
		return gotasi_time_x;
	}

	public void setGotasi_time_x(String gotasi_time_x) {
		this.gotasi_time_x = gotasi_time_x;
	}

	public Date getGotasi_time_z() {
		return gotasi_time_z;
	}

	public void setGotasi_time_z(Date gotasi_time_z) {
		this.gotasi_time_z = gotasi_time_z;
	}

	public String getGotasi_adress() {
		return gotasi_adress;
	}

	public void setGotasi_adress(String gotasi_adress) {
		this.gotasi_adress = gotasi_adress;
	}

	public String getRegistration_time() {
		return registration_time;
	}

	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}

	public String getRegistration_go() {
		return registration_go;
	}

	public void setRegistration_go(String registration_go) {
		this.registration_go = registration_go;
	}

	public int getMessage_status() {
		return message_status;
	}

	public void setMessage_status(int message_status) {
		this.message_status = message_status;
	}

	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", tel=" + tel
				+ ", gotasi_time_x=" + gotasi_time_x + ", gotasi_time_z="
				+ gotasi_time_z + ", gotasi_adress=" + gotasi_adress
				+ ", registration_time=" + registration_time
				+ ", registration_go=" + registration_go + ", message_status="
				+ message_status + ", user_status=" + user_status
				+ ", project=" + project + "]";
	}

}
