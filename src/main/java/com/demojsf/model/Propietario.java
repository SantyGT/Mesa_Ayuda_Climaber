
package com.demojsf.model;

public class Propietario {
    private int idpropietario;
    private String ccnit;
    private String nombre;
    private String direccion;
    private String telefono;
    private String celular;
    private String email;
    private String ciudad;
    private String sexo;
    private int porccomi;

    public int getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(int idpropietario) {
        this.idpropietario = idpropietario;
    }

    public String getCcnit() {
        return ccnit;
    }

    public void setCcnit(String ccnit) {
        this.ccnit = ccnit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getPorccomi() {
        return porccomi;
    }

    public void setPorccomi(int porccomi) {
        this.porccomi = porccomi;
    }
    
    @Override
    public String toString(){
        return "Propietario{" + "idpropietario=" + idpropietario + ", ccnit=" 
                + ccnit + ", nombre=" + nombre + ", direccion="
                + direccion + ", telefono=" + telefono + ", celular=" 
                + celular + ", email=" + email + ", ciudad=" + ciudad + ", sexo=" 
                + sexo + ", porccomi=" + porccomi + '}';
    }   
}
