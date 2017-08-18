package pool_java_project01.TEST_UNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import pool_java_project01.CONTROL.*;
import pool_java_project01.CONTROL.CURRENCIES.CanadianDollar;
import pool_java_project01.CONTROL.CURRENCIES.Currency;
import pool_java_project01.CONTROL.CURRENCIES.Dollar;
import pool_java_project01.CONTROL.CURRENCIES.Euro;
import pool_java_project01.CONTROL.CURRENCIES.Pound;

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
