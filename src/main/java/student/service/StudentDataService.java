package student.service;



import student.dao.MilitaryStateDao;
import student.dao.StudentDataDao;
import student.dao.impl.MilitaryStateDaoImpl;
import student.dao.impl.StudentDataDaoImpl;

public class StudentDataService {
	private StudentDataDao studentDataDao =  StudentDataDaoImpl.getInstance();
	private MilitaryStateDao miltaryStateDao = MilitaryStateDaoImpl.getInstance();
	//private StdDepartmentDao empDao = StdDepartmentDaoImpl.getInstance();
	
	
	
}
