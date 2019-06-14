
package com.demojsf.model;

import java.util.Date;
 
 public class Contrato {

    private int numcontrato;
    private Date feccreacion;
    private Date fecinicio;
    private Date fecvenc;
    private int idclie;
    private double valor;
    private String observacion;
    private String estado;
    private int idpropied;

    public int getNumcontrato() {
        return numcontrato;
    }

    public Date getFeccreacion() {
        return feccreacion;
    }

    public Date getFecinicio() {
        return fecinicio;
    }

    public Date getFecvenc() {
        return fecvenc;
    }

    public int getIdclie() {
        return idclie;
    }

    public double getValor() {
        return valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdpropied() {
        return idpropied;
    }


    public void setNumcontrato(int numcontrato) {
        this.numcontrato = numcontrato;
    }

    public void setFeccreacion(Date feccreacion) {
        this.feccreacion = feccreacion;
    }

    public void setFecinicio(Date fecinicio) {
        this.fecinicio = fecinicio;
    }

    public void setFecvenc(Date fecvenc) {
        this.fecvenc = fecvenc;
    }

    public void setIdclie(int idclie) {
        this.idclie = idclie;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdpropied(int idpropied) {
        this.idpropied = idpropied;
    }
    
    
     @Override
    public String toString() {
        return "Contrato{" + ", numcontrato=" + numcontrato + ", feccreacion=" 
                + feccreacion + ", fecinicio=" + fecinicio + ", fecvenc=" 
                + fecvenc + ", idclie=" + idclie + ", valor=" 
                + valor + ", observacion=" + observacion + ", estado=" 
                + estado + ", idpropied=" + idpropied + '}';
    }
    
    
}
