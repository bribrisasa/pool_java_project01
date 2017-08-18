package pool_java_project01.CONTROL;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import pool_java_project01.CONTROL.CURRENCIES.Dollar;
import pool_java_project01.CONTROL.CURRENCIES.Euro;

public class Controler {

	public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException {
		
		
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
				System.out.println(nameCurrency.getTextContent());
			}
		}
	}
}