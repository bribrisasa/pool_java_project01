package application;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class Controller {
	
	private int changeCount;
	private static String value="";

	@FXML private Label CalcLabel;

	@FXML private TextField output;

	@FXML private ImageView Calc,Ballance,Homebt;

	@FXML private AnchorPane Converter, Calculator,Home,Menu;
	
	@FXML private FlowPane changePanel;
	
	@FXML 
	private void processMenuButton(MouseEvent event){
		if(event.getSource()== Calc){
			Home.setVisible(false);
			Converter.setVisible(false);
			Calculator.setVisible(true);
			Calculator.toFront();
		}
		else if(event.getSource()== Ballance){
			Home.setVisible(false);
			Converter.setVisible(true);
			Calculator.setVisible(false);
			Converter.toFront();
		}
		else if(event.getSource()== Homebt){
			Home.setVisible(true);
			Converter.setVisible(false);
			Calculator.setVisible(false);
			Converter.toFront();
		}
	}
	@FXML 
	private void processExitButton(MouseEvent event){
		System.exit(0);
	}
	
	@FXML 
	private void processAddButton() throws IOException{
		Parent root;
		if(changeCount<9)
		{
		root = FXMLLoader.load(getClass().getResource("ChangeWindow.fxml"));
		AnchorPane scene = new AnchorPane(root);
		changePanel.getChildren().add(new AnchorPane(scene));
		changeCount++;
		}
	}
	
	@FXML 
	private void processNumpad(MouseEvent event){ 
		value=value.concat(((Button) event.getSource()).getText());
		CalcLabel.setText(value);
	}
}

