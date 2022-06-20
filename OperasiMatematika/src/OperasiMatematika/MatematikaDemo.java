/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperasiMatematika;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author mmahf
 */
public class MatematikaDemo {   
    static boolean isRun = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        Matematika mtk = new Matematika();
        do{
            System.out.println("========= Matematika ========");
            System.out.println("[1] Penjumlahan");
            System.out.println("[2] Pengurangan");
            System.out.println("[3] Perkalian");
            System.out.println("[4] Pembagian");
            System.out.println("[5] Keluar Aplikasi");
            System.out.println("=========ooOOoo========");
            System.out.print("PILIH MENU -> ");

            int pilihMenu = Integer.valueOf(input.readLine());
            switch(pilihMenu){
                case 1 -> mtk.Penjumlahan();
                case 2 -> mtk.Pengurangan();
                case 3 -> mtk.Perkalian();
                case 4 -> mtk.Pembagian();
                case 5 -> System.exit(0);
                default -> System.out.println("Pilihan salah!");
            }
        }while (isRun);
    }            
}
