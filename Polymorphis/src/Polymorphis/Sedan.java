/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Polymorphis;

/**
 *
 * @author mmahf
 */
public class Sedan extends Mobil {
    
    @Override
    void setSpeed(int pertambahanSpeed){
        speed = 4 * pertambahanSpeed;
    }
    
    @Override
    int getSpeed(){
        return speed;
    }
    
    @Override
    public void tampilkan_speed(){
        System.out.println("Kecepatan Sedan jadi\t:"+speed);
    }
}
