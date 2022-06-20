/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Restoran;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class Restoran {
    int harga = 5000;
    int total;
    int jml_beli;
    String pilihan = "";
    
    static Scanner inputdata=new Scanner(System.in);
    
    public void NasiGoreng(){
        System.out.print("Jumlah Beli : ");
        jml_beli = inputdata.nextInt();
        String pilihan1 = "Nasi Goreng\t "+ jml_beli+"\n";
        pilihan = pilihan.concat(pilihan1);
        total +=harga*jml_beli;
    }
    
    public void NasiRawon(){
        System.out.print("Jumlah Beli : ");
        jml_beli = inputdata.nextInt();
        String pilihan2 = "Nasi Rawon\t "+ jml_beli+"\n";
        pilihan = pilihan.concat(pilihan2);
        total +=harga*jml_beli;
    }
    
     public void NasiRames(){
        System.out.print("Jumlah Beli : ");
        jml_beli = inputdata.nextInt();
        String pilihan3 = "Nasi Rames\t "+ jml_beli+"\n";
        pilihan = pilihan.concat(pilihan3);
        total +=harga*jml_beli;
    }
    
    public void NasiGudeg(){
        System.out.print("Jumlah Beli : ");
        jml_beli = inputdata.nextInt();
        String pilihan4 = "Nasi Gudeg\t "+ jml_beli+"\n";
        pilihan = pilihan.concat(pilihan4);
        total +=harga*jml_beli;
    }
    
    public void Esteh(){
        System.out.print("Jumlah Beli : ");
        jml_beli = inputdata.nextInt();
        String pilihan5 = "Esteh\t\t "+ jml_beli+"\n";
        pilihan = pilihan.concat(pilihan5);
        total +=harga*jml_beli;
    }
    
    public void Kopi(){
        System.out.print("Jumlah Beli : ");
        jml_beli = inputdata.nextInt();
        String pilihan6 = "Kopi\t\t "+ jml_beli+ "\n";
        pilihan = pilihan.concat(pilihan6);
        total +=harga*jml_beli;
    }
    
    public void HitungTotal(){
        System.out.println("Pilihan Anda ");
        System.out.println("------------------------------");
        System.out.println(pilihan);
        
        System.out.println("------------------------------");
        System.out.println("Total Harga\t : Rp." + total);
     
        System.out.print("TotalBayar\t : Rp.");
        int bayar = inputdata.nextInt();
        
        bayar -= total;
        
        System.out.println("Kembalian\t : Rp." + bayar);
        System.out.println("");
    }
    
}
