
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoSoftwareImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.dao.DaoSoftware;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Software;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "softwareBean")
@ViewScoped

public class SoftwareJSFManagedBean implements Serializable {

    private Software software = new Software();
    private List<Software> lista = new ArrayList<>();
    private DaoSoftware dao = new DaoSoftwareImpl();
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

    public void setSoftware(Software software) {
        this.software = software;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getSoftware();
        software.setId_sol_soft(lista.size() + 1);
    }

    public List<Software> getLista() {
        return lista;
    }

    public void setLista(List<Software> lista) {
        this.lista = lista;       
    }
    
    public Software getSoftware() {
        return software;
    }

    public SoftwareJSFManagedBean() {
    }

    public void save() {

        dao.save(software);
        lista = dao.getSoftware();
        software = new Software();
        software.setId_sol_soft(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(software);
        lista = dao.getSoftware();
        software = new Software();
        software.setId_sol_soft(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(software);
        lista = dao.getSoftware();
        software = new Software();
        software.setId_sol_soft(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
