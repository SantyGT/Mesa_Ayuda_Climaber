
package com.demojsf.model;

 public class Usuario {

    
    private int iduser;
    private String correo;
    private String clave;
    private boolean m1_reg;
    private boolean m11_proprio;
    private boolean m12_propdad;
    private boolean m13_cli;
    private boolean m14_cont;
    private boolean m2_fact;
    private boolean m3_rec;
    private boolean m4_com;
    private boolean m5_inf;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

    public boolean getM1_reg() {
        return m1_reg;
    }

    public void setM1_reg(boolean m1_reg) {
        this.m1_reg = m1_reg;
    }

    public boolean getM11_proprio() {
        return m11_proprio;
    }

    public void setM11_proprio(boolean m11_proprio) {
        this.m11_proprio = m11_proprio;
    }

    public boolean getM12_propdad() {
        return m12_propdad;
    }

    public void setM12_propdad(boolean m12_propdad) {
        this.m12_propdad = m12_propdad;
    }

    public boolean getM13_cli() {
        return m13_cli;
    }

    public void setM13_cli(boolean m13_cli) {
        this.m13_cli = m13_cli;
    }

    public boolean getM14_cont() {
        return m14_cont;
    }

    public void setM14_cont(boolean m14_cont) {
        this.m14_cont = m14_cont;
    }

    public boolean getM2_fact() {
        return m2_fact;
    }

    public void setM2_fact(boolean m2_fact) {
        this.m2_fact = m2_fact;
    }

    public boolean getM3_rec() {
        return m3_rec;
    }

    public void setM3_rec(boolean m3_rec) {
        this.m3_rec = m3_rec;
    }

    public boolean getM4_com() {
        return m4_com;
    }

    public void setM4_com(boolean m4_com) {
        this.m4_com = m4_com;
    }

    public boolean getM5_inf() {
        return m5_inf;
    }

    public void setM5_inf(boolean m5_inf) {
        this.m5_inf = m5_inf;
    }
    
    
   
    
    @Override
    public String toString() {
        return "Usuario{" + "Id Usuario=" + iduser + ", E-mail=" + correo + ", Clave=" + clave + ", Permiso Menu Registros=" + m1_reg+ ", "
                + "Permiso Menu Propietarios=" + m11_proprio+ ", Permiso Menu Propiedades=" + m12_propdad+ ", Permiso Menu Clientes=" + m13_cli+ ", "
                + "Permiso Menu Contratos=" + m14_cont+ ", Permiso Menu Facturacion=" + m2_fact+ ", Permiso Menu Recaudo=" + m3_rec+ ","
                + " Permiso Menu Comision=" + m4_com+ ", Permiso Menu Info y Consul=" + m5_inf + '}';
    }

}
