package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ControlerBloc {
	@FXML
	AnchorPane Window;
	@FXML
	TextArea textAreaNote;
	@FXML
	Text okSave;

	@FXML
	private void processSuprBloc() {
		Window.setVisible(false);
	}

	@FXML
	private void saveNote() {
		try {
			FileWriter lu = new FileWriter("Note.txt");

			BufferedWriter out = new BufferedWriter(lu);
			System.out.println("");
			out.write(textAreaNote.getText()); //
			out.close();
			okSave.setText("Saved.");

		} catch (IOException er) {
		}
		
	}

	@FXML
	private void openNote() {
		try {
			FileInputStream fis = new FileInputStream("Note.txt");
			int n;

			try {
				while ((n = fis.available()) > 0) {
					byte[] b = new byte[n];
					int result = fis.read(b);
					if (result == -1)
						break;
					String s = new String(b);
					textAreaNote.setText(s);
				}
			} catch (IOException e) {
				
			}
		} catch (FileNotFoundException err) {

		}
	}

	public void chargeNote(Node text) {
		String s="";
		System.out.println(s);
		try {
			FileInputStream fis = new FileInputStream("Note.txt");
			int n;

				while ((n = fis.available()) > 0) {
					byte[] b = new byte[n];
					int result = fis.read(b);
					if (result == -1)
						break;
					s = new String(b);
					
				}
				((TextArea) text).setText(s);
		}catch(Exception e) { e.printStackTrace();}
	}
}
