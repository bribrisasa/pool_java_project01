package pool_java_project01.TEST_UNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import pool_java_project01.CONTROL.Converter;
import pool_java_project01.CONTROL.CURRENCIES.Currency;

public class ConvertTest {

	Currency doll = new Currency("DOLLAR",1);
	Currency eur = new Currency("EURO",1.18);
	Currency pou = new Currency("POUND",1.29);
	Currency can = new Currency("CANADIAN DOLLAR",0.79);
	
	Converter cr = new Converter();
	
	@Test
	public void dollToEur() {
		assertTrue(cr.toResult(doll, eur, 1) == 0.85);
	}
	
	@Test
	public void dollToPou() {
		assertTrue(cr.toResult(doll, pou, 1) == 0.78);
	}
	
	@Test
	public void dollToCan() {
		assertTrue(cr.toResult(doll, can, 1) == 1.27);
	}

	@Test
	public void eurToEur() {
		assertTrue(cr.toResult(eur, eur, 1) == 1);
	}
	
	@Test
	public void eurToPou() {
		assertTrue(cr.toResult(eur, pou, 1) == 0.91);
	}
	
	@Test
	public void eurToCan() {
		assertTrue(cr.toResult(eur, can, 1) == 1.49);
	}
	
	@Test
	public void pouToEur() {
		assertTrue(cr.toResult(pou, eur, 1) == 1.09);
	}
	
	@Test
	public void pouToPou() {
		assertTrue(cr.toResult(pou, pou, 1) == 1);
	}
	
	@Test
	public void pouToCan() {
		assertTrue(cr.toResult(pou, can, 1) == 1.63);
	}
	
	@Test
	public void canToEuro() {
		assertTrue(cr.toResult(can, eur, 1) == 0.67);
	}
	
	@Test
	public void canToPou() {
		assertTrue(cr.toResult(can, pou, 1) == 0.61);
	}
	
	@Test
	public void canToCan() {
		assertTrue(cr.toResult(can, can, 1) == 1);
	}
}


