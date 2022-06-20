/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change  license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit  template
 */
package AC;

/**
 *
 * @author mmahf
 */
public class AC implements InterfaceAC{
    int StatusAC;
    
    @Override
    public void hidupkan(){
	if (StatusAC == MATI){
            StatusAC = HIDUP;
            System.out.println("Hidupkan AC! --> AC Hidup");
	}else{
            System.out.println("Hidupkan AC! --> AC Sudah Hidup Kok");
        }
    }
    
    @Override
    public void matikan(){
	if (StatusAC == HIDUP){
            StatusAC = MATI;
            System.out.println("Matikan AC! --> AC Mati");
	}else{
            System.out.println("Matikan AC! --> AC Sudah Mati Kok");
	}
    }
    
    @Override
    public void panaskan(){
        if (StatusAC == HIDUP){
            if (StatusAC == DINGIN){
                StatusAC = PANAS;
                System.out.println("Panaskan AC! --> Pemanas AC Hidup");
            }else{
                System.out.println("Panaskan AC! --> Pemanas AC Hidup Kok");
            } 
        }else{
            System.out.println("AC Mati, Hidupkan AC Dulu");
        }
    }

    @Override
    public void dinginkan(){
        if (StatusAC == HIDUP){
            if (StatusAC == PANAS){
                StatusAC = DINGIN;
                System.out.println("Dinginkan AC! --> Pendingin AC Hidup");
            }else{
                System.out.println("Dinginkan AC! --> AC Sudah Mati Kok");
            }
        }else{
            System.out.println("AC Mati, Hidupkan AC Dulu");
        }
    }
    
}
