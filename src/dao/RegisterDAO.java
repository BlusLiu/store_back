package dao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;
import util.DataAccess;

import com.mysql.jdbc.Connection;

public class RegisterDAO {
	Connection con=(Connection) DataAccess.getCon();
	public Boolean Register(UserDTO user) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="Insert into user(account,password) values(?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,user.getAccount());
			ps.setString(2,user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
