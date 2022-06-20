/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author mmahf
 */
public class AdvancedCalcAction {
    static boolean isRun = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    
    public static void main(String[] args) throws IOException {
            Calc calc = new Calc();
            AdvancedCalc advcalc = new AdvancedCalc();
            
        do{
            System.out.println("========= Advanced Calculator ========");
            System.out.println("For Addition press 1");
            System.out.println("For Subtraction press 2");
            System.out.println("For Multiplicationn press 3");
            System.out.println("For Division press 4");
            System.out.println("For Modulo press 5");
            System.out.println("[0] Exit");
            System.out.println("--------------------------------------");
            System.out.print("Enter your choice : ");

            int pilihMenu = Integer.valueOf(input.readLine());
            switch(pilihMenu){
                case 1:
                    calc.addition();
                    break;
                case 2:
                    calc.subtraction();
                    break;
                case 3:
                    calc.multiplication();
                    break;
                case 4:
                    calc.division();
                    break;
                case 5:
                    advcalc.modulo();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        }while (isRun);
    }
}
