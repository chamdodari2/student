package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.dao.StdDepartmentDao;
import student.dbcon.JdbcConn;
import student.dto.StdDepartment;
import student.ui.exception.SqlConstraintException;

public class StdDepartmentDaoImpl implements StdDepartmentDao {

	private static final StdDepartmentDaoImpl instance = new StdDepartmentDaoImpl();

	
	private StdDepartmentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static StdDepartmentDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<StdDepartment> selectStdDepartmentByAll() {
		String sql = "select deptCode, deptName from stddepartment";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<StdDepartment> list = new ArrayList<>();
				list.add(new StdDepartment()); //널 넣어주기
				do {
					list.add(getStdDepartment(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private StdDepartment getStdDepartment(ResultSet rs) throws SQLException {
		String deptCode = rs.getString("deptCode");
		String deptName = rs.getString("deptName");
		return new StdDepartment(deptCode, deptName);
	}

	@Override
	public StdDepartment selectStdDepartmentByNo(StdDepartment stdDepartment) {
		String sql = "select deptCode, deptName from stddepartment where deptCode = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, stdDepartment.getDeptCode());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getStdDepartment(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insertStdDepartment(StdDepartment stdDepartment) {
		String sql = "insert into stddepartment  values (?,?) ";
		try(Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, stdDepartment.getDeptCode());
			pstmt.setString(2, stdDepartment.getDeptName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		
			throw new SqlConstraintException(e.getMessage(), e);
		}

	
	}

	@Override
	public int updateStdDepartment(StdDepartment stdDepartment) {
		String sql = "update stddepartment set deptCode  = ?, deptName = ? where deptCode = ?";
		try(Connection con = JdbcConn.getConnection(); PreparedStatement pstmt= con.prepareStatement(sql)){
			pstmt.setString(1, stdDepartment.getDeptCode());
			pstmt.setString(2, stdDepartment.getDeptName());
			pstmt.setString(3, stdDepartment.getDeptCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStdDepartment(StdDepartment stdDepartment) {
		String sql = "delete from stddepartment where deptCode =?";
		try(Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, stdDepartment.getDeptCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
