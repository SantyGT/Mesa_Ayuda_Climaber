
package com.demojsf.model;

public class Estado {

    private int id_estado;
    private String estado;

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Estado{" + ", id_estado=" + id_estado + ", estado=" 
                + estado +'}';
    }
}
