
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoAreaImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.dao.DaoArea;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Cliente;
import com.demojsf.model.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "areaBean")
@ViewScoped

public class AreaJSFManagedBean implements Serializable {

    private Area area = new Area();
    private List<Area> lista = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private DaoArea dao = new DaoAreaImpl();
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

    public void setArea(Area area) {
        this.area = area;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getArea();
        area.setId_area(lista.size() + 1);
    }

    public List<Area> getLista() {
        return lista;
    }

    public void setLista(List<Area> lista) {
        this.lista = lista;       
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;       
    }
   
    public Area getArea() {
        return area;
    }

    public AreaJSFManagedBean() {
    }

    public void save() {

        dao.save(area);
        lista = dao.getArea();
        area = new Area();
        area.setId_area(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(area);
        lista = dao.getArea();
        area = new Area();
        area.setId_area(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(area);
        lista = dao.getArea();
        area = new Area();
        area.setId_area(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
