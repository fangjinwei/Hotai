package cn.it.backstag.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.it.backstag.dao.BaseDao;
import cn.it.backstag.model.User;
import cn.it.backstag.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    static	Logger log=Logger.getLogger(UserServiceImpl.class);
	@Resource(name = "userDao")
	private BaseDao<User> userDao;

	public List<User> findAllJoinProject(int page, int size, String type) {
		String hql = "from User u inner join fetch u.project p inner join fetch p.type where u.username like ? and u.project.project_state=1 or u.tel like ? order by u.id desc";
		List<User> list = this.userDao.findEntityByHQLS(hql, page, size, "%"
				+ type + "%", "%" + type + "%");
       if(!list.isEmpty()){
    	   for (User user : list) {
			user.setSum(enrollsum(user.getTel()));
		}
       }
		
		return list;
	}

	public Long getUserCount(String type) {
		String hql = "select count(u) from User u inner join  u.project p inner join  p.type where u.username like ? and u.project.project_state=1 or u.tel like ?";
		return this.userDao.getCount(hql, "%" + type + "%", "%" + type + "%");
		
	}

	public List<User> findAllJoinProjectDate(Integer page, Integer size,
			String datetime) {
		String hql = "from User u inner join fetch u.project p inner join fetch p.type where u.registration_time like ? and u.project.project_state=1 order by u.id desc";
		List<User> list = this.userDao.findEntityByHQLS(hql, page, size, "%"
				+ datetime + "%");
		  if(!list.isEmpty()){
	    	   for (User user : list) {
				user.setSum(enrollsum(user.getTel()));
			}
	       }
		return list;
	}

	public long getUserCountDate(String datetime) {
		String hql = "select count(u) from User u inner join  u.project p inner join  p.type where u.registration_time like ? and u.project.project_state=1";
		return this.userDao.getCount(hql, "%" + datetime + "%");
		
	}

	/*
	 * 用户删除实现
	 */
	@Override
	public void deleteByids(String ids) {
		String hql = "delete from User where id in (" + ids + ")";
		userDao.batchEntityByHQL(hql);
	}

	@Override
	public void save(User model) {
		this.userDao.saveEntity(model);
	}

	/**
	 * 短信分页+时间查询
	 */
	@Override
	public List<User> findAllMessagedate(Integer page, Integer size,
			String datetime) {                                                                                           
		String hql = "from User u inner join fetch u.project p inner join fetch p.type where (u.registration_time like ?) and u.project.project_state=1 and u.user_status=0 and u.message_status=0 order by u.id desc";
		List<User> list = this.userDao.findEntityByHQLS(hql, page, size, "%"
				+ datetime + "%");
		for (User user : list) {
			log.info(user.getProject().getType());
		}
		  if(!list.isEmpty()){
	    	   for (User user : list) {
				user.setSum(enrollsum(user.getTel()));
			}
	       }
		return list;
	}

	/**
	 * 短信分页+时间查询(总数量)
	 */
	@Override
	public Object getMessagedateCountDate(String datetime) {
		String hql = "select count(*) from User u inner join  u.project p inner join  p.type where u.registration_time like ?  and u.project.project_state=1 and u.user_status=0 and u.message_status=0";
		return this.userDao.getCount(hql, "%" + datetime + "%");
	}

	/*
	 * 短信用户和电话查询+分页+默认初始化页面
	 */
	@Override
	public List<User> findAllMessage(Integer page, Integer size, String string) {
		String hql = "from User u inner join fetch u.project p inner join fetch p.type where u.username like ? or u.tel like ? and u.project.project_state=1 and u.user_status=0 and u.message_status=0  order by u.id desc";
		List<User> list = this.userDao.findEntityByHQLS(hql, page, size, "%"
				+ string + "%", "%" + string + "%");
		for (User user : list) {
			log.info(user.getProject().getType());
		}
		  if(!list.isEmpty()){
	    	   for (User user : list) {
				user.setSum(enrollsum(user.getTel()));
			}
	       }
		return list;
	}

	/*
	 * 短信用户和电话查询+分页+默认初始化页面(总数量)
	 */
	@Override
	public Long getMessageCount(String string) {
		String hql = "select count(*) from User u inner join  u.project p inner join  p.type where u.username like ? or u.tel like ? and u.project.project_state=1 and u.user_status=0 and u.message_status=0";
		return this.userDao.getCount(hql, "%" + string + "%", "%" + string
				+ "%");
	}

	@Override
	public void pdateMessageByids(int user_status, String ids) {
		String hql = "update  User set user_status =?,message_status=1 where id in ("
				+ ids + ")";
		this.userDao.batchEntityByHQL(hql, user_status);
	}

	/*
	 * 用户活动确认
	 */
	@Override
	public void gototimeByIds(int user_status, Date datetime, String ids) {
		String hql = "update User  set user_status =?,gotasi_time_z=? where id in ("
				+ ids + ")";
		this.userDao.batchEntityByHQL(hql, user_status,datetime);
	}

	@Override
	public void gotoendByIds(int user_status, String ids) {
		String hql = "update User  set user_status =? where id in ("
				+ ids + ")";
		this.userDao.batchEntityByHQL(hql, user_status);
	}


	


	@Override
	public long enrollsum(String tel) {
        String hql="select count(*) from User where tel=?";
          Long count = userDao.getCount(hql, tel);
          return count;
	}

	



}
