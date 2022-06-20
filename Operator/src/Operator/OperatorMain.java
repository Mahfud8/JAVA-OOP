/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operator;

/**
 *
 * @author mmahf
 */
public class OperatorMain {
    public static void main(String[] args){
        
        System.out.println("Program Increment dan Decrement");
        In_De_crement in_de_crement = new In_De_crement(); 
        in_de_crement.Increment1();
        in_de_crement.Decrement1();
        in_de_crement.Increment2();
        in_de_crement.Decrement2();
        System.out.println("-------------------------");
        
        System.out.println("Program Operator bit");
        OperatorBit operatorbit = new OperatorBit();
        operatorbit.KaliBagi();
        System.out.println("-------------------------");
        
        System.out.println("Program Operasi Perbandingan");
        OperatorPembanding optrpembanding = new OperatorPembanding();
        optrpembanding.Banding1();
        optrpembanding.Banding2();
    }
}
