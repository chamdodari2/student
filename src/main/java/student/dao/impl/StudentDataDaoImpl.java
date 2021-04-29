package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import student.dao.StudentDataDao;
import student.dbcon.JdbcConn;
import student.dto.MilitaryState;
import student.dto.StdDepartment;
import student.dto.StdState;
import student.dto.StudentData;
import student.dto.StudentScore;
import student.ui.exception.SqlConstraintException;

public class StudentDataDaoImpl implements StudentDataDao { // StudentDataDao 인터페이스 상속(오버라이딩)

	private static StudentDataDaoImpl instance = new StudentDataDaoImpl(); // 본 클래스 객체생성, private static으로 여기서만 쓸수있게
																			// 싱글턴패턴

	public static StudentDataDaoImpl getInstance() { // getInstance()메소드 : null이면 객체생성해서 돌려주기?
		if (instance == null) {
			instance = new StudentDataDaoImpl();
		}
		return instance; // 싱글턴패턴

	}

	@Override
	public List<StudentData> selectStudentDataByAll() { // 학생정보 테이블의 모든것 검색메소드
		String sql = "select " + "stdNo," + " stdName," + " deptCode," + " deptName," + " grade," + " stateCode,"
				+ " stateName, " // sql문
				+ " militaryCode," + " militaryName," + " idNo," + " gender," + " hpNo," + " dayNightShift,"
				+ " subject1," + " subject2," + " subject3," + " total," + " avg, " + "pic " + " from vw_full_studentdata order by deptName  ";  //학과 내림차순 정렬

		try (Connection con = JdbcConn.getConnection(); // 기존 db연결용 Connection클래스를 이용해서, dbproperties 파일에 있는 url키의 벨류인
														// db주소 읽어서 연결
				PreparedStatement pstmt = con.prepareStatement(sql); // db에 연결된상태에서 sql문 던져주기1
				ResultSet rs = pstmt.executeQuery()) { // 던져주기2

			if (rs.next()) { // 출력할 있다면 -> StudentData클래스의 모든 변수들을 담을수있는 리스트를 어레이리스트로 변환
				List<StudentData> list = new ArrayList<>();
				do {
					list.add(getStudentData(rs)); // 만든 리스트에 하나씩 추가하기(rs를 매개변수로 넣어서) getStudentData()메소드 호출해서, 그 메소드에서
													// 정해준거 넣을거임

				} while (rs.next());
				return list;
			}
			// 예외처리
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private StudentData getStudentData(ResultSet rs) throws SQLException { // dto 보면서 하기
		int stdNo = rs.getInt("stdNo"); // 학번 //각 타입의 변수에 쿼리에 있는내용중 실제 DB에 있는 칼럼명(칼럼인덱스) 적어줘야함!
		String stdName = rs.getString("stdName");// 이름
		int grade = rs.getInt("grade"); // 학년
		String idNo = rs.getString("idNo"); // 주민번호
		String hpNo = rs.getString("hpNo"); // 전화번호
		String dayNightShift = rs.getString("dayNightShift"); // 주야
		String gender = rs.getString("gender");
		int subject1 = rs.getInt("subject1");
		int subject2 = rs.getInt("subject2");
		int subject3 = rs.getInt("subject3");
		int total = rs.getInt("total");
		double avg = rs.getDouble("avg");
		String pic = rs.getString("pic");

		StdDepartment stdDepartment = null; // 다른테이블에 있는 칼럼이랑 조인해서 같이 보여줘야하는 칼럼 있으면, 해당 조인할 테이블 타입으로 변수선언해주고 초기화만 시켜준다
											// 밑에 트라이1에서 객체생성후 본테이블에 있는 칼럼명들 적어주고, 트라이2에서 조인할 테이블에 있는 칼럼명 적어준다
		StdState stdState = null;
		MilitaryState militaryState = null;

		try {// 1
			stdDepartment = new StdDepartment(rs.getString("deptCode")); // 여기서 본테이블에 있는 컬럼명들은 적어주고, 다른테이블에 있는애들은 밑에
																			// 한줄한줄씩 따로 해줘야하는듯(근데 뷰로 해서 크게 상관은 없는거같다.
																			// 조인할때 필요할듯)
			stdState = new StdState(rs.getString("stateCode"));
			militaryState = new MilitaryState(rs.getString("militaryCode"));

			// 존재할 경우 찍어주기. if끼리 따로 빼기
		} catch (SQLException e) {
		}
		try {// 2
			stdDepartment.setDeptName(rs.getString("deptName"));

		} catch (SQLException e) {
		}
		try {
			stdState.setStateName(rs.getString("stateName"));
		} catch (SQLException e) {
		}
		try {
			militaryState.setMilitaryName(rs.getString("militaryName"));////////////////////// 이름 동일한지 확인하기!
		} catch (SQLException e) {
		}

		return new StudentData(stdNo, stdName, stdDepartment, grade, stdState, militaryState, idNo, gender, hpNo,
				dayNightShift, subject1, subject2, subject3, total, avg, pic);
	}
	
	private StudentData getStudentData1(ResultSet rs) throws SQLException { // dto 보면서 하기
		int stdNo = rs.getInt("stdNo"); // 학번 //각 타입의 변수에 쿼리에 있는내용중 실제 DB에 있는 칼럼명(칼럼인덱스) 적어줘야함!
		String stdName = rs.getString("stdName");// 이름
		int grade = rs.getInt("grade"); // 학년
		String idNo = rs.getString("idNo"); // 주민번호
		String hpNo = rs.getString("hpNo"); // 전화번호
		String dayNightShift = rs.getString("dayNightShift"); // 주야
		String gender = rs.getString("gender");
		int subject1 = rs.getInt("subject1");
		int subject2 = rs.getInt("subject2");
		int subject3 = rs.getInt("subject3");
		int total = rs.getInt("total");
		double avg = rs.getDouble("avg");
		String pic = rs.getString("pic");
		int num = rs.getInt("num");

		StdDepartment stdDepartment = null; // 다른테이블에 있는 칼럼이랑 조인해서 같이 보여줘야하는 칼럼 있으면, 해당 조인할 테이블 타입으로 변수선언해주고 초기화만 시켜준다
											// 밑에 트라이1에서 객체생성후 본테이블에 있는 칼럼명들 적어주고, 트라이2에서 조인할 테이블에 있는 칼럼명 적어준다
		StdState stdState = null;
		MilitaryState militaryState = null;

		try {// 1
			stdDepartment = new StdDepartment(rs.getString("deptCode")); // 여기서 본테이블에 있는 컬럼명들은 적어주고, 다른테이블에 있는애들은 밑에
																			// 한줄한줄씩 따로 해줘야하는듯(근데 뷰로 해서 크게 상관은 없는거같다.
																			// 조인할때 필요할듯)
			stdState = new StdState(rs.getString("stateCode"));
			militaryState = new MilitaryState(rs.getString("militaryCode"));

			// 존재할 경우 찍어주기. if끼리 따로 빼기
		} catch (SQLException e) {
		}
		try {// 2
			stdDepartment.setDeptName(rs.getString("deptName"));

		} catch (SQLException e) {
		}
		try {
			stdState.setStateName(rs.getString("stateName"));
		} catch (SQLException e) {
		}
		try {
			militaryState.setMilitaryName(rs.getString("militaryName"));////////////////////// 이름 동일한지 확인하기!
		} catch (SQLException e) {
		}

		return new StudentData(stdNo, stdName, stdDepartment, grade, stdState, militaryState, idNo, gender, hpNo,
				dayNightShift, subject1, subject2, subject3, total, avg, pic,num);
	}

	@Override
	public StudentData selectStudentDataByNo(StudentData studentData) {

		String sql = "select stdNo, " + " stdName, " + "deptCode, " + "deptName, " + "grade, " + "stateCode, "
				+ "stateName, " + "militaryCode, " + "militaryName, " + "idNo, " + "gender, " + "hpNo, "
				+ "dayNightShift, " + "subject1, " + "subject2, " + "subject3, " + "total, " + "avg, " + "pic"
				+ "from vw_full_studentdata where stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, studentData.getStdNo());
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					return getStudentData(rs);
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStudentData(StudentData studentData) {
		// stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo,
		// dayNightShift

		String sql = "insert into StudentData values " + "( ?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, studentData.getStdNo());
			pstmt.setString(2, studentData.getStdName());
			pstmt.setString(3, studentData.getStdDepartment().getDeptCode()); /////////////////////// 형변환 안해도된다!!!
			pstmt.setInt(4, studentData.getGrade());//////////////////
			pstmt.setString(5, studentData.getStdState().getStateCode());
			pstmt.setString(6, studentData.getMilitaryState().getMilitaryCode());
			pstmt.setString(7, studentData.getIdNo());
			pstmt.setString(8, studentData.getHpNo());
			pstmt.setString(9, studentData.getDayNightShift());
			pstmt.setString(10, studentData.getPic());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SqlConstraintException(e.getMessage(), e);

		}

	}

	@Override
	public int updateStudentData(StudentData studentData) {
		String sql = "update studentData set stdNo = ?, " + "stdName= ?, " + "deptCode= ?, " + "grade= ?, "
				+ "stateCode=?, " + "militaryCode=?, " + "idNo=?, " + "hpNo=?,  " + " dayNightShift=?, "+ " pic = ?"
				+ " where stdNo = ?";

		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, studentData.getStdNo());
			pstmt.setString(2, studentData.getStdName());
			System.out.println(1);
			pstmt.setString(3, studentData.getStdDepartment().getDeptCode()); /////////////////////// 형변환 안해도된다!!!
			System.out.println(2);
			pstmt.setInt(4, studentData.getGrade());//////////////////
			pstmt.setString(5, studentData.getStdState().getStateCode());
			pstmt.setString(6, studentData.getMilitaryState().getMilitaryCode());
			pstmt.setString(7, studentData.getIdNo());
			pstmt.setString(8, studentData.getHpNo());
			pstmt.setString(9, studentData.getDayNightShift());
			pstmt.setString(10, studentData.getPic());
			pstmt.setInt(11, studentData.getStdNo());
			System.out.println(pstmt); // 중요!!! 에러뜰때 활용해서 디비버에서 수행해보면 뭐가문젠지 알수있다!!!!!!!!!!!

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SqlConstraintException();
		}
		
	}

