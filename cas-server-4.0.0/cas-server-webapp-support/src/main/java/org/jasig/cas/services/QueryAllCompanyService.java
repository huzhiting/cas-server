package org.jasig.cas.services;


import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * 查询所有学校名称Service层
 * @author hzt
 * @Date 2017年3月7日
 *
 */
public class QueryAllCompanyService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -876319883108068825L;

	@NotNull
    private QueryAllCompanyDao queryAllCompanyDao;
	
	public QueryAllCompanyDao getQueryAllCompanyDao() {
		return queryAllCompanyDao;
	}


	public void setQueryAllCompanyDao(QueryAllCompanyDao queryAllCompanyDao) {
		this.queryAllCompanyDao = queryAllCompanyDao;
	}


	@SuppressWarnings("rawtypes")
	public List queryAllCompany() {	
		return this.queryAllCompanyDao.queryAllCompany();
	}
}
