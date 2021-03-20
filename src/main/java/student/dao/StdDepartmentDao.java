package student.dao;  //학과 테이블

import java.util.List;

import student.dto.StdDepartment;
import student.dto.StdState;

public interface StdDepartmentDao {
	
	 //1.아무것도 안넣고 조회 눌렀을때 (학번,성명,학적구분) 출력
	List<StdDepartment> selectStdDepartmentByAll();   ///조건없이 학과테이블 전체검색

	StdDepartment selectStdDepartmentByNo(StdDepartment stdDepartment);  //학과를 조건으로 조회하기(dto에 있는 변수중 아무거나 가능!)
	
	int insertStdDepartment(StdDepartment stdDepartment);	//추가
	int updateStdDepartment(StdDepartment stdDepartment);	//수정
	int deleteStdDepartment(StdDepartment stdDepartment);	//삭제
	

}
