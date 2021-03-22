package student.dao;  //학생 테이블

import java.util.List;

import student.dto.StudentData;

public interface StudentDataDao {
	
	List<StudentData> selectStudentDataByAll();   //조건없이 학생정보 테이블 모두 조회하기
	
	StudentData selectStudentDataByNo(StudentData studentData);  //학생테이블을 조건으로 검색하기(dto에 있는 변수중 아무거나 가능!)  
	
	int insertStudentData(StudentData studentData);	//추가
	int updateStudentData(StudentData studentData);	//수정
	int deleteStudentData(StudentData studentData);	//삭제
	
	
	

//	List<Employee> SelectEmployeeByTitle(Title title);   //동일직책으로 검색해보기
	//List<Employee> SelectEmployeeByDepartment(Department department);   //동일부서로 검색해보기
	
	//StdState selectStudentByNo(StdState student);
	
	

}
