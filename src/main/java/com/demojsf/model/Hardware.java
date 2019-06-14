
package com.demojsf.model;

public class Hardware {

    private int id_sol_hard;
    private String nombre_sol_hard;

    public int getId_sol_hard() {
        return id_sol_hard;
    }

    public void setId_sol_hard(int id_sol_hard) {
        this.id_sol_hard = id_sol_hard;
    }

    public String getNombre_sol_hard() {
        return nombre_sol_hard;
    }

    public void setNombre_sol_hard(String nombre_sol_hard) {
        this.nombre_sol_hard = nombre_sol_hard;
    }

    @Override
    public String toString() {
        return "Hardware{" + ", id_sol_hard=" + id_sol_hard + ", nombre_sol_hard=" 
                + nombre_sol_hard +'}';
    }
}