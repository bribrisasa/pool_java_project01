package pool_java_project01.TEST_UNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import pool_java_project01.CONTROL.CURRENCIES.Currency;

public class CreateCurr {

	@Test
	public void testDollar() {
		Currency dollar = new Currency("DOLLAR",1);
		assertTrue(dollar.getName() == "DOLLAR");
	}
	
	@Test
	public void testEuro() {
		Currency euro = new Currency("EURO",1);
		assertTrue(euro.getName() == "EURO");
	}
	
	@Test
	public void testCanadianDollar() {
		Currency cDollar = new Currency("CANADIAN DOLLAR",1);
		assertTrue(cDollar.getName() == "CANADIAN DOLLAR");
	}
	
	@Test
	public void testPound() {
		Currency pound = new Currency("POUND",1);
		assertTrue(pound.getName() == "POUND");
	}

}
