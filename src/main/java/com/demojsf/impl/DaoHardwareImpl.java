
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
import com.demojsf.dao.DaoHardware;
//import com.demojsf.model.Cliente;
import com.demojsf.model.Hardware;
import java.sql.Timestamp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoHardwareImpl implements DaoHardware<Hardware> {

    @Override
    public void save(Hardware h) {
        try {
            if (existe(h)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Hardware ya existe...."));
            } else {
                
                Connection connect = null;
                try {
        
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into sol_hardware (id_sol_hard,nombre_sol_hard) values(?,?)");

            pst.setInt(1, h.getId_sol_hard());
            pst.setString(2, h.getNombre_sol_hard());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
            
    @Override
    public void update(Hardware h) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                     prepareStatement("Update sol_hardware set nombre_sol_hard=? where id_sol_hard=?");
            pst.setInt(2, h.getId_sol_hard());
            pst.setString(1, h.getNombre_sol_hard());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Hardware h) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from sol_hardware where id_sol_hard=?");
            
            pst.setInt(1, h.getId_sol_hard());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Hardware> getHardware() {
        List<Hardware> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from sol_hardware order by 1");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Hardware h = new Hardware();

                h.setId_sol_hard(rs.getInt(1));
                h.setNombre_sol_hard(rs.getString(2));
                lista.add(h);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DaoHardwareImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/
     
     public boolean existe(Hardware h) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from sol_hardware where id_sol_hard=?");
        pst.setInt(1, h.getId_sol_hard());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}