package pool_java_project01.CONTROL;
import pool_java_project01.CONTROL.CURRENCIES.Currency;

public class Converter {

	public double toResult(Currency currency, double input){
		double result;

		result = currency.getConvertDollar()*input;
		return result;	
	}
	
	public String[] currenciesList() {
		
		return null;		
	}
}