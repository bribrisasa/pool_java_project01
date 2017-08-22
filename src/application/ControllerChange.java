package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pool_java_project01.CONTROL.Converter;

public class ControllerChange {

	@FXML private ChoiceBox<String> scroll01;
	@FXML private ChoiceBox<String> scroll02;
	@FXML private ImageView Flag01;
	@FXML private ImageView Flag02;
	@FXML private TextArea amount01;
	@FXML private TextArea amount02;
	private Boolean firstLaunch=true;
	
	Converter conv=new Converter();

	@FXML
	private void initialize() throws SAXException, IOException, ParserConfigurationException {
		ArrayList<String> list = conv.currenciesList();
		ObservableList<String> options = FXCollections.observableArrayList(list);
		scroll01.setValue("Euro");
		scroll02.setValue("Pound");
		scroll01.setItems(options);
		scroll02.setItems(options);
		amount01.setText("0.00");
		amount02.setText("0.00");
	}

	private void processFlag() throws SAXException, IOException, ParserConfigurationException {
			
				File file = new File(conv.getFlag(scroll01.getSelectionModel().getSelectedItem()));
				
				Image image = new Image(file.toURI().toString());
				Flag01.setImage(image);
	}
	
	private void processFlag2() throws SAXException, IOException, ParserConfigurationException {
		
		File file = new File(conv.getFlag(scroll02.getSelectionModel().getSelectedItem()));

		Image image = new Image(file.toURI().toString());
		Flag02.setImage(image);
		
		}
	
	@FXML
	public void changeFlag1() {

		scroll01.valueProperty().addListener(new ChangeListener<String>() {
        
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					processFlag();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}    
        });
	}
	
	@FXML
	public void changeFlag2() {

		scroll02.valueProperty().addListener(new ChangeListener<String>() {
        
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					processFlag2();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}    
        });
	}
	
	@FXML
	private void processConverter() throws SAXException, IOException, ParserConfigurationException {
		amount02.setText(
		conv.convert(amount01.getText(), scroll01.getSelectionModel().getSelectedItem(), scroll02.getSelectionModel().getSelectedItem())
		);
	}
	
	@FXML
	private void processConverterRevert() throws SAXException, IOException, ParserConfigurationException {
		amount01.setText(
		conv.convertRevert(amount02.getText(), scroll02.getSelectionModel().getSelectedItem(), scroll01.getSelectionModel().getSelectedItem())
		);
	}
}
