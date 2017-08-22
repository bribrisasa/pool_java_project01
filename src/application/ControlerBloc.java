package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControlerBloc {
	@FXML private AnchorPane Window;
	
	@FXML 
	private void processSuprBloc() {
		Window.setVisible(false);
	}
}
