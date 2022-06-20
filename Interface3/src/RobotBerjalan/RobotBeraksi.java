/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RobotBerjalan;

/**
 *
 * @author mmahf
 */
public class RobotBeraksi {
    public static void main(String[] args){
        Robot robot = new Robot();
        
        System.out.println("Status Robot Saat Ini: Berhenti");
        robot.RobotBerjalan();
        robot.RobotBerhenti();
        robot.RobotBerjalan();
        robot.RobotMaju();
        robot.RobotBelokKiri();
        robot.RobotBelokKanan();
        robot.RobotMundur();
        robot.RobotBerhenti();
        robot.RobotMaju();
        robot.RobotBerjalan();
        robot.RobotMaju();
        
    }
}
