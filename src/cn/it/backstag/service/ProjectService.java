package cn.it.backstag.service;

import java.util.List;

import cn.it.backstag.model.Project;

/*
 * ProjectService
 */
public interface ProjectService {
	public List<Project> findAllProject(int page, int size, String type,String ispant);

	public Long getProjectCount(String type,String ispant);

	public List<Project> findAllProjectDate(Integer page, Integer size,
			String datetime,String ispant);

	public Object getProjectCountDate(String datetime,String ispant);

	// 根据id删除一条或多条记录
	public void deleteByids(String ids);

	public Project findById(int id);
	
	
	public Project findByIdAndIspant(int id,String ispant);

	public void update(Project model);
	
	
	public Project sava(Project project);

	public void upload(String url, int id,String arg);

	public void updatestauts(String ids);

	public void updatenum(int id);
	
	
        
	//修改标准所以审核员电话
	public void updatetel(String project_kf_audit_tel);
	//修改模版2所以审核员电话
	public void updatemoban2tel(String project_kf_audit_tel);
	//修改自定义所以审核员电话
	public void updatezidingyitel(String project_kf_audit_tel);

}
