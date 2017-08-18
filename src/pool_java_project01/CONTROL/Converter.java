package pool_java_project01.CONTROL;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pool_java_project01.CONTROL.CURRENCIES.Currency;

public class Converter {

	public double toResult(Currency currency, double input){
		double result;

		result = currency.getConvertDollar()*input;
		return result;	
	}
	
	public ArrayList<String> currenciesList() throws SAXException, IOException, ParserConfigurationException {
		ArrayList<String> currencies=new ArrayList<>();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		File fileXML = new File("src/pool_java_project01/CONTROL/conversionRate.xml");

		Document xml = builder.parse(fileXML);		
		final Element racine = xml.getDocumentElement();
		final NodeList racineNoeuds = racine.getChildNodes();
		final int nbRacineNoeuds = racineNoeuds.getLength();

		for (int i = 0; i<nbRacineNoeuds; i++) {
			if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
				final Element currency = (Element) racineNoeuds.item(i);
				final Element nameCurrency = (Element) currency.getElementsByTagName("name").item(0);			
				currencies.add(nameCurrency.getTextContent());
			}	
		}
		return currencies;
	}
}