	@Override
	public int deleteStudentData(StudentData studentData) {
		String sql = "delete from studentData where  stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, studentData.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<StudentData> SelectStudentBy4(StudentData studentData) {
		String sql = "select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg, pic from vw_full_studentdata  "
				+ "where dayNightShift =  ? and deptCode =  ? and  grade = ? and stateCode = ?";

		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, studentData.getDayNightShift());
			pstmt.setString(2, studentData.getStdDepartment().getDeptCode());
			pstmt.setInt(3, studentData.getGrade());
			pstmt.setString(4, studentData.getStdState().getStateCode());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<StudentData> list = new ArrayList<StudentData>();
					do {
						list.add(getStudentData(rs));
					} while (rs.next());
					return list;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

///////////////////////////반장님 아이디어
	@Override
	public Object[] ComboListSelect(String table, String where) {
		String sql = "select * from " + table; // 모든 칼럼 검색 + 테이블명. 얘는 사실 필요없는것같다
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				ArrayList<String> list = new ArrayList<String>();
				list.add("");
				do {
					list.add(rs.getString(where));
				} while (rs.next());

				return Arrays.stream(list.toArray()).distinct().sorted().toArray();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentData> SelectStudentByWhere(String where) { //
		String sql = "select " + "stdNo," + " stdName," + " deptCode," + " deptName," + " grade," + " stateCode,"
				+ " stateName, " // sql문
				+ " militaryCode," + " militaryName," + " idNo," + " gender," + " hpNo," + " dayNightShift,"
				+ " subject1," + " subject2," + " subject3," + " total," + " avg, " + "pic" + " from vw_full_studentdata  "
				+ where + " order by deptName "; // 모든칼럼 검색 + 조건은 where로 따로 뺀다
		System.out.println(sql);
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<StudentData> list = new ArrayList<StudentData>();
				do {
					list.add(getStudentData(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentScore> selectStudentScoreListByStdNo(StudentData studentData) {
		String sql = "select stdNo, subject1, subject2, subject3 from studentscore  "
				+ "where stdNo=(select stdNo from studentdata  where stdNo = ?)";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, studentData.getStdNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<StudentScore> scoreList = new ArrayList<>();
					do {
						StudentData stdNo = new StudentData(rs.getInt("stdNo"));
						int subject1 = rs.getInt("subject1");
						int subject2 = rs.getInt("subject2");
						int subject3 = rs.getInt("subject3");
						scoreList.add(new StudentScore(stdNo, subject1, subject2, subject3));
					} while (rs.next());
					return scoreList;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public StudentScore selectStudentScoreByNo(StudentData studentData) {
		String sql = "select stdNo, subject1, subject2, subject3 from studentscore "
				+ "where stdNo=(select stdNo from studentdata  where stdNo = ?)";
		try(Connection con = JdbcConn.getConnection();PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, studentData.getStdNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getStudentScore(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private StudentScore getStudentScore(ResultSet rs) throws SQLException {
		
		int subject1 = rs.getInt("subject1");
		int subject2 = rs.getInt("subject2");
		int subject3 = rs.getInt("subject3");
		StudentData stdNo =null; // new StudentData(rs.getInt("stdNo"));
		try {stdNo = new StudentData(rs.getInt("stdNo"));
				}catch(SQLException e ) {
					e.printStackTrace();
				}
		return new StudentScore(stdNo, subject1, subject2, subject3);
	}

	@Override
	public List<StudentData> SelectStudentScoreByWhere(String where) {
		String sql = " select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg, pic , @num:=@num+1 as num "
				   + " from (select  @num:=0)a, vw_full_studentData " + where + "  order by total desc "; // 모든칼럼 검색 + 조건은 where로 따로 뺀다
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<StudentData> list = new ArrayList<StudentData>();
				do {
					list.add(getStudentData1(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentData> selectStudentScoreByAll() {
		String sql = "select " + "stdNo," + " stdName," + " deptCode," + " deptName," + " grade," + " stateCode,"
				+ " stateName, " // sql문
				+ " militaryCode," + " militaryName," + " idNo," + " gender," + " hpNo," + " dayNightShift,"
				+ " subject1," + " subject2," + " subject3," + " total," + " avg, " + "pic,  " +  "@num:=@num+1 as num" +  " from  (select  @num:=0)a, vw_full_studentdata order by total desc";

		try (Connection con = JdbcConn.getConnection(); // 기존 db연결용 Connection클래스를 이용해서, dbproperties 파일에 있는 url키의 벨류인
														// db주소 읽어서 연결
				PreparedStatement pstmt = con.prepareStatement(sql); // db에 연결된상태에서 sql문 던져주기1
				ResultSet rs = pstmt.executeQuery()) { // 던져주기2

			if (rs.next()) { // 출력할 있다면 -> StudentData클래스의 모든 변수들을 담을수있는 리스트를 어레이리스트로 변환
				List<StudentData> list = new ArrayList<>();
				do {
					list.add(getStudentData1(rs)); // 만든 리스트에 하나씩 추가하기(rs를 매개변수로 넣어서) getStudentData()메소드 호출해서, 그 메소드에서
													// 정해준거 넣을거임

				} while (rs.next());
				return list;
			}
			// 예외처리
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/*
	 * private StudentScore getScore(ResultSet rs) throws SQLException {
	 * //////////////////////////////////////////여기도 수정쓰 반장님꺼 참고해서 넣은거임 ㅠㅠ 이거 있어야
	 * toArray에서 for문 쓸수있는것같아서 일단 넣어봄 ㅠㅠ 근데 나는 과목테이블 따로없어서 약간 수정행햐ㅏㅁ! return new
	 * StudentScore(new StudentData(rs.getInt("subjectno"),
	 * rs.getString("subjectname")), rs.getInt("score")); }
	 */
}
