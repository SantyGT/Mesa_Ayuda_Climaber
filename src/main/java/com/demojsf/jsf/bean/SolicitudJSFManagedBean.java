
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
import com.demojsf.model.Solicitud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "solicitudBean")
@ViewScoped

public class SolicitudJSFManagedBean implements Serializable {

    private Solicitud solicitud = new Solicitud();
    private List<Solicitud> lista = new ArrayList<>();
    private DaoSolicitud dao = new DaoSolicitudImpl();
    private boolean modoInsert = false;
    private boolean modoEdit = true;
    
    ///******** Inicio de variables de formulario ********///
    
    private int id_solicitud;
    private Date fecha_solicitud;
    private int id_area;
    private int id_usuario;
    private String cargo_solicitud;
    private String asunto_solicitud;
    private String observacion;
    private int id_estado;
    private int id_tipo_solicitud;
    private int id_lista_solicitud;

    public DaoSolicitud getDao() {
        return dao;
    }

    public void setDao(DaoSolicitud dao) {
        this.dao = dao;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCargo_solicitud() {
        return cargo_solicitud;
    }

    public void setCargo_solicitud(String cargo_solicitud) {
        this.cargo_solicitud = cargo_solicitud;
    }

    public String getAsunto_solicitud() {
        return asunto_solicitud;
    }

    public void setAsunto_solicitud(String asunto_solicitud) {
        this.asunto_solicitud = asunto_solicitud;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_tipo_solicitud() {
        return id_tipo_solicitud;
    }

    public void setId_tipo_solicitud(int id_tipo_solicitud) {
        this.id_tipo_solicitud = id_tipo_solicitud;
    }

    public int getId_lista_solicitud() {
        return id_lista_solicitud;
    }

    public void setId_lista_solicitud(int id_lista_solicitud) {
        this.id_lista_solicitud = id_lista_solicitud;
    }
        
    ///******** Fin de variables de formulario ********///

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
