package student.dao;  //학과 테이블

import java.util.List;

import student.dto.StudentData;

public interface StudentDataDao {
	
	//학적,학생관리 
	 //아무것도 안넣고 조회 눌렀을때 (학번,성명,학적구분) 출력
	List<StudentData> selectStudentDataByAll();   //조건없이 학생정보 테이블 모두 조회하기
	
	StudentData selectStudentDataByNo(StudentData student);  //학번으로 조회하기!   
	
	int insertStudentData(StudentData student);
	int updateStudentData(StudentData student);
	int deleteStudentData(StudentData student);
	
	
	

//	List<Employee> SelectEmployeeByTitle(Title title);   //동일직책으로 검색해보기
	//List<Employee> SelectEmployeeByDepartment(Department department);   //동일부서로 검색해보기
	
	//StdState selectStudentByNo(StdState student);
	
	

}
