/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author mmahf
 */
public class Koneksi {
    Connection conn; 
    Statement stm;
    
    public Koneksi() throws ClassNotFoundException {
        try {
            String url = "jdbc:mysql://localhost/db_perhotelan";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            stm = (Statement) conn.createStatement();

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {

            System.err.println("Koneksi Gagal" + e.getMessage());

        }  
    }
    
    //public static void main(String[] args) throws ClassNotFoundException {
    //    Koneksi knn=new Koneksi();
    //}
}
