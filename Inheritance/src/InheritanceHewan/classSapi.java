/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InheritanceHewan;

/**
 *
 * @author mmahf
 */
public class classSapi extends Hewan{

    public classSapi(String nama, String jenis, String suara, int jmlkaki) {
        super(nama, jenis, suara, jmlkaki);
    }
    
    public void cetakData(){
        System.out.println("Nama Hewan  :"+nama);
        System.out.println("jenis Hewan :"+jenis);
        System.out.println("Suara Hewan :"+suara);
        System.out.println("Jumlah Kaki :"+jmlkaki);
        System.out.println("----------------------");
    }
    
}
