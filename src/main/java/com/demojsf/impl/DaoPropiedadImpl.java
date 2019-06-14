
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
import com.demojsf.dao.DaoPropiedades;
import com.demojsf.model.Propiedad;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class DaoPropiedadImpl implements DaoPropiedades<Propiedad> {

    @Override
    public void save(Propiedad p) {
        try {
            if (existe(p)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existente!", "Propiedad ya existe..."));
            } else {
               
                Connection connect = null;
                    try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Propiedad (codigo,nombre,pais,ciudad,barrio,sector,zona,direccion,area_tot,area_cons,estrato,tipo,valor,observacion,est_ocupacion,est_facturacion,idpropietario,idpropiedad) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, p.getCodigo());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getPais());
            pst.setString(4, p.getCiudad());
            pst.setString(5, p.getBarrio());
            pst.setString(6, p.getSector());
            pst.setString(7, p.getZona());
            pst.setString(8, p.getDireccion());
            pst.setInt(9, p.getArea_tot());
            pst.setInt(10, p.getArea_cons());
            pst.setString(11, p.getEstrato());
            pst.setString(12, p.getTipo());
            pst.setDouble(13, p.getValor());
            pst.setString(14, p.getObservacion());
            pst.setString(15, p.getEst_ocupacion());
            pst.setString(16, p.getEst_facturacion());
            pst.setInt(17, p.getIdpropietario());
            pst.setInt(18, p.getIdpropiedad());
                       
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void update(Propiedad p) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Update Propiedad set codigo=?,nombre=?,pais=?,ciudad=?,barrio=?,sector=?,zona=?,direccion=?,area_tot=?,area_cons=?,estrato=?,tipo=?,valor=?,observacion=?,est_ocupacion=?,est_facturacion=?,idpropietario=? where idpropiedad=?");
            pst.setInt(18, p.getIdpropiedad());
            pst.setString(1, p.getCodigo());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getPais());
            pst.setString(4, p.getCiudad());
            pst.setString(5, p.getBarrio());
            pst.setString(6, p.getSector());
            pst.setString(7, p.getZona());
            pst.setString(8, p.getDireccion());
            pst.setInt(9, p.getArea_tot());
            pst.setInt(10, p.getArea_cons());
            pst.setString(11, p.getEstrato());
            pst.setString(12, p.getTipo());
            pst.setDouble(13, p.getValor());
            pst.setString(14, p.getObservacion());
            pst.setString(15, p.getEst_ocupacion());
            pst.setString(16, p.getEst_facturacion());
            pst.setInt(17, p.getIdpropietario());
            
            pst.executeUpdate();
            
            connect.commit();
            
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Propiedad p) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Propiedad where idpropiedad=?");
            
            pst.setInt(1, p.getIdpropiedad());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Propiedad> getPropiedad() {
        List<Propiedad> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.
                    prepareStatement("Select * from Propiedad order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Propiedad p = new Propiedad();
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setPais(rs.getString(3));
                p.setCiudad(rs.getString(4));
                p.setBarrio(rs.getString(5));
                p.setSector(rs.getString(6));
                p.setZona(rs.getString(7));
                p.setDireccion(rs.getString(8));
                p.setArea_tot(rs.getInt(9));
                p.setArea_cons(rs.getInt(10));
                p.setEstrato(rs.getString(11));
                p.setTipo(rs.getString(12));
                p.setValor(rs.getDouble(13));
                p.setObservacion(rs.getString(14));
                p.setEst_ocupacion(rs.getString(15));
                p.setEst_facturacion(rs.getString(16));
                p.setIdpropietario(rs.getInt(17));
                p.setIdpropiedad(rs.getInt(18));
                lista.add(p);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoPropiedadImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     public boolean existe(Propiedad p) throws SQLException, ClassNotFoundException {

        Connection connect = JdbcConnect.getConnect();
        PreparedStatement pst = connect.prepareStatement("Select * from Propiedad where codigo=?");
        pst.setString(1, p.getCodigo());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return true;
        }

        return false;
    }
}