package cn.it.backstag.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import cn.it.backstag.dao.BaseDao;

/*
 * �����daoʵ�֣�ר�������̳�
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource(name="sessionFactory")
	private SessionFactory sf;

	private Class<T> clazz;

	public BaseDaoImpl() { 
		// �õ����ͻ�����
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	public T saveEntity(T t) {
		sf.getCurrentSession().save(t);
		return t;
	}

	public void saveOrUpdateEntity(T t) {
		sf.getCurrentSession().saveOrUpdate(t);
	}

	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
	}

	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);
	}

	/**
	 * ����HQL��������������
	 */
	public void batchEntityByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}

	public T loadEntity(Integer id) {
		return (T) sf.getCurrentSession().load(clazz, id);
	}

	public T getEntity(Integer id) {
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

	// ��ҳ����
	public List<T> findEntityByHQLS(String hql, int page, int size,
			Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);

		}
		q.setFirstResult((page - 1) * size);
		q.setMaxResults(size);
		return q.list();
	}
	// ��ü�¼��
		public Long getCount(String hql, Object... objects) {
			Query q = sf.getCurrentSession().createQuery(hql);
			for (int i = 0; i < objects.length; i++) {
				q.setParameter(i, objects[i]);
			}
			return (Long) q.uniqueResult();
		}
		
		
		//ԭʼsql
		public int batchBySql(String sql, Object... objects){
			SQLQuery createSQLQuery = sf.getCurrentSession().createSQLQuery(sql);
			for (int i = 0; i <objects.length ; i++) {
				createSQLQuery.setParameter(i, objects[i]);
			}
			return createSQLQuery.executeUpdate();
		}
}
