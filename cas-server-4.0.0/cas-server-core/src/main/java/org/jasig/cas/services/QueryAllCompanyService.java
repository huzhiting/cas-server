package org.jasig.cas.services;

import java.io.Serializable;
import java.util.List;

/**
 * 查询所有学校名称Service层
 * @author hzt
 * @Date 2017年3月7日
 *
 */
public interface QueryAllCompanyService extends Cloneable, Serializable{
	
	@SuppressWarnings("rawtypes")
	List queryAllCompany();

}
