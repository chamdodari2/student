package student.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student.dao.impl.StudentDataDaoImpl;
import student.dto.MilitaryState;
import student.dto.StdDepartment;
import student.dto.StdState;
import student.dto.StudentData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDataDaoTest {
	private StudentDataDao studentDataDao = StudentDataDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectStudentDataByAll() {
		System.out.printf("%s()%n", "test01SelectStudentDataByAll");
		List<StudentData> studentDataList = studentDataDao.selectStudentDataByAll();
		Assert.assertNotNull(studentDataList);

		for (StudentData e : studentDataList) {
			System.out.println(e);
		}
	}

	@Test
	public void test02SelectStudentDataByNo() {
		System.out.printf("%s()%n","test02SelectStudentDataByNo");
		StudentData studentData = new StudentData(18010016);
		
		StudentData serchStudentData = studentDataDao.selectStudentDataByNo(studentData);
		Assert.assertNotNull(serchStudentData);
		System.out.println(studentDataDao.selectStudentDataByNo(studentData));

	}

	@Test
	public void test03InsertStudentData() {
		System.out.printf("%s()%n","test03InsertStudentData");
		//update studentdata  set stdNo = 17010013, stdName= '김예진2', deptCode='3', grade='2', stateCode='hla', militaryCode='y2c', idNo='970828*******', hpNo='010-9566-0477', dayNightShift='야간'; 
		StudentData newStudentData = new StudentData(17010013,"김예진",new StdDepartment("1"),2,new StdState("hlb"),new MilitaryState("y2a"),"960828*******","010-9566-0476","야간");
		int res = studentDataDao.insertStudentData(newStudentData);
		Assert.assertEquals(1, res);
		studentDataDao.selectStudentDataByAll().stream().forEach(System.out::println);

	}

	@Test
	public void test04UpdateStudentData() {
		System.out.printf("%s()%n","test04UpdateStudentData");
		//update studentdata  set stdNo = 17010013, stdName= '김예진2', deptCode='3', grade='2', stateCode='hla', militaryCode='y2c', idNo='970828*******', hpNo='010-9566-0477', dayNightShift='야간'; 
		StudentData updateStudentData = new StudentData(17010013,"김예진2",new StdDepartment("2"),3,new StdState("hla"),new MilitaryState("y2c"),"970828*******","010-9566-0477","주간");
		int res = studentDataDao.updateStudentData(updateStudentData);
		Assert.assertEquals(1, res);
		studentDataDao.selectStudentDataByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test05DeleteStudentData() {
		System.out.printf("%s()%n","test05DeleteStudentData");
		StudentData delStudentData = new StudentData(17010013);
		int res = studentDataDao.deleteStudentData(delStudentData);
		Assert.assertEquals(1, res);
		studentDataDao.selectStudentDataByAll().stream().forEach(System.out::println);
	}

}