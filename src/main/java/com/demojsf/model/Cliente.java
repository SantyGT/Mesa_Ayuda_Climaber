
package com.demojsf.model;


public class Cliente {
    private int idcliente;
    private String nombre;
    private String ccnit;
    private String direccion;
    private String telefono;
    private String email;
    private String celular;
    private String ciudad;
    private String sexo;
    private String asesor;

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCcnit() {
        return ccnit;
    }

    public void setCcnit(String ccnit) {
        this.ccnit = ccnit;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }
    
    @Override
    public String toString(){
        return "Cleinte {" + "idcliente=" + idcliente + "nombre=" + nombre + "ccnit="
                + ccnit + ", direccion=" + direccion + "telefono=" + telefono + "celular="
                + celular +", email=" + email + "sexo=" + sexo + "ciudad=" 
                + ciudad + "asesor=" + asesor + '}';
    }
    
    
}
