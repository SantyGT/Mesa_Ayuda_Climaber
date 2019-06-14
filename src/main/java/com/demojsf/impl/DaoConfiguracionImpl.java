
package com.demojsf.impl;

import com.demojsf.db.JdbcConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.demojsf.dao.DaoConfiguracion;
import com.demojsf.model.Configuracion;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoConfiguracionImpl implements DaoConfiguracion<Configuracion> {

    @Override
    public void save(Configuracion c) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Config (idconfig,nit_empresa,razon_social,nom_legal,telefono_emp,direccion_emp,email_emp,sitio_web_emp,ciudad_emp,pais_emp,resolu_dian,factura_dian,prefijo_dian,num_cons_fact,regimen_emp) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, c.getIdconfig());
            pst.setString(2, c.getNit_empresa());
            pst.setString(3, c.getRazon_social());
            pst.setString(4, c.getNom_legal());
            pst.setString(5, c.getTelefono_emp());
            pst.setString(6, c.getDireccion_emp());
            pst.setString(7, c.getEmail_emp());
            pst.setString(8, c.getSitio_web_emp());
            pst.setString(9, c.getCiudad_emp());
            pst.setString(10, c.getPais_emp());
            pst.setString(11, c.getResolu_dian());
            pst.setString(12, c.getFactura_dian());
            pst.setString(13, c.getPrefijo_dian());
            pst.setInt(14, c.getNum_cons_fact());
            pst.setString(15, c.getRegimen_emp());
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoConfiguracionImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoConfiguracionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Configuracion c) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Update Config set nit_empresa=?,razon_social=?,nom_legal=?,telefono_emp=?,direccion_emp=?,email_emp=?,sitio_web_emp=?,ciudad_emp=?,pais_emp=?,resolu_dian=?,factura_dian=?,prefijo_dian=?,num_cons_fact=?,regimen_emp=? where idconfig=?");
            pst.setInt(15, c.getIdconfig());
            pst.setString(1, c.getNit_empresa());
            pst.setString(2, c.getRazon_social());
            pst.setString(3, c.getNom_legal());
            pst.setString(4, c.getTelefono_emp());
            pst.setString(5, c.getDireccion_emp());
            pst.setString(6, c.getEmail_emp());
            pst.setString(7, c.getSitio_web_emp());
            pst.setString(8, c.getCiudad_emp());
            pst.setString(9, c.getPais_emp());
            pst.setString(10, c.getResolu_dian());
            pst.setString(11, c.getFactura_dian());
            pst.setString(12, c.getPrefijo_dian());
            pst.setInt(13, c.getNum_cons_fact());
            pst.setString(14, c.getRegimen_emp());
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoConfiguracionImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoConfiguracionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Configuracion c) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Config where Idconfig=?");
            
            pst.setInt(1, c.getIdconfig());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoConfiguracionImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoConfiguracionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Configuracion> getConfigs() {
        List<Configuracion> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.
                    prepareStatement("Select * from Config order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Configuracion c = new Configuracion();
                c.setIdconfig(rs.getInt(1));
                c.setNit_empresa(rs.getString(2));
                c.setRazon_social(rs.getString(3));
                c.setNom_legal(rs.getString(4));
                c.setTelefono_emp(rs.getString(5));
                c.setDireccion_emp(rs.getString(6));
                c.setEmail_emp(rs.getString(7));
                c.setSitio_web_emp(rs.getString(8));
                c.setCiudad_emp(rs.getString(9));
                c.setPais_emp(rs.getString(10));
                c.setResolu_dian(rs.getString(11));
                c.setFactura_dian(rs.getString(12));
                c.setPrefijo_dian(rs.getString(13));
                c.setNum_cons_fact(rs.getInt(14));
                c.setRegimen_emp(rs.getString(15));
                lista.add(c);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoConfiguracionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
