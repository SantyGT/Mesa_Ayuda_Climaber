
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
import com.demojsf.dao.DaoSoftware;
//import com.demojsf.model.Cliente;
import com.demojsf.model.Software;
import java.sql.Timestamp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoSoftwareImpl implements DaoSoftware<Software> {

    @Override
    public void save(Software s) {
        try {
            if (existe(s)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Software ya existe...."));
            } else {
                
                Connection connect = null;
                try {
        
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Software(id_sol_soft,nombre_sol_soft) values(?,?)");

            pst.setInt(1, s.getId_sol_soft());
            pst.setString(2, s.getNombre_sol_soft());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
            
    @Override
    public void update(Software s) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                     prepareStatement("Update Software set nombre_sol_soft=? where id_sol_soft=?");
            pst.setInt(2, s.getId_sol_soft());
            pst.setString(1, s.getNombre_sol_soft());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Software s) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Software where id_sol_soft=?");
            
            pst.setInt(1, s.getId_sol_soft());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Software> getSoftware() {
        List<Software> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select id_sol_soft,nombre_sol_soft from Software ");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Software s = new Software();

                s.setId_sol_soft(rs.getInt(1));
                s.setNombre_sol_soft(rs.getString(2));
                lista.add(s);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DaoSoftwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/
     
     public boolean existe(Software s) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Software where id_sol_soft=?");
        pst.setInt(1, s.getId_sol_soft());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}