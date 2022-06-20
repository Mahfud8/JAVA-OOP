/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamjson;

import java.io.IOException;

/**
 *
 * @author mmahf
 */
public class OutputConsole {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{

        byte[] data = {'a','b','c','d','e','f','g'};

        System.out.write(data,3,4);
        System.out.write('\n');
        System.out.write(data);
    }
}
