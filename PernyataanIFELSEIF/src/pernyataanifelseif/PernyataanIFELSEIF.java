/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pernyataanifelseif;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class PernyataanIFELSEIF {
    static Scanner inputdata=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int skorUjian; char nilai;
        
        System.out.print("Masukan Skor Ujian : ");
        skorUjian = inputdata.nextInt();
                
        if (skorUjian >= 90) {
            nilai = 'A';
        } else if (skorUjian >= 80) {
            nilai = 'B';
        } else if (skorUjian >= 70) {
            nilai = 'C';
        } else {
            nilai = 'D';
        }
        System.out.println("Nilai untuk skor ujian "+ skorUjian +" adalah " + nilai);
    }
    
}
