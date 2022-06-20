/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negara;

/**
 *
 * @author mmahf
 */
public class NegaraKota{
    public static void main(String[] args){
        String[][]IbukotaNegara = {
            {"Amerika","Inggris","Jepang","Perancis","Indonesia","Iran","Irak"},
            {"Teheran","Bekasi","Jakarta","Bantar Gebang","Tokyo"}
        };
        
        System.out.println("Ibukota "+IbukotaNegara[0][4] +" adalah "+IbukotaNegara[1][2]);
        System.out.println("Ibukota "+IbukotaNegara[0][2] +" adalah "+IbukotaNegara[1][4]);
        System.out.println("Ibukota "+IbukotaNegara[0][5] +" adalah "+IbukotaNegara[1][0]);
    }
}
