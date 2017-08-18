package pool_java_project01.TEST_UNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import pool_java_project01.CONTROL.*;

public class CreateMoney {

	@Test
	public void testDollar() {
		Money dollar = new Dollar();
		assertTrue(dollar.getName() == "Dollar");
	}

}
