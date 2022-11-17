/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.perpus_view;

/**
 *
 * @author PC LAB 2
 */
public interface perpus_controller {
    public void Simpan(perpus_view pv) throws SQLException;
    public void Ubah(perpus_view pv) throws SQLException;
    public void Hapus(perpus_view pv) throws SQLException;
    public void Tampil(perpus_view pv) throws SQLException;
}
