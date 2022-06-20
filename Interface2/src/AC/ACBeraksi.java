/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AC;

/**
 *
 * @author mmahf
 */
public class ACBeraksi {
    public static void main(String[] args){
        AC ac = new AC();

        System.out.println("Status AC Saat Ini: Mati");

        ac.hidupkan(); //Hidupkan AC
        ac.panaskan();
        ac.dinginkan();
        ac.matikan(); //Matikan AC
        ac.dinginkan();
        ac.panaskan();
        ac.hidupkan();
        ac.hidupkan();
        ac.matikan();
        ac.matikan();
        ac.hidupkan();
        ac.dinginkan();
    }
}
