package cn.it.backstag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.it.backstag.dao.BaseDao;
import cn.it.backstag.model.Project;
import cn.it.backstag.model.User;
import cn.it.backstag.service.ProjectService;

@Service("projectpantService")
public class ProjectPantServiceImpl implements ProjectService {
	@Resource(name = "projectDao")
	private BaseDao<Project> projectDao;
	
	@Resource(name = "userDao")
	private BaseDao<User> userDao;

	@Override
	public List<Project> findAllProject(int page, int size, String type,String ispant) {
		String hql = "from Project p  inner join fetch p.type where p.project_name like ? and p.type.type_status=1 and p.ispant=? order by p.id desc";
		List<Project> list = this.projectDao.findEntityByHQLS(hql, page, size,
				"%" + type + "%","自定义");

		return list;
	}

	@Override
	public Long getProjectCount(String type,String ispant) {
		String hql = "select count(p) from Project p inner join  p.type where p.project_name like ? and p.type.type_status=1 and p.ispant=?";
		return this.projectDao.getCount(hql, "%" + type + "%","自定义");
	}

	@Override
	public List<Project> findAllProjectDate(Integer page, Integer size,
			String datetime,String ispant) {
		String hql = "from Project p inner join fetch p.type where p.project_createtime like ?  and p.type.type_status=1 and p.ispant=? order by p.id desc";
		List<Project> list = this.projectDao.findEntityByHQLS(hql, page, size,
				"%" + datetime + "%","自定义");

		return list;
	}

	@Override
	public Object getProjectCountDate(String datetime,String ispant) {
		String hql = "select count(p) from Project p inner join  p.type where p.project_createtime like ? and p.type.type_status=1 and p.ispant=?";
		return this.projectDao.getCount(hql, "%" + datetime + "%","自定义");
	}

	@Override
	public void deleteByids(String ids) {
		String hql = "delete from Project p where p.id in (" + ids + ")";
		this.projectDao.batchEntityByHQL(hql);

	}

	@Override
	public Project findById(int id) {
		String hql="from Project p left join fetch p.type where  p.id=? ";
		
        return this.projectDao.findEntityByHQL(hql, id).get(0);	
	}

	@Override
	public void update(Project model) {
         
        this.projectDao.updateEntity(model);
	}

	@Override
	public Project sava(Project project){
		return this.projectDao.saveEntity(project);
	}

	@Override
	public void upload(String url, int id,String arg) {

		String hql="update Project set "+arg+"=? where id=?";
        this.projectDao.batchEntityByHQL(hql, url,id);		
	}

	@Override
	public void updatestauts(String ids) {
		String hql = "update  Project set project_state=? where id in ("+ids+")";
		this.projectDao.batchEntityByHQL(hql, 0);
	}

	@Override
	public void updatenum(int id) {
		
		 String hql="update Project  set project_num =project_num+1 where id=?";
		 this.projectDao.batchEntityByHQL(hql,id);
	}


   
	
	//修改所以审核员电话
	@Override
	public void updatetel(String project_kf_audit_tel) {
       String hql="update Project set project_kf_audit_tel=?";
       this.projectDao.batchEntityByHQL(hql,project_kf_audit_tel);
	}

	@Override
	public Project findByIdAndIspant(int id, String ispant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatemoban2tel(String project_kf_audit_tel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatezidingyitel(String project_kf_audit_tel) {
		// TODO Auto-generated method stub
		
	}
	
	
}
