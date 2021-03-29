package student.dao;  //학과 테이블

import java.util.List;

import student.dto.MilitaryState;

public interface MilitaryStateDao {
	
	
	List<MilitaryState> selectMilitaryStateByAll();   ///조건없이 병역상태 테이블 모두 조회

	MilitaryState selectMilitaryStateByNo(MilitaryState militaryState);  //학번으로 병역상태 조회
	
	int insertMilitaryState(MilitaryState militaryState);
	int updateMilitaryState(MilitaryState militaryState);
	int deleteMilitaryState(MilitaryState militaryState);
	

}
