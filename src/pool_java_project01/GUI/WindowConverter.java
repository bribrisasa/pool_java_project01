package pool_java_project01.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import pool_java_project01.CONTROL.Converter;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class WindowConverter {

    private JFrame frame;
    private final JLabel title = new JLabel("The Original Converter");
    private JTextField amountBeforeConvert;
    private JLabel resultLabel;
    private JLabel lblNewLabel_1;
    String result;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WindowConverter window = new WindowConverter();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public WindowConverter() throws SAXException, IOException, ParserConfigurationException {
        initialize();
    }

    private void initialize() throws SAXException, IOException, ParserConfigurationException {
        
        Converter converter = new Converter(this);
        
        
        frame = new JFrame();
        frame.setBounds(100, 100, 291, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        title.setBounds(6, 6, 279, 40);
        frame.getContentPane().add(title);
        
        JComboBox currencyOrigin = new JComboBox();
        currencyOrigin.setModel(new DefaultComboBoxModel(converter.currenciesList()));
        currencyOrigin.setBounds(26, 96, 110, 27);
        frame.getContentPane().add(currencyOrigin);
        
        JComboBox currencyTarget = new JComboBox();
        
        currencyTarget.setBounds(148, 96, 110, 27);
        frame.getContentPane().add(currencyTarget);
        currencyTarget.setModel(new DefaultComboBoxModel(converter.currenciesList()));

        amountBeforeConvert = new JTextField();
        amountBeforeConvert.setBounds(29, 58, 227, 26);
        frame.getContentPane().add(amountBeforeConvert);
        amountBeforeConvert.setColumns(10);
        
        JButton goConvert = new JButton("Convert");
        goConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					result = converter.convert(amountBeforeConvert.getText(), currencyOrigin.getSelectedItem().toString(), currencyTarget.getSelectedItem().toString());
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                resultLabel.setText(result);
            }
        });
        
        
        goConvert.setBounds(26, 135, 117, 29);
        frame.getContentPane().add(goConvert);
        
        resultLabel = new JLabel("Result");
        
        resultLabel.setBounds(171, 140, 61, 16);
        frame.getContentPane().add(resultLabel);
        
        lblNewLabel_1 = new JLabel(">");
        lblNewLabel_1.setBounds(136, 100, 61, 16);
        frame.getContentPane().add(lblNewLabel_1);
    }
}