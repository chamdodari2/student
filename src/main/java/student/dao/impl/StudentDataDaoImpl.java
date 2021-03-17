package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.dao.StudentDataDao;
import student.dbcon.JdbcConn;
import student.dto.StudentData;

import student.dto.StdDepartment;

public class StudentDataDaoImpl implements StudentDataDao {
	
private static StudentDataDaoImpl instance = new StudentDataDaoImpl();  //상수 선언. StudentDataDaoImpl 객체생성.  타입의   참조변수 instance 선언

public static StudentDataDaoImpl getInstance() {	//  
	if (instance == null) {
		instance = new  StudentDataDaoImpl();
	}
	return instance;      //싱글턴패턴은 이게 다다.

}


	@Override
	public List<StudentData> selectStudentDataByAll() {
		String sql = "select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, "
				+ " militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg " 
				+ " from vw_full_studentdata";   // " from vw_full_StudentData";
		// Connection 타입의 참조변수 con 선언,  
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				List<StudentData> list = new ArrayList<>();
				do {
					list.add(getStudentData(rs));

				} while (rs.next());
				return list;
			}
			//예외처리
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////왜 인식을 못하까
	private StudentData getStudentData(ResultSet rs)  throws SQLException {
		int stdNo = rs.getInt("stdNo");
		String stdName = rs.getString("stdName");	
		StdDepartment deptCode = null;											//다른테이블 타입으로 변수선언한거는, 여기서 선언과 초기화만 시켜주고, 밑에 트라이에서 객체생성해서 넣어준다.
		//= rs.geString("deptCode");
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		try {
		title = new Title(rs.getInt("title_no"));
		manager = new Employee(rs.getInt("manager_no"));
		salary = rs.getInt("salary");		
		 dept = new Department(rs.getInt("deptno"));
		//존재할 경우 찍어주기. if끼리 따로 빼기
		}catch (SQLException e) {	}
			try {
			title.settName(rs.getNString("title_name"));
		}catch(SQLException e) {}		
			try {
				manager.setEmpName(rs.getNString("manager_name"));
			}catch (SQLException e ) {}
			try {
				dept.setDeptName(rs.getString("deptname"));//////////////////////이름 동일한지 확인하기!
			}catch(SQLException e) {}
			try {
				 dept.setFloor(rs.getInt("floor"));
			} catch(SQLException e ) {}
			
			
		
		return new Employee(empno, empname, title, manager, salary, dept);

	@Override
	public StudentData selectStudentDataByNo(StudentData student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudentData(StudentData student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentData(StudentData student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudentData(StudentData student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
