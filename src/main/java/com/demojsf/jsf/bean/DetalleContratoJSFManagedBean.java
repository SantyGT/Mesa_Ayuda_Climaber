
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoDetalleContratoImpl;
import com.demojsf.model.DetalleContrato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.model.Propiedad;
import com.demojsf.dao.DaoDetalleContrato;


@Named(value = "detalleContratoBean")
@ViewScoped

public class DetalleContratoJSFManagedBean implements Serializable {


    private DetalleContrato detalleContrato = new DetalleContrato();
    private List<DetalleContrato> lista = new ArrayList<>();
    private DaoDetalleContrato dao = new DaoDetalleContratoImpl();
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

    public void setDetalleContrato(DetalleContrato detalleContrato) {
        this.detalleContrato = detalleContrato;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getDetalleContrato();
        detalleContrato.setIdDetalleContratoConcep(lista.size() + 1);
    }

    public List<DetalleContrato> getLista() {
        return lista;
    }

    public void setLista(List<DetalleContrato> lista) {
        this.lista = lista;
    }

    public DetalleContrato getDetalleContrato() {
        return detalleContrato;
    }

    public DetalleContratoJSFManagedBean() {
    }

    public void save() {

        dao.save(detalleContrato);
        lista = dao.getDetalleContrato();
        detalleContrato = new DetalleContrato();
        detalleContrato.setIdDetalleContratoConcep(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(detalleContrato);
        lista = dao.getDetalleContrato();
        detalleContrato = new DetalleContrato();
        detalleContrato.setIdDetalleContratoConcep(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(detalleContrato);
        lista = dao.getDetalleContrato();
        detalleContrato = new DetalleContrato();
        detalleContrato.setIdDetalleContratoConcep(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
