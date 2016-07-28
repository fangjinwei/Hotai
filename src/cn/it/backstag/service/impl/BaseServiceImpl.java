package cn.it.backstag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import cn.it.backstag.dao.BaseDao;
import cn.it.backstag.service.BaseService;

/**
 * 抽象的baseService,专门用于继承
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	protected BaseDao<T> dao;

	// 注入dao
	@Resource
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public void saveEntity(T t) {
		dao.saveEntity(t);
	}

	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}

	public void updateEntity(T t) {
		dao.updateEntity(t);
	}

	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}

	public void batchEntityByHQL(String hql, Object... objects) {
		dao.batchEntityByHQL(hql, objects);
	}

	public T loadEntity(Integer id) {
		return dao.loadEntity(id);
	}

	public T getEntity(Integer id) {
		return dao.getEntity(id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		return dao.findEntityByHQL(hql, objects);
	}

	public List<T> findEntityByHQLS(String hql, int page, int size,
			Object... objects) {
		return dao.findEntityByHQLS(hql, page, size, objects);
	}

	// 获得记录数
	public Long getCount(String hql, Object... objects) {
		 
		
		return  dao.getCount(hql, objects);
	}
}
