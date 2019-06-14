
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoHardwareImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.dao.DaoHardware;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Cliente;
import com.demojsf.model.Hardware;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "hardwareBean")
@ViewScoped

public class HardwareJSFManagedBean implements Serializable {

    private Hardware hardware = new Hardware();
    private List<Hardware> lista = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private DaoHardware dao = new DaoHardwareImpl();
    private boolean modoInsert = false;
    private boolean modoEdit = true;

    public boolean isModoInsert() {
        return modoInsert;
    }

    public void setModoInsert(boolean modoInsert) {
        this.modoInsert = modoInsert;
    }

    public boolean isModoEdit() {
        return modoEdit;
    }

    public void setModoEdit(boolean modoEdit) {
        this.modoEdit = modoEdit;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getHardware();
        hardware.setId_sol_hard(lista.size() + 1);
    }

    public List<Hardware> getLista() {
        return lista;
    }

    public void setLista(List<Hardware> lista) {
        this.lista = lista;       
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;       
    }
   
    public Hardware getHardware() {
        return hardware;
    }

    public HardwareJSFManagedBean() {
    }

    public void save() {

        dao.save(hardware);
        lista = dao.getHardware();
        hardware = new Hardware();
        hardware.setId_sol_hard(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(hardware);
        lista = dao.getHardware();
        hardware = new Hardware();
        hardware.setId_sol_hard(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(hardware);
        lista = dao.getHardware();
        hardware = new Hardware();
        hardware.setId_sol_hard(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}