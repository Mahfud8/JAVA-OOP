/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceLampu;

/**
 *
 * @author mmahf
 */
interface InterfaceLampu{
    public static final int KEADAAN_HIDUP=1;
    public static final int KEADAAN_MATI=0;

    public abstract void hidupkan();
    public abstract void matikan();
}
