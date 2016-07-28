package cn.it.backstag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.it.backstag.dao.BaseDao;
import cn.it.backstag.model.Project;
import cn.it.backstag.model.Types;
import cn.it.backstag.model.User;
import cn.it.backstag.service.TypesService;

@Service("typeService")
public class TypesServiceImpl implements TypesService {
	@Resource(name = "projectDao")
	private BaseDao<Project> projectDao;

	@Resource(name = "typeDao")
	private BaseDao<Types> typeDao;

	@Override
	public List<Types> findAllType(int page, int size, String type) {
		String hql = "from Types  where type_name like ?  order by id desc";
		List<Types> list = this.typeDao.findEntityByHQLS(hql, page, size, "%"
				+ type + "%");

		return list;
	}

	@Override
	public Long getTypeCount(String type) {
		String hql = "select count(t) from Types t where t.type_name like ?";
		return this.typeDao.getCount(hql, "%" + type + "%");
	}

	@Override
	public List<Types> findAllTypeDate(Integer page, Integer size,
			String datetime) {
		String hql = "from Types t where t.type_create_date like ?  order by t.id desc";
		List<Types> list = this.typeDao.findEntityByHQLS(hql, page, size, "%"
				+ datetime + "%");

		return list;
	}

	@Override
	public Object getTypeCountDate(String datetime) {
		String hql = "select count(t) from Types t where t.type_create_date like ? ";
		return this.typeDao.getCount(hql, "%" + datetime + "%");
	}

	@Override
	public void deleteByids(String ids) {
		String hql = "delete from Types t where t.id in (" + ids + ")";
		this.typeDao.batchEntityByHQL(hql);

	}

	@Override
	public Types findById(int id) {
		return this.typeDao.getEntity(id);
	}

	@Override
	public void update(Types model) {

		this.typeDao.updateEntity(model);
	}

	@Override
	public Types save(Types type) {
		return this.typeDao.saveEntity(type);
	}

	@Override
	public void updatestauts(String ids) {
		String hql = "update Types set type_status=0  where t.id in (" + ids
				+ ")";
	}

	@Override
	public List<Types> findTypeAll() {
		String hql = "from Types  where type_status=1 order by id desc";
		List<Types> list = this.typeDao.findEntityByHQL(hql);

		return list;
	}

	@Override
	public void updatenum(int type_id) {
              String hql="update Types set type_num=type_num+1 where id=?";
             this.typeDao.batchEntityByHQL(hql,type_id); 		  
	}

}
