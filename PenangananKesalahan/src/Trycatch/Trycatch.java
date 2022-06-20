/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trycatch;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class Trycatch {
    static Scanner inputdata=new Scanner(System.in);
     
    public static void Pembagian(){
        try{
            System.out.print("Masukan angka pertama : ");
            int x = inputdata.nextInt();
            System.out.print("Masukan angka kedua : ");
            int y = inputdata.nextInt();
            double hasil = x/y ;
            System.out.println("Hasil Pembagian : "+x+" / "+y+" = "+hasil);
            int[] Arr = {0,1,2,3,4,5};
            //Arr[10] = 23; //indeks ke 10
            System.out.println("Tidak terjadi eksepsi");
	}catch(ArithmeticException e){
            System.out.println("Terdapat pembagian dengan nol" +e.getMessage());
	}catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Indeks di luar kapasitas");
	}finally{
            System.out.println("Bagian finally");
	}
            System.out.println("Selesai");
    }
     
    public static void main(String[] args){
        Pembagian();
        
    }

}
