/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PBOMysql;

import java.sql.*;
import java.sql.DriverManager;
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author mmahf
 */
public class MenuUtama extends javax.swing.JFrame {
    private DefaultTableModel tmodel;
    Connection conn;
    Statement stm;
        String url ="jdbc:mysql://localhost/pbo_penjualan";
        String user="root";
        String pass="";
    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() throws SQLException {
        initComponents();
        kontrol_atas(false);
        kontrol_tengah(false);
        hapus_temporary();
        tampil_penjualan();
        tampil_databarang();
        tampil_datapelanggan();
        tampil_datatransaksi();
        nofaktur();
        Waktu();
    }
    
    private void kontrol_atas(boolean x){
        xtgl.setEnabled(x);
        xnofak.setEnabled(x);
        xkdpel.setEnabled(x);
        xnmpel.setEnabled(x);
        xalmtpel.setEnabled(x);
        xnmkasir.setEnabled(x);
    }
    
    private void kontrol_tengah(boolean x){
        xkdbrg.setEnabled(x);
        xnmbrg.setEnabled(x);
        xsatbrg.setEnabled(x);
        xhrgbrg.setEnabled(x);
        xjmlbrg.setEnabled(x);
        xtotbrg.setEnabled(x);
    }
    
    
    private void kosongkan_barang_master(){
        kd_brg.setText("");
        nm_brg.setText("");
        sat_brg.setText("");
        hrg_brg.setText("");
        jml_brg.setText("");
        kd_brg.requestFocus();
    }
    
    private void kosongkan_pelanggan_master(){
        kd_pel.setText("");
        nm_pel.setText("");
        telp_pel.setText("");
        almt_pel.setText("");
        kota_pel.setText("");
        kd_pel.requestFocus();
    }
    
    
    private void kosongkan_barang_transaksi(){
        xkdbrg.setText("");
        xnmbrg.setText("");
        xsatbrg.setText("");
        xhrgbrg.setText("");
        xjmlbrg.setText("");
        xtotbrg.setText("");
        xkdbrg.requestFocus();
    }
    
