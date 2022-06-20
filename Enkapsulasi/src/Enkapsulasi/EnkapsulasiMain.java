/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enkapsulasi;

/**
 *
 * @author mmahf
 */
public class EnkapsulasiMain {
    public static void main (String[] args){
        Enkapsulasi1 ek = new Enkapsulasi1();
        ek.setNama("M.Mahfud");
        ek.setNim("A11.2020.13018");
        ek.setUsia(21);
        ek.setJeniskelamin("Laki-laki");
        ek.setAlamat("Magelung RT04/01, Kaliwungu Selatan, Kendal, Jawa Tengah");
        
        System.out.println("Nama            : " + ek.getNama());
        System.out.println("NIM             : " + ek.getNim());
        System.out.println("Usia            : " + ek.getUsia());
        System.out.println("Jenis Kelamin   : " + ek.getJeniskelamin());
        System.out.println("Alamat          : " + ek.getAlamat());
    }
}
