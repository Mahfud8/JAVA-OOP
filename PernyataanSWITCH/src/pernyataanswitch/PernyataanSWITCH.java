/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pernyataanswitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class PernyataanSWITCH {
    static boolean isRun = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    static Scanner inputdata=new Scanner(System.in);
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        do{
            System.out.println("========= Daftar  Menu ========");
            System.out.println("[1] SotoAyam");
            System.out.println("[2] Gule Kambing");
            System.out.println("[3] Nasi Goreng");
            System.out.println("[0] Exit");
            System.out.print("Pilih Menu Apa -> ");

        int pilihMenu = Integer.valueOf(input.readLine());
	switch(pilihMenu){
	    case 1:
		System.out.println("Menu yang anda pilih adalah Soto Ayam");
		break;
            case 2:
		System.out.println("Menu yang anda pilih adalah Gule Kambing");
		break;
            case 3:
		System.out.println("Menu yang anda pilih adalah Nasi Goreng");
		break;
            case 0:
                System.exit(0);
                break;
            default:
		System.out.println("Silakan Pilih 1, 2 atau 3");
            }
        }while (isRun);
    }
    
}
