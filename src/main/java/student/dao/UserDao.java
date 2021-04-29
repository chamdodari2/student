package student.dao;

import student.dto.User;

public interface UserDao { //관리자회원가입용
	
	public User selectUserByAll(int id, String pass); //조건없이 유저 정보 모두검색
	

}
