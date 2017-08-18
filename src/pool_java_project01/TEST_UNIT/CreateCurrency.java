package pool_java_project01.TEST_UNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import pool_java_project01.CONTROL.*;

public class CreateCurrency {

	@Test
	public void testDollar() {
		Currency dollar = new Dollar();
		assertTrue(dollar.getName() == "Dollar");
	}
	
	@Test
	public void testEuro() {
		Currency euro = new Euro();
		assertTrue(euro.getName() == "Euro");
	}
	
	@Test
	public void testCanadianDollar() {
		Currency cDollar = new CanadianDollar();
		assertTrue(cDollar.getName() == "Canadian Dollar");
	}
	
	@Test
	public void testPound() {
		Currency pound = new Pound();
		assertTrue(pound.getName() == "Pound");
	}
	

}
