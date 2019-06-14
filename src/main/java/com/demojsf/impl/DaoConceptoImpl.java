
package com.demojsf.impl;

import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Concepto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.demojsf.dao.DaoConcepto;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoConceptoImpl implements DaoConcepto<Concepto> {

    @Override
    public void save(Concepto c) {
        try {
            if (existe(c)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Concepto ya existe...."));
            } else {

                Connection connect = null;
                try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Concepto (idconcepto,cod_concepto,nom_concepto,porcentaje_iva) values(?,?,?,?)");
            pst.setInt(1, c.getIdconcepto());
            pst.setString(2, c.getCod_concepto());
            pst.setString(3, c.getNom_concepto());
            pst.setInt(4, c.getPorcentaje_iva());
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        } catch (SQLException ex) {
            Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       

    @Override
    public void update(Concepto c) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Update Concepto set cod_concepto=?,nom_concepto=?,porcentaje_iva=? where idconcepto=?");
            pst.setInt(4, c.getIdconcepto());
            pst.setString(1, c.getCod_concepto());
            pst.setString(2, c.getNom_concepto());
            pst.setInt(3, c.getPorcentaje_iva());
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Concepto c) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Concepto where idconcepto=?");
            
            pst.setInt(1, c.getIdconcepto());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Concepto> getConcepto() {
        List<Concepto> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.
                    prepareStatement("Select * from Concepto order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Concepto c = new Concepto();
                c.setIdconcepto(rs.getInt(1));
                c.setCod_concepto(rs.getString(2));
                c.setNom_concepto(rs.getString(3));
                c.setPorcentaje_iva(rs.getInt(4));
                lista.add(c);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoConceptoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     public boolean existe(Concepto c) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Concepto where cod_concepto=?");
        pst.setString(1, c.getCod_concepto());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }
    
    
}