    private void tampil_databarang() throws SQLException{
        tmodel = new DefaultTableModel();

        tmodel.addColumn("KODE");
        tmodel.addColumn("NAMA");
        tmodel.addColumn("SATUAN");
        tmodel.addColumn("JUMLAH");
        tmodel.addColumn("HARGA");

        TableBarang.setModel(tmodel);
        
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet res = stm.executeQuery("select * from barang");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("kode_brg"),
                res.getString("nama_brg"),
                res.getString("satuan_brg"),
                res.getString("jml_brg"),
                res.getString("hrg_brg"),
            });
        }
    }
    
    private void tampil_datapelanggan() throws SQLException{
        tmodel = new DefaultTableModel();

        tmodel.addColumn("KODE");
        tmodel.addColumn("NAMA");
        tmodel.addColumn("TELP");
        tmodel.addColumn("ALAMAT");
        tmodel.addColumn("KOTA");
        TablePelanggan.setModel(tmodel);
        
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet res = stm.executeQuery("select * from pelanggan");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("kode_pelanggan"),
                res.getString("nama_pelanggan"),
                res.getString("telp_pelanggan"),
                res.getString("alamat_pelanggan"),
                res.getString("kota_pelanggan")
            });
        }

    }
    
    private void tampil_datatransaksi() throws SQLException{
        tmodel = new DefaultTableModel();

        tmodel.addColumn("KODE");
        tmodel.addColumn("NAMA");
        tmodel.addColumn("SATUAN");
        tmodel.addColumn("JUMLAH");
        tmodel.addColumn("HARGA");
        tmodel.addColumn("TOTAL");
        Tabel1.setModel(tmodel);
        
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet res = stm.executeQuery("select * from temporary_jual");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("kode_brg"),
                res.getString("nama_brg"),
                res.getString("satuan_brg"),
                res.getString("jml_brg"),
                res.getString("hrg_brg"),
                res.getString("total_brg")
            });
        }

    }
    
    private void tampil_penjualan() throws SQLException{
        tmodel = new DefaultTableModel();

        tmodel.addColumn("NOMOR FAKTUR");
        tmodel.addColumn("TANGGAL FAKTUR");
        tmodel.addColumn("KODE BARANG");
        tmodel.addColumn("NAMA BARANG");
        tmodel.addColumn("KODE PELANGGAN");
        tmodel.addColumn("NAMA_PELANGGAN");
        tmodel.addColumn("JUMLAH");
        tmodel.addColumn("TOTAL");
        tmodel.addColumn("NAMA_KASIR");

        TablePenjualan.setModel(tmodel);
        
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet res = stm.executeQuery("select * from penjualan");
        while (res.next()) {
            tmodel.addRow(new Object[]{res.getString("nomor_faktur"),
                res.getString("tgl_faktur"),
                res.getString("kd_brg"),
                res.getString("nm_brg"),
                res.getString("kode_pelanggan"),
                res.getString("nm_pel"),
                res.getString("jumlah"),
                res.getString("tot_faktur"),
                res.getString("nm_kasir"),
                
            });
        }
    }
    
    private void simpan_datapelanggan() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("insert into pelanggan"
                + "(kode_pelanggan, nama_pelanggan, telp_pelanggan, alamat_pelanggan, kota_pelanggan)"
                + "values ('"+kd_pel.getText()+"', '"+nm_pel.getText()+"', '"+telp_pel.getText()
                + "', '"+almt_pel.getText()+"','"+kota_pel.getText()+"')");
            
        
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Simpan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Simpan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    private void update_datapelanggan() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("update  pelanggan set nama_pelanggan='"+nm_pel.getText()
                + "', telp_pelanggan='"+telp_pel.getText()+"', "
                + "alamat_pelanggan='"+almt_pel.getText()+"',"
                + "kota_pelanggan='"+kota_pel.getText()+"'  "
                + "where kode_pelanggan = '"+kd_pel.getText()+"'");
                

        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Update sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Update gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void hapus_datapelanggan() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("delete from pelanggan where kode_pelanggan = '"+kd_pel.getText()+"'");

        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void simpan_databarang() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("insert into barang"
                + "(kode_brg, nama_brg, jml_brg, satuan_brg, hrg_brg)"
                + "values ('"+kd_brg.getText()+"', '"+nm_brg.getText()+"', '"+jml_brg.getText()
                + "', '"+sat_brg.getText()+"','"+hrg_brg.getText()+"')");
            
        
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Simpan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Simpan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    private void update_databarang() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("update  barang set nama_brg='"+nm_brg.getText()
                + "', jml_brg='"+jml_brg.getText()+ "', "
                + "satuan_brg='"+sat_brg.getText()+"', "
                + "hrg_brg='"+hrg_brg.getText()+ "' "
                + "where kode_brg = '"+kd_brg.getText()+"'");
                

        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Update sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Update gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void hapus_databarang() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("delete from barang where kode_brg = '"+kd_brg.getText()+"'");

        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Delete sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Delete gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void simpan_datatransaksi() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm = conn.prepareStatement("insert into temporary_jual"
                + "(kode_brg, nama_brg, satuan_brg, jml_brg, hrg_brg, total_brg, kode_pelanggan, nomor_faktur, tgl_faktur, nama_pelanggan, almt_pelanggan, nm_kasir)"
                + "values ('"+xkdbrg.getText()+"', '"+xnmbrg.getText()+"', '"+xsatbrg.getText()
                + "', '"+xjmlbrg.getText()+"','"+xhrgbrg.getText()+"', '"+xtotbrg.getText()+"', '"+xkdpel.getText()
                +"', '"+xnofak.getText()+"', '"+xtgl.getDate().toString()+"', '"+xnmpel.getText()+"', '"+xalmtpel.getText()+"', '"+xnmkasir.getText()+"')");
        tampil_datatransaksi();
        
        if (pstm.executeUpdate()>0){
            JOptionPane.showMessageDialog(this, "Simpan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Simpan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();
        }
    }
    
    private void hapus_temporary(){
        try {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement();
            boolean hapus = stm.execute("delete from temporary_jual");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "kesalahan"+err);
        }   
    }
    
    private void jumlah_barang() throws SQLException{
        conn = (Connection) DriverManager.getConnection(url, user, pass);
        stm = conn.createStatement();
        ResultSet res = stm.executeQuery("select * from barang where kode_brg= '" + xkdbrg.getText() + "'");
        if (res.next()) {
            int stock = Integer.parseInt(res.getString("jml_brg"));
            int beli = Integer.parseInt(xjmlbrg.getText());

            int sisastock = stock - beli;

            PreparedStatement pstm = conn.prepareStatement("update barang set jml_brg='"+""+sisastock+"' where kode_brg = '"+xkdbrg.getText()+"'");
            if (pstm.executeUpdate()>0){
            }else{
            }
        }
    }
    
    private void nofaktur() {
        try {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement();
            ResultSet res = stm.executeQuery("select * from penjualan order by nomor_faktur desc");
            if (res.next()) {
                String nofak = res.getString("nomor_faktur").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                switch (AN.length()) {
                    case 1:
                        Nol = "000";
                        break;
                    case 2:
                        Nol = "00";
                        break;
                    case 3:
                        Nol = "0";
                        break;
                    case 4:
                        Nol = "";
                        break;
                    default:
                        break;
                }

                xnofak.setText("F" + Nol + AN);
            } else {
                xnofak.setText("F0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void Waktu(){
        Date tgl = new Date();
        xtgl.setDate(tgl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUtama = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        homebutton = new javax.swing.JButton();
        masterbutton = new javax.swing.JButton();
        transaksibutton = new javax.swing.JButton();
        laporanbutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        contentpanel = new javax.swing.JPanel();
        panelhome = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelmaster = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Data_pelanggan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablePelanggan = new javax.swing.JTable();
        save_pelanggan = new javax.swing.JButton();
        update_pelanggan = new javax.swing.JButton();
        delete_pelanggan = new javax.swing.JButton();
        nm_pel = new javax.swing.JTextField();
        telp_pel = new javax.swing.JTextField();
        almt_pel = new javax.swing.JTextField();
        kota_pel = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        kd_pel = new javax.swing.JTextField();
        Laporan_Pelanggan = new javax.swing.JButton();
        ExportPelanggan = new javax.swing.JButton();
        Data_barang = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableBarang = new javax.swing.JTable();
        savebarang = new javax.swing.JButton();
        update_barang = new javax.swing.JButton();
        delete_barang = new javax.swing.JButton();
        nm_brg = new javax.swing.JTextField();
        jml_brg = new javax.swing.JTextField();
        sat_brg = new javax.swing.JTextField();
        hrg_brg = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        kd_brg = new javax.swing.JTextField();
        Laporan_Barang = new javax.swing.JButton();
        ExportBarang = new javax.swing.JButton();
        paneltransaksi = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        xtgl = new com.toedter.calendar.JDateChooser();
        xnofak = new javax.swing.JTextField();
        xkdpel = new javax.swing.JTextField();
        xnmpel = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        xalmtpel = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        xnmkasir = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        xkdbrg = new javax.swing.JTextField();
        xnmbrg = new javax.swing.JTextField();
        xsatbrg = new javax.swing.JTextField();
        xjmlbrg = new javax.swing.JTextField();
        xhrgbrg = new javax.swing.JTextField();
        xtotbrg = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        InputButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        xtotfak = new javax.swing.JTextField();
        panellaporan = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablePenjualan = new javax.swing.JTable();
        Laporan_Penjualan = new javax.swing.JButton();
        ExportPenjualan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMenu.setBackground(new java.awt.Color(204, 255, 255));

        homebutton.setText("Home");
        homebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebuttonActionPerformed(evt);
            }
        });

        masterbutton.setText("Master");
        masterbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterbuttonActionPerformed(evt);
            }
        });

        transaksibutton.setText("Transaksi");
        transaksibutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksibuttonActionPerformed(evt);
            }
        });

        laporanbutton.setText("Laporan");
        laporanbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanbuttonActionPerformed(evt);
            }
        });

        exitbutton.setText("Keluar");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("PT MAJU JAYA");

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(homebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(masterbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transaksibutton, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(laporanbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(homebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(masterbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(transaksibutton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(laporanbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280)
                .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentpanel.setBackground(new java.awt.Color(204, 204, 255));
        contentpanel.setLayout(new java.awt.CardLayout());

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel19.setText("Home");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel19)
                .addContainerGap(888, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel19)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Selamat Datang");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelhomeLayout = new javax.swing.GroupLayout(panelhome);
        panelhome.setLayout(panelhomeLayout);
        panelhomeLayout.setHorizontalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelhomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelhomeLayout.setVerticalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentpanel.add(panelhome, "card2");

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel18.setText("Master");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel18)
                .addContainerGap(880, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Data_pelanggan.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Data Pelanggan");

        TablePelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TablePelanggan);

        save_pelanggan.setText("Save");
        save_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_pelangganActionPerformed(evt);
            }
        });

        update_pelanggan.setText("Update");
        update_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_pelangganActionPerformed(evt);
            }
        });

        delete_pelanggan.setText("Delete");
        delete_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_pelangganActionPerformed(evt);
            }
        });

        nm_pel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nm_pelKeyPressed(evt);
            }
        });

        telp_pel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telp_pelKeyPressed(evt);
            }
        });

        almt_pel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                almt_pelKeyPressed(evt);
            }
        });

        jLabel21.setText("Kode Pelanggan");

        jLabel22.setText("Nama Pelanggan");

        jLabel23.setText("Telp");

        jLabel24.setText("Alamat");

        jLabel25.setText("Kota");

        kd_pel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kd_pelKeyPressed(evt);
            }
        });

        Laporan_Pelanggan.setText("Cetak");
        Laporan_Pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Laporan_PelangganActionPerformed(evt);
            }
        });

        ExportPelanggan.setText("Export");
        ExportPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Data_pelangganLayout = new javax.swing.GroupLayout(Data_pelanggan);
        Data_pelanggan.setLayout(Data_pelangganLayout);
        Data_pelangganLayout.setHorizontalGroup(
            Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Data_pelangganLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Data_pelangganLayout.createSequentialGroup()
                        .addComponent(save_pelanggan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_pelanggan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete_pelanggan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Laporan_Pelanggan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExportPelanggan))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Data_pelangganLayout.createSequentialGroup()
                        .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(Data_pelangganLayout.createSequentialGroup()
                                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kd_pel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nm_pel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telp_pel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(almt_pel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kota_pel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Data_pelangganLayout.setVerticalGroup(
            Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Data_pelangganLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nm_pel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telp_pel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(almt_pel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kota_pel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kd_pel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Data_pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_pelanggan)
                    .addComponent(update_pelanggan)
                    .addComponent(delete_pelanggan)
                    .addComponent(Laporan_Pelanggan)
                    .addComponent(ExportPelanggan))
                .addGap(14, 14, 14))
        );

        Data_barang.setBackground(new java.awt.Color(255, 255, 204));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Data Barang");

        TableBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TableBarang);

        savebarang.setText("Save");
        savebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebarangActionPerformed(evt);
            }
        });

        update_barang.setText("Update");
        update_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_barangActionPerformed(evt);
            }
        });

        delete_barang.setText("Delete");
        delete_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_barangActionPerformed(evt);
            }
        });

        nm_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nm_brgKeyPressed(evt);
            }
        });

        jml_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jml_brgKeyPressed(evt);
            }
        });

        sat_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sat_brgKeyPressed(evt);
            }
        });

        jLabel26.setText("Kode Barang");

        jLabel27.setText("Nama Barang");

        jLabel28.setText("Jumlah");

        jLabel29.setText("Satuan");

        jLabel30.setText("Harga");

        kd_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kd_brgKeyPressed(evt);
            }
        });

        Laporan_Barang.setText("Cetak");
        Laporan_Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Laporan_BarangActionPerformed(evt);
            }
        });

        ExportBarang.setText("Export");
        ExportBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Data_barangLayout = new javax.swing.GroupLayout(Data_barang);
        Data_barang.setLayout(Data_barangLayout);
        Data_barangLayout.setHorizontalGroup(
            Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Data_barangLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Data_barangLayout.createSequentialGroup()
                        .addComponent(savebarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_barang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete_barang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Laporan_Barang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExportBarang))
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Data_barangLayout.createSequentialGroup()
                        .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(kd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jml_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sat_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(hrg_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        Data_barangLayout.setVerticalGroup(
            Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Data_barangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jml_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sat_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hrg_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(Data_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebarang)
                    .addComponent(update_barang)
                    .addComponent(delete_barang)
                    .addComponent(Laporan_Barang)
                    .addComponent(ExportBarang))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout panelmasterLayout = new javax.swing.GroupLayout(panelmaster);
        panelmaster.setLayout(panelmasterLayout);
        panelmasterLayout.setHorizontalGroup(
            panelmasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmasterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelmasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Data_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Data_barang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelmasterLayout.setVerticalGroup(
            panelmasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmasterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Data_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentpanel.add(panelmaster, "card3");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Transaksi Penjualan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        jLabel7.setText("Tanggal");

        jLabel8.setText("No. Faktur");

        jLabel4.setText("Kode Pelanggan");

        jLabel9.setText("Nama Pelanggan");

        xtgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xtglKeyPressed(evt);
            }
        });

        xnofak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xnofakKeyPressed(evt);
            }
        });

        xkdpel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xkdpelKeyPressed(evt);
            }
        });

        jLabel13.setText("Alamat Pelanggan");

        jLabel31.setText("Nama Kasir");

        xnmkasir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xnmkasirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xtgl, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(xnofak)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xnmkasir)))
                .addGap(127, 127, 127)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xkdpel)
                    .addComponent(xnmpel)
                    .addComponent(xalmtpel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(xtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(xkdpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(xnofak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(xnmkasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xnmpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xalmtpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel10.setText("Kode Barang");

        jLabel11.setText("Nama Barang");

        jLabel12.setText("Satuan");

        jLabel14.setText("Jumlah");

        jLabel15.setText("Harga");

        jLabel16.setText("Total Harga");

        xkdbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xkdbrgActionPerformed(evt);
            }
        });
        xkdbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xkdbrgKeyPressed(evt);
            }
        });

        xjmlbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xjmlbrgKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xkdbrg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(xnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xsatbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xjmlbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(xhrgbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(xtotbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xsatbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xjmlbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xhrgbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xtotbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        Tabel1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        InputButton.setText("INPUT");
        InputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("DELETE");

        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel17.setText("Total Faktur");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(InputButton)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton)
                .addGap(18, 18, 18)
                .addComponent(SaveButton)
                .addGap(191, 191, 191)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(xtotfak, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(xtotfak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout paneltransaksiLayout = new javax.swing.GroupLayout(paneltransaksi);
        paneltransaksi.setLayout(paneltransaksiLayout);
        paneltransaksiLayout.setHorizontalGroup(
            paneltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneltransaksiLayout.setVerticalGroup(
            paneltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentpanel.add(paneltransaksi, "card4");

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Laporan Penjualan");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 204, 204));

        TablePenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TablePenjualan);

        Laporan_Penjualan.setText("Cetak");
        Laporan_Penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Laporan_PenjualanActionPerformed(evt);
            }
        });

        ExportPenjualan.setText("Export");
        ExportPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportPenjualanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(Laporan_Penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ExportPenjualan)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Laporan_Penjualan)
                    .addComponent(ExportPenjualan))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout panellaporanLayout = new javax.swing.GroupLayout(panellaporan);
        panellaporan.setLayout(panellaporanLayout);
        panellaporanLayout.setHorizontalGroup(
            panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panellaporanLayout.setVerticalGroup(
            panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentpanel.add(panellaporan, "card5");

        javax.swing.GroupLayout PanelUtamaLayout = new javax.swing.GroupLayout(PanelUtama);
        PanelUtama.setLayout(PanelUtamaLayout);
        PanelUtamaLayout.setHorizontalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUtamaLayout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelUtamaLayout.setVerticalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebuttonActionPerformed
        // TODO add your handling code here:
        contentpanel.removeAll();
        contentpanel.repaint();
        contentpanel.revalidate();
        
        contentpanel.add(panelhome);
        contentpanel.repaint();
        contentpanel.revalidate();
    }//GEN-LAST:event_homebuttonActionPerformed

    private void masterbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterbuttonActionPerformed
        //TODO add your handling code here:
        contentpanel.removeAll();
        contentpanel.repaint();
        contentpanel.revalidate();
        
        contentpanel.add(panelmaster);
        contentpanel.repaint();
        contentpanel.revalidate();

    }//GEN-LAST:event_masterbuttonActionPerformed

    private void transaksibuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksibuttonActionPerformed
        // TODO add your handling code here:
        contentpanel.removeAll();
        contentpanel.repaint();
        contentpanel.revalidate();
        
        contentpanel.add(paneltransaksi);
        contentpanel.repaint();
        contentpanel.revalidate();
    }//GEN-LAST:event_transaksibuttonActionPerformed

    private void laporanbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanbuttonActionPerformed
        // TODO add your handling code here:
        contentpanel.removeAll();
        contentpanel.repaint();
        contentpanel.revalidate();
        
        contentpanel.add(panellaporan);
        contentpanel.repaint();
        contentpanel.revalidate();
    }//GEN-LAST:event_laporanbuttonActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbuttonActionPerformed

    private void xnofakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xnofakKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_xnofakKeyPressed

    private void xkdpelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xkdpelKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                conn = (Connection) DriverManager.getConnection(url, user, pass);
                stm = conn.createStatement();
                //System.out.println("koneksi berhasil;");
                ResultSet res = stm.executeQuery("select * from pelanggan where kode_pelanggan = '" + xkdpel.getText() + "'");
                if (res.next()) {
                    xnmpel.setText(res.getString("nama_pelanggan"));
                    xalmtpel.setText(res.getString("alamat_pelanggan"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiJual.class.getName()).log(Level.SEVERE, null, ex);
            }

            kontrol_tengah(true);
            xkdbrg.requestFocus();
        }
    }//GEN-LAST:event_xkdpelKeyPressed

    private void xkdbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xkdbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xkdbrgActionPerformed

    private void xkdbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xkdbrgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                conn = (Connection) DriverManager.getConnection(url, user, pass);
                stm = conn.createStatement();
                //System.out.println("koneksi berhasil;");
                ResultSet res = stm.executeQuery("select * from barang where kode_brg = '" + xkdbrg.getText() + "'");
                if (res.next()) {
                    xnmbrg.setText(res.getString("nama_brg"));
                    xsatbrg.setText(res.getString("satuan_brg"));
                    xhrgbrg.setText(res.getString("hrg_brg"));
                    xjmlbrg.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiJual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_xkdbrgKeyPressed

    private void xjmlbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xjmlbrgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int jml = Integer.parseInt(xjmlbrg.getText());
            int hrg = Integer.parseInt(xhrgbrg.getText());

            int hasil = jml * hrg;
            xtotbrg.setText("" + hasil);
            try {
                simpan_datatransaksi();
                jumlah_barang();
                tampil_datatransaksi();
                kosongkan_barang_transaksi();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiJual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_xjmlbrgKeyPressed

    private void InputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputButtonActionPerformed
        // TODO add your handling code here:
        kontrol_atas(true);
        xnmkasir.requestFocus();
    }//GEN-LAST:event_InputButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        try {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement();
            ResultSet res = stm.executeQuery("select * from temporary_jual");
            while (res.next()) {
                PreparedStatement pstm = conn.prepareStatement("insert into penjualan"
                    + "(nomor_faktur, tgl_faktur, kd_brg, nm_brg, kode_pelanggan, nm_pel, jumlah,tot_faktur, nm_kasir )"
                    + "values ( '"+res.getString("nomor_faktur")+"', '"+res.getString("tgl_faktur")+"', '"+res.getString("kode_brg")+"',"
                    + " '"+res.getString("nama_brg")+"','"+res.getString("kode_pelanggan")+"','"+res.getString("nama_pelanggan")+"',"
                    + " '"+res.getString("jml_brg")+"', '"+res.getString("total_brg")+"','"+res.getString("nm_kasir")+"')");

                if (pstm.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this, "Simpan ke Penjualan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Simpan ke Penjualan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    pstm.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiJual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void kd_pelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kd_pelKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                conn = (Connection) DriverManager.getConnection(url, user, pass);
                stm = conn.createStatement();
                //System.out.println("koneksi berhasil;");
                ResultSet res = stm.executeQuery("select * from pelanggan where kode_pelanggan = '" + kd_pel.getText() + "'");
                if (res.next()) {
                    nm_pel.setText(res.getString("nama_pelanggan"));
                    telp_pel.setText(res.getString("telp_pelanggan"));
                    almt_pel.setText(res.getString("alamat_pelanggan"));
                    kota_pel.setText(res.getString("kota_pelanggan"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            nm_pel.requestFocus();
        }
    }//GEN-LAST:event_kd_pelKeyPressed

    private void nm_pelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nm_pelKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            telp_pel.requestFocus();
        }
    }//GEN-LAST:event_nm_pelKeyPressed

    private void telp_pelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telp_pelKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            almt_pel.requestFocus();
        }
    }//GEN-LAST:event_telp_pelKeyPressed

    private void almt_pelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_almt_pelKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kota_pel.requestFocus();
        }
    }//GEN-LAST:event_almt_pelKeyPressed

    private void save_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_pelangganActionPerformed
        // TODO add your handling code here:
        try {
            simpan_datapelanggan();
            tampil_datapelanggan();
            kosongkan_pelanggan_master();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_save_pelangganActionPerformed

    private void update_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_pelangganActionPerformed
        // TODO add your handling code here:
        try {
            update_datapelanggan();
            tampil_datapelanggan();
            kosongkan_pelanggan_master();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_update_pelangganActionPerformed

    private void delete_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_pelangganActionPerformed
        // TODO add your handling code here:
        try {
            hapus_datapelanggan();
            tampil_datapelanggan();
            kosongkan_pelanggan_master();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delete_pelangganActionPerformed

    private void kd_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kd_brgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                conn = (Connection) DriverManager.getConnection(url, user, pass);
                stm = conn.createStatement();
                //System.out.println("koneksi berhasil;");
                ResultSet res = stm.executeQuery("select * from barang where kode_brg= '" + kd_brg.getText() + "'");
                if (res.next()) {
                    nm_brg.setText(res.getString("nama_brg"));
                    jml_brg.setText(res.getString("jml_brg"));
                    sat_brg.setText(res.getString("satuan_brg"));
                    hrg_brg.setText(res.getString("hrg_brg"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            nm_brg.requestFocus();
        }
    }//GEN-LAST:event_kd_brgKeyPressed

    private void nm_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nm_brgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jml_brg.requestFocus();
        }
    }//GEN-LAST:event_nm_brgKeyPressed

    private void jml_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jml_brgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sat_brg.requestFocus();
        }
    }//GEN-LAST:event_jml_brgKeyPressed

    private void sat_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sat_brgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            hrg_brg.requestFocus();
        }
    }//GEN-LAST:event_sat_brgKeyPressed

    private void savebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebarangActionPerformed
        // TODO add your handling code here:
        try {
            simpan_databarang();
            tampil_databarang();
            kosongkan_barang_master();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_savebarangActionPerformed

    private void update_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_barangActionPerformed
        // TODO add your handling code here:
        try {
            update_databarang();
            tampil_databarang();
            kosongkan_barang_master();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_update_barangActionPerformed

    private void delete_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_barangActionPerformed
        // TODO add your handling code here:
        try {
            hapus_databarang();
            tampil_databarang();
            kosongkan_barang_master();

        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delete_barangActionPerformed

    private void xtglKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtglKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            xnmkasir.requestFocus();
        }
    }//GEN-LAST:event_xtglKeyPressed

    private void Laporan_PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Laporan_PelangganActionPerformed
        // TODO add your handling code here:
       try {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            File namafile = new File("src/Laporan/report_pelanggan.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Laporan_PelangganActionPerformed

    private void Laporan_BarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Laporan_BarangActionPerformed
        // TODO add your handling code here:
        try {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            File namafile = new File("src/Laporan/report_barang.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Laporan_BarangActionPerformed

    private void Laporan_PenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Laporan_PenjualanActionPerformed
        // TODO add your handling code here:
         try {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            File namafile = new File("src/Laporan/report_penjualan.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Laporan_PenjualanActionPerformed

    private void xnmkasirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xnmkasirKeyPressed
        // TODO add your handling code here:
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            xkdpel.requestFocus();
        }
    }//GEN-LAST:event_xnmkasirKeyPressed

    private void ExportPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportPenjualanActionPerformed
        // TODO add your handling code here:
        ExportToExcel ex = new ExportToExcel(TablePenjualan, new File("DataPenjualan.xls")); 
    }//GEN-LAST:event_ExportPenjualanActionPerformed

    private void ExportPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportPelangganActionPerformed
        // TODO add your handling code here:
        ExportToExcel ex = new ExportToExcel(TablePelanggan, new File("DataPelanggan.xls"));
    }//GEN-LAST:event_ExportPelangganActionPerformed

    private void ExportBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportBarangActionPerformed
        // TODO add your handling code here:
        ExportToExcel ex = new ExportToExcel(TableBarang, new File("DataBarang.xls"));
    }//GEN-LAST:event_ExportBarangActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MenuUtama().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Data_barang;
    private javax.swing.JPanel Data_pelanggan;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton ExportBarang;
    private javax.swing.JButton ExportPelanggan;
    private javax.swing.JButton ExportPenjualan;
    private javax.swing.JButton InputButton;
    private javax.swing.JButton Laporan_Barang;
    private javax.swing.JButton Laporan_Pelanggan;
    private javax.swing.JButton Laporan_Penjualan;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelUtama;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTable Tabel1;
    private javax.swing.JTable TableBarang;
    private javax.swing.JTable TablePelanggan;
    private javax.swing.JTable TablePenjualan;
    private javax.swing.JTextField almt_pel;
    private javax.swing.JPanel contentpanel;
    private javax.swing.JButton delete_barang;
    private javax.swing.JButton delete_pelanggan;
    private javax.swing.JButton exitbutton;
    private javax.swing.JButton homebutton;
    private javax.swing.JTextField hrg_brg;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JTextField jml_brg;
    private javax.swing.JTextField kd_brg;
    private javax.swing.JTextField kd_pel;
    private javax.swing.JTextField kota_pel;
    private javax.swing.JButton laporanbutton;
    private javax.swing.JButton masterbutton;
    private javax.swing.JTextField nm_brg;
    private javax.swing.JTextField nm_pel;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panellaporan;
    private javax.swing.JPanel panelmaster;
    private javax.swing.JPanel paneltransaksi;
    private javax.swing.JTextField sat_brg;
    private javax.swing.JButton save_pelanggan;
    private javax.swing.JButton savebarang;
    private javax.swing.JTextField telp_pel;
    private javax.swing.JButton transaksibutton;
    private javax.swing.JButton update_barang;
    private javax.swing.JButton update_pelanggan;
    private javax.swing.JTextField xalmtpel;
    private javax.swing.JTextField xhrgbrg;
    private javax.swing.JTextField xjmlbrg;
    private javax.swing.JTextField xkdbrg;
    private javax.swing.JTextField xkdpel;
    private javax.swing.JTextField xnmbrg;
    private javax.swing.JTextField xnmkasir;
    private javax.swing.JTextField xnmpel;
    private javax.swing.JTextField xnofak;
    private javax.swing.JTextField xsatbrg;
    private com.toedter.calendar.JDateChooser xtgl;
    private javax.swing.JTextField xtotbrg;
    private javax.swing.JTextField xtotfak;
    // End of variables declaration//GEN-END:variables
}
