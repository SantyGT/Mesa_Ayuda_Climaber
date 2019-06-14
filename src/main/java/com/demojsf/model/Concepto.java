/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demojsf.model;


/**
 *
 * @author docente
 */

    
 public class Concepto {

    
    private int idconcepto;
    private String cod_concepto;
    private String nom_concepto;
    private int porcentaje_iva;
    
    
    public void setNom_concepto(String nom_concepto) {
        this.nom_concepto = nom_concepto;
    }

    public String getNom_concepto() {
        return nom_concepto;
    }
    

    public int getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(int id) {
        this.idconcepto = id;
    }

    public String getCod_concepto() {
        return cod_concepto;
    }

    public void setCod_concepto(String cod) {
        this.cod_concepto = cod;
    }

    public int getPorcentaje_iva() {
        return porcentaje_iva;
    }

    public void setPorcentaje_iva(int porcentaje_iva) {
        this.porcentaje_iva = porcentaje_iva;
    }


    
    @Override
    public String toString() {
        return "Concepto{" + "Idconcepto=" + idconcepto + ", Codigo Concepto=" + cod_concepto + ", Nombre concepto=" + nom_concepto + ", Porcentaje iva=" + porcentaje_iva + '}';
    }
    
    
}
