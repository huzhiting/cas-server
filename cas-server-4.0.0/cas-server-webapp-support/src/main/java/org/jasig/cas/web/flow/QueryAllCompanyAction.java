package org.jasig.cas.web.flow;

import java.util.ArrayList;
import java.util.List;


import javax.validation.constraints.NotNull;

import org.jasig.cas.services.QueryAllCompanyService;
import org.jasig.cas.util.Items;
import org.jasig.cas.util.JSONUtil;
import org.springframework.webflow.execution.RequestContext;

/**
 * 查询所有学校Action层
 * @author hzt
 * @Date 2017年3月7日
 * 
 */
public class QueryAllCompanyAction {

	/** Instance of QueryAllCompanyService. */
    @NotNull
    private QueryAllCompanyService queryAllCompanyService;
    
 
    public QueryAllCompanyService getQueryAllCompanyService() {
		return queryAllCompanyService;
	}


	public void setQueryAllCompanyService(
			QueryAllCompanyService queryAllCompanyService) {
		this.queryAllCompanyService = queryAllCompanyService;
	}

	public String queryAllCompany(RequestContext context){
//		List companyList=this.queryAllCompanyService.queryAllCompany();
//		JSONUtil jsonutil=new JSONUtil();
//		if(companyList!=null && !companyList.isEmpty()){	
//			return jsonutil.toJSONString(companyList);
//		}else{
//			return "";
//		}	
		//调用service查找 数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		//向list中填充静态数据

		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		
		context.getFlashScope().put("itemsList", itemsList);
		return "success";
    }
	
}
