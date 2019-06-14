
package com.demojsf.impl;

import com.demojsf.dao.DaoFactura;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoFacturaImpl implements DaoFactura<Factura> {

    @Override
    public void save(Factura f) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.
                    prepareStatement("Insert into Factura values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, f.getIdfactura());
            pst.setInt(2, f.getCons_factura());
            pst.setInt(3, f.getNum_contrato());
            pst.setTimestamp(4, new Timestamp(f.getFecha_creacion().getTime()));
            pst.setTimestamp(5, new Timestamp(f.getFecha_facturacion().getTime()));
            pst.setInt(6, f.getDias());
            pst.setString(7, f.getPrefijo());
            pst.setString(8, f.getCod_propiedad());
            pst.setString(9, f.getCc_nit_cliente());
            pst.setString(10, f.getObservacion());
            pst.setInt(11, f.getValor());
            pst.setInt(12, f.getSaldo_factura());
            pst.setInt(13, f.getIva());
            pst.setString(14, f.getEstado_factura());
            pst.setString(15, f.getEstado_comision());
            pst.setString(16, f.getEstado_recaudo());
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Factura f) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Update Factura set cons_factura=?,Num_contrato=?,Fecha_creacion=?,Fecha_facturacion=?,Dias=?,Prefijo=?,Cod_propiedad=?,Cc_nit_cliente=?,Observacion=?,Valor=?,Saldo_factura=?,Iva=?,Estado_factura=?,Estado_comision=?,Estado_recaudo where Idfactura=?");
            
            pst.setInt(16, f.getIdfactura());
            pst.setInt(1, f.getCons_factura());
            pst.setInt(2, f.getNum_contrato());
            pst.setTimestamp(3, new Timestamp(f.getFecha_creacion().getTime()));
            pst.setTimestamp(4, new Timestamp(f.getFecha_facturacion().getTime()));
            pst.setInt(5, f.getDias());
            pst.setString(6, f.getPrefijo());
            pst.setString(7, f.getCod_propiedad());
            pst.setString(8, f.getCc_nit_cliente());
            pst.setString(9, f.getObservacion());
            pst.setInt(10, f.getValor());
            pst.setInt(11, f.getSaldo_factura());
            pst.setInt(12, f.getIva());
            pst.setString(13, f.getEstado_factura());
            pst.setString(14, f.getEstado_comision());
            pst.setString(15, f.getEstado_recaudo());
            
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateComision(Factura f) {

        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Update Factura set Estado_comision='ON',ValorComision=? where Idfactura=?");
            
            pst.setInt(2, f.getIdfactura());
            pst.setDouble(1, f.getValorComision());
            
      
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateRecaudo(Factura f) {

        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Update Factura set Estado_recaudo='ON' where Idfactura=?");
            
            pst.setInt(1, f.getIdfactura());
                        
            pst.executeUpdate();
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Factura f) {
        Connection connect = null;
        try {

            connect = JdbcConnect.getConnect();

            PreparedStatement pst = connect.prepareStatement("Delete from Factura where Idfactura=?");
            
            pst.setInt(1, f.getIdfactura());
            
            pst.executeUpdate();
            
            connect.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Factura> getFact() {
        List<Factura> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select * from Factura order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();     
                
                f.setIdfactura(rs.getInt(1));
                f.setCons_factura(rs.getInt(2));
                f.setNum_contrato(rs.getInt(3));
                f.setFecha_creacion(rs.getDate(4));
                f.setFecha_facturacion(rs.getDate(5));
                f.setDias(rs.getInt(6));
                f.setPrefijo(rs.getString(7));
                f.setCod_propiedad(rs.getString(8));
                f.setCc_nit_cliente(rs.getString(9));
                f.setObservacion(rs.getString(10));
                f.setValor(rs.getInt(11));
                f.setSaldo_factura(rs.getInt(12));
                f.setIva(rs.getInt(13));
                f.setEstado_factura(rs.getString(14));
                f.setEstado_comision(rs.getString(15));
                f.setEstado_recaudo(rs.getString(16));

                lista.add(f);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        
    @Override
    public List<Factura> getListFact() {
        List<Factura> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select f.idfactura,f.cons_factura,f.idcontra,f.fecha_creacion,f.fecha_facturacion,f.dias"
                    + ",f.prefijo,f.idpropied,f.idclie,f.observacion,f.valor,f.saldo_factura,f.iva,f.estado_factura,f.estado_comision,f.estado_recaudo,pr.porccomi from Factura f "
                    + "inner join Propiedad p on f.idpropied = p.idpropiedad "
                    + "inner join Propietarios pr on pr.idpropietario = p.idpropietario "
                    + "where Estado_comision!='ON' order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();     
                
                f.setIdfactura(rs.getInt(1));
                f.setCons_factura(rs.getInt(2));
                f.setNum_contrato(rs.getInt(3));
                f.setFecha_creacion(rs.getDate(4));
                f.setFecha_facturacion(rs.getDate(5));
                f.setDias(rs.getInt(6));
                f.setPrefijo(rs.getString(7));
                f.setCod_propiedad(rs.getString(8));
                f.setCc_nit_cliente(rs.getString(9));
                f.setObservacion(rs.getString(10));
                f.setValor(rs.getInt(11));
                f.setSaldo_factura(rs.getInt(12));
                f.setIva(rs.getInt(13));
                f.setEstado_factura(rs.getString(14));
                f.setEstado_comision(rs.getString(15));
                f.setEstado_recaudo(rs.getString(16));
                f.setValorComision(rs.getInt(11)*rs.getDouble(17)/100);

                lista.add(f);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    @Override
    public List<Factura> getListRecau() {
        List<Factura> lista = new ArrayList<>();
        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select f.idfactura,f.cons_factura,f.idcontra,f.fecha_creacion,f.fecha_facturacion,f.dias"
                    + ",f.prefijo,f.idpropied,f.idclie,f.observacion,f.valor,f.saldo_factura,f.iva,f.estado_factura,f.estado_comision,f.estado_recaudo from Factura f "
                    + "where Estado_recaudo!='ON' order by 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();     
                
                f.setIdfactura(rs.getInt(1));
                f.setCons_factura(rs.getInt(2));
                f.setNum_contrato(rs.getInt(3));
                f.setFecha_creacion(rs.getDate(4));
                f.setFecha_facturacion(rs.getDate(5));
                f.setDias(rs.getInt(6));
                f.setPrefijo(rs.getString(7));
                f.setCod_propiedad(rs.getString(8));
                f.setCc_nit_cliente(rs.getString(9));
                f.setObservacion(rs.getString(10));
                f.setValor(rs.getInt(11));
                f.setSaldo_factura(rs.getInt(12));
                f.setIva(rs.getInt(13));
                f.setEstado_factura(rs.getString(14));
                f.setEstado_comision(rs.getString(15));
                f.setEstado_recaudo(rs.getString(16));
                
                lista.add(f);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoFacturaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
