/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class Calc {
    static Scanner inputdata=new Scanner(System.in);
    
    protected double result = 0;
    protected double operand1 = 0;
    protected double operand2 = 0;


    protected void setOperand1(double operand1) {
        this.operand1 = operand1;
    }
    
    protected void setOperand2(double operand2) {
        this.operand2 = operand2;
    }
        
    protected double getOperand1() {
        return operand1;
    }

    protected double getOperand2() {
        return operand2;
    }

    protected double addition(){
        System.out.println("======================================");
        System.out.print("Enter Fist Number = ");
        operand1 = inputdata.nextInt();
        System.out.print("Second Fist Number = ");
        operand2 = inputdata.nextInt();
        
        result = operand1 + operand2;
        
        System.out.println(operand1+"+"+operand2+"="+result);
        System.out.println("======================================");
        return result;
    }
    protected double subtraction(){
        System.out.println("======================================");
        System.out.print("Enter Fist Number = ");
        operand1 = inputdata.nextInt();
        System.out.print("Second Fist Number = ");
        operand2 = inputdata.nextInt();
        
        result = operand1 - operand2;
        System.out.println(operand1+"-"+operand2+"="+result);
        System.out.println("======================================");
        return result;
    }
    
    protected double multiplication(){
        System.out.println("======================================");
        System.out.print("Enter Fist Number = ");
        operand1 = inputdata.nextInt();
        System.out.print("Second Fist Number = ");
        operand2 = inputdata.nextInt();
        
        result = operand1 * operand2;
        System.out.println(operand1+"x"+operand2+"="+result);
        System.out.print("======================================");
        return result;
    }
    protected double division(){
        System.out.println("======================================");
        System.out.print("Enter Fist Number = ");
        operand1 = inputdata.nextInt();
        System.out.print("Second Fist Number = ");
        operand2 = inputdata.nextInt();
        
        result = operand1 / operand2;
        System.out.println(operand1+"/"+operand2+"="+result);
        System.out.println("======================================");
        return result;
    }
}
