/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperasiMatematika;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class Matematika {
    double x, y; //x sebbagai angka pertama, y sebagai angka ke dua
    double hasil;
    
    static Scanner inputdata=new Scanner(System.in);
    
    void Penjumlahan() {
        System.out.print("Masukan angka pertama : ");
        x = inputdata.nextDouble();
        System.out.print("Masukan angka kedua : ");
        y = inputdata.nextDouble();
        
        hasil = x + y;
        System.out.println("Penjumlahan : "+x+" + "+y+" = "+hasil);
    }
    void Pengurangan() {
        System.out.print("Masukan angka pertama : ");
        x = inputdata.nextDouble();
        System.out.print("Masukan angka kedua : ");
        y = inputdata.nextDouble();
        
        hasil = x - y;
        System.out.println("Pengurangan : "+x+" - "+y+" = "+hasil);
    }
    void Perkalian() {
        System.out.print("Masukan angka pertama : ");
        x = inputdata.nextDouble();
        System.out.print("Masukan angka kedua : ");
        y = inputdata.nextDouble();
        
        hasil = x * y;
        System.out.println("Perkalian : "+x+" x "+y+" = "+hasil);
    }
    void Pembagian() {
        System.out.print("Masukan angka pertama : ");
        x = inputdata.nextDouble();
        System.out.print("Masukan angka kedua : ");
        y = inputdata.nextDouble();
        hasil = x /y ;
        System.out.println("Pebagian : "+x+" / "+y+" = "+hasil);
    }
}
