package pool_java_project01.CONTROL;
import javax.swing.JFrame;

import pool_java_project01.CONTROL.CURRENCIES.Currency;
import pool_java_project01.GUI.WindowConverter;

public class Converter {
	WindowConverter view;
	
	public Converter(WindowConverter view) {
		this.view = view;
	}

	public double toResult(Currency currency, double input){
		double result;

		result = currency.getConvertDollar()*input;
		return result;	
	}
	
	public String[] currenciesList() {
		
		return null;		
	}
	
	public String convert(String amountOrigin, String currencyOrigin, String currencyTarget) {
		System.out.println(amountOrigin + currencyOrigin + currencyTarget);
		return (amountOrigin + currencyOrigin + currencyTarget);
	}
}