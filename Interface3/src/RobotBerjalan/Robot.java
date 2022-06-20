/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RobotBerjalan;

/**
 *
 * @author mmahf
 */
public class Robot implements InterfaceRobot {
    int StatusRobot;
    
    @Override
    public void RobotBerjalan(){
	if (StatusRobot == BERHENTI){
            StatusRobot = BERJALAN;
            System.out.println("Berjalan! --> Robot Berjalan");
	}else{
            System.out.println("Berjalan! --> Robot Sudah Berjalan");
        }
    }
    
    @Override
    public void RobotBerhenti(){
	if (StatusRobot == BERJALAN){
            StatusRobot = BERHENTI;
            System.out.println("Berhenti! --> Robot Berhenti");
	}else{
            System.out.println("Berhenti! --> Robot Sudah Berhenti");
	}
    }
    
    @Override
    public void RobotMaju(){
        if (StatusRobot == BERJALAN){
            if (StatusRobot == MUNDUR){
                StatusRobot = MAJU;
                System.out.println("Maju! --> Robot Berjalan Maju");
            } 
        }else{
            System.out.println("Robot Berhenti, Jalankan Robot Dulu Untuk Maju");
        }
    }

    @Override
    public void RobotMundur(){
        if (StatusRobot != BERHENTI){
            if (StatusRobot == MAJU){
                StatusRobot = MUNDUR;
                System.out.println("Mundur! --> Robot Berjalan Mundur");
            }
        }else{
            System.out.println("Robot Berhenti, Jalankan Robot Dulu Untuk Mundur");
        }
    }
    
    @Override
    public void RobotBelokKanan(){
        if (StatusRobot == BERJALAN){
            if (StatusRobot == BELOK_KIRI){
                StatusRobot = BELOK_KANAN;
                System.out.println("Belok Kanan! --> Robot Berbelok ke Kanan");
            }
        }else{
            System.out.println("Robot Berhenti, Jalankan Robot Dulu Untuk Maju");
        }
    }

    @Override
    public void RobotBelokKiri(){
        if (StatusRobot == BERJALAN){
            if (StatusRobot == BELOK_KANAN){
                StatusRobot = BELOK_KIRI;
                System.out.println("Belok Kiri! --> Robot Berbelok ke Kiri");
            }
        }else{
            System.out.println("Robot Berhenti, Jalankan Robot Dulu Untuk Mundur");
        }
    }
}
