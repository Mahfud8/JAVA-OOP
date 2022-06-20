/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Restoran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mmahf
 */
public class RestoranDemo {

    static boolean isRun = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Restoran restoran = new Restoran();

        do {
            System.out.println("========= Menu Utama ========");
            System.out.println("[1] Nasi Goreng");
            System.out.println("[2] Nasi Rawon");
            System.out.println("[3] Nasi Rames");
            System.out.println("[4] Nasi Gudeg");
            System.out.println("[5] Minum Esteh");
            System.out.println("[6] Minum Kopi");
            System.out.println("[7] Hitung Total");
            System.out.println("[8] Keluar");
            System.out.println("==============================");
            System.out.print("PILIH MENU -> ");

            int pilihMenu = Integer.valueOf(input.readLine());
            switch (pilihMenu) {
                case 1:
                    restoran.NasiGoreng();
                    break;
                case 2:
                    restoran.NasiRawon();
                    break;
                case 3:
                    restoran.NasiRames();
                    break;
                case 4:
                    restoran.NasiGudeg();
                    break;
                case 5:
                    restoran.Esteh();
                    break;
                case 6:
                    restoran.Kopi();
                    break;
                case 7:
                    restoran.HitungTotal();
                    System.exit(0);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Silahkan pilih menu 1 - 8");
                    break;
            }
        } while (isRun);
    }
}
