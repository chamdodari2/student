package student.dao;  //학생성적 테이블

import java.util.List;

import student.dto.StdDepartment;
import student.dto.StdState;
import student.dto.StudentScore;

public interface StudentScoreDao {
	
	
	List<StudentScore> selectStudentScoreByAll();   ///조건없이 '학생상태'테이블 전체검색

	StudentScore selectStudentScoreByNo(StudentScore studentScore);  //학적상태를 조건으로 검색하기 (dto에 있는 변수중 아무거나 가능!)
	
	int insertStudentScore(StudentScore studentScore);  //추가
	int updateStudentScore(StudentScore studentScore);	 //수정
	int deleteStudentScore(StudentScore studentScore);	 //삭제
	

}
