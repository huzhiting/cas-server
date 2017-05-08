package org.jasig.cas.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jasig.cas.util.ConnectionUtils;

public class QueryAllCompanyDaoImpl implements QueryAllCompanyDao {
	
	public static final String FIND_ALL_COMPANY = "select companyName from ta_registuser where isDelete=0";//查询语句

	@SuppressWarnings("rawtypes")
	public List queryAllCompany() {
		List<String> companyList=new ArrayList<String>();
		try {
			Connection conn = ConnectionUtils.getConnection();
			PreparedStatement stmt = conn.prepareStatement(FIND_ALL_COMPANY);
	        ResultSet rs = stmt.executeQuery();
	        while(rs.next()){
	        	String company=rs.getString("companyName");
	        	companyList.add(company);
	        }
	        ConnectionUtils.closeAll(stmt, rs);        
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		return companyList!=null ? companyList:Collections.emptyList();
	}

}
