/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihannGui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author mmahf
 */
public class CardLayoutBeraksi extends JFrame {
    public static void main(String[] args){
	JFrame frame = new JFrame("Card Layout Beraksi");
	JPanel panel1 = new JPanel(); 
        JPanel panel2 = new JPanel();
	JButton button = new JButton("Button dalam panel ke 1");
	//JT tA t t JT tA ("T t d l l k 2")
	JTextArea text = new JTextArea("Text dalam panel ke 2");
	panel1.add(button); 
        panel2.add(text);
	JTabbedPane tab = new JTabbedPane();
	tab.add(panel1, "Tab 1"); 
        tab.add(panel2, "Tab 2");
	frame.getContentPane().add(tab,BorderLayout.NORTH);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack(); 
        frame.setVisible(true);
    }
    
}
