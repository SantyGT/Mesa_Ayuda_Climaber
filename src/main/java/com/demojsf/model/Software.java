
package com.demojsf.model;

public class Software {

    private int id_sol_soft;
    private String nombre_sol_soft;

    public int getId_sol_soft() {
        return id_sol_soft;
    }

    public void setId_sol_soft(int id_sol_soft) {
        this.id_sol_soft = id_sol_soft;
    }

    public String getNombre_sol_soft() {
        return nombre_sol_soft;
    }

    public void setNombre_sol_soft(String nombre_sol_soft) {
        this.nombre_sol_soft = nombre_sol_soft;
    }
    
    @Override
    public String toString() {
        return "Software{" + ", id_sol_soft=" + id_sol_soft + ", nombre_sol_soft=" 
                + nombre_sol_soft +'}';
    }
}