package org.jasig.cas.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.jasig.cas.services.QueryAllCompanyService;
import org.jasig.cas.util.JSONUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;



/**
 * 查询所有学校Controller层
 * @author 胡志婷
 * @Date 2017年3月7日
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class QueryAllCompanyController extends AbstractController{

	@NotNull
    private QueryAllCompanyService queryAllCompanyService;
	
	public QueryAllCompanyService getQueryAllCompanyService() {
		return queryAllCompanyService;
	}

	public void setQueryAllCompanyService(
			QueryAllCompanyService queryAllCompanyService) {
		this.queryAllCompanyService = queryAllCompanyService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        Map<String,Object> attributes = new HashMap<String,Object>();
		List list=queryAllCompanyService.queryAllCompany();
		List companyList;
		companyList=list.subList(0, 10);
        attributes.put("status", Boolean.TRUE);
        attributes.put("reason", "操作成功");
        attributes.put("dataList", companyList);
        view.setAttributesMap(attributes);
        mav.setView(view);
        return mav;
	}

}
