package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.dao.StudentScoreDao;
import student.dbcon.JdbcConn;
import student.dto.StudentData;
import student.dto.StudentScore;
import student.ui.exception.SqlConstraintException;

public class StudentScoreDaoImpl implements StudentScoreDao {
	private static StudentScoreDaoImpl instance = new StudentScoreDaoImpl();

	public static StudentScoreDaoImpl getInstance() {
		if (instance == null) {
			instance = new StudentScoreDaoImpl();
		}
		return instance;
	}

	@Override
	public List<StudentScore> selectStudentScoreByAll() {
		String sql = "select stdNo, subject1, subject2, subject3 from studentscore";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<StudentScore> list = new ArrayList<StudentScore>();
				do {
					list.add(getStudentScore(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private StudentScore getStudentScore(ResultSet rs) throws SQLException {
		StudentData studentData =null;
		int subject1 =rs.getInt("subject1");
		int subject2 = rs.getInt("subject2");
		int subject3 = rs.getInt("subject3");
		try {
			studentData = new StudentData(rs.getInt("stdNo"));
		}catch(SQLException e ) {}
	//	try {
		//	studentData.setStdName(rs.getString(""));
		//}
 		return new StudentScore(studentData,subject1, subject2,subject3);//////////////////////////여기 의심 트라이캐치 더 해서 같이띄우고싶은 칼럼관련 적어줘야하는거가잉가
	}

	@Override
	public StudentScore selectStudentScoreByNo(StudentScore studentScore) {
		String sql = "select stdNo, subject1, subject2, subject3 from studentscore where stdNo = ? ";
		try(Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1,studentScore.getStudentData().getStdNo());
			try(ResultSet rs= pstmt.executeQuery()){
				if (rs.next()) {
					return getStudentScore(rs);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStudentScore(StudentScore studentScore) { // 학생정보 입력하면 이 메소드 호출하게 해야하지않을까?? 신입생 들어오면 점수입력안된애
																// 구분할수있어야하니까 일단 학생추가시 점수도 자동으로 추가되고 점수없음또는 ""로 초기화해주기
		String sql = "insert into studentscore values (?, ?, ? ,?)";
		
		try(Connection con = JdbcConn.getConnection(); PreparedStatement pstmt =con.prepareStatement(sql)){
			pstmt.setInt(1, studentScore.getStudentData().getStdNo());
			pstmt.setInt(2, studentScore.getStudentData().getSubject1());
			pstmt.setInt(3, studentScore.getStudentData().getSubject2());
			pstmt.setInt(4, studentScore.getStudentData().getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		
			throw new SqlConstraintException(e.getMessage(),e);
		}
		
	}

	@Override
	public int updateStudentScore(StudentScore studentScore) {
		String sql = "update studentscore  set subject1 = ?, subject2 = ?, subject3 = ? where stdNo = ?";
		
		try(Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, studentScore.getSubject1());
			pstmt.setInt(2, studentScore.getSubject2());
			pstmt.setInt(3, studentScore.getSubject3());
			pstmt.setInt(4, studentScore.getStudentData().getStdNo());
			pstmt.executeUpdate();
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudentScore(StudentScore studentScore) {
		String sql = "delete from studentscore  where stdNo = ?";
		try(Connection con =  JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, studentScore.getStudentData().getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

}
