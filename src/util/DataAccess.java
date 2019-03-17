package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;





public  class DataAccess {
	private static  String driver = "com.mysql.jdbc.Driver";
	private static  String url = "jdbc:mysql://127.0.0.1:3306/test";
	private static  String user = "root";
	private static  String pwd = "scgy1999";
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			 Statement stmt = con.createStatement();  
		        ResultSet rs=stmt.executeQuery("select account from user");  
		        while(rs.next()){  
		            System.out.print(rs.getString("account"));  
		        }  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public  void closeConnection(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
				rs=null;
			}
			if(ps!=null) {
				ps.close();
				ps=null;
			}
			if(conn!=null) {
				conn.close();
				conn=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

