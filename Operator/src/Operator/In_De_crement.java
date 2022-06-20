/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operator;

/**
 *
 * @author mmahf
 */
public class In_De_crement extends Operator{
    int w; 
    
    public void Increment1(){
        System.out.println("Increment/Penjumlahan 1");
        x = 42;
        y = x++;
        //menampilkan x,y
        System.out.println("x = " + x + "," + " y = " + y );

        z = ++x;
        //menampilkan x,z
        System.out.println("x = " + x + "," + " z = " + z );
    }

    public void Decrement1(){
        System.out.println("Decrement/Pengurangan 1");
        x = 42;
        y = x--;
        //menampilkan x,y saat ini
        System.out.println("x = " + x + "," + " y = " + y );
        
        z = --x;
        //menampilkan x,z saat ini
        System.out.println("x = " + x + "," + " z = " + z );
        
    }
        
    public void Increment2(){
        System.out.println("Increment/Penjumlahan 2");
        x = 5;
        w = 5;
        y = 8 - x++;
        //menampilkan w,x,y
        System.out.println("w = " + w + "," + " x = " + x + "," + " y = " + y );
        
        z = 8 - ++x;
        //menampilkan w,x,z
        System.out.println("w = " + w + "," + " x = " + x + "," + " z = " + z );
        }

        public void Decrement2(){
        System.out.println("Decrement/Pengurangan 2");
        x = 5;
        w = 5;
        y = 8 - x--;
        //menampilkan w,x,y saat ini
        System.out.println("w = " + w + "," + " x = " + x + "," + " y = " + y );

        z = 8- --x;
        //menampilkan w,x,z saat ini
        System.out.println("w = " + w + "," + " x = " + x + "," + " z = " + z );
        
    }     
}

