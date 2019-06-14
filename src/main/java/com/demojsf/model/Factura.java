
package com.demojsf.model;

import java.util.Date;

 public class Factura {

    private int idfactura;
    private int cons_factura;
    private int num_contrato;
    private Date fecha_creacion;
    private Date fecha_facturacion;
    private int dias;
    private String prefijo;
    private String cod_propiedad;
    private String cc_nit_cliente;
    private String observacion;
    private int valor;
    private int saldo_factura;
    private int iva;
    private String estado_factura;
    private String estado_comision;
    private String estado_recaudo;
    private double valorComision;

    
    public double getValorComision() {
        return valorComision;
    }

    public void setValorComision(double valorComision) {
        this.valorComision = valorComision;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getCons_factura() {
        return cons_factura;
    }

    public void setCons_factura(int cons_factura) {
        this.cons_factura = cons_factura;
    }

    public int getNum_contrato() {
        return num_contrato;
    }

    public void setNum_contrato(int num_contrato) {
        this.num_contrato = num_contrato;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_facturacion() {
        return fecha_facturacion;
    }

    public void setFecha_facturacion(Date fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getCod_propiedad() {
        return cod_propiedad;
    }

    public void setCod_propiedad(String cod_propiedad) {
        this.cod_propiedad = cod_propiedad;
    }

    public String getCc_nit_cliente() {
        return cc_nit_cliente;
    }

    public void setCc_nit_cliente(String cc_nit_cliente) {
        this.cc_nit_cliente = cc_nit_cliente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getSaldo_factura() {
        return saldo_factura;
    }

    public void setSaldo_factura(int saldo_factura) {
        this.saldo_factura = saldo_factura;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public String getEstado_factura() {
        return estado_factura;
    }

    public void setEstado_factura(String estado_factura) {
        this.estado_factura = estado_factura;
    }

    public String getEstado_comision() {
        return estado_comision;
    }

    public void setEstado_comision(String estado_comision) {
        this.estado_comision = estado_comision;
    }

    public String getEstado_recaudo() {
        return estado_recaudo;
    }

    public void setEstado_recaudo(String estado_recaudo) {
        this.estado_recaudo = estado_recaudo;
    }

    @Override
    public String toString() {
        return "Factura{" + "idfactura=" + idfactura + ", cons_factura=" + cons_factura + ", num_contrato=" + num_contrato + ", fecha_creacion=" + fecha_creacion + ", "
                + "fecha_facturacion=" + fecha_facturacion + ", dias=" + dias + ", prefijo=" + prefijo + ", "
                + "cod_propiedad=" + cod_propiedad + ", cc_nit_cliente=" + cc_nit_cliente + ", observacion=" + observacion + ","
                + " valor=" + valor + ", saldo_factura=" + saldo_factura + ", iva" + iva + ", estado_factura" + estado_factura + ", estado_comision" + estado_comision + ", estado_recaudo" + estado_recaudo + '}';
    }

}
