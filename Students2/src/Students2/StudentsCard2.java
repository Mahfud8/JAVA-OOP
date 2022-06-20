/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Students2;

import java.util.Scanner;
/**
 *
 * @author mmahf
 */
public class StudentsCard2 {
    
    
    public static void main(String[] args){
        Scanner inputdata = new Scanner(System.in);
        Students2 students2 = new Students2("nama", "nim");
        
        System.out.print("Student Name = ");
        students2.nama = inputdata.nextLine();
        
        System.out.println("Student Number Format = xxx.xxxx.xxxxx");
        System.out.print("Student Number = ");
        students2.nim = inputdata.nextLine();
        
        System.out.println("--------------------------------------");
        System.out.println("Student Name : " + students2.getNama());
        System.out.println("Student Number : " + students2.getNim());
        
    }
}
