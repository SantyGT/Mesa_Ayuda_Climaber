
package com.demojsf.model;

import java.util.Date;
 
 public class Solicitud {

    private int id_solicitud;
    private int num_solicitud;
    private Date fecha_solicitud;
    private int id_area;
    private int id_usuario;
    private String cargo_solicitud;
    private String asunto_solicitud;
    private String observacion;
    private int id_estado;
    private int id_tipo_solicitud;
    private int id_lista_solicitud;

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public int getNum_solicitud() {
        return num_solicitud;
    }

    public void setNum_solicitud(int num_solicitud) {
        this.num_solicitud = num_solicitud;
    }
    
    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCargo_solicitud() {
        return cargo_solicitud;
    }

    public void setCargo_solicitud(String cargo_solicitud) {
        this.cargo_solicitud = cargo_solicitud;
    }

    public String getAsunto_solicitud() {
        return asunto_solicitud;
    }

    public void setAsunto_solicitud(String asunto_solicitud) {
        this.asunto_solicitud = asunto_solicitud;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_tipo_solicitud() {
        return id_tipo_solicitud;
    }

    public void setId_tipo_solicitud(int id_tipo_solicitud) {
        this.id_tipo_solicitud = id_tipo_solicitud;
    }

    public int getId_lista_solicitud() {
        return id_lista_solicitud;
    }

    public void setId_lista_solicitud(int id_lista_solicitud) {
        this.id_lista_solicitud = id_lista_solicitud;
    }
    
     @Override
    public String toString() {
        return "Solicitud{" + ", id_solicitud=" + id_solicitud + ", num_solicitud=" 
                + num_solicitud + ", fecha_solicitud=" + fecha_solicitud + ", id_area=" 
                + id_area + ", id_usuario=" + id_usuario + ", cargo_solicitud=" 
                + cargo_solicitud + ", asunto_solicitud=" + asunto_solicitud + ", observacion=" 
                + observacion + ", id_estado=" + id_estado + ", id_tipo_solicitud=" 
                + id_tipo_solicitud + ", id_lista_solicitud=" + id_lista_solicitud + '}';
    }
}
