/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iostreamjson;

import java.io.IOException;

/**
 *
 * @author mmahf
 */
public class InputConsole {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
	byte[ ] data = new byte[10];
	System.out.println("Ketik 10 buah karakter:");
	System.in.read(data);

	System.out.println("Karakter yang anda ketik adalah:");
	for(int i=0; i<data.length; i++){
            System.out.print((char) data[i]);
            
	}
        System.out.println("");
    }
}
