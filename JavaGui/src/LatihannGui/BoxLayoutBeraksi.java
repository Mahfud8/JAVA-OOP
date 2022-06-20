/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihannGui;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mmahf
 */
public class BoxLayoutBeraksi extends JFrame {
    public BoxLayoutBeraksi() {
	super("BoxLayoutBeraksi"); setSize(430, 150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel commandPane = new JPanel();
	BoxLayout horizontal = new
	BoxLayout(commandPane,BoxLayout.X_AXIS);
	commandPane.setLayout(horizontal);
	JButton subscribe = new JButton("Subscribe");
	JButton unsubscribe = new
	JButton("Unsubscribe");
	JButton refresh = new JButton("Refresh");
	commandPane.add(subscribe);
	commandPane.add(unsubscribe);
	commandPane.add(refresh);
	add(commandPane);
        setVisible(true);
    }
    
    public static void main(String[] args) {
	BoxLayoutBeraksi st = new BoxLayoutBeraksi();
    }
}


