/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class Atm {
    int saldo;
    
    
    static Scanner inputdata=new Scanner(System.in);
    
    public void cek_Saldo(){
        System.out.println("Saldo anda adalah : Rp. "+saldo);
    }
    
    public void simpan_Uang(){
        System.out.print("Jumlah Uang Yang Ingin Anda Simpan Rp. ");
        int simpan = inputdata.nextInt();
        
        saldo += simpan;
        System.out.println("Saldo anda adalah Rp." + saldo);
    }
    
    public void ambil_Uang(){
        System.out.print("Jumlah Uang Yang Ingin Anda Ambil Rp. ");
        int ambil = inputdata.nextInt();
        
        saldo -= ambil;
        System.out.println("Saldo anda adalah Rp." + saldo);
    }
    
}
