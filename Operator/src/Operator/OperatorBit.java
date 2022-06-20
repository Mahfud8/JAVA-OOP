/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operator;

/**
 *
 * @author mmahf
 */
public class OperatorBit extends Operator {
    int n;
    double hasil_1, hasil_2;
        
    public void KaliBagi(){
        //Program kali dan bagi 2
        //Catatan hasil = x >> n = x/2.n
        x = 10;
        n = 2;
        hasil_1 = x >> n;
        System.out.println("hasil x >> n : "+hasil_1);
        hasil_2 = x << n;
        System.out.println("hasil x << n : "+hasil_2);
        
    }
}
