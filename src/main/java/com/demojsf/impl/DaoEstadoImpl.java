
package com.demojsf.impl;

import com.demojsf.db.JdbcConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.demojsf.dao.DaoEstado;
//import com.demojsf.model.Cliente;
import com.demojsf.model.Estado;
import java.sql.Timestamp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoEstadoImpl implements DaoEstado<Estado> {

    @Override
    public void save(Estado e) {
        try {
            if (existe(e)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Estado ya existe...."));
            } else {
                
                Connection connect = null;
                try {
        
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Estado(id_estado,estado) values(?,?)");

            pst.setInt(1, e.getId_estado());
            pst.setString(2, e.getEstado());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
            
    @Override
    public void update(Estado e) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                     prepareStatement("Update Estado set estado=? where id_estado=?");
            pst.setInt(2, e.getId_estado());
            pst.setString(1, e.getEstado());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Estado e) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Estado where id_estado=?");
            
            pst.setInt(1, e.getId_estado());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Estado> getEstado() {
        List<Estado> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from Estado order by 1");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Estado e = new Estado();

                e.setId_estado(rs.getInt(1));
                e.setEstado(rs.getString(2));
                lista.add(e);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /*public List<String> ListaClientes() {
        List<String> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from Cliente order by 1");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Cliente c = new Cliente();

                c.setNombre(rs.getString(1));

                lista.add(c.getNombre());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoEstadoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/
     
    public boolean existe(Estado e) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Estado where id_estado=?");
        pst.setInt(1, e.getId_estado());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}