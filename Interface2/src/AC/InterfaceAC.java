/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AC;

/**
 *
 * @author mmahf
 */
public interface InterfaceAC {
    public static final int HIDUP=1;
    public static final int MATI=0;
    
    public static final int PANAS=1;
    public static final int DINGIN=1;

    public abstract void hidupkan();
    public abstract void matikan();
    
    public abstract void panaskan();
    public abstract void dinginkan();
}
