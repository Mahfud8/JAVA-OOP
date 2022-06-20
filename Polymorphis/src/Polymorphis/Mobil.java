/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphis;

/**
 *
 * @author mmahf
 */
public class Mobil {
    int speed;
    
    void setSpeed(int pertambahanSpeed){
        speed = speed + pertambahanSpeed;
    }
    
    int getSpeed(){
        return speed;
    }
    
    public void tampilkan_speed(){
        System.out.println("Speed "+speed);
    }
}
