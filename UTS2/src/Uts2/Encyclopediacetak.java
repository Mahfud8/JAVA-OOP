/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Uts2;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class Encyclopediacetak {
    public static void main(String[] args){
    Scanner inputdata = new Scanner(System.in);
    Encyclopedia ency = new Encyclopedia(0,0,"title","author");

    
    System.out.print("title = ");
        ency.title = inputdata.nextLine();
        
    System.out.print("Author = ");
        ency.author = inputdata.nextLine();
        
    System.out.print("ISBN = ");
        ency.isbn = inputdata.nextInt();
        
    System.out.print("Volume = ");
        ency.volume = inputdata.nextInt();
        
        
    System.out.println("--------------------------------------");
        System.out.println("title = " + ency.getTitle());
        System.out.println("Author = " + ency.getAuthor());  
        System.out.println("ISBN = " + ency.getIsbn());
        System.out.println("Volume = " + ency.getVolume());
    
    }
}
