
package com.demojsf.model;

public class Propiedad {
    private String codigo;
    private String nombre;
    private String pais;
    private String ciudad;
    private String barrio;
    private String sector;
    private String zona;
    private String direccion;
    private int area_tot;
    private int area_cons;
    private String estrato;
    private String tipo;
    private Double valor;
    private String observacion;
    private String est_ocupacion;
    private String est_facturacion;
    private int idpropietario;
    private int idpropiedad;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getArea_tot() {
        return area_tot;
    }

    public void setArea_tot(int area_tot) {
        this.area_tot = area_tot;
    }

    public int getArea_cons() {
        return area_cons;
    }

    public void setArea_cons(int area_cons) {
        this.area_cons = area_cons;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEst_ocupacion() {
        return est_ocupacion;
    }

    public void setEst_ocupacion(String est_ocupacion) {
        this.est_ocupacion = est_ocupacion;
    }

    public String getEst_facturacion() {
        return est_facturacion;
    }

    public void setEst_facturacion(String est_facturacion) {
        this.est_facturacion = est_facturacion;
    }

    public int getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(int idpropietario) {
        this.idpropietario = idpropietario;
    }

    public int getIdpropiedad() {
        return idpropiedad;
    }

    public void setIdpropiedad(int idpropiedad) {
        this.idpropiedad = idpropiedad;
    }
    
     @Override
      public String toString() {
        return "Propiedad{" + "codigo=" + codigo + ", nombre=" + nombre + ", pais=" 
                + pais + ", ciudad=" + ciudad + ", barrio=" + barrio + ", sector=" 
                + sector + ", zona=" + zona + ", direccion=" + direccion + ", area_tot=" 
                + area_tot + ", area_cons=" + area_cons + ",estrato=" + estrato + ", tipo=" 
                + tipo + ", valor=" + valor + ", observacion=" + observacion + ", est_ocupacion=" 
                + est_ocupacion + ", est_facturacion=" + est_facturacion + ", idpropietario=" 
                + idpropietario + ", idpropiedad=" + idpropiedad + '}';
    }
}
