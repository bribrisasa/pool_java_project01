package pool_java_project01.TEST_UNIT;

import static org.junit.Assert.*;

import org.junit.Test;

import pool_java_project01.CONTROL.Converter;
import pool_java_project01.CONTROL.CURRENCIES.Currency;

public class ConvertToDollarTest {

	Currency doll = new Currency("DOLLAR",1);
	Currency eur = new Currency("EURO",1.18);
	Currency pou = new Currency("POUND",1.29);
	Currency can = new Currency("CANADIAN DOLLAR",0.79);
	
	Converter cr = new Converter();
	
	@Test
	public void dollToDollar() {
		assertTrue(cr.toResult(doll, doll, 1) == 1);
	}

	@Test
	public void eurToDollar() {
		assertTrue(cr.toResult(eur, doll, 1) == 1.18);
	}
	
	@Test
	public void pouToDollar() {
		assertTrue(cr.toResult(pou, doll, 1) == 1.29);
	}
	
	@Test
	public void canToDollar() {
		assertTrue(cr.toResult(can, doll, 1) == 0.79);
	}
}
