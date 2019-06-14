

package com.demojsf.impl;

import com.demojsf.dao.DaoPropietario;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoPropietarioImpl implements DaoPropietario<Propietario>{

    @Override
    public void save(Propietario p) {
        try {
            if (existe(p)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Propietario ya existe..."));
            } else {

                Connection connect = null;
                try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into propietarios(ccnit,nombre,direccion,telefono,celular,email,ciudad,sexo,porccomi,idpropietario) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, p.getCcnit());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getDireccion());
            pst.setString(4, p.getTelefono());
            pst.setString(5, p.getCelular());
            pst.setString(6, p.getEmail());
            pst.setString(7, p.getCiudad());
            pst.setString(8, p.getSexo());
            pst.setInt(9, p.getPorccomi());
            pst.setInt(10, p.getIdpropietario());

            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException  | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Propietario p) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect. prepareStatement("Update propietarios set ccnit=?,nombre=?,direccion=?,telefono=?,celular=?,email=?,ciudad=?,sexo=?,porccomi=? where idpropietario=?");
            pst.setInt(10, p.getIdpropietario());
            pst.setString(1, p.getCcnit());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getDireccion());
            pst.setString(4, p.getTelefono());
            pst.setString(5, p.getCelular());
            pst.setString(6, p.getEmail());
            pst.setString(7, p.getCiudad());
            pst.setString(8, p.getSexo());
            pst.setInt(9, p.getPorccomi());
            pst.executeUpdate();
 
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex);
       
        }
    }

    @Override
    public void delete(Propietario p) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Propietarios where Idpropietario=?");
            
            pst.setInt(1, p.getIdpropietario());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Propietario> getProperty() {
        List<Propietario> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
           PreparedStatement pst = connect.prepareStatement("Select * from propietarios order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Propietario p = new Propietario();
                p.setCcnit(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDireccion(rs.getString(3));
                p.setTelefono(rs.getString(4));
                p.setCelular(rs.getString(5));
                p.setEmail(rs.getString(6));
                p.setCiudad(rs.getString(7));
                p.setSexo(rs.getString(8));
                p.setPorccomi(rs.getInt(9));
                p.setIdpropietario(rs.getInt(10));
                lista.add(p);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoPropietarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public boolean existe(Propietario p) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Propietarios  where ccnit=?");
        pst.setString(1, p.getCcnit());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}
