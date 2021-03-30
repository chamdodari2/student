package student.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student.dao.impl.MilitaryStateDaoImpl;
import student.dto.MilitaryState;
import student.dto.StudentData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MilitaryStateDaoTest {
	private MilitaryStateDao militaryStateDao = MilitaryStateDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectMilitaryStateByAll() {
		System.out.printf("%s()%n", "test01SelectMilitaryStateByAll");
		List<MilitaryState> militaryStatesList = militaryStateDao.selectMilitaryStateByAll();
		Assert.assertNotNull(militaryStatesList);

		for (MilitaryState e : militaryStatesList) {
			System.out.println(e);
		}
	}

	//@Test
	public void testSelectMilitaryStateByNo() {
		fail("Not yet implemented");
	}

//	@Test
	public void testInsertMilitaryState() {
		fail("Not yet implemented");
	}

	//@Test
	public void testUpdateMilitaryState() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDeleteMilitaryState() {
		fail("Not yet implemented");
	}

}
