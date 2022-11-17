/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.perpus_controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.perpus_koneksi;
import view.perpus_view;

/**
 *
 * @author PC LAB 2
 */
public class perpus_model implements perpus_controller{

    @Override
    public void Simpan(perpus_view pv) throws SQLException {
        try{
    Connection con = perpus_koneksi.getcon();
    String sql = "Insert Into perpus Values(?,?)";
    PreparedStatement prepare = con.prepareStatement(sql);
    prepare.setString(1, pv.txtNo.getText());
    prepare.setString(2, pv.txtJudul.getText());
    prepare.executeUpdate();
    JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
    prepare.close();
    } catch (Exception e){
    System.out.println(e);
    } finally {
    Tampil(pv);
    
        } 
    }

    @Override
    public void Ubah(perpus_view pv) throws SQLException {
        try {
    Connection con = perpus_koneksi.getcon();
    String sql = "UPDATE perpus SET judul_buku=?" + "WHERE no_buku=?";
    PreparedStatement prepare = con.prepareStatement(sql);
    prepare.setString(2, pv.txtNo.getText());
    prepare.setString(1, pv.txtJudul.getText());
    prepare.executeUpdate();
    JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
    prepare.close();
    } catch (Exception e){
        System.out.println(e);
    } finally {
    Tampil(pv);
    }
    }

    @Override
    public void Hapus(perpus_view pv) throws SQLException {
        try{
            Connection con = perpus_koneksi.getcon();
            String sql ="DELETE FROM perpus WHERE no_buku =?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, pv.txtNo.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
    } finally{
           Tampil(pv);
        }
    }

    @Override
    public void Tampil(perpus_view pv) throws SQLException {
        pv.tblmodel.getDataVector().removeAllElements();
     pv.tblmodel.fireTableDataChanged();
        try {
            Connection con = perpus_koneksi.getcon();
            Statement stt = con.createStatement();
           // Query Menampilkan Semua Data Pada Table Siswa
           // Dengan Urutan NIS Dari Kecil Ke Besar
           String sql = "SELECT * FROM perpus";
           ResultSet res = stt.executeQuery(sql);
            while (res.next()) {                
                Object[] ob = new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                pv.tblmodel.addRow(ob);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }
