/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mmahf
 */
public class JavaApplication3 {
    static boolean isRun = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    static Scanner inputdata=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    static void showMenu() throws IOException{
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
    }
    static void segitiga(){
       int a, t;
        double luas;
        
        System.out.print("Masukan Alas : ");
        a=inputdata.nextInt();
        System.out.print("Masukan Tinggi : ");
        t=inputdata.nextInt();
        
        luas=0.5*a*t;
        System.out.println("Luas Segitiga : "+luas);
    }
    static void lingkaran(){
     double luas, phi=3.14;
       int r;

       //Input nilai jari-jari
       System.out.print("Masukan Jari-jari : ");
       r=inputdata.nextInt();

       //Menghitung luas lingkaran
       luas=phi*r*r;

       //Tampilkan hasil
       System.out.println("Luas Lingkaran = "+luas);
    }
    static void bujursangkar(){
        int sisi, luas;
        System.out.print("Masukkan panjang sisi persegi: ");
        sisi = inputdata.nextInt();
        luas = sisi * sisi;
        System.out.println("Luas Persegi adalah " + luas);
    }
    static void persegipanjang(){
    int panjang, lebar, luas;
      
        System.out.println("PROGRAM JAVA MENGHITUNG LUAS PERSEGI PANJANG : ");
        System.out.println("-----------------------------------------------");

        System.out.print("Masukan Panjang      : ");
        panjang=inputdata.nextInt();
        System.out.print("Masukan Lebar        : ");
        lebar=inputdata.nextInt();
        
        luas=panjang*lebar;

        System.out.println("Luas Persegi Panjang : "+luas);
    }

    public static void main(String[] args) throws IOException {
     // TODO code application logic here
        do {
            showMenu();
        } while (isRun);
    }
}
