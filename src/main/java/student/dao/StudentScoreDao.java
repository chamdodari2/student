package student.dao;  //학생성적 테이블

import java.util.List;

import student.dto.StudentData;
import student.dto.StudentScore;

public interface StudentScoreDao {
	
	
	List<StudentScore> selectStudentScoreByAll();   ///조건없이 '학생점수'테이블 전체검색

	StudentScore selectStudentScoreByNo(StudentScore studentScore);  //학생점수를 조건으로 검색하기 (dto에 있는 변수중 아무거나 가능!)
	
	int insertStudentScore(int stdNo);  //추가
	int updateStudentScore(StudentScore studentScore);	 //수정
	int deleteStudentScore(StudentScore studentScore);	 //삭제
	
	
	

}
