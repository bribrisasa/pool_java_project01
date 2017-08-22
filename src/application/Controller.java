package application;


import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

	private int changeCount;
	private static String value="";
	private double xOffset = 0;
	private double yOffset = 0;

	@FXML private Label CalcLabel;

	@FXML private TextField output;

	@FXML private Pane Calc,ballance,Homebt,Plusdoc;

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
		else if(event.getSource()== ballance){
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

	@FXML 
	private void processAddBloc() throws IOException{
		Parent root;
		Stage BlocStage=new Stage();
		root = FXMLLoader.load(getClass().getResource("BlocNote.fxml"));
		BlocStage.initStyle(StageStyle.TRANSPARENT);
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				BlocStage.setX(event.getScreenX() - xOffset);
				BlocStage.setY(event.getScreenY() - yOffset);
			}
		});

		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		BlocStage.setScene(scene);
		BlocStage.sizeToScene(); 
		BlocStage.show();
	}
}

