package cn.it.backstag.dao;

import java.util.List;

/*
 * BaseDao接口
 */
public interface BaseDao<T> {
	// 写操作
	public T saveEntity(T t);

	public void saveOrUpdateEntity(T t);

	public void updateEntity(T t);

	public void deleteEntity(T t);

	public void batchEntityByHQL(String hql, Object... objects);

	// 分页显现
	public List<T> findEntityByHQLS(String hql, int page, int size,
			Object... objects);
	// 获得记录数
		public Long getCount(String hql, Object... objects);

	// 读操作
	public T loadEntity(Integer id);

	public T getEntity(Integer id);

	public List<T> findEntityByHQL(String hql, Object... objects);

	//原始sql
	public int batchBySql(String sql, Object... objects);
}
