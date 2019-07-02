
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
import com.demojsf.dao.DaoSolicitud;
import com.demojsf.model.Solicitud;
import java.sql.Timestamp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoSolicitudImpl implements DaoSolicitud<Solicitud> {

    @Override
    public void save(Solicitud s) {
        try {
            if (existe(s)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Solicitud ya existe...."));
            } else {
                
                Connection connect = null;
                try {
        
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Solicitud (id_solicitud,fecha_solicitud,id_area,nombre_usuario,cargo_solicitud,asunto_solicitud,observacion,id_estado,id_tipo_solicitud,id_lista_solicitud) values(?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, s.getId_solicitud());
            pst.setTimestamp(2, new Timestamp (s.getFecha_solicitud().getTime()));
            pst.setInt(3, s.getId_area());
            pst.setInt(4, s.getId_usuario());
            pst.setString(5, s.getCargo_solicitud());
            pst.setString(6, s.getAsunto_solicitud());
            pst.setString(7, s.getObservacion());
            pst.setInt(8, s.getId_estado());
            pst.setInt(9, s.getId_tipo_solicitud());
            pst.setInt(10, s.getId_lista_solicitud());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
            
    @Override
    public void update(Solicitud s) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                     prepareStatement("Update Solicitud set fecha_solicitud=?,id_area=?,nombre_usuario=?,cargo_solicitud=?,asunto_solicitud=?,observacion=?,id_estado=?,id_tipo_solicitud=?,id_lista_solicitud=? where id_solicitud=?");
            pst.setInt(11, s.getId_solicitud());
            pst.setTimestamp(1, new Timestamp (s.getFecha_solicitud().getTime()));
            pst.setInt(2, s.getId_area());
            pst.setInt(3, s.getId_usuario());
            pst.setString(4, s.getCargo_solicitud());
            pst.setString(5, s.getAsunto_solicitud());
            pst.setString(6, s.getObservacion());
            pst.setInt(7, s.getId_estado());
            pst.setInt(8, s.getId_tipo_solicitud());
            pst.setInt(9, s.getId_lista_solicitud());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Solicitud s) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Solicitud where id_solicitud=?");
            
            pst.setInt(1, s.getId_solicitud());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Solicitud> getSolicitud() {
        List<Solicitud> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from Solicitud order by 1");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Solicitud s = new Solicitud();

                s.setId_solicitud(rs.getInt(1));
                s.setFecha_solicitud(rs.getDate(2));
                s.setId_area(rs.getInt(3));
                s.setId_usuario(rs.getInt(4));
                s.setCargo_solicitud(rs.getString(5));
                s.setAsunto_solicitud(rs.getString(6));
                s.setObservacion(rs.getString(7));
                s.setId_estado(rs.getInt(8));
                s.setId_tipo_solicitud(rs.getInt(9));
                s.setId_lista_solicitud(rs.getInt(10));
                lista.add(s);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoSolicitudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
  
     public boolean existe(Solicitud s) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Solicitud where id_solicitud=?");
        pst.setInt(1, s.getId_solicitud());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}
