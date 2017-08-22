package pool_java_project01.CONTROL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
    
    public Converter() {
        
    }
    public double toResult(Currency origin, Currency target, double amount) throws SAXException, IOException, ParserConfigurationException {
        double result,total;

        result = amount * getRate(origin.getName());
        total = result / getRate(target.getName());
       
        return (double) Math.round(total * 100) / 100;

    }

    public ArrayList<String> currenciesList() throws SAXException, IOException, ParserConfigurationException {
        ArrayList<String> currencies = new ArrayList<String>();

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        File fileXML = new File("src/pool_java_project01/CONTROL/conversionRate.xml");

        Document xml = builder.parse(fileXML);
        final Element racine = xml.getDocumentElement();
        final NodeList racineNoeuds = racine.getChildNodes();
        final int nbRacineNoeuds = racineNoeuds.getLength();

        for (int i = 0; i < nbRacineNoeuds; i++) {
            if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element currency = (Element) racineNoeuds.item(i);
                final Element nameCurrency = (Element) currency.getElementsByTagName("name").item(0);
                if (nameCurrency.getTextContent() != null)
                    currencies.add(nameCurrency.getTextContent());
            }
        }    
        
        
        return currencies;
        
    }

    public double getRate(String currencyName) throws SAXException, IOException, ParserConfigurationException {
        double d = 0;
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        File fileXML = new File("src/pool_java_project01/CONTROL/conversionRate.xml");

      Document xml = builder.parse(fileXML);        
      final Element racine = xml.getDocumentElement();
        final NodeList racineNoeuds = racine.getChildNodes();
        final int nbRacineNoeuds = racineNoeuds.getLength();        
      for (int i = 0; i < nbRacineNoeuds; i++) {
            if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element currency = (Element) racineNoeuds.item(i);
                final Element nameCurrency = (Element) currency.getElementsByTagName("name").item(0);
                final Element ValueCurrency = (Element) currency.getElementsByTagName("Value").item(0);
                if (nameCurrency.getTextContent().equalsIgnoreCase(currencyName)) {
                     d = Double.parseDouble(ValueCurrency.getTextContent());
                }
            }
        }
       return d;
    }
    
    public String getFlag(String currencyName) throws SAXException, IOException, ParserConfigurationException {
        String f = "";
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        File fileXML = new File("src/pool_java_project01/CONTROL/conversionRate.xml");

      Document xml = builder.parse(fileXML);        
      final Element racine = xml.getDocumentElement();
        final NodeList racineNoeuds = racine.getChildNodes();
        final int nbRacineNoeuds = racineNoeuds.getLength();        
      for (int i = 0; i < nbRacineNoeuds; i++) {
            if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element currency = (Element) racineNoeuds.item(i);
                final Element nameCurrency = (Element) currency.getElementsByTagName("name").item(0);
                final Element ValueCurrency = (Element) currency.getElementsByTagName("flag").item(0);
                if (nameCurrency.getTextContent().equalsIgnoreCase(currencyName)) {
                     f = ValueCurrency.getTextContent();
                }
            }
        }
       return f;
    }
    
    public String convert(String amountOrigin, String currencyOrigin, String currencyTarget) throws SAXException, IOException, ParserConfigurationException {
        double total = 0;

        Currency origin = null;
        Currency target = null;

        boolean b = Pattern.matches("[^a-zA-Z -]*", amountOrigin);
        if (b) {
            
            origin = new Currency(currencyOrigin, getRate(currencyOrigin));
            target = new Currency(currencyTarget, getRate(currencyTarget)); 
            

            total = toResult(origin, target, Double.parseDouble(amountOrigin));
            return Double.toString(total);
        } else{return "O";}
    }
    
    public String convertRevert(String amountOrigin, String currencyOrigin, String currencyTarget) throws SAXException, IOException, ParserConfigurationException {
        double total = 0;

        Currency origin = null;
        Currency target = null;

        boolean b = Pattern.matches("[^a-zA-Z -]*", amountOrigin);
        if (b) {
            
            origin = new Currency(currencyOrigin, getRate(currencyOrigin));
            target = new Currency(currencyTarget, getRate(currencyTarget)); 
            

            total = toResult(origin, target, Double.parseDouble(amountOrigin));
            return Double.toString(total);
        } else{return "O";}
    }
}