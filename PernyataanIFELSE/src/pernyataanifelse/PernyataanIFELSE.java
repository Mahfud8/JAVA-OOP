/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pernyataanifelse;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class PernyataanIFELSE {
    static Scanner inputdata=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int diskon =0;
        int totalBelanja;
        
        System.out.print("Masukan Total Belanja : ");
        totalBelanja = inputdata.nextInt();

        if(totalBelanja >= 100000){
            diskon = totalBelanja/10;
        } else{
            diskon = 0;
        }
	System.out.println("Diskon = " + diskon);

    }
    
}
