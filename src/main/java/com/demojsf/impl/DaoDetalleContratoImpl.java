
package com.demojsf.impl;

import com.demojsf.db.JdbcConnect;
import com.demojsf.model.DetalleContrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.demojsf.dao.DaoDetalleContrato;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoDetalleContratoImpl implements DaoDetalleContrato<DetalleContrato> {

    @Override
    public void save(DetalleContrato dc) {
        try {
            if (existe(dc)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Contrato ya existe...."));
            } else {
                
                Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into DetalleContrato (idDetalleContratoConcep,idcontra,idconc,valor,estado,periodo_ini,periodo_fin) values(?,?,?,?,?,?,?)");
            pst.setInt(1, dc.getIdDetalleContratoConcep());
            pst.setInt(2, dc.getIdcontra());
            pst.setInt(3, dc.getIdconc());
            pst.setDouble(4, dc.getValor());
            pst.setString(5, dc.getEstado());
            pst.setTimestamp(6, new Timestamp (dc.getPeriodo_ini().getTime()));
            pst.setTimestamp(7, new Timestamp (dc.getPeriodo_fin().getTime()));           
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    } catch (SQLException ex) {
            Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
       

    @Override
    public void update(DetalleContrato dc) {
        Connection connect = null;
        
        System.out.println("SSSSiiiiiiiii");
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Update DetalleContrato set idcontra=?,idconc=?,valor=?,estado=?,periodo_ini=?,periodo_fin=? where idDetalleContratoConcep=?");
            pst.setInt(7, dc.getIdDetalleContratoConcep());
            pst.setInt(1, dc.getIdcontra());
            pst.setInt(2, dc.getIdconc());
            pst.setDouble(3, dc.getValor());
            pst.setString(4, dc.getEstado());
            pst.setTimestamp(5, new Timestamp (dc.getPeriodo_ini().getTime()));
            pst.setTimestamp(6, new Timestamp (dc.getPeriodo_fin().getTime()));
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(DetalleContrato dc) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from DetalleContrato where idDetalleContratoConcep=?");
            
            pst.setInt(1, dc.getIdDetalleContratoConcep());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<DetalleContrato> getDetalleContrato() {
        List<DetalleContrato> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.
                    prepareStatement("Select * from DetalleContrato order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DetalleContrato dc = new DetalleContrato();
                dc.setIdDetalleContratoConcep(rs.getInt(1));
                dc.setIdcontra(rs.getInt(2));
                dc.setIdconc(rs.getInt(3));
                dc.setValor(rs.getInt(4));
                dc.setEstado(rs.getString(5));
                dc.setPeriodo_ini(rs.getDate(6));
                dc.setPeriodo_fin(rs.getDate(7));
                lista.add(dc);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoDetalleContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
    public boolean existe(DetalleContrato dc) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from DetalleContrato where idcontra=? and idconc=?");
        pst.setInt(1, dc.getIdcontra());
        pst.setInt(2, dc.getIdconc());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }
}
