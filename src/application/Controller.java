package application;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

	private int changeCount;
	private double xOffset = 0;
	private double yOffset = 0;
	ControlerBloc cb;
	public static Boolean isVisible=false; 

	@FXML
	private Label CalcLabel;

	@FXML
	private TextField output;

	@FXML
	private Pane Calc, ballance, Homebt, Plusdoc;

	@FXML
	private AnchorPane Converter, Calculator, Home, Menu;


	@FXML
	private FlowPane changePanel;

	@FXML
	private void processMenuButton(MouseEvent event) {
		if (event.getSource() == Calc) {
			Home.setVisible(false);
			Converter.setVisible(false);
			Calculator.toFront();
		} else if (event.getSource() == ballance) {
			Home.setVisible(false);
			Converter.setVisible(true);
			Converter.toFront();
		} else if (event.getSource() == Homebt) {
			Home.setVisible(true);
			Converter.setVisible(false);
			Converter.toFront();
		}
	}

	@FXML
	private void processExitButton(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	private void processAddButton() throws IOException {
		Parent root;
		if (changeCount < 9) {
			root = FXMLLoader.load(getClass().getResource("ChangeWindow.fxml"));
			AnchorPane scene = new AnchorPane(root);
			changePanel.getChildren().add(new AnchorPane(scene));
			changeCount++;
		}
	}

	@FXML
	private void processAddBloc() throws IOException {
		Parent root;
		Stage BlocStage = new Stage();
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

	@FXML
	private void openNote() throws IOException {
		if(isVisible==false) {
		Parent root;
			cb = new ControlerBloc();
			Stage BlocStage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("BlocNote.fxml"));
			root = loader.load();

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
			cb.chargeNote((Node) loader.getNamespace().get("textAreaNote"));
			BlocStage.show();
			isVisible=true;
		}
	} 
}

