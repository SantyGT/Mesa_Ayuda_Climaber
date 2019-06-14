
package com.demojsf.model;

public class Area {

    private int id_area;
    private String nombre_area;

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }
        
    @Override
    public String toString() {
        return "Area{" + ", id_area=" + id_area + ", nombre_area=" 
                + nombre_area +'}';
    }
}
