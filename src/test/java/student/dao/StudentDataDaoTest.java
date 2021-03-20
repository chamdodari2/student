package student.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student.dao.impl.StudentDataDaoImpl;
import student.dto.StudentData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDataDaoTest {
	private StudentDataDao studentDao = StudentDataDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectStudentDataByAll() {
		System.out.printf("%s()%n", "test01SelectStudentDataByAll");
		List<StudentData> studentDataList = studentDao.selectStudentDataByAll();
		Assert.assertNotNull(studentDataList);

		for (StudentData e : studentDataList) {
			System.out.println(e);
		}

		/*
		 * @Test public void testSelectStudentDataByNo() { fail("Not yet implemented");
		 * }
		 */
		/*
		 * @Test public void testInsertStudentData() { fail("Not yet implemented"); }
		 * 
		 * @Test public void testUpdateStudentData() { fail("Not yet implemented"); }
		 * 
		 * @Test public void testDeleteStudentData() { fail("Not yet implemented"); }
		 * 
		 * }
		 */
	}
}