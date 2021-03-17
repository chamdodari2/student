package student.dao;  //학과 테이블

import java.util.List;

import student.dto.StdState;
import student.dto.StudentData;

public interface MilitaryStateDao {
	
	 //1.아무것도 안넣고 조회 눌렀을때 (학번,성명,학적구분) 출력
	List<MilitaryStateDao> selectMilitaryStateByAll();   ///조건없이 병역상태 테이블 모두 조회

	MilitaryStateDao selectMilitaryStateByNo(MilitaryStateDao militaryState);  //학번으로 병역상태 조회
	
	int insertMilitaryState(MilitaryStateDao militaryState);
	int updateMilitaryState(MilitaryStateDao militaryState);
	int deleteMilitaryState(MilitaryStateDao militaryState);
	

}
