package org.jasig.cas.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtils {

	// 线程单例
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
//    private static String url;
//    private static String driver;
//    private static String username;
//    private static String password;
    public static final String driver="com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/itoo_cloudroot";  
    public static final String username = "root";  
    public static final String password = "111111"; 
    
    static {
//        Properties props = new Properties();
//        if (props != null) {
//            url = props.getProperty("url");
//            driver = props.getProperty("driver");
//            username = props.getProperty("username");
//            password = props.getProperty("password");
//      
//        }
    	// 装载并注册数据库驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = DriverManager.getConnection(url, username, password);
            tl.set(con);
        }
        return con;
    }

    public static void closeConnection() {
        Connection con = tl.get();
        try {
            if (con != null) {
                con.close();
                tl.set(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeAll(Statement stmt, ResultSet rs){
        closeConnection();
        closeStatement(stmt);
        closeResultSet(rs);
    }
    
}
