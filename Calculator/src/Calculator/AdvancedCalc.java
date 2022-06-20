/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

/**
 *
 * @author mmahf
 */
public class AdvancedCalc extends Calc{
    public double modulo(){
        System.out.println("======================================");
        System.out.print("Enter Fist Number = ");
        operand1 = inputdata.nextInt();
        System.out.print("Second Fist Number = ");
        operand2 = inputdata.nextInt();
        
        result = operand1 % operand2;
        System.out.println(operand1+"%"+operand2+"="+result);
        System.out.println("======================================");
        return result;
    }
    
}
