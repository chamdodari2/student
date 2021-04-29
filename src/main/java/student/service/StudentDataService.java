package student.service;

import java.util.List;

import student.dao.MilitaryStateDao;
import student.dao.StdDepartmentDao;
import student.dao.StdStateDao;
import student.dao.StudentDataDao;
import student.dao.StudentScoreDao;
import student.dao.UserDao;
import student.dao.impl.MilitaryStateDaoImpl;
import student.dao.impl.StdDepartmentDaoImpl;
import student.dao.impl.StdStateDaoImpl;
import student.dao.impl.StudentDataDaoImpl;
import student.dao.impl.StudentScoreDaoImpl;
import student.dao.impl.UserDaoImpl;
import student.dto.MilitaryState;
import student.dto.StdDepartment;
import student.dto.StdState;
import student.dto.StudentData;
import student.dto.StudentScore;
import student.dto.User;

public class StudentDataService {
	private StudentDataDao studentDataDao = StudentDataDaoImpl.getInstance();
	private MilitaryStateDao militaryStateDao = MilitaryStateDaoImpl.getInstance();
	private StdDepartmentDao stdDepartmentDao = StdDepartmentDaoImpl.getInstance();
	private StdStateDao stdStateDao = StdStateDaoImpl.getInstance();
	private StudentScoreDao studentScoreDao = StudentScoreDaoImpl.getInstance();
	private UserDao userDao = UserDaoImpl.getInstance();

	// 무조건 모두 검색
	public List<StudentData> showStudentDatas() {
		return studentDataDao.selectStudentDataByAll();
	}
	public List<StudentData> showStudentScoreDatas() {
		return studentDataDao.selectStudentScoreByAll();
	}
	

	public List<MilitaryState> showMilitaryStates() {
		return militaryStateDao.selectMilitaryStateByAll();
	}

	public List<StdDepartment> showStdDepartments() {
		return stdDepartmentDao.selectStdDepartmentByAll();
	}

	public List<StdState> showStdStates() {
		return stdStateDao.selectStdStateByAll();
	}

	public List<StudentScore> showStudentScores() {
		return studentScoreDao.selectStudentScoreByAll();
	}

	// insert
	public void addStudentData(StudentData studentData) {
		studentDataDao.insertStudentData(studentData);
	}

	public void addMilitaryState(MilitaryState militaryState) {
		militaryStateDao.insertMilitaryState(militaryState);
	}

	public void addStdDepartment(StdDepartment stdDepartment) {
		stdDepartmentDao.insertStdDepartment(stdDepartment);

	}

	public void addStdState(StdState stdState) {
		stdStateDao.insertStdState(stdState);

	}

	public void addStudentScore(int stdNo) {
		studentScoreDao.insertStudentScore(stdNo);
	}
//sel by
	public StudentData showStudentDatasByNo(StudentData studentData) {
		return studentDataDao.selectStudentDataByNo(studentData);
		}
	//////////////where 조건으로 검색
	
	public List<StudentData> showStudentDataByWhere(String where) {
	return studentDataDao.SelectStudentByWhere(where);
	}	

	public List<StudentData> showStudentScoreByWhere(String where) {
	return studentDataDao.SelectStudentScoreByWhere(where);
	}	
	////////////////학번으로 성적리스트 검색
	
	public List<StudentScore> showStudentScoreListByStdNo(StudentData studentData){
		return studentDataDao.selectStudentScoreListByStdNo(studentData);
	}
		
	
	
	//// 로그인아이디 검색
	
	public User showUserByAll(int id, String pass) {
		return userDao.selectUserByAll(id ,pass);
		}	
	
	
	
	
	
	
	
	
	// update
	public void modifyStudentData(StudentData studentData) {
		studentDataDao.updateStudentData(studentData);
	}

	public void modifyMilitaryState(MilitaryState militaryState) {
		militaryStateDao.updateMilitaryState(militaryState);
	}

	public void modifyStdDepartment(StdDepartment stdDepartment) {
		stdDepartmentDao.updateStdDepartment(stdDepartment);
	}

	public void modifyStdState(StdState stdState) {
		stdStateDao.updateStdState(stdState);
	}

	public void modifyStudentScore(StudentScore studentScore) {
		studentScoreDao.updateStudentScore(studentScore);
	}

	// delete
	public void removeStudentData(StudentData studentData) {
		studentDataDao.deleteStudentData(studentData);
	}
	
	public void removeMilitaryState(MilitaryState militaryState) {
		militaryStateDao.deleteMilitaryState(militaryState);
		
	}
	public void removeStdState(StdState stdState) {
		stdStateDao.deleteStdState(stdState);
	}
	public void removeStdDepartment(StdDepartment stdDepartment) {
		stdDepartmentDao.deleteStdDepartment(stdDepartment);
		
	}
	public void removeStudentScore(StudentScore studentScore) {
		studentScoreDao.deleteStudentScore(studentScore);
		
	}
	// 콤보박스에 학과 리스트 넣기
	public  List<StdDepartment> showDeptList(StdDepartment dept){
		return stdDepartmentDao.selectStdDepartmentByAll();   //deptDao에 있는 메소드  selectDepartmentByAll 호출 ----> 부서테이블의 모든것 출력
	}
	
	
	//SelectStudentBy4
	public List<StudentData> showStudentDatasBy4(StudentData studentData) {
		return studentDataDao.SelectStudentBy4(studentData);
	}
	
	
}
