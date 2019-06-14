
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoSolicitudImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.dao.DaoSolicitud;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Cliente;
import com.demojsf.model.Solicitud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "solicitudBean")
@ViewScoped

public class SolicitudJSFManagedBean implements Serializable {

    private Solicitud solicitud = new Solicitud();
    private List<Solicitud> lista = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private DaoSolicitud dao = new DaoSolicitudImpl();
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

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getSolicitud();
        solicitud.setId_solicitud(lista.size() + 1);
    }

    public List<Solicitud> getLista() {
        return lista;
    }

    public void setLista(List<Solicitud> lista) {
        this.lista = lista;       
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;       
    }
   
    public Solicitud getSolicitud() {
        return solicitud;
    }

    public SolicitudJSFManagedBean() {
    }

    public void save() {

        dao.save(solicitud);
        lista = dao.getSolicitud();
        solicitud = new Solicitud();
        solicitud.setId_solicitud(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(solicitud);
        lista = dao.getSolicitud();
        solicitud = new Solicitud();
        solicitud.setId_solicitud(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(solicitud);
        lista = dao.getSolicitud();
        solicitud = new Solicitud();
        solicitud.setId_solicitud(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
