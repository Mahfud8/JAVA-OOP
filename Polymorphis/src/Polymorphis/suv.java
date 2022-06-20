/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphis;

/**
 *
 * @author mmahf
 */
public class suv extends Mobil {

    @Override
    public void tampilkan_speed() {
        System.out.println("Kecepatan SUV jadi\t:"+speed); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    int getSpeed() {
        return speed; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    void setSpeed(int pertambahanSpeed) {
        speed = 5 * pertambahanSpeed; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
