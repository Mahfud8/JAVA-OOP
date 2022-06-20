/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCar2;

/**
 *
 * @author mmahf
 */
public class MyCar2 {
    public String Color;
    public int yearOfProduction;
    
    public void printMyCar(){
        System.out.println("Color : "+ Color);
        System.out.println("Year Of Production : "+ yearOfProduction);
    }
    
    public void turnOnMechine(){
        System.out.println("Mechine is turned ON");
    }
    
    public void changeGear(){
        System.out.println("Change gear");
    }
    
    public void turnOffMechine(){
        System.out.println("Mechine is turned OFF");
    }
}
