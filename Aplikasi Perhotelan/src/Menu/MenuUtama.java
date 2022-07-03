/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mmahf
 */
public class MenuUtama extends javax.swing.JFrame {
    private DefaultTableModel tmodel;
    Connection conn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet res;
    /**
     * Creates new form MenuUtama
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public MenuUtama() throws ClassNotFoundException, SQLException {
        initComponents();
        Koneksi db = new Koneksi();
        conn = db.conn;
        stm = conn.createStatement();
        
        kodetamu();
        
        tampil_datakamar();
        tampil_datatamu();
        
        tampil_datacheckin();
        tampil_datacheckout();
        
        tampil_datalapcheckin();
        tampil_datalapcheckout();
        tampil_datakeuangan();
    }
    
    
    //DATA KAMAR
   
    private void tampil_datakamar() throws SQLException{
        tmodel = new DefaultTableModel();

        tmodel.addColumn("Kode");
        tmodel.addColumn("Nama");
        tmodel.addColumn("Kelas");
        tmodel.addColumn("Harga");
        tmodel.addColumn("Fasilitas");
        tmodel.addColumn("jumlah_kamar");

        tablekamar.setModel(tmodel);
        
        stm = conn.createStatement();
        res = stm.executeQuery("select * from kamar");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("Kode_kamar"),
                res.getString("Nama_kamar"),
                res.getString("Kelas"),
                res.getString("Harga"),
                res.getString("Fasilitas"),
                res.getString("jumlah_kamar"),
            });
        }
    }
    
    private void kosongkan_datakamar(){
        kodekamar.setText("");
        namakamar.setText("");
        kelas.setText("");
        harga.setText("");
        fasilitas.setText("");
        jmlkamar.setText("");
    }
    
    private void save_datakamar() throws SQLException{
        pstm = conn.prepareStatement("insert into kamar"
                + "(Kode_kamar, Nama_kamar, Kelas, Harga, Fasilitas, Jumlah_kamar)"
                + "values ('"+kodekamar.getText()+"', '"+namakamar.getText()+"', '"+kelas.getText()
                + "', '"+harga.getText()+"','"+fasilitas.getText()+"', '"+jmlkamar.getText()+"')");
            
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Simpan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Simpan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    private void update_datakamar() throws SQLException{
        pstm = conn.prepareStatement("update kamar set Nama_kamar='"+namakamar.getText()
                + "', Kelas='"+kelas.getText()+"', "
                + "Harga='"+harga.getText()+"',"
                + "Fasilitas='"+fasilitas.getText()+"', "
                + "jumlah_kamar='"+jmlkamar.getText()+"' "
                + "where Kode_kamar = '"+kodekamar.getText()+"'");
                
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Update sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Update gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void delete_datakamar() throws SQLException{ 
        pstm = conn.prepareStatement("delete from kamar where kode_kamar = '"+kodekamar.getText()+"'");
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    
    //DATA TAMU
    private void tampil_datatamu() throws SQLException{
        tmodel = new DefaultTableModel();

        tmodel.addColumn("Kode");
        tmodel.addColumn("Nama");
        tmodel.addColumn("Jenis Kelamin");
        tmodel.addColumn("Usia");
        tmodel.addColumn("Alamat");

        tabletamu.setModel(tmodel);
                
        stm = conn.createStatement();
        res = stm.executeQuery("select * from tamu");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("Kode_tamu"),
                res.getString("Nama_tamu"),
                res.getString("Jns_kel"),
                res.getString("Usia"),
                res.getString("Alamat"),
            });
        }
    }
    
    private void kosongkan_datatamu(){
        kodetamu.setText("");
        namatamu.setText("");
        jeniskelamin.setText("");
        usia.setText("");
        alamat.setText("");
    }
    
    private void save_datatamu() throws SQLException{
        pstm = conn.prepareStatement("insert into tamu"
                + "(kode_tamu, nama_tamu, Jns_kel, usia, alamat)"
                + "values ('"+kodetamu.getText()+"', '"+namatamu.getText()+"', '"+jeniskelamin.getText()
                + "', '"+usia.getText()+"','"+alamat.getText()+"')");
                    
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Simpan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Simpan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    private void update_datatamu() throws SQLException{
         pstm = conn.prepareStatement("update tamu set nama_tamu='"+namatamu.getText()
                + "', Jns_kel='"+jeniskelamin.getText()+"', "
                + "usia='"+usia.getText()+"',"
                + "alamat='"+alamat.getText()+"'  "
                + "where kode_tamu = '"+kodetamu.getText()+"'");
                
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Update sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Update gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void delete_datatamu() throws SQLException{ 
        pstm = conn.prepareStatement("delete from tamu where kode_tamu = '"+kodetamu.getText()+"'");
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    //CHECK IN
    private void tampil_datacheckin() throws SQLException{
        tmodel = new DefaultTableModel();
        
        tmodel.addColumn("Kode Tamu");
        tmodel.addColumn("Nama Tamu");
        tmodel.addColumn("Kode Kamar");
        tmodel.addColumn("Kelas");
        tmodel.addColumn("LamaInap");
        tmodel.addColumn("Herga");
        tmodel.addColumn("Total");

        tablecheckin.setModel(tmodel);
                
        stm = conn.createStatement();
        res = stm.executeQuery("select * from temporary_checkin");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("Kode_tamu"),
                res.getString("Nama_tamu"),
                res.getString("Kode_kamar"),
                res.getString("Kelas_kamar"),
                res.getString("Lama_inap"),
                res.getString("Harga"),
                res.getString("Total_harga"),
            });
        }
    }
    
    private void kosongkan_datacheckin(){
        kodetamuin.setText("");
        namatamuin.setText("");
        kodekamarin.setText("");
        kelasin.setText("");
        fasilitasin.setText("");
        lamainap.setText("");
        hargain.setText("");
        totalin.setText("");
    }
    
    private void simpan_datacheckin() throws SQLException{
        res = stm.executeQuery("SELECT * FROM tamu WHERE kode_tamu='" +kodetamuin.getText()+"'");
        while (res.next()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(tglcheckin.getDate());
                      
            SimpleDateFormat stf = new SimpleDateFormat("H:mm:ss");
            String waktu = stf.format(waktucheckin.getValue());
         
            pstm = conn.prepareStatement("insert into temporary_checkin"
                    + "(kode_tamu, nama_tamu, Jns_kel, usia, tgl_checkin, jam_checkin, kode_kamar, "
                    + "kelas_kamar, harga, lama_inap, fasilitas, total_harga)"
                    + "values ('"+kodetamuin.getText()+ "', '"+res.getString("Nama_Tamu")+"', '" +res.getString("Jns_kel")
                    + "', '"+res.getString("Usia")+"', '" +date+ "', '" +waktu+"', '" +kodekamarin.getText()+"', '" +kelasin.getText()
                    + "', '"+hargain.getText()+"', '"+lamainap.getText()+"', '"+ fasilitasin.getText()+"','"+totalin.getText()+"')");

            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Simpan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Simpan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                pstm.close();
            }
        }
    }
    
    
    private void delete_datacheckin() throws SQLException{
        try {
            boolean hapus = stm.execute("delete from temporary_checkin");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "kesalahan"+err);
        }   
    }
    
    //CHECK OUT
    private void tampil_datacheckout() throws SQLException{
        tmodel = new DefaultTableModel();
        
        tmodel.addColumn("Kode Tamu");
        tmodel.addColumn("Nama Tamu");
        tmodel.addColumn("Kode Kamar");
        tmodel.addColumn("Kelas");
        tmodel.addColumn("LamaInap");
        tmodel.addColumn("Herga");
        tmodel.addColumn("Total");

        tablecheckout.setModel(tmodel);
                
        stm = conn.createStatement();
        res = stm.executeQuery("select * from temporary_checkout");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("Kode_tamu"),
                res.getString("Nama_tamu"),
                res.getString("Kode_kamar"),
                res.getString("Kelas_kamar"),
                res.getString("Lama_inap"),
                res.getString("Harga"),
                res.getString("Total_harga"),
            });
        }
    }
    
    private void kosongkan_datacheckout(){
        kodetamuout.setText("");
        namatamuout.setText("");
        kodekamarout.setText("");
        kelasout.setText("");
        fasilitasout.setText("");
        lamainapout.setText("");
        hargaout.setText("");
        totalout.setText("");
    }
    
    private void simpan_datacheckout() throws SQLException{
        res = stm.executeQuery("SELECT * FROM tamu WHERE kode_tamu='" +kodetamuout.getText()+"'");
        while (res.next()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(tglcheckout.getDate());
                      
            SimpleDateFormat stf = new SimpleDateFormat("H:mm:ss");
            String waktu = stf.format(waktucheckout.getValue());
         
            pstm = conn.prepareStatement("insert into temporary_checkout"
                    + "(kode_tamu, nama_tamu, Jns_kel, usia, tgl_checkout, jam_checkout, kode_kamar, "
                    + "kelas_kamar, harga, lama_inap, fasilitas, total_harga)"
                    + "values ('"+kodetamuout.getText()+ "', '"+res.getString("Nama_Tamu")+"', '" +res.getString("Jns_kel")
                    + "', '"+res.getString("Usia")+"', '" +date+ "', '" +waktu+"', '" +kodekamarout.getText()+"', '" +kelasout.getText()
                    + "', '"+hargaout.getText()+"', '"+lamainapout.getText()+"', '"+ fasilitasout.getText()+"','"+totalout.getText()+"')");

            if (pstm.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Simpan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Simpan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                pstm.close();
            }
        }
    }
    
    private void savedatacheckouttolapCheckout()throws SQLException{
        try {
            stm = conn.createStatement();
            res = stm.executeQuery("select * from temporary_checkout");
            while (res.next()) {
                pstm = conn.prepareStatement("insert into cek_out"
                    + "(Kode_tamu, tgl_checkout, Jam_checkout, Kode_kamar, Lama_inap)"
                    + "values ( '"+res.getString("Kode_tamu")+"', '"+res.getString("Tgl_checkout")+"', '"+res.getString("Jam_checkout")+"',"
                    + " '"+res.getString("Kode_kamar")+"','"+res.getString("Lama_inap")+"')");
                
                if (pstm.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this, "Simpan Check Out Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Simpan Check Out gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    pstm.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void savedatacheckouttokeuangan()throws SQLException{
        try {
            stm = conn.createStatement();
            res = stm.executeQuery("select * from temporary_checkout");
            while (res.next()) {
                pstm = conn.prepareStatement("insert into keuangan"
                    + "(Kode_tamu, Kode_kamar, Lama_inap, Harga, Total_harga)"
                    + "values ( '"+res.getString("Kode_tamu")+"','"+res.getString("Kode_kamar")+"','"+res.getString("Lama_inap")
                    +"','"+res.getString("Harga")+"','"+res.getString("Total_harga")+"')");
                
                if (pstm.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this, "Simpan Check Out Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Simpan Check Out gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    pstm.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delete_datacheckout() throws SQLException{
        try {
            boolean hapus = stm.execute("delete from temporary_checkout");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "kesalahan"+err);
        }   
    }
    
    //Laporan Check In
    private void tampil_datalapcheckin()throws SQLException{
        tmodel = new DefaultTableModel();
        
        tmodel.addColumn("Kode Tamu");
        tmodel.addColumn("Tanggal Check IN");
        tmodel.addColumn("Jam Check IN");
        tmodel.addColumn("Kode Kamar");
        tmodel.addColumn("Posisi Kamar");


        tablelaporancheckin.setModel(tmodel);
                
        stm = conn.createStatement();
        res = stm.executeQuery("select * from cek_in");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("Kode_tamu"),
                res.getString("Tgl_checkin"),
                res.getString("JAm_checkin"),
                res.getString("Kode_kamar"),
                res.getString("Posisi_kamar"),
            });
        }
    }
    
    private void kosongkan_datalapcheckin(){
        kodetamulapin.setText("");
        waktulapcheckin.setValue("");
        kodekamarlapin.setText("");
        posisikamarlapin.setText("");
    }
    
    private void update_datalapcheckin()throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(tgllapcheckin.getDate());
                      
            SimpleDateFormat stf = new SimpleDateFormat("H:mm:ss");
            String waktu = stf.format(waktulapcheckin.getValue());
            
        pstm = conn.prepareStatement("update cek_in set Tgl_checkin='"+date
                + "', Jam_checkin='"+waktu+"', "
                + "Kode_kamar='"+kodekamarlapin.getText()+"',"
                + "Posisi_kamar='"+posisikamarlapin.getText()+"'  "
                + "where kode_tamu = '"+kodetamulapin.getText()+"'");
                
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Update sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Update gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void delete_datalapcheckin()throws SQLException{
        pstm = conn.prepareStatement("delete from cek_in where kode_tamu = '"+kodetamulapin.getText()+"'");
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    
    //Laporan Check Out
    private void tampil_datalapcheckout()throws SQLException{
        tmodel = new DefaultTableModel();
        
        tmodel.addColumn("Kode Tamu");
        tmodel.addColumn("Tanggal Check Out");
        tmodel.addColumn("Jam Check Out");
        tmodel.addColumn("Kode Kamar");
        tmodel.addColumn("Lama Inap");


        tablelaporancheckout.setModel(tmodel);
                
        stm = conn.createStatement();
        res = stm.executeQuery("select * from cek_out");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("Kode_tamu"),
                res.getString("tgl_checkout"),
                res.getString("Jam_checkout"),
                res.getString("Kode_kamar"),
                res.getString("Lama_inap"),
            });
        }
    }
    
    private void kosongkan_datalapcheckout(){
        kodetamulapout.setText("");
        waktulapcheckout.setValue("");
        kodekamarlapout.setText("");
        lamainapout.setText("");
    }
    
    private void update_datalapcheckout()throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(tgllapcheckout.getDate());
                      
            SimpleDateFormat stf = new SimpleDateFormat("H:mm:ss");
            String waktu = stf.format(waktulapcheckout.getValue());
            
        pstm = conn.prepareStatement("update cek_out set Tgl_checkout='"+date
                + "', Jam_checkout='"+waktu+"', "
                + "Kode_kamar='"+kodekamarlapout.getText()+"',"
                + "Lama_inap='"+lamainapout.getText()+"'  "
                + "where kode_tamu = '"+kodetamulapout.getText()+"'");
                
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Update sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Update gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void delete_datalapcheckout()throws SQLException{
        pstm = conn.prepareStatement("delete from cek_out where kode_tamu = '"+kodetamulapout.getText()+"'");
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    //Laporan keuangan
    private void tampil_datakeuangan()throws SQLException{
        tmodel = new DefaultTableModel();
        
        tmodel.addColumn("Kode Tamu");
        tmodel.addColumn("Kode Kamar");
        tmodel.addColumn("LamaInap");
        tmodel.addColumn("Herga");
        tmodel.addColumn("Total");

        tablekeuangan.setModel(tmodel);
                
        stm = conn.createStatement();
        res = stm.executeQuery("select * from keuangan");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("Kode_tamu"),
                res.getString("Kode_kamar"),
                res.getString("Lama_inap"),
                res.getString("Harga"),
                res.getString("Total_harga"),
            });
        }
    }
    
    private void kosongkan_datakeuangan(){
        kodetamuk.setText("");
        kodekamark.setText("");
        lamainapk.setText("");
        hargak.setText("");
        totalk.setText("");     
    }
    
    private void update_datakeuangan()throws SQLException{
        pstm = conn.prepareStatement("update keuangan set Kode_kamar='"+kodekamark.getText()
                + "', Lama_inap='"+lamainapk.getText()+"', "
                + "Harga='"+hargak.getText()+"',"
                + "total_harga='"+totalk.getText()+"'  "
                + "where kode_tamu = '"+kodetamuk.getText()+"'");
                
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Update sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Update gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void delete_datakeuangan()throws SQLException{
        pstm = conn.prepareStatement("delete from keuangan where kode_tamu = '"+kodetamuk.getText()+"'");
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void kodetamu() {
        try {
            stm = conn.createStatement();
            res = stm.executeQuery("select * from tamu order by kode_tamu desc");
            if (res.next()) {
                String nofak = res.getString("kode_tamu").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";
                switch (AN.length()) {
                    case 1:
                        Nol = "00000";
                        break;
                    case 2:
                        Nol = "0000";
                        break;
                    case 3:
                        Nol = "000";
                        break;
                    case 4:
                        Nol = "00";
                        break;
                    case 5:
                        Nol = "0";
                        break;
                    case 6:
                        Nol = "0";
                        break;
                    default:
                        break;
                }

                kodetamu.setText("T" + Nol + AN);
            } else {
                kodetamu.setText("T000001");
            }

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void Sisa_kamar() throws SQLException{
        stm = conn.createStatement();
        res = stm.executeQuery("select * from kamar where kode_kamar= '" + kodekamar.getText() + "'");
        if (res.next()) {
            int kamar = Integer.parseInt(res.getString("jml_brg"));


            int sisakamar = kamar - 1;

            pstm = conn.prepareStatement("update barang set jml_brg='"+""+sisakamar+"' where kode_brg = '"+kodekamar.getText()+"'");
            if (pstm.executeUpdate()>0){
            }else{
            }
        }
    }
    
    private void Jumlah_kamar() throws SQLException{
        stm = conn.createStatement();
        res = stm.executeQuery("select * from kamar where kode_kamar= '" + kodekamar.getText() + "'");
        if (res.next()) {
            int kamar = Integer.parseInt(res.getString("jml_brg"));


            int sisakamar = kamar + 1;

            pstm = conn.prepareStatement("update barang set jml_brg='"+""+sisakamar+"' where kode_brg = '"+kodekamar.getText()+"'");
            if (pstm.executeUpdate()>0){
            }else{
            }
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        PanelUtama = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Home = new javax.swing.JButton();
        Masterdata = new javax.swing.JButton();
        Checkin = new javax.swing.JButton();
        Checkout = new javax.swing.JButton();
        Laporan = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        PanelContent = new javax.swing.JPanel();
        PanelHome = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelMaster = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TabMaster = new javax.swing.JTabbedPane();
        PanelDataKamar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        kelas = new javax.swing.JTextField();
        fasilitas = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        kodekamar = new javax.swing.JTextField();
        namakamar = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jmlkamar = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablekamar = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        savekamar = new javax.swing.JButton();
        updatekamar = new javax.swing.JButton();
        deletekamar = new javax.swing.JButton();
        laporandatakamar = new javax.swing.JButton();
        PanelDataTamu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabletamu = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        kodetamu = new javax.swing.JTextField();
        namatamu = new javax.swing.JTextField();
        jeniskelamin = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        usia = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        savetamu = new javax.swing.JButton();
        updatetamu = new javax.swing.JButton();
        deletetamu = new javax.swing.JButton();
        laporandatatamu = new javax.swing.JButton();
        PanelCheckin = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        namatamuin = new javax.swing.JTextField();
        tglcheckin = new com.toedter.calendar.JDateChooser();
        waktucheckin = new javax.swing.JSpinner();
        kodetamuin = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablecheckin = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        savecheckin = new javax.swing.JButton();
        deletecheckin = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        kodekamarin = new javax.swing.JTextField();
        kelasin = new javax.swing.JTextField();
        totalin = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        hargain = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        lamainap = new javax.swing.JTextField();
        fasilitasin = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        PanelCheckout = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        namatamuout = new javax.swing.JTextField();
        waktucheckout = new javax.swing.JSpinner();
        kodetamuout = new javax.swing.JTextField();
        tglcheckout = new com.toedter.calendar.JDateChooser();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablecheckout = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        savecheckout = new javax.swing.JButton();
        deletecheckout = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        kodekamarout = new javax.swing.JTextField();
        fasilitasout = new javax.swing.JTextField();
        hargaout = new javax.swing.JTextField();
        kelasout = new javax.swing.JTextField();
        lamainapout = new javax.swing.JTextField();
        totalout = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        PanelLaporan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tablaporan = new javax.swing.JTabbedPane();
        LaporanCheckin = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        kodetamulapin = new javax.swing.JTextField();
        kodekamarlapin = new javax.swing.JTextField();
        posisikamarlapin = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        waktulapcheckin = new javax.swing.JSpinner();
        tgllapcheckin = new com.toedter.calendar.JDateChooser();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablelaporancheckin = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        updatelapcheckin = new javax.swing.JButton();
        deletelapcheckin = new javax.swing.JButton();
        laporandatacheckin = new javax.swing.JButton();
        LaporanCheckout = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        kodekamarlapout = new javax.swing.JTextField();
        lamainaplapout = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        kodetamulapout = new javax.swing.JTextField();
        tgllapcheckout = new com.toedter.calendar.JDateChooser();
        waktulapcheckout = new javax.swing.JSpinner();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablelaporancheckout = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        deletelapcheckout = new javax.swing.JButton();
        laporandatacheckout = new javax.swing.JButton();
        updatelapcheckout = new javax.swing.JButton();
        LaporanKeuangan = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        kodetamuk = new javax.swing.JTextField();
        kodekamark = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        hargak = new javax.swing.JTextField();
        totalk = new javax.swing.JTextField();
        lamainapk = new javax.swing.JTextField();
        total1 = new javax.swing.JLabel();
        total2 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablekeuangan = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        updatekeuangan = new javax.swing.JButton();
        deletekeuangan = new javax.swing.JButton();
        laporankeuangan = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Perhotelan");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu.setPreferredSize(new java.awt.Dimension(250, 649));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel1.setText("Hotel MM");

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Masterdata.setText("Master");
        Masterdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasterdataActionPerformed(evt);
            }
        });

        Checkin.setText("Check In");
        Checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckinActionPerformed(evt);
            }
        });

        Checkout.setText("Check Out");
        Checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutActionPerformed(evt);
            }
        });

        Laporan.setText("Laporan");
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });

        Exit.setText("Keluar");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(Masterdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Checkin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Masterdata, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        PanelContent.setBackground(new java.awt.Color(255, 255, 255));
        PanelContent.setLayout(new java.awt.CardLayout());

        PanelHome.setBackground(new java.awt.Color(255, 255, 255));
        PanelHome.setPreferredSize(new java.awt.Dimension(1000, 750));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Selamat Datang");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Sistem informasi Hotel Muhammad Mahfud");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel2)
                .addGap(61, 61, 61)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelHomeLayout = new javax.swing.GroupLayout(PanelHome);
        PanelHome.setLayout(PanelHomeLayout);
        PanelHomeLayout.setHorizontalGroup(
            PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelHomeLayout.setVerticalGroup(
            PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelContent.add(PanelHome, "card2");

        PanelMaster.setBackground(new java.awt.Color(255, 255, 255));
        PanelMaster.setPreferredSize(new java.awt.Dimension(1000, 750));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Master Data");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(940, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(112, 60));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Data Kamar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Kode Kamar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Nama Kamar");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Kelas");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Harga");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Fasilitas");

        kelas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kelasKeyPressed(evt);
            }
        });

        fasilitas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        harga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hargaKeyPressed(evt);
            }
        });

        kodekamar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodekamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodekamarKeyPressed(evt);
            }
        });

        namakamar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namakamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namakamarKeyPressed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Jumlah kamar");

        jmlkamar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(kodekamar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namakamar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fasilitas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmlkamar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel44))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fasilitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kodekamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namakamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmlkamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tablekamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablekamar);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        savekamar.setText("Save");
        savekamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savekamarActionPerformed(evt);
            }
        });

        updatekamar.setText("Update");
        updatekamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatekamarActionPerformed(evt);
            }
        });

        deletekamar.setText("Delete");
        deletekamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletekamarActionPerformed(evt);
            }
        });

        laporandatakamar.setText("Laporan");
        laporandatakamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporandatakamarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(savekamar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatekamar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletekamar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laporandatakamar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savekamar)
                    .addComponent(updatekamar)
                    .addComponent(deletekamar)
                    .addComponent(laporandatakamar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelDataKamarLayout = new javax.swing.GroupLayout(PanelDataKamar);
        PanelDataKamar.setLayout(PanelDataKamarLayout);
        PanelDataKamarLayout.setHorizontalGroup(
            PanelDataKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelDataKamarLayout.setVerticalGroup(
            PanelDataKamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDataKamarLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TabMaster.addTab("Data Kamar", PanelDataKamar);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Data Tamu");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        tabletamu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabletamu);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Kode Tamu");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Nama Tamu");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Jenis Kelamin");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Usia");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Alamat");

        kodetamu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodetamu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodetamuKeyPressed(evt);
            }
        });

        namatamu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namatamu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namatamuKeyPressed(evt);
            }
        });

        jeniskelamin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jeniskelamin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jeniskelaminKeyPressed(evt);
            }
        });

        alamat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        usia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usiaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel17))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(kodetamu, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namatamu, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usia, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodetamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namatamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        savetamu.setText("Save");
        savetamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savetamuActionPerformed(evt);
            }
        });

        updatetamu.setText("Update");
        updatetamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatetamuActionPerformed(evt);
            }
        });

        deletetamu.setText("Delete");
        deletetamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletetamuActionPerformed(evt);
            }
        });

        laporandatatamu.setText("Laporan");
        laporandatatamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporandatatamuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(savetamu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatetamu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletetamu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laporandatatamu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savetamu)
                    .addComponent(updatetamu)
                    .addComponent(deletetamu)
                    .addComponent(laporandatatamu))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelDataTamuLayout = new javax.swing.GroupLayout(PanelDataTamu);
        PanelDataTamu.setLayout(PanelDataTamuLayout);
        PanelDataTamuLayout.setHorizontalGroup(
            PanelDataTamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelDataTamuLayout.setVerticalGroup(
            PanelDataTamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDataTamuLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TabMaster.addTab("Data Tamu", PanelDataTamu);

        javax.swing.GroupLayout PanelMasterLayout = new javax.swing.GroupLayout(PanelMaster);
        PanelMaster.setLayout(PanelMasterLayout);
        PanelMasterLayout.setHorizontalGroup(
            PanelMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelMasterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TabMaster)
                    .addContainerGap()))
        );
        PanelMasterLayout.setVerticalGroup(
            PanelMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(686, Short.MAX_VALUE))
            .addGroup(PanelMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMasterLayout.createSequentialGroup()
                    .addContainerGap(104, Short.MAX_VALUE)
                    .addComponent(TabMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        PanelContent.add(PanelMaster, "card2");

        PanelCheckin.setBackground(new java.awt.Color(255, 255, 255));
        PanelCheckin.setPreferredSize(new java.awt.Dimension(1000, 750));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Check In");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("KodeTamu");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Nama Tamu ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Tanggal Chek In");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Waktu Chek In");

        namatamuin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tglcheckin.setDateFormatString("yyyy-MM-dd"); // NOI18N
        tglcheckin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tglcheckin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tglcheckinKeyPressed(evt);
            }
        });

        waktucheckin.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        waktucheckin.setEditor(new javax.swing.JSpinner.DateEditor(waktucheckin, "HH:mm:ss"));

        kodetamuin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodetamuin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodetamuinKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(kodetamuin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(namatamuin, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(tglcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(waktucheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(366, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(namatamuin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(waktucheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kodetamuin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tglcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tablecheckin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablecheckin);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        savecheckin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        savecheckin.setText("Save");
        savecheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savecheckinActionPerformed(evt);
            }
        });

        deletecheckin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deletecheckin.setText("Delete");
        deletecheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecheckinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(savecheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletecheckin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savecheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletecheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Kode Kamar");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Kelas");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Harga");

        kodekamarin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodekamarin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodekamarinKeyPressed(evt);
            }
        });

        kelasin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        totalin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel56.setText("Total Harga");

        hargain.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hargain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hargainKeyPressed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Lama Inap");

        lamainap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lamainap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lamainapKeyPressed(evt);
            }
        });

        fasilitasin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel57.setText("Fasilitas");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodekamarin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(kelasin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(fasilitasin, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(lamainap, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(hargain, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodekamarin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelasin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lamainap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fasilitasin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelCheckinLayout = new javax.swing.GroupLayout(PanelCheckin);
        PanelCheckin.setLayout(PanelCheckinLayout);
        PanelCheckinLayout.setHorizontalGroup(
            PanelCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelCheckinLayout.setVerticalGroup(
            PanelCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelContent.add(PanelCheckin, "card3");

        PanelCheckout.setBackground(new java.awt.Color(255, 255, 255));
        PanelCheckout.setPreferredSize(new java.awt.Dimension(1000, 750));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Check Out");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("KodeTamu");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Nama Tamu");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Tanggal Check Out");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Waktu Check Out");

        namatamuout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        waktucheckout.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        waktucheckout.setEditor(new javax.swing.JSpinner.DateEditor(waktucheckout, "HH:mm:ss"));
        waktucheckout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                waktucheckoutKeyPressed(evt);
            }
        });

        kodetamuout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodetamuout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodetamuoutKeyPressed(evt);
            }
        });

        tglcheckout.setDateFormatString("yyyy-MM-dd"); // NOI18N
        tglcheckout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tglcheckout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tglcheckoutKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(kodetamuout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(namatamuout, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel29))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(tglcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(waktucheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namatamuout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kodetamuout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(waktucheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tglcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tablecheckout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablecheckout);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        savecheckout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        savecheckout.setText("Save");
        savecheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savecheckoutActionPerformed(evt);
            }
        });

        deletecheckout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deletecheckout.setText("Delete");
        deletecheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(savecheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletecheckout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savecheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletecheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("Kode Kamar");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setText("fasilitas");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setText("Kelas");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setText("Harga");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel55.setText("Lama Inap");

        kodekamarout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodekamarout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodekamaroutKeyPressed(evt);
            }
        });

        fasilitasout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        hargaout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        kelasout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lamainapout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lamainapout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lamainapoutKeyPressed(evt);
            }
        });

        totalout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel58.setText("Total Harga");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodekamarout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(kelasout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fasilitasout, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lamainapout, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargaout, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalout, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel53)
                    .addComponent(jLabel52)
                    .addComponent(jLabel58))
                .addGap(17, 17, 17)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodekamarout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelasout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lamainapout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fasilitasout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelCheckoutLayout = new javax.swing.GroupLayout(PanelCheckout);
        PanelCheckout.setLayout(PanelCheckoutLayout);
        PanelCheckoutLayout.setHorizontalGroup(
            PanelCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelCheckoutLayout.setVerticalGroup(
            PanelCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelContent.add(PanelCheckout, "card4");

        PanelLaporan.setBackground(new java.awt.Color(255, 255, 255));
        PanelLaporan.setPreferredSize(new java.awt.Dimension(1000, 750));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Laporan");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        kodetamulapin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodetamulapin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodetamulapinKeyPressed(evt);
            }
        });

        kodekamarlapin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        posisikamarlapin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Kode Tamu");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Tanggal Check In");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Kode Kamar");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Waktu Check In");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Posisi Kamar");

        waktulapcheckin.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        waktulapcheckin.setEditor(new javax.swing.JSpinner.DateEditor(waktulapcheckin, "HH:mm:ss"));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodetamulapin, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(10, 10, 10)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(tgllapcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(waktulapcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodekamarlapin, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(8, 8, 8)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(posisikamarlapin, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel36)
                        .addComponent(jLabel32)
                        .addComponent(jLabel37))
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kodetamulapin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kodekamarlapin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(posisikamarlapin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(waktulapcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tgllapcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        tablelaporancheckin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablelaporancheckin);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        updatelapcheckin.setText("Update");
        updatelapcheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatelapcheckinActionPerformed(evt);
            }
        });

        deletelapcheckin.setText("Delete");
        deletelapcheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletelapcheckinActionPerformed(evt);
            }
        });

        laporandatacheckin.setText("Laporan");
        laporandatacheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporandatacheckinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updatelapcheckin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletelapcheckin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laporandatacheckin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatelapcheckin)
                    .addComponent(laporandatacheckin)
                    .addComponent(deletelapcheckin))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LaporanCheckinLayout = new javax.swing.GroupLayout(LaporanCheckin);
        LaporanCheckin.setLayout(LaporanCheckinLayout);
        LaporanCheckinLayout.setHorizontalGroup(
            LaporanCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LaporanCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LaporanCheckinLayout.setVerticalGroup(
            LaporanCheckinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanCheckinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaporan.addTab("Data Check In", LaporanCheckin);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        kodekamarlapout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lamainaplapout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Kode Tamu");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("Tanggal Check In");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("Kode Kamar");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Waktu Check In");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("Lama Inap");

        kodetamulapout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodetamulapout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodetamulapoutKeyPressed(evt);
            }
        });

        waktulapcheckout.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        waktulapcheckout.setEditor(new javax.swing.JSpinner.DateEditor(waktulapcheckout, "HH:mm:ss"));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodetamulapout, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(10, 10, 10)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgllapcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(waktulapcheckout))
                .addGap(53, 53, 53)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodekamarlapout, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lamainaplapout, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgllapcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kodekamarlapout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lamainaplapout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kodetamulapout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(waktulapcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        tablelaporancheckout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablelaporancheckout);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        deletelapcheckout.setText("Delete");
        deletelapcheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletelapcheckoutActionPerformed(evt);
            }
        });

        laporandatacheckout.setText("Laporan");
        laporandatacheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporandatacheckoutActionPerformed(evt);
            }
        });

        updatelapcheckout.setText("Update");
        updatelapcheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatelapcheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(updatelapcheckout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deletelapcheckout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laporandatacheckout)
                .addContainerGap(788, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laporandatacheckout)
                    .addComponent(deletelapcheckout)
                    .addComponent(updatelapcheckout))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LaporanCheckoutLayout = new javax.swing.GroupLayout(LaporanCheckout);
        LaporanCheckout.setLayout(LaporanCheckoutLayout);
        LaporanCheckoutLayout.setHorizontalGroup(
            LaporanCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LaporanCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LaporanCheckoutLayout.setVerticalGroup(
            LaporanCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaporan.addTab("Data Check Out", LaporanCheckout);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        kodetamuk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kodetamuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodetamukKeyPressed(evt);
            }
        });

        kodekamark.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("Kode Tamu");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Kode Kamar");

        total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total.setText("lama Inap");

        hargak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        totalk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lamainapk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        total1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total1.setText("Harga");

        total2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total2.setText("Total ");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(kodetamuk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kodekamark, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel45)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total)
                    .addComponent(lamainapk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargak, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel45)
                    .addComponent(total)
                    .addComponent(total1)
                    .addComponent(total2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodetamuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kodekamark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lamainapk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        tablekeuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tablekeuangan);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        updatekeuangan.setText("Update");
        updatekeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatekeuanganActionPerformed(evt);
            }
        });

        deletekeuangan.setText("Delete");
        deletekeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletekeuanganActionPerformed(evt);
            }
        });

        laporankeuangan.setText("Laporan");
        laporankeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporankeuanganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updatekeuangan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletekeuangan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laporankeuangan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatekeuangan)
                    .addComponent(laporankeuangan)
                    .addComponent(deletekeuangan))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LaporanKeuanganLayout = new javax.swing.GroupLayout(LaporanKeuangan);
        LaporanKeuangan.setLayout(LaporanKeuanganLayout);
        LaporanKeuanganLayout.setHorizontalGroup(
            LaporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanKeuanganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LaporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LaporanKeuanganLayout.setVerticalGroup(
            LaporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanKeuanganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaporan.addTab("Data Keuangan", LaporanKeuangan);

        javax.swing.GroupLayout PanelLaporanLayout = new javax.swing.GroupLayout(PanelLaporan);
        PanelLaporan.setLayout(PanelLaporanLayout);
        PanelLaporanLayout.setHorizontalGroup(
            PanelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablaporan, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        PanelLaporanLayout.setVerticalGroup(
            PanelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaporan.getAccessibleContext().setAccessibleName("tablaporan");

        PanelContent.add(PanelLaporan, "card5");

        javax.swing.GroupLayout PanelUtamaLayout = new javax.swing.GroupLayout(PanelUtama);
        PanelUtama.setLayout(PanelUtamaLayout);
        PanelUtamaLayout.setHorizontalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUtamaLayout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE))
        );
        PanelUtamaLayout.setVerticalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .addComponent(PanelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //BUTTON MENU
    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        PanelContent.repaint();
        PanelContent.revalidate();
        
        PanelContent.add(PanelHome);
        PanelContent.repaint();
        PanelContent.revalidate();
    }//GEN-LAST:event_HomeActionPerformed

    private void MasterdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasterdataActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        PanelContent.repaint();
        PanelContent.revalidate();
        
        PanelContent.add(PanelMaster);
        PanelContent.repaint();
        PanelContent.revalidate();
    }//GEN-LAST:event_MasterdataActionPerformed

    private void CheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckinActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        PanelContent.repaint();
        PanelContent.revalidate();
        
        PanelContent.add(PanelCheckin);
        PanelContent.repaint();
        PanelContent.revalidate();
    }//GEN-LAST:event_CheckinActionPerformed

    private void CheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        PanelContent.repaint();
        PanelContent.revalidate();
        
        PanelContent.add(PanelCheckout);
        PanelContent.repaint();
        PanelContent.revalidate();
    }//GEN-LAST:event_CheckoutActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
        // TODO add your handling code here:
         PanelContent.removeAll();
        PanelContent.repaint();
        PanelContent.revalidate();
        
        PanelContent.add(PanelLaporan);
        PanelContent.repaint();
        PanelContent.revalidate();
    }//GEN-LAST:event_LaporanActionPerformed

    //MANIPULASI DATA KAMAR
    private void kodekamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodekamarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from kamar where kode_kamar = '" + kodekamar.getText() + "'");
                if (res.next()) {
                    namakamar.setText(res.getString("nama_kamar"));
                    kelas.setText(res.getString("kelas"));
                    harga.setText(res.getString("harga"));
                    fasilitas.setText(res.getString("fasilitas"));
                    jmlkamar.setText(res.getString("jumlah_kamar"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            namakamar.requestFocus();
        }
    }//GEN-LAST:event_kodekamarKeyPressed

    private void namakamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namakamarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kelas.requestFocus();
        }
    }//GEN-LAST:event_namakamarKeyPressed

    private void kelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kelasKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            harga.requestFocus();
        }
    }//GEN-LAST:event_kelasKeyPressed

    private void hargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fasilitas.requestFocus();
        }
    }//GEN-LAST:event_hargaKeyPressed

    private void savekamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savekamarActionPerformed
        // TODO add your handling code here:
        try {
            save_datakamar();
            tampil_datakamar();
            kosongkan_datakamar();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_savekamarActionPerformed

    private void updatekamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatekamarActionPerformed
        // TODO add your handling code here:
        try {
            update_datakamar();
            tampil_datakamar();
            kosongkan_datakamar();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatekamarActionPerformed

    private void deletekamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletekamarActionPerformed
        // TODO add your handling code here:
        try {
            delete_datakamar();
            tampil_datakamar();
            kosongkan_datakamar();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletekamarActionPerformed

    private void laporandatakamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporandatakamarActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/Laporan/reportDataKamar.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_laporandatakamarActionPerformed

    
    //MANIPULASI DATA TAMU
    private void kodetamuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodetamuKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from tamu where kode_tamu = '" + kodetamu.getText() + "'");
                if (res.next()) {
                    namatamu.setText(res.getString("nama_tamu"));
                    jeniskelamin.setText(res.getString("Jns_kel"));
                    usia.setText(res.getString("usia"));
                    alamat.setText(res.getString("alamat"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            namatamu.requestFocus();
        }
    }//GEN-LAST:event_kodetamuKeyPressed

    private void namatamuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namatamuKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jeniskelamin.requestFocus();
        }
    }//GEN-LAST:event_namatamuKeyPressed

    private void jeniskelaminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jeniskelaminKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usia.requestFocus();
        }
    }//GEN-LAST:event_jeniskelaminKeyPressed

    private void usiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usiaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alamat.requestFocus();
        }
    }//GEN-LAST:event_usiaKeyPressed

    private void savetamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savetamuActionPerformed
        // TODO add your handling code here:
        try {
            save_datatamu();
            tampil_datatamu();
            kosongkan_datatamu();
            kodetamu();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_savetamuActionPerformed

    private void updatetamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatetamuActionPerformed
        // TODO add your handling code here:
        try {
            update_datatamu();
            tampil_datatamu();
            kosongkan_datatamu();
            kodetamu();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatetamuActionPerformed

    private void deletetamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletetamuActionPerformed
        // TODO add your handling code here:
        try {
            delete_datatamu();
            tampil_datatamu();
            kosongkan_datatamu();
            kodetamu();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletetamuActionPerformed

    private void laporandatatamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporandatatamuActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/Laporan/reportDataTamu.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        
    }//GEN-LAST:event_laporandatatamuActionPerformed

    
    
    //CHECK IN
    private void tglcheckinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tglcheckinKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            waktucheckin.requestFocus();
        }
    }//GEN-LAST:event_tglcheckinKeyPressed

    private void lamainapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lamainapKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int jml = Integer.parseInt(lamainap.getText());
            int hrg = Integer.parseInt(hargain.getText());

            int hasil = jml * hrg;
            totalin.setText("" + hasil);
            try {
                simpan_datacheckin();
                tampil_datacheckin();
                kosongkan_datacheckin();
            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lamainapKeyPressed

    private void kodekamarinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodekamarinKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from kamar where kode_kamar = '" + kodekamarin.getText() + "'");
                if (res.next()) {
                    kelasin.setText(res.getString("kelas"));
                    hargain.setText(res.getString("harga"));
                    fasilitasin.setText(res.getString("fasilitas"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamainap.requestFocus();    
        }
    }//GEN-LAST:event_kodekamarinKeyPressed

    private void hargainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargainKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargainKeyPressed

    private void savecheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savecheckinActionPerformed
        // TODO add your handling code here:
        try {
            res = stm.executeQuery("select * from temporary_checkin");
            while (res.next()) {
                pstm = conn.prepareStatement("insert into cek_in"
                    + "(Kode_tamu, tgl_checkin, Jam_checkin, Kode_kamar, Posisi_Kamar)"
                    + "values ( '"+res.getString("Kode_tamu")+"', '"+res.getString("Tgl_checkin")+"', '"+res.getString("Jam_checkin")+"',"
                    + " '"+res.getString("Kode_kamar")+"','"+res.getString("Kelas_kamar")+"')");

                if (pstm.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this, "Simpan Check In sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Simpan Check In gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    pstm.close();
                }   
            }
            Sisa_kamar();
            tampil_datalapcheckin();
            delete_datacheckin();
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_savecheckinActionPerformed

    private void deletecheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletecheckinActionPerformed
        // TODO add your handling code here:
        try {
                delete_datacheckin();
                tampil_datacheckin();
                kosongkan_datacheckin();
            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_deletecheckinActionPerformed

    private void kodetamuinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodetamuinKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from tamu where kode_tamu = '" + kodetamuin.getText() + "'");
                if (res.next()) {
                    namatamuin.setText(res.getString("nama_tamu"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            tglcheckin.requestFocus();
        } 
    }//GEN-LAST:event_kodetamuinKeyPressed

    
    //Check Out
    private void kodetamuoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodetamuoutKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from tamu where kode_tamu = '" + kodetamuout.getText() + "'");
                if (res.next()) {
                    namatamuout.setText(res.getString("nama_tamu"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            tglcheckout.requestFocus();
        } 
    }//GEN-LAST:event_kodetamuoutKeyPressed

    private void tglcheckoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tglcheckoutKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            waktucheckout.requestFocus();
        }
    }//GEN-LAST:event_tglcheckoutKeyPressed

    private void waktucheckoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_waktucheckoutKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kodekamarout.requestFocus();
        }
    }//GEN-LAST:event_waktucheckoutKeyPressed

    private void kodekamaroutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodekamaroutKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from kamar where kode_kamar = '" + kodekamarout.getText() + "'");
                if (res.next()) {
                    kelasout.setText(res.getString("kelas"));
                    hargaout.setText(res.getString("harga"));
                    fasilitasout.setText(res.getString("fasilitas"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamainapout.requestFocus();    
        }
    }//GEN-LAST:event_kodekamaroutKeyPressed

    private void lamainapoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lamainapoutKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int jml = Integer.parseInt(lamainapout.getText());
            int hrg = Integer.parseInt(hargaout.getText());

            int hasil = jml * hrg;
            totalout.setText("" + hasil);
            try {
                simpan_datacheckout();
                tampil_datacheckout();
                kosongkan_datacheckout();
            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lamainapoutKeyPressed

    private void savecheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savecheckoutActionPerformed
        try {
            // TODO add your handling code here:
            savedatacheckouttolapCheckout();
            savedatacheckouttokeuangan();
            tampil_datalapcheckout();
            tampil_datakeuangan();
            Jumlah_kamar();
            delete_datacheckout();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_savecheckoutActionPerformed

    private void deletecheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletecheckoutActionPerformed
        // TODO add your handling code here:
        try {
                delete_datacheckout();
                tampil_datacheckout();
                kosongkan_datacheckout();
            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_deletecheckoutActionPerformed

    
    // Laporan Data Checkin
    private void kodetamulapinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodetamulapinKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from cek_in where kode_tamu = '" + kodetamulapin.getText() + "'");
                if (res.next()) {
                    tgllapcheckin.setDate(res.getDate("Tgl_checkin"));
                    waktulapcheckin.setValue(res.getString("Jam_checkin"));
                    kodekamarlapin.setText(res.getString("Kode_kamar"));
                    posisikamarlapin.setText(res.getString("Posisi_kamar"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_kodetamulapinKeyPressed

    private void updatelapcheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatelapcheckinActionPerformed
        // TODO add your handling code here:
        try {
            update_datalapcheckin();
            tampil_datalapcheckin();
            kosongkan_datalapcheckin();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatelapcheckinActionPerformed

    private void deletelapcheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletelapcheckinActionPerformed
        // TODO add your handling code here:
        try {
            delete_datalapcheckin();
            tampil_datalapcheckin();
            kosongkan_datalapcheckin();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletelapcheckinActionPerformed

    private void laporandatacheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporandatacheckinActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/Laporan/reportCheckIn.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_laporandatacheckinActionPerformed

    
    //Laporan Data Check Out
    private void kodetamulapoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodetamulapoutKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from cek_in where kode_tamu = '" + kodetamulapout.getText() + "'");
                if (res.next()) {
                    tgllapcheckout.setDate(res.getDate("Tgl_checkin"));
                    waktulapcheckout.setValue(res.getString("Jam_checkin"));
                    kodekamarlapout.setText(res.getString("Kode_kamar"));
                    lamainapout.setText(res.getString("Posisi_kamar"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_kodetamulapoutKeyPressed

    private void updatelapcheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatelapcheckoutActionPerformed
        // TODO add your handling code here:
        try {
            update_datalapcheckout();
            tampil_datalapcheckout();
            kosongkan_datalapcheckout();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatelapcheckoutActionPerformed

    private void deletelapcheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletelapcheckoutActionPerformed
        // TODO add your handling code here:
        try {
            delete_datalapcheckout();
            tampil_datalapcheckout();
            kosongkan_datalapcheckout();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletelapcheckoutActionPerformed

    private void laporandatacheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporandatacheckoutActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/Laporan/reportCheckOut.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_laporandatacheckoutActionPerformed

    //Laporan Keuangan
    private void kodetamukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodetamukKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                res = stm.executeQuery("select * from keuangan where kode_tamu = '" + kodetamuk.getText() + "'");
                if (res.next()) {
                    kodekamark.setText(res.getString("Kode_kamar"));
                    lamainapk.setText(res.getString("Lama_inap"));
                    hargak.setText(res.getString("Harga"));
                    totalk.setText(res.getString("Total_harga"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_kodetamukKeyPressed

    private void updatekeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatekeuanganActionPerformed
        // TODO add your handling code here:
        try {
            update_datakeuangan();
            tampil_datakeuangan();
            kosongkan_datakeuangan();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatekeuanganActionPerformed

    private void deletekeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletekeuanganActionPerformed
        // TODO add your handling code here:
        try {
            delete_datakeuangan();
            tampil_datakeuangan();
            kosongkan_datakeuangan();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletekeuanganActionPerformed

    private void laporankeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporankeuanganActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/Laporan/reportKeuangan.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_laporankeuanganActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    
   
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MenuUtama().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Checkin;
    private javax.swing.JButton Checkout;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Home;
    private javax.swing.JButton Laporan;
    private javax.swing.JPanel LaporanCheckin;
    private javax.swing.JPanel LaporanCheckout;
    private javax.swing.JPanel LaporanKeuangan;
    private javax.swing.JButton Masterdata;
    private javax.swing.JPanel PanelCheckin;
    private javax.swing.JPanel PanelCheckout;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JPanel PanelDataKamar;
    private javax.swing.JPanel PanelDataTamu;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JPanel PanelLaporan;
    private javax.swing.JPanel PanelMaster;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelUtama;
    private javax.swing.JTabbedPane TabMaster;
    private javax.swing.JTextField alamat;
    private javax.swing.JButton deletecheckin;
    private javax.swing.JButton deletecheckout;
    private javax.swing.JButton deletekamar;
    private javax.swing.JButton deletekeuangan;
    private javax.swing.JButton deletelapcheckin;
    private javax.swing.JButton deletelapcheckout;
    private javax.swing.JButton deletetamu;
    private javax.swing.JTextField fasilitas;
    private javax.swing.JTextField fasilitasin;
    private javax.swing.JTextField fasilitasout;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField hargain;
    private javax.swing.JTextField hargak;
    private javax.swing.JTextField hargaout;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jeniskelamin;
    private javax.swing.JTextField jmlkamar;
    private javax.swing.JTextField kelas;
    private javax.swing.JTextField kelasin;
    private javax.swing.JTextField kelasout;
    private javax.swing.JTextField kodekamar;
    private javax.swing.JTextField kodekamarin;
    private javax.swing.JTextField kodekamark;
    private javax.swing.JTextField kodekamarlapin;
    private javax.swing.JTextField kodekamarlapout;
    private javax.swing.JTextField kodekamarout;
    private javax.swing.JTextField kodetamu;
    private javax.swing.JTextField kodetamuin;
    private javax.swing.JTextField kodetamuk;
    private javax.swing.JTextField kodetamulapin;
    private javax.swing.JTextField kodetamulapout;
    private javax.swing.JTextField kodetamuout;
    private javax.swing.JTextField lamainap;
    private javax.swing.JTextField lamainapk;
    private javax.swing.JTextField lamainaplapout;
    private javax.swing.JTextField lamainapout;
    private javax.swing.JButton laporandatacheckin;
    private javax.swing.JButton laporandatacheckout;
    private javax.swing.JButton laporandatakamar;
    private javax.swing.JButton laporandatatamu;
    private javax.swing.JButton laporankeuangan;
    private javax.swing.JTextField namakamar;
    private javax.swing.JTextField namatamu;
    private javax.swing.JTextField namatamuin;
    private javax.swing.JTextField namatamuout;
    private javax.swing.JTextField posisikamarlapin;
    private javax.swing.JButton savecheckin;
    private javax.swing.JButton savecheckout;
    private javax.swing.JButton savekamar;
    private javax.swing.JButton savetamu;
    private javax.swing.JTabbedPane tablaporan;
    private javax.swing.JTable tablecheckin;
    private javax.swing.JTable tablecheckout;
    private javax.swing.JTable tablekamar;
    private javax.swing.JTable tablekeuangan;
    private javax.swing.JTable tablelaporancheckin;
    private javax.swing.JTable tablelaporancheckout;
    private javax.swing.JTable tabletamu;
    private com.toedter.calendar.JDateChooser tglcheckin;
    private com.toedter.calendar.JDateChooser tglcheckout;
    private com.toedter.calendar.JDateChooser tgllapcheckin;
    private com.toedter.calendar.JDateChooser tgllapcheckout;
    private javax.swing.JLabel total;
    private javax.swing.JLabel total1;
    private javax.swing.JLabel total2;
    private javax.swing.JTextField totalin;
    private javax.swing.JTextField totalk;
    private javax.swing.JTextField totalout;
    private javax.swing.JButton updatekamar;
    private javax.swing.JButton updatekeuangan;
    private javax.swing.JButton updatelapcheckin;
    private javax.swing.JButton updatelapcheckout;
    private javax.swing.JButton updatetamu;
    private javax.swing.JTextField usia;
    private javax.swing.JSpinner waktucheckin;
    private javax.swing.JSpinner waktucheckout;
    private javax.swing.JSpinner waktulapcheckin;
    private javax.swing.JSpinner waktulapcheckout;
    // End of variables declaration//GEN-END:variables
}
