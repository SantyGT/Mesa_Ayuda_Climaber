
package com.demojsf.impl;

import com.demojsf.dao.DaoCliente;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Cliente;
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

public class DaoClienteImpl implements DaoCliente<Cliente> {

    @Override
    public void save(Cliente c) {
        try {
            if (existe(c)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Concepto ya existe...."));
            } else {

                Connection connect = null;
                try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Insert into clientes (idcliente,nombre,ccnit,direccion,telefono,celular,email,ciudad,sexo,asesor) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, c.getIdcliente());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getCcnit());
            pst.setString(4, c.getDireccion());
            pst.setString(5, c.getTelefono());
            pst.setString(6, c.getCelular());
            pst.setString(7, c.getEmail());
            pst.setString(8, c.getCiudad());
            pst.setString(9, c.getSexo());
            pst.setString(10, c.getAsesor());
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException  ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        } catch (SQLException ex) {
            Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Cliente c) {
        Connection connect = null;
        try {
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Update  clientes set ccnit=?,nombre=?,direccion=?,telefono=?,celular=?,email=?,ciudad=?,sexo=?,asesor=? where idcliente=?");
            
            pst.setInt(10, c.getIdcliente());
            pst.setString(1, c.getCcnit());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getTelefono());
            pst.setString(5, c.getCelular());
            pst.setString(6, c.getEmail());
            pst.setString(7, c.getCiudad());
            pst.setString(8, c.getSexo());
            pst.setString(9, c.getAsesor());
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Cliente c) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from clientes where idcliente=?");
            
            pst.setInt(1, c.getIdcliente());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> getCliente() {
        List<Cliente> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.
                    prepareStatement("Select * from clientes order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt(1));
                c.setNombre(rs.getString(3));
                c.setCcnit(rs.getString(2));
                c.setDireccion(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setCelular(rs.getString(6));
                c.setEmail(rs.getString(7));
                c.setCiudad(rs.getString(8));
                c.setSexo(rs.getString(9));
                c.setAsesor(rs.getString(10));
                lista.add(c);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public boolean existe(Cliente c) throws SQLException, ClassNotFoundException {
        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from clientes where ccnit=?");
        pst.setString(1, c.getCcnit());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}
