/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphis;

/**
 *
 * @author mmahf
 */
public class MobilBeraksi {
    public static void aturMobil(Mobil m){
        m.tampilkan_speed();
    }
    
    public static void main(String[] args){
        Mobil mbl1 = new Sedan();
        Mobil mbl2 = new suv();
        Mobil mbl3 = new Truk();
        Mobil mbl4 = new mpv();
        Mobil mbl5 = new Bis();
        
        mbl1.setSpeed(4);
        mbl2.setSpeed(5);
        mbl3.setSpeed(10);
        mbl4.setSpeed(6);
        mbl5.setSpeed(8);
        
        aturMobil(mbl1);
        aturMobil(mbl2);
        aturMobil(mbl3);
        aturMobil(mbl4);
        aturMobil(mbl5);
    }
}
