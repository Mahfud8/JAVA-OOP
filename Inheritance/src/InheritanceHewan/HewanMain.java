/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InheritanceHewan;

/**
 *
 * @author mmahf
 */
public class HewanMain {
    public static void main(String[] args){
        classSapi sapi = new classSapi("Sapi","Herbivora","Mooooo",4);
        classAyam ayam = new classAyam("Ayam","Omnivora","Kukuruyuk",2);
        classKucing kucing = new classKucing("Kucing","Karnivora","Meow",4);
        classBebek bebek = new classBebek("Bebek","Omnivora","kweek-kweek",2);
        classKambing kmbng = new classKambing("Kambing","Herbivora","Mbeeekkk",4);
        
        sapi.cetakData();
        ayam.cetakData();
        kucing.cetakData();
        bebek.cetakData();
        kmbng.cetakData();
        
        
    }
    
}
