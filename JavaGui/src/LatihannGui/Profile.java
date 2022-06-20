/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihannGui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 *
 * @author mmahf
 */
public class Profile extends JFrame {

    public Profile() {
        super("Informasi Profile");
	setSize(500, 200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextArea text = new JTextArea(" Nama\t: Muhammad Mahfud\n NIM\t: A11.2020.13018\n Kelas\t: A11.4401\n\n"
                + " Saya merupakan mahasiswa Teknik Informatika Udinus yang sedang belajar\n JavaGUI dalam mata kuliah PBO.");
	getContentPane().add(text);

        setVisible(true);
    }
    public static void main(String[] arguments) {
	Profile frame= new Profile();
    }
}
      

