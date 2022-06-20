/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihannGui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author mmahf
 */
public class ButtonBeraksi extends JFrame {
	JButton load = new JButton("Load");
	JButton save = new JButton("Save");
	public ButtonBeraksi() {
		super("Button Beraksi");
		setSize(140, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(load);
		pane.add(save);
		add(pane);
		setVisible(true);
	}
	public static void main(String[] arguments) {
		ButtonBeraksi button = new ButtonBeraksi();
        }
}

