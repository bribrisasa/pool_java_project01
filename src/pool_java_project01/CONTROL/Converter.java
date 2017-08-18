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
import javax.swing.JFrame;

import pool_java_project01.CONTROL.CURRENCIES.CanadianDollar;
import pool_java_project01.CONTROL.CURRENCIES.Currency;
import pool_java_project01.CONTROL.CURRENCIES.Dollar;
import pool_java_project01.CONTROL.CURRENCIES.Euro;
import pool_java_project01.CONTROL.CURRENCIES.Pound;
import pool_java_project01.GUI.WindowConverter;

public class Converter {
	WindowConverter view;

	public Converter(WindowConverter view) {
		this.view = view;
	}

	public double toResult(Currency origin, Currency target,double amount){
		double result;
		result = amount*origin.convertToDollar();
		return result / target.convertToDollar();

	}

	public String[] currenciesList() throws SAXException, IOException, ParserConfigurationException {
        String[] currencies;
        ArrayList<String> curr = new ArrayList<String>();
        
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
                if(nameCurrency.getTextContent() != null)
                    curr.add(nameCurrency.getTextContent());
            }    
        }
        currencies = new String[curr.size()];
        for (int i = 0; i<curr.size(); i++) {
            currencies[i] = curr.get(i);
        }
        return currencies;
    }

	
	public String convert(String amountOrigin, String currencyOrigin, String currencyTarget) {
		double total=0;
		
		Currency origin = null;
		Currency target = null;
		System.out.println(currencyOrigin);
		System.out.println(currencyTarget);
		switch(currencyOrigin) {
		case "EURO":
			origin=new Euro();	
			break;
		case "DOLLAR":
			origin=new Dollar();	
			break;
		case "POUND":
			origin=new Pound();	
			break;
		case "CANADIAN DOLLAR":
			origin=new CanadianDollar();	
			break;
		}
		switch(currencyTarget) {
		case "EURO":
			target=new Euro();	
			break;
		case "DOLLAR":
			target=new Dollar();	
			break;
		case "POUND":
			target=new Pound();	
			break;
		case "CANADIAN DOLLAR":
			origin=new CanadianDollar();	
			break;
		}
		System.out.println(origin.getName());
		total=toResult(origin,target,Double.parseDouble(amountOrigin));
		return  Double.toString(total);	
	}
}