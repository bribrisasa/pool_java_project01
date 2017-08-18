package pool_java_project01.CONTROL.CURRENCIES;

import pool_java_project01.GUI.*;

public abstract class Currency {

	protected String name;
	protected double convertDollar;

	public Currency(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void seeMoneyName(){
		System.out.println(this.name);
	}

	public double getConvertDollar(){
		return convertDollar;	
	}
}
