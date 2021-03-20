package student.dao;  //학적상태 테이블

import java.util.List;

import student.dto.StdDepartment;
import student.dto.StdState;

public interface StdStateDao {
	
	
	List<StdState> selectStdStateByAll();   ///조건없이 '학적상태'테이블 전체검색

	StdState selectStdStateByNo(StdState stdState);  //학적상태를 조건으로 검색하기 (dto에 있는 변수중 아무거나 가능!)
	
	int insertStdState(StdDepartment stdState);  //추가
	int updateStdState(StdDepartment stdState);	 //수정
	int deleteStdState(StdDepartment stdState);	 //삭제
	

}
