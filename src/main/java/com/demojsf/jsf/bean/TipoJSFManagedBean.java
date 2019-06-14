
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoTipoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.dao.DaoTipo;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Cliente;
import com.demojsf.model.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "tipoBean")
@ViewScoped

public class TipoJSFManagedBean implements Serializable {

    private Tipo tipo = new Tipo();
    private List<Tipo> lista = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private DaoTipo dao = new DaoTipoImpl();
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

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getTipo();
        tipo.setId_tipo(lista.size() + 1);
    }

    public List<Tipo> getLista() {
        return lista;
    }

    public void setLista(List<Tipo> lista) {
        this.lista = lista;       
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;       
    }
   
    public Tipo getTipo() {
        return tipo;
    }

    public TipoJSFManagedBean() {
    }

    public void save() {

        dao.save(tipo);
        lista = dao.getTipo();
        tipo = new Tipo();
        tipo.setId_tipo(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(tipo);
        lista = dao.getTipo();
        tipo = new Tipo();
        tipo.setId_tipo(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(tipo);
        lista = dao.getTipo();
        tipo = new Tipo();
        tipo.setId_tipo(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
