package cn.it.backstag.service;

import java.util.Date;
import java.util.List;

import cn.it.backstag.model.User;

/**
 * UserService
 */
public interface UserService {
	public List<User> findAllJoinProject(int page, int size, String type);

	public Long getUserCount(String type);

	public List<User> findAllJoinProjectDate(Integer page, Integer size,
			String datetime);

	public long getUserCountDate(String datetime);
	
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
