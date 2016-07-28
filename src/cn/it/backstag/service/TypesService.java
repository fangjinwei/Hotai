package cn.it.backstag.service;

import java.util.List;

import cn.it.backstag.model.Types;

/*
 * TypeService
 */
public interface TypesService {
	public List<Types> findAllType(int page, int size, String type);

	public Long getTypeCount(String type);

	public List<Types> findAllTypeDate(Integer page, Integer size,
			String datetime);

	public Object getTypeCountDate(String datetime);

	// ����idɾ��һ���������¼
	public void deleteByids(String ids);

	public Types findById(int id);

	public void update(Types model);
	
    public Types save(Types type);
    //�������
	public void updatestauts(String ids);
    //��ѯ�������
	public List<Types> findTypeAll();
    
	//num+1
	public void updatenum(int type_id);

}
