
package com.demojsf.impl;

import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.demojsf.dao.DaoUser;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoUsuarioImpl implements DaoUser<Usuario> {

    @Override
    public void save(Usuario u) {
        
        try {
            if (existe(u)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Usuario ya existe...."));
            } else {
                
                Connection connect = null;
                try {

                    connect = JdbcConnect.getConnect();

                    PreparedStatement pst = connect.
                            prepareStatement("Insert into User values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setInt(1, u.getIduser());
                    pst.setString(2, u.getCorreo());
                    pst.setString(3, u.getClave());
                    pst.setBoolean(4, u.getM1_reg());
                    pst.setBoolean(5, u.getM11_proprio());
                    pst.setBoolean(6, u.getM12_propdad());
                    pst.setBoolean(7, u.getM13_cli());
                    pst.setBoolean(8, u.getM14_cont());
                    pst.setBoolean(9, u.getM2_fact());
                    pst.setBoolean(10, u.getM3_rec());
                    pst.setBoolean(11, u.getM4_com());
                    pst.setBoolean(12, u.getM5_inf());
                    pst.executeUpdate();
                    connect.commit();
                } catch (ClassNotFoundException | SQLException ex) {
                    try {
                        if (connect != null) {
                            connect.rollback();
                        }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Usuario u) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Update user set Correo=?,Clave=?,M1_reg=?,M11_proprio=?,M12_propdad=?,M13_cli=?,M14_cont=?,M2_fact=?,M3_rec=?,M4_com=?,M5_inf=? where Iduser=?");

            pst.setInt(12, u.getIduser());
            pst.setString(1, u.getCorreo());
            pst.setString(2, u.getClave());
            pst.setBoolean(3, u.getM1_reg());
            pst.setBoolean(4, u.getM11_proprio());
            pst.setBoolean(5, u.getM12_propdad());
            pst.setBoolean(6, u.getM13_cli());
            pst.setBoolean(7, u.getM14_cont());
            pst.setBoolean(8, u.getM2_fact());
            pst.setBoolean(9, u.getM3_rec());
            pst.setBoolean(10, u.getM4_com());
            pst.setBoolean(11, u.getM5_inf());

            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Usuario u) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from User where Iduser=?");

            pst.setInt(1, u.getIduser());

            pst.executeUpdate();

            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from User order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();

                u.setIduser(rs.getInt(1));
                u.setCorreo(rs.getString(2));
                u.setClave(rs.getString(3));
                u.setM1_reg(rs.getBoolean(4));
                u.setM11_proprio(rs.getBoolean(5));
                u.setM12_propdad(rs.getBoolean(6));
                u.setM13_cli(rs.getBoolean(7));
                u.setM14_cont(rs.getBoolean(8));
                u.setM2_fact(rs.getBoolean(9));
                u.setM3_rec(rs.getBoolean(10));
                u.setM4_com(rs.getBoolean(11));
                u.setM5_inf(rs.getBoolean(12));

                lista.add(u);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean existe(Usuario u) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from User where correo=?");
        pst.setString(1, u.getCorreo());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }
}
