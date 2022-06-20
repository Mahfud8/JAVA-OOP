/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pernyataanswitch2;


import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class PernyataanSWITCH2 {
    static Scanner inputdata=new Scanner(System.in);
      
    /**
     * @param args the command line arguments

     */
    public static void main(String[] args)  {
        // TODO code application logic here
        int bulan, hari = 0, tahun;
        
        System.out.print("Masukan Tahun : ");
        tahun = inputdata.nextInt();
        
        System.out.print("Masukan Bulan : ");    
        bulan = inputdata.nextInt();
        
	switch(bulan){
	    case 1 -> hari = 31;
            case 2 -> {
                if (((tahun % 4 == 0) && ! (tahun % 100 == 0))
                        || (tahun % 400 == 0))
                    hari = 29;
                else 
                    hari = 28;
            }
            case 3 -> hari = 31;
            case 4 -> hari = 30;
            case 5 -> hari = 31;
            case 6 -> hari = 30;
            case 7 -> hari = 31;
            case 8 -> hari = 31;
            case 9 -> hari = 31;
            case 10 -> hari = 31;
            case 11 -> hari = 30;
            case 12 -> hari = 31;
            default -> System.out.println("Silakan masukan bulan 1 - 12");
        }
        System.out.println("Jumlah hari pada tahun "+tahun+" bulan "+bulan+" adalah "+hari+" hari");
    }
}

