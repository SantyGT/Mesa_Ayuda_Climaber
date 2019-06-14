
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
import com.demojsf.dao.DaoContrato;
import com.demojsf.model.Cliente;
import com.demojsf.model.Contrato;
import java.sql.Timestamp;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoContratoImpl implements DaoContrato<Contrato> {

    @Override
    public void save(Contrato ct) {
        try {
            if (existe(ct)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Contrato ya existe...."));
            } else {
                
                Connection connect = null;
                try {
        
            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Contrato(Numcontrato,Feccreacion,Fecinicio,Fecvenc,Idclie,Valor,Observacion,Estado,Idpropied) values(?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, ct.getNumcontrato());
            pst.setTimestamp(2, new Timestamp (ct.getFeccreacion().getTime()));
            pst.setTimestamp(3, new Timestamp (ct.getFecinicio().getTime()));
            pst.setTimestamp(4, new Timestamp (ct.getFecvenc().getTime()));
            pst.setInt(5, ct.getIdclie());
            pst.setDouble(6, ct.getValor());
            pst.setString(7, ct.getObservacion());
            pst.setString(8, ct.getEstado());
            pst.setInt(9, ct.getIdpropied());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
                    } catch (SQLException ex1) {
                        Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }        
            
            
            
    @Override
    public void update(Contrato ct) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                     prepareStatement("Update Contrato set feccreacion=?,fecinicio=?,fecvenc=?,idclie=?,valor=?,observacion=?,estado=?,idpropied=? where numcontrato=?");
            pst.setInt(9, ct.getNumcontrato());
            pst.setTimestamp(1, new Timestamp (ct.getFeccreacion().getTime()));
            pst.setTimestamp(2, new Timestamp (ct.getFecinicio().getTime()));
            pst.setTimestamp(3, new Timestamp (ct.getFecvenc().getTime()));
            pst.setInt(4, ct.getIdclie());
            pst.setDouble(5, ct.getValor());
            pst.setString(6, ct.getObservacion());
            pst.setString(7, ct.getEstado());
            pst.setInt(8, ct.getIdpropied());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Contrato c) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Contrato where Numcontrato=?");
            
            pst.setInt(1, c.getNumcontrato());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Contrato> getContrato() {
        List<Contrato> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from Contrato order by 1");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                 Contrato ct = new Contrato();

                ct.setNumcontrato(rs.getInt(1));
                ct.setFeccreacion(rs.getDate(2));
                ct.setFecinicio(rs.getDate(3));
                ct.setFecvenc(rs.getDate(4));
                ct.setIdclie(rs.getInt(5));
                ct.setValor(rs.getDouble(6));
                ct.setObservacion(rs.getString(7));
                ct.setEstado(rs.getString(8));
                ct.setIdpropied(rs.getInt(9));
                lista.add(ct);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     public List<String> ListaClientes() {
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
            Logger.getLogger(DaoContratoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
     
     public boolean existe(Contrato ct) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Contrato where numcontrato=?");
        pst.setInt(1, ct.getNumcontrato());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }

}
