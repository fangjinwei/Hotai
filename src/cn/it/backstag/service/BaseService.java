package cn.it.backstag.service;

import java.util.List;

/*
 * ������BaseService�ӿ�
 */
public interface BaseService<T> {
	// д����
	public void saveEntity(T t);

	public void saveOrUpdateEntity(T t);

	public void updateEntity(T t);

	public void deleteEntity(T t);

	public void batchEntityByHQL(String hql, Object... objects);

	// ��ҳ����
	public List<T> findEntityByHQLS(String hql, int page, int size,
			Object... objects);
	// ��ü�¼��
		public Long getCount(String hql, Object... objects);

	// ������
	public T loadEntity(Integer id);

	public T getEntity(Integer id);

	public List<T> findEntityByHQL(String hql, Object... objects);
	
	

}
