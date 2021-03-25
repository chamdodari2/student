package student.dao.impl;

import java.util.List;

import student.dao.MilitaryStateDao;

public class MilitaryStateDaoImpl implements MilitaryStateDao {
	private static MilitaryStateDaoImpl instance = new MilitaryStateDaoImpl();  //본 클래스 객체생성, private static으로 여기서만 쓸수있게 싱글턴패턴
	public static MilitaryStateDaoImpl getInstance() {	//getInstance()메소드 :  null이면 객체생성해서 돌려주기?
		if (instance == null) {
			instance = new MilitaryStateDaoImpl();
		}
		return instance;      //싱글턴패턴

	}
	
	
	@Override
	public List<MilitaryStateDao> selectMilitaryStateByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MilitaryStateDao selectMilitaryStateByNo(MilitaryStateDao militaryState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMilitaryState(MilitaryStateDao militaryState) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMilitaryState(MilitaryStateDao militaryState) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMilitaryState(MilitaryStateDao militaryState) {
		// TODO Auto-generated method stub
		return 0;
	}

}
