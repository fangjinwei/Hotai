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
	
	//根据id删除一条或多条记录
	public void deleteByids(String ids);

	public void save(User model);
     
	
	//短信分页+时间查询
	public List<User> findAllMessagedate(Integer page, Integer size, String datetime);
    
	//短信分页+时间查询(总数量)
	public Object getMessagedateCountDate(String datetime);
    //短信用户和电话查询+分页+默认初始化页面
	public List<User> findAllMessage(Integer page, Integer size, String string);
	//短信用户和电话查询+分页+默认初始化页面(总数量)
	public Object getMessageCount(String string);
   //短信审核用户（一条或多条）
	public void pdateMessageByids(int user_status, String ids);
  //用户上车确认
	public void gototimeByIds(int user_status,Date date, String ids);
	  //用户活动结束确认
	public void gotoendByIds(int user_status, String ids);

	//查询报名次数
	public long enrollsum(String tel);
	
	
	
	
}
