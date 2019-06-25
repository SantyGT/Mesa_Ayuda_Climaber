
package com.demojsf.model;

 public class Usuario {
    
    private int iduser;
    private String nombre_usuario;
    private String cedula_usuario;
    private String correo;
    private String clave;
    private String estado_usuario;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(String cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }
    
    @Override
    public String toString() {
        return "User {" + "IdUser=" + iduser + ", "
                + "Nombre_Usuario=" + nombre_usuario+ ", "
                + "Cedula_Usuario=" + cedula_usuario + ", "
                + "Correo=" + correo + ", " 
                + "Clave=" + clave + ", "
                + "Estado_Usuario=" + estado_usuario + '}';
    }
}
