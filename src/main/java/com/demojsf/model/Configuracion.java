
package com.demojsf.model;

public class Configuracion {
    private int idconfig;
    private String nit_empresa;
    private String razon_social;
    private String nom_legal;
    private String telefono_emp;
    private String direccion_emp;
    private String email_emp;
    private String sitio_web_emp;
    private String ciudad_emp;
    private String pais_emp;
    private String resolu_dian;
    private String factura_dian;
    private String prefijo_dian;
    private int num_cons_fact;
    private String regimen_emp;

    public int getIdconfig() {
        return idconfig;
    }

    public void setIdconfig(int idconfig) {
        this.idconfig = idconfig;
    }

    public String getNit_empresa() {
        return nit_empresa;
    }

    public void setNit_empresa(String nit_empresa) {
        this.nit_empresa = nit_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNom_legal() {
        return nom_legal;
    }

    public void setNom_legal(String nom_legal) {
        this.nom_legal = nom_legal;
    }

    public String getTelefono_emp() {
        return telefono_emp;
    }

    public void setTelefono_emp(String telefono_emp) {
        this.telefono_emp = telefono_emp;
    }

    public String getDireccion_emp() {
        return direccion_emp;
    }

    public void setDireccion_emp(String direccion_emp) {
        this.direccion_emp = direccion_emp;
    }

    public String getEmail_emp() {
        return email_emp;
    }

    public void setEmail_emp(String email_emp) {
        this.email_emp = email_emp;
    }

    public String getSitio_web_emp() {
        return sitio_web_emp;
    }

    public void setSitio_web_emp(String sitio_web_emp) {
        this.sitio_web_emp = sitio_web_emp;
    }

    public String getCiudad_emp() {
        return ciudad_emp;
    }

    public void setCiudad_emp(String ciudad_emp) {
        this.ciudad_emp = ciudad_emp;
    }

    public String getPais_emp() {
        return pais_emp;
    }

    public void setPais_emp(String pais_emp) {
        this.pais_emp = pais_emp;
    }

    public String getResolu_dian() {
        return resolu_dian;
    }

    public void setResolu_dian(String resolu_dian) {
        this.resolu_dian = resolu_dian;
    }

    public String getFactura_dian() {
        return factura_dian;
    }

    public void setFactura_dian(String factura_dian) {
        this.factura_dian = factura_dian;
    }

    public String getPrefijo_dian() {
        return prefijo_dian;
    }

    public void setPrefijo_dian(String prefijo_dian) {
        this.prefijo_dian = prefijo_dian;
    }

    public int getNum_cons_fact() {
        return num_cons_fact;
    }

    public void setNum_cons_fact(int num_cons_fact) {
        this.num_cons_fact = num_cons_fact;
    }

    public String getRegimen_emp() {
        return regimen_emp;
    }

    public void setRegimen_emp(String regimen_emp) {
        this.regimen_emp = regimen_emp;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "idconfig=" + idconfig + ", nit_empresa=" + nit_empresa + ", razon_social=" 
                + razon_social + ", nom_legal=" + nom_legal + ", telefono_emp=" 
                + telefono_emp + ", direccion_emp=" + direccion_emp + ", email_emp=" 
                + email_emp + ", sitio_web_emp=" + sitio_web_emp + ", ciudad_emp=" 
                + ciudad_emp + ", pais_emp=" + pais_emp + ", resolu_dian=" 
                + resolu_dian + ", factura_dian=" + factura_dian + ", prefijo_dian=" 
                + prefijo_dian + ", num_cons_fact=" + num_cons_fact + ", regimen_emp=" 
                + regimen_emp + '}';
    }
}
