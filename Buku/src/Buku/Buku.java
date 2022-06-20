/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buku;

/**
 *
 * @author mmahf
 */
public class Buku {
    String judul, pengarang, penerbit;
    int tahun;
    
    public Buku(String judul, String pengarang, String penerbit, int tahun) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun = tahun;
    }
    
    public void cetakBuku(){
        System.out.println(this.judul+", "+this.pengarang+", "+this.penerbit+", "+this.tahun);
    }
     
}
