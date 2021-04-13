package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import student.dao.StdStateDao;
import student.dbcon.JdbcConn;
import student.dto.StdDepartment;
import student.dto.StdState;

public class StdStateDaoImpl implements StdStateDao {
	private static StdStateDaoImpl instance = new StdStateDaoImpl();

	public static StdStateDaoImpl getInstance() {
		if (instance == null) {
			instance = new StdStateDaoImpl();
		}
		return instance;
	}

	@Override
	public List<StdState> selectStdStateByAll() {
		String sql = "select stateCode, stateName from stdstate";
		
		try(Connection con = JdbcConn.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if(rs.next()) {
				List<StdState> list = new ArrayList<>();
				list.add(new StdState());
				do {
					list.add(getStdState(rs));
				}while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	private StdState getStdState(ResultSet rs) throws SQLException {
		String stateCode = rs.getString("stateCode");
		String stateName = rs.getString("stateName");
		return new StdState(stateCode, stateName);
	}

	@Override
	public StdState selectStdStateByNo(StdState stdState) {
		String sql = "select stateCode, stateName from stdstate where stateCode = ?";
		
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if (rs.next()) {
				return getStdState(rs);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStdState(StdState stdState) {
		String sql= "insert into stdstate  values  ( ? , ? )";
		try(Connection con = JdbcConn.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, stdState.getStateCode());
			pstmt.setString(2, stdState.getStateName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStdState(StdState stdState) {
		String sql="update stdstate  set stateCode = ?, stateName = ? where stateCode = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, stdState.getStateCode());
			pstmt.setString(2, stdState.getStateName());
			pstmt.setString(3, stdState.getStateCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStdState(StdState stdState) {
		String sql="delete  from stdstate  where stateCode = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, stdState.getStateCode());  ///////return
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
