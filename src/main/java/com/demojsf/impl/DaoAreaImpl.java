
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
import com.demojsf.dao.DaoArea;
import com.demojsf.model.Area;
import java.sql.Timestamp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoAreaImpl implements DaoArea<Area> {

    @Override
    public void save(Area a) {
        try {
            if (existe(a)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Area ya existe...."));
            } else {
                
                Connection connect = null;
                try {
        
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Area(id_area,nombre_area) values(?,?)");

            pst.setInt(1, a.getId_area());
            pst.setString(2, a.getNombre_area());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
            
    @Override
    public void update(Area a) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                     prepareStatement("Update Area set nombre_area=? where id_area=?");
            pst.setInt(2, a.getId_area());
            pst.setString(1, a.getNombre_area());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Area a) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Area where id_area=?");
            
            pst.setInt(1, a.getId_area());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Area> getArea() {
        List<Area> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from Area order by 1");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Area a = new Area();

                a.setId_area(rs.getInt(1));
                a.setNombre_area(rs.getString(2));
                lista.add(a);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DaoAreaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/
     
    public boolean existe(Area a) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Area where id_area=?");
        pst.setInt(1, a.getId_area());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}
