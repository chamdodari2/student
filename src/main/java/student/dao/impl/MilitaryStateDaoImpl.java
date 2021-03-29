package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.dao.MilitaryStateDao;
import student.dbcon.JdbcConn;
import student.dto.MilitaryState;
import student.ui.exception.SqlConstraintException;

public class MilitaryStateDaoImpl implements MilitaryStateDao {
	private static MilitaryStateDaoImpl instance = new MilitaryStateDaoImpl(); // 본 클래스 객체생성, private static으로 여기서만 쓸수있게
																				// 싱글턴패턴

	public static MilitaryStateDaoImpl getInstance() { // getInstance()메소드 : null이면 객체생성해서 돌려주기?
		if (instance == null) {
			instance = new MilitaryStateDaoImpl();
		}
		return instance; // 싱글턴패턴

	}

	@Override
	public List<MilitaryState> selectMilitaryStateByAll() {
		String sql = "select militaryCode, militaryName from MilitaryState";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<MilitaryState> list = new ArrayList<>();
				do {
					list.add(getMilitaryState(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private MilitaryState getMilitaryState(ResultSet rs) throws SQLException {
		String militaryCode = rs.getString("militaryCode");
		String militaryName = rs.getString("militaryName");

		return new MilitaryState(militaryCode, militaryName);
	}

	@Override
	public MilitaryState selectMilitaryStateByNo(MilitaryState militaryState) {
		String sql = "select militaryCode, militaryName from MilitaryState where  militaryCode = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				return getMilitaryState(rs);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertMilitaryState(MilitaryState militaryState) {
		String sql = "insert into militarystate values (?,?)";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, militaryState.getMilitaryCode());
			pstmt.setString(2, militaryState.getMilitaryName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {

			throw new SqlConstraintException(e.getMessage(), e);
		}

	}

	@Override
	public int updateMilitaryState(MilitaryState militaryState) {
		String sql = "update militarystate set militaryCode  = ? , militaryName  = ? where militaryCode = ?";
		try (Connection con = JdbcConn.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, militaryState.getMilitaryCode());
			pstmt.setString(2, militaryState.getMilitaryName());
			pstmt.setString(3, militaryState.getMilitaryCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMilitaryState(MilitaryState militaryState) {
		String sql = "delete from militarystate where militaryCode = ? ";
		try(Connection con = JdbcConn.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, militaryState.getMilitaryCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
