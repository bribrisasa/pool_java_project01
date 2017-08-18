package pool_java_project01.CONTROL;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Controler {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

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
					
			   // System.out.println("Id : " + currency.getAttribute("id"));
				
			    final Element nameCurrency = (Element) currency.getElementsByTagName("name").item(0);
			    final Element valueCurrency = (Element) currency.getElementsByTagName("Value").item(0);
						
			    if(nameCurrency.getTextContent().equalsIgnoreCase("Euro")) {
			    	double d = Double.parseDouble(valueCurrency.getTextContent());
			    		//System.out.println(d);
			    }
			    
			   // System.out.println("Name : " + nameCurrency.getTextContent());
			  //  System.out.println("Value : " + valueCurrency.getTextContent());
		        }
			}
			
			
	}
}
