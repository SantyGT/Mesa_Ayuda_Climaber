
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
import com.demojsf.dao.DaoTipo;
//import com.demojsf.model.Cliente;
import com.demojsf.model.Tipo;
import java.sql.Timestamp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoTipoImpl implements DaoTipo<Tipo> {

    @Override
    public void save(Tipo t) {
        try {
            if (existe(t)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Tipo ya existe...."));
            } else {
                
                Connection connect = null;
                try {
        
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Tipo(id_tipo,nombre_tipo) values(?,?)");

            pst.setInt(1, t.getId_tipo());
            pst.setString(2, t.getNombre_tipo());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
            
    @Override
    public void update(Tipo t) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                     prepareStatement("Update Tipo set nombre_tipo=? where id_tipo=?");
            pst.setInt(2, t.getId_tipo());
            pst.setString(1, t.getNombre_tipo());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Tipo t) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Tipo where id_tipo=?");
            
            pst.setInt(1, t.getId_tipo());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Tipo> getTipo() {
        List<Tipo> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from Tipo order by 1");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Tipo t = new Tipo();

                t.setId_tipo(rs.getInt(1));
                t.setNombre_tipo(rs.getString(2));
                lista.add(t);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DaoTipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/
     
     public boolean existe(Tipo t) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Tipo where id_tipo=?");
        pst.setInt(1, t.getId_tipo());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}