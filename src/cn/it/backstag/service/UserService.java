package cn.it.backstag.service;

import java.util.Date;
import java.util.List;

import cn.it.backstag.model.User;

/**
 * UserService
 */
public interface UserService {
	public List<User> findAllJoinProject(int page, int size, String type, String type2);

	public Long getUserCount(String type, String type2);

	public List<User> findAllJoinProjectDate(Integer page, Integer size,
			String datetime, String type);

	public long getUserCountDate(String datetime, String type);
	
	
	
	public List<User> findAllJoinProject2(int page, int size, String type, String type2,String type3);

	public Long getUserCount2(String type, String type2,String type3);

	public List<User> findAllJoinProjectDate2(Integer page, Integer size,
			String datetime, String type,String type3);

	public long getUserCountDate2(String datetime, String type,String type3);
	
	//����idɾ��һ���������¼
	public void deleteByids(String ids);

	public void save(User model);
     
	
	//���ŷ�ҳ+ʱ���ѯ
	public List<User> findAllMessagedate(Integer page, Integer size, String datetime);
    
	//���ŷ�ҳ+ʱ���ѯ(������)
	public Object getMessagedateCountDate(String datetime);
    //�����û��͵绰��ѯ+��ҳ+Ĭ�ϳ�ʼ��ҳ��
	public List<User> findAllMessage(Integer page, Integer size, String string);
	//�����û��͵绰��ѯ+��ҳ+Ĭ�ϳ�ʼ��ҳ��(������)
	public Object getMessageCount(String string);
   //��������û���һ���������
	public void pdateMessageByids(int user_status, String ids);
  //�û��ϳ�ȷ��
	public void gototimeByIds(int user_status,Date date, String ids);
	  //�û������ȷ��
	public void gotoendByIds(int user_status, String ids);

	//��ѯ��������
	public long enrollsum(String tel);
	
	
	
	
}
