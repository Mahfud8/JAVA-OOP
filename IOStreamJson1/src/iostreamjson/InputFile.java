/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamjson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author mmahf
 */
public class InputFile {
    public static void main(String[] args) {
        
            byte data;
            FileInputStream fin = null;
            String file = "D:\\Input.txt";    

            try{
                fin = new FileInputStream(file);
                do{
                    data = (byte)fin.read();
                    System.out.print((char)data);
                }while(data!=-1);

            }catch(FileNotFoundException e){
                System.out.println("File: " + file + "tidak ditemukan.");
            }catch(IOException e){
                System.out.println("Ekspresi tidak diketahui : " + e) ;
            }finally{
                if(fin!=null){
                    try{ 
                        fin.close();
                    }catch(IOException err){ 
                        System.out.println("Ekspresi tidak diketahui : " + err);
                    }
                }
            }
        }
}

