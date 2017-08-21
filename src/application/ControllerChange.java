package application;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

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

	ObservableList<String> options = FXCollections.observableArrayList("Euro","Pound","Dollar","Canadian Dollar");

	@FXML
	private void initialize() {
		scroll01.setValue("Euro");
		scroll02.setValue("Euro");
		scroll01.setItems(options);
		scroll02.setItems(options);
	}

	@FXML
	private void processFlag1() throws SAXException, IOException, ParserConfigurationException {
		if(firstLaunch==false) {
			amount02.setText(processConverter());
			
			
		}else 
		{			
			firstLaunch=false;
			amount01.setText("0.00");
			amount02.setText("0.00");}
	}

	/*@FXML
	private void processFlag2() {
		if(firstLaunch==false) {
			if(	scroll02.getSelectionModel().getSelectedItem()=="Euro") {
				File file = new File("src/IMAGES/icons8_France_96px.png");
				Image image = new Image(file.toURI().toString());
				Flag02.setImage(image);
			}
			else if(scroll02.getSelectionModel().getSelectedItem()=="Dollar") 
			{
				File file = new File("src/IMAGES/icons8_USA_96px.png");
				Image image = new Image(file.toURI().toString());
				Flag02.setImage(image);	
			}
			else if(scroll02.getSelectionModel().getSelectedItem()=="Pound") 
			{
				File file = new File("src/IMAGES/icons8_Great_Britain_96px.png");
				Image image = new Image(file.toURI().toString());
				Flag02.setImage(image);	
			}
			else if(scroll02.getSelectionModel().getSelectedItem()=="Canadian Dollar") 
			{
				File file = new File("src/IMAGES/icons8_Canada_96px.png");
				Image image = new Image(file.toURI().toString());
				Flag02.setImage(image);	
			}
		}else {firstLaunch=false;
		System.out.println("not ok");}
	}*/
	
	private String processConverter() throws SAXException, IOException, ParserConfigurationException {

		return conv.convert(amount01.getText(), scroll01.getSelectionModel().getSelectedItem(), scroll02.getSelectionModel().getSelectedItem());
	}
}
