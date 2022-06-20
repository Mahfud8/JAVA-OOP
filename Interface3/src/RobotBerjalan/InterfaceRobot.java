/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RobotBerjalan;

/**
 *
 * @author mmahf
 */
public interface InterfaceRobot {
    public static final int BERJALAN=1;
    public static final int BERHENTI=0;

    public static final int MAJU=1;
    public static final int MUNDUR=1;
    
    public static final int BELOK_KANAN=1;
    public static final int BELOK_KIRI=1;
    
    public abstract void RobotBerjalan();
    public abstract void RobotBerhenti();
    
    public abstract void RobotMaju();
    public abstract void RobotMundur();
    
    public abstract void RobotBelokKanan();
    public abstract void RobotBelokKiri();
}
