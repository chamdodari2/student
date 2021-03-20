package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.dao.StudentDataDao;
import student.dbcon.JdbcConn;
import student.dto.MilitaryState;
import student.dto.StdDepartment;
import student.dto.StdState;
import student.dto.StudentData;

public class StudentDataDaoImpl implements StudentDataDao {  //StudentDataDao 인터페이스 상속(오버라이딩)
	
private static StudentDataDaoImpl instance = new StudentDataDaoImpl();  //본 클래스 객체생성, private static으로 여기서만 쓸수있게 싱글턴패턴

public static StudentDataDaoImpl getInstance() {	//getInstance()메소드 :  null이면 객체생성해서 돌려주기?
	if (instance == null) {
		instance = new  StudentDataDaoImpl();
	}
	return instance;      //싱글턴패턴

}


	@Override
	public List<StudentData> selectStudentDataByAll() { 			// 학생정보 테이블의 모든것 검색메소드
		String sql = "select "
				+ "stdNo,"
				+ " stdName,"
				+ " deptCode,"
				+ " deptName,"
				+ " grade,"
				+ " stateCode,"
				+ " stateName, "  //sql문
				+ " militaryCode,"
				+ " militaryName,"
				+ " idNo,"
				+ " gender,"
				+ " hpNo,"
				+ " dayNightShift,"
				+ " subject1,"
				+ " subject2,"
				+ " subject3,"
				+ " total,"
				+ " avg " 
				+ " from vw_full_studentdata";   	
		
		try (Connection con = JdbcConn.getConnection(); 					//기존 db연결용 Connection클래스를 이용해서, dbproperties 파일에 있는 url키의 벨류인 db주소 읽어서 연결  
				PreparedStatement pstmt = con.prepareStatement(sql);		//db에 연결된상태에서 sql문 던져주기1
				ResultSet rs = pstmt.executeQuery()) {						//던져주기2

			if (rs.next()) {												//출력할 있다면 -> StudentData클래스의 모든 변수들을 담을수있는 리스트를 어레이리스트로 변환
				List<StudentData> list = new ArrayList<>();
				do {
					list.add(getStudentData(rs));							//만든 리스트에 하나씩 추가하기(rs를 매개변수로 넣어서) getStudentData()메소드 호출해서, 그 메소드에서 정해준거 넣을거임

				} while (rs.next());
				return list;
			}
			//예외처리
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
/*				+ "stdNo,"  //학번
				+ " stdName,"  //이름
				+ " deptCode,"  //학과코드
				+ " deptName,"//학과명
				+ " grade,"//학년
				+ " stateCode,"//학적상태코드
				+ " stateName, "  //학적상태명
				+ " militaryCode," //병역상태코드
				+ " militaryName,"  //병역상태명
				+ " idNo,"			//주민번호
				+ " gender,"		//성별
				+ " hpNo,"			//핸드폰
				+ " dayNightShift,"	//주야구분
				+ " subject1,"     //과목1
				+ " subject2,"		//과목2
				+ " subject3,"		//과목3
				+ " total,"			//총점
				+ " avg " */		//평균
	private StudentData getStudentData(ResultSet rs)  throws SQLException {  //dto 보면서 하기
		int stdNo = rs.getInt("stdNo");			 //학번  									//각 타입의 변수에  쿼리에 있는내용중   실제  DB에 있는 칼럼명(칼럼인덱스) 적어줘야함!		
		String stdName = rs.getString("stdName");//이름	
		int grade = rs.getInt("grade");			 //학년
		String idNo =rs.getString("idNo");		//주민번호
		String hpNo = rs.getString("hpNo");     //전화번호
		String dayNightShift =rs.getString("dayNightShift"); //주야
		String gender = rs.getString("gender");
		int subject1 = rs.getInt("subject1");
		int subject2 = rs.getInt("subject2");
		int subject3 = rs.getInt("subject3");	
		int total =rs.getInt("total");
		double avg = rs.getDouble("avg");
	//	List<StudentData> studentData =  new ArrayList<StudentData>();
//		studentData	= ;
	//	StudentData studentScore = new StudentData();
	//	if(rs.next()) {
			
		//	for(int i = 0; i>=3;i++) {
		//		studentScore = studentScore.getSubject1()
		//} 
		//}
		StdDepartment stdDepartment = null;				//다른테이블에 있는 칼럼이랑 조인해서 같이 보여줘야하는 칼럼 있으면, 해당 조인할 테이블 타입으로 변수선언해주고 초기화만 시켜준다 밑에 트라이1에서 객체생성후 본테이블에 있는 칼럼명들 적어주고, 트라이2에서 조인할 테이블에 있는 칼럼명 적어준다
		StdState stdState = null;
		MilitaryState militaryState = null;
		
		try {//1
			 stdDepartment = new StdDepartment(rs.getString("deptCode"));	//여기서  본테이블에 있는 컬럼명들은 적어주고, 다른테이블에 있는애들은  밑에 한줄한줄씩 따로 해줘야하는듯(근데 뷰로 해서 크게 상관은 없는거같다. 조인할때 필요할듯)
			 stdState = new StdState(rs.getString("stateCode"));
			 militaryState = new MilitaryState(rs.getString("militaryCode")); 
			
		//존재할 경우 찍어주기. if끼리 따로 빼기
		}catch (SQLException e) {	}
			try {//2
				stdDepartment.setDeptName(rs.getString("deptName"));
				
				
				
		}catch(SQLException e) {}		
			try {
				stdState.setStateName(rs.getString("stateName"));
			}catch (SQLException e ) {}
			try {
				militaryState.setMilitaryName(rs.getString("militaryName"));//////////////////////이름 동일한지 확인하기!
			}catch(SQLException e) {}
		
		
		
		return new StudentData(stdNo, stdName, stdDepartment, grade, stdState, militaryState, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg);
	}
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
