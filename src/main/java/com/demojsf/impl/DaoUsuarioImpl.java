
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
import com.demojsf.dao.DaoUsuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoUsuarioImpl implements DaoUsuario<Usuario> {

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
                            prepareStatement("Insert into User values(?,?,?,?,?,?)");
                    pst.setInt(1, u.getIduser());
                    pst.setString(2, u.getNombre_usuario());
                    pst.setString(3, u.getCedula_usuario());
                    pst.setString(4, u.getCorreo());
                    pst.setString(5, u.getClave());
                    pst.setString(6, u.getEstado_usuario());
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

            PreparedStatement pst = connect.prepareStatement("Update User set Nombre_usuario=?,Cedula_usuario=?,Correo=?,Clave=?,Estado_usuario=? where Iduser=?");

            pst.setInt(6, u.getIduser());
            pst.setString(1, u.getNombre_usuario());
            pst.setString(2, u.getCedula_usuario());
            pst.setString(3, u.getCorreo());
            pst.setString(4, u.getClave());
            pst.setString(5, u.getEstado_usuario());
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
                u.setNombre_usuario(rs.getString(2));
                u.setCedula_usuario(rs.getString(3));
                u.setCorreo(rs.getString(4));
                u.setClave(rs.getString(5));
                u.setEstado_usuario(rs.getString(6));

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
