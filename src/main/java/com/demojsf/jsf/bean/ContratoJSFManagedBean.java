
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoContratoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.dao.DaoContrato;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Cliente;
import com.demojsf.model.Contrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "contratoBean")
@ViewScoped

public class ContratoJSFManagedBean implements Serializable {

    private Contrato contrato = new Contrato();
    private List<Contrato> lista = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private DaoContrato dao = new DaoContratoImpl();
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

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getContrato();
        contrato.setNumcontrato(lista.size() + 1);
    }

    public List<Contrato> getLista() {
        return lista;
    }

    public void setLista(List<Contrato> lista) {
        this.lista = lista;       
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;       
    }
   
    public Contrato getContrato() {
        return contrato;
    }

    public ContratoJSFManagedBean() {
    }

    public void save() {

        dao.save(contrato);
        lista = dao.getContrato();
        contrato = new Contrato();
        contrato.setNumcontrato(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(contrato);
        lista = dao.getContrato();
        contrato = new Contrato();
        contrato.setNumcontrato(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(contrato);
        lista = dao.getContrato();
        contrato = new Contrato();
        contrato.setNumcontrato(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
    

   
    
    
}
