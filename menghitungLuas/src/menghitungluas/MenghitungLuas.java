/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menghitungluas;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mmahf
 */
public class MenghitungLuas {
    static boolean isRun = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    static Scanner inputdata=new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        do{
            System.out.println("========= Kalkulator Luas ========");
            System.out.println("[1] Segitiga");
            System.out.println("[2] Lingkaran");
            System.out.println("[3] Bujur Sangkar");
            System.out.println("[4] Persegi Panjang");
            System.out.println("[0] Exit");
            System.out.println("=========ooOOoo========");
            System.out.print("PILIH MENU -> ");

            int pilihMenu = Integer.valueOf(input.readLine());
            switch(pilihMenu){
                case 1:
                    segitiga();
                    break;
                case 2:
                    lingkaran();
                    break;
                case 3:
                    bujursangkar();
                    break;
                case 4:
                    persegipanjang();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        }while (isRun);
    }
         
    static void segitiga(){
        int alas, tinggi;
        double luas;
        
        System.out.print("Masukan Alas : ");
        alas = inputdata.nextInt();
        System.out.print("Masukan Tinggi : ");
        tinggi = inputdata.nextInt();
        
        luas = 0.5*alas*tinggi;
        
        System.out.println("Luas Segitiga : "+luas);
    }
    static void lingkaran(){
        double luas, phi=3.14;
        int r;

        System.out.print("Masukan Jari-jari : ");
        r = inputdata.nextInt();

        luas = phi*r*r;
        
        System.out.println("Luas Lingkaran : "+luas);
    }
    static void bujursangkar(){
        int sisi, luas;
        System.out.print("Masukkan panjang sisi: ");
        sisi = inputdata.nextInt();
        
        luas = sisi * sisi;
        
        System.out.println("Luas BujurSangkar adalah " + luas);
    }
    static void persegipanjang(){
        int panjang, lebar, luas;

        System.out.print("Masukan Panjang : ");
        panjang = inputdata.nextInt();
        System.out.print("Masukan Lebar : ");
        lebar = inputdata.nextInt();
      
        luas = panjang * lebar;
        
        System.out.println("Luas Persegi Panjang : "+luas);
    }
}
