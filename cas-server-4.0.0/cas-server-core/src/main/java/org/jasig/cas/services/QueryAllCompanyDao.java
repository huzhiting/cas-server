package org.jasig.cas.services;

import java.util.List;

/**
 * 查询所有学校Dao层
 * @author hzt
 * @Date   2017年3月7日
 *
 */
public interface QueryAllCompanyDao {
	
	/**
	 * 查询所有学校名称
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List queryAllCompany();

}
