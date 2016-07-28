package cn.it.backstag.struts.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.backstag.model.Types;
import cn.it.backstag.service.TypesService;
import cn.it.backstag.util.Createdatetime;
import cn.it.backstag.util.Pant;

@Controller
@Scope("prototype")
public class TypeAction extends BaseAction<Types> {
	@Resource
	private TypesService TypeService;

	List<Types> typelist;
     
	/*
	 * 分页join查询Type+时间查询+用户和电话查询
	 */
	public String query() {

		pageMap = new HashMap<>();

		/*
		 * 时间查询+分页
		 */
		if (datetime != null && !"".equals(datetime)) {
			List<Types> list = TypeService.findAllTypeDate(page, size,
					datetime);
			pageMap.put("rows", list);
			pageMap.put("total", TypeService.getTypeCountDate(datetime));
			return "jsonMap";
		}

		/*
		 * 用户和电话查询+分页+默认初始化页面
		 */

		List<Types> list = TypeService.findAllType(page, size, "%"
				+ nametype.trim() + "%");
		pageMap.put("rows", list);
		pageMap.put("total", TypeService
				.getTypeCount(nametype == null ? nametype = "" : nametype.trim()));

		return "jsonMap";

	}

	/**
	 * 删除用户（一条或多条）
	 * 
	 * @return 流
	 */
	public String deleteTypesByIds() {

		TypeService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	/*
	 * 去修改页面，通过id
	 */
	public String toudpate() {
		model = TypeService.findById(model.getType_id());
		return "jsonType";
	}

	/**
	 * 修改
	 */
	public String update() {
		TypeService.update(model);
		return "jsonType";
	}

	public String sava() {
		model.setType_create_date(Createdatetime.getdatetime());
		model = TypeService.save(model);
		return "jsonType";
	}

	

	
	public String delete(){
		TypeService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public String updatestauts(){
		TypeService.updatestauts(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	
	public String findAll(){
		pageMap = new HashMap<>();
		 typelist = TypeService.findTypeAll();
		 pageMap.put("types", typelist);
		 pageMap.put("pant", Pant.getpant());
		return "jsonMap";
	}



	/******************************************************************/
	public List<Types> getTypelist() {
		return typelist;
	}

	public void setTypelist(List<Types> typelist) {
		this.typelist = typelist;
	}

}
