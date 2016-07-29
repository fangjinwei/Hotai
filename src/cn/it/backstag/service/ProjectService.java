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

	// ����idɾ��һ���������¼
	public void deleteByids(String ids);

	public Project findById(int id);
	
	
	public Project findByIdAndIspant(int id,String ispant);

	public void update(Project model);
	
	
	public Project sava(Project project);

	public void upload(String url, int id,String arg);

	public void updatestauts(String ids);

	public void updatenum(int id);
	
	
        
	//�޸ı�׼�������Ա�绰
	public void updatetel(String project_kf_audit_tel);
	//�޸�ģ��2�������Ա�绰
	public void updatemoban2tel(String project_kf_audit_tel);
	//�޸��Զ����������Ա�绰
	public void updatezidingyitel(String project_kf_audit_tel);

}
