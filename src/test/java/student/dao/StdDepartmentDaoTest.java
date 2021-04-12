package student.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import student.dao.impl.StdDepartmentDaoImpl;
import student.dto.StdDepartment;

public class StdDepartmentDaoTest {
	private StdDepartmentDao stdDepartmentDao = StdDepartmentDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}


	@Test
	public void testSelectStdDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectStdDepartmentByAll()");
		List<StdDepartment> stdDeptList = stdDepartmentDao.selectStdDepartmentByAll();
		Assert.assertNotNull(stdDeptList);
		for(StdDepartment e : stdDeptList) {
			System.out.println(e);
		}
	}

	@Test
	public void testSelectStdDepartmentByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertStdDepartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateStdDepartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteStdDepartment() {
		fail("Not yet implemented");
	}

}
