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

	// 根据id删除一条或多条记录
	public void deleteByids(String ids);

	public Types findById(int id);

	public void update(Types model);
	
    public Types save(Types type);
    //冻结类别
	public void updatestauts(String ids);
    //查询所以类别
	public List<Types> findTypeAll();
    
	//num+1
	public void updatenum(int type_id);

}
