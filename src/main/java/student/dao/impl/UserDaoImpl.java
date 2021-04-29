package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.dao.UserDao;
import student.dbcon.JdbcConn;
import student.dto.User;

public class UserDaoImpl implements UserDao {
	private static UserDaoImpl instance = new UserDaoImpl();

	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	@Override
	public User selectUserByAll(int id , String pass) {
		String sql = "select  id, pass, grants from users where id = ? and pass = password(?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, id);
			pstmt.setString(2, pass);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getUsers(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
			return null;
		}
	
	private User getUsers(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String pass = rs.getString("pass");
		boolean grants = rs.getBoolean("grants");
	
		return new User(id, pass, grants);
	}

}
