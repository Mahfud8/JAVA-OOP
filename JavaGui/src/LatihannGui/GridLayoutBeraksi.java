/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihannGui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mmahf
 */
public class GridLayoutBeraksi extends JFrame {
    JButton marcia = new JButton("Marcia");
    JButton carol = new JButton("Carol");
    JButton greg = new JButton("Greg");
    JButton jan = new JButton("Jan");
    JButton alice = new JButton("Alice");
    //JButton( Alice );
    JButton peter = new JButton("Peter");
    JButton cindy = new JButton("Cindy");
    JButton mike = new JButton("Mike");
    JButton bobby = new JButton("Bobby");
    
    public GridLayoutBeraksi() {
	super(" Grid Layout Beraksi ");
	setSize(260, 260);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel pane = new JPanel();
        GridLayout family = new
        GridLayout(3, 3, 10, 10);

        pane.setLayout(family);
        pane.add(marcia); pane.add(carol);
        pane.add(greg); pane.add(jan);
        pane.add(alice); pane.add(peter);
        pane.add(cindy); pane.add(mike);
        pane.add(bobby);

        add(pane);
        setVisible(true);
}

public static void main(String[] args) {
       GridLayoutBeraksi frame = new GridLayoutBeraksi();
        }
}

