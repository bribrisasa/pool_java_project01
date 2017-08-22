package application;

import java.util.regex.Pattern;

import javafx.scene.control.Button;

public class Calculatrice {
	Calculatrice calculette = new Calculatrice();
	
	final Pattern num = Pattern.compile("C=(\\d+\\.\\d+)");
	final Pattern op = Pattern.compile("C=(\\+\\-\\*\\\\.\\,=)");
	final Pattern cl = Pattern.compile("C=CLEAR");
	
	boolean isNum = num.matcher(value).matches();
	boolean isOp = op.matcher(value).matches();
	boolean isCl = cl.matcher(value).matches();
	
	System.out.println(value);
	while(isNum) {
		value=value.concat(((Button) event.getSource()).getText());
		CalcLabel.setText(value);
		isNum = num.matcher(value).matches();
		isOp = op.matcher(value).matches();
		isCl = cl.matcher(value).matches();
	}
	
	System.out.println(isNum);
	System.out.println(isOp);
	System.out.println(isCl);
	
}
}
