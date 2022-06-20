/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamjson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author mmahf
 */
public class OutputFile {
    public static void main (String[] args) throws IOException {
       
        byte data;
        OutputStream fout=null;
        String file = "D:\\Output.txt";
        try{
            fout = new FileOutputStream(file);
            System.out.println ("Ketik data yang ingin Anda tulis ke file. Q untuk berhenti");
            data = (byte)System.in.read();
            while(data!=(byte)'Q') {
                fout.write(data);
                data = (byte)System.in.read();
            }
        }catch(FileNotFoundException e) {
            System.out.println("file : " + file + " tidak dapat dibuka atau dibuat.");
        }catch(IOException e) {
            System.out.println("Ekspresi tidak diketahui : " + e);
        }finally {
            if(fout!=null) {
                try{ 
                    fout.close();
                }catch(IOException err) { 
                    System.out.println("Ekspresi tidak diketahui : " + err);
                }
            }
        }
    }
}
