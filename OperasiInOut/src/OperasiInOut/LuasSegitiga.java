/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperasiInOut;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class LuasSegitiga {
    static Scanner inputdata=new Scanner(System.in);
    
    public static void main(String[] args){
        double alas, tinggi;
        
        System.out.print("Masukan Alas : ");
        alas = inputdata.nextDouble();
        System.out.print("Masukan Tinggi : ");
        tinggi = inputdata.nextDouble();
        
        double luas = (alas*tinggi)/2;
        System.out.println("Luas Segitiga = "+"("+ alas + " x "+ tinggi+")"+" / 2 = " + luas);
    }         
}
