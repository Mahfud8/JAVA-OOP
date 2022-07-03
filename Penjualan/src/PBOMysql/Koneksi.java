/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PBOMysql;


import java.sql.*;
/**
 *
 * @author mmahf
 */
public class Koneksi {
    Connection conn; 
    Statement stm;
    
    public Koneksi() throws ClassNotFoundException {
        try {

            String url = "jdbc:mysql://localhost/pbo_penjualan";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
           // stm = (Statement) conn.createStatement();

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {

            System.err.println("Koneksi Gagal" + e.getMessage());

        }
      }
    
    //public static void main(String[] args) throws ClassNotFoundException {
    //    Koneksi knn=new Koneksi();
    //}

}