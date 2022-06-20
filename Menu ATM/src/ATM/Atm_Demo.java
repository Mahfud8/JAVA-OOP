/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mmahf
 */
public class Atm_Demo {
    static boolean isRun = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        Atm atm = new Atm();
        
        do{
            System.out.println("========= Bank Mahfud ========");
            System.out.println("[1] Cek Saldo");
            System.out.println("[2] Simpan Uang");
            System.out.println("[3] Ambil Uang");
            System.out.println("[4] Keluar");
            System.out.println("==============================");
            System.out.print("PILIH MENU -> ");

            int pilihMenu = Integer.valueOf(input.readLine());
            switch(pilihMenu){
                case 1 -> atm.cek_Saldo();
                case 2 -> atm.simpan_Uang();
                case 3 -> atm.ambil_Uang();
                case 4 -> System.exit(0);
                default -> System.out.println("Silahkan pilih menu 1 - 4");
            }
        }while (isRun);
    }            
}
