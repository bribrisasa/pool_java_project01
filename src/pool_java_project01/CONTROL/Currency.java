package pool_java_project01.CONTROL;

import pool_java_project01.GUI.*;

public abstract class Currency {

	String name;
	
	public Currency(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void seeMoneyName() {
		System.out.println(this.name);
	}
}
