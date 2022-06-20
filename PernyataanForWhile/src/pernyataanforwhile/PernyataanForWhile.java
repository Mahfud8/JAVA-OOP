/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pernyataanforwhile;

/**
 *
 * @author mmahf
 */
public class PernyataanForWhile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Pernyataan For");
        int x;
        for(x=2; x<21; x++){
            if (x % 2 == 0)
            System.out.println(x);
        }
        System.out.println("---------------");
        
        
        System.out.println("Pernyataan While");
        int y = 2;
	while (y < 21) {
            System.out.println(y);
            y+=2;
	}
        System.out.println("---------------");

    }
    
}
