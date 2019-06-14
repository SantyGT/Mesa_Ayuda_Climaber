
package com.demojsf.jsf.bean;

import com.demojsf.dao.DaoPropietario;
import com.demojsf.impl.DaoPropietarioImpl;
import com.demojsf.model.Propietario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "propietarioBean")
@ViewScoped
public class PropietarioJSFManagedBean implements Serializable {

    private Propietario propietario = new Propietario();
    private List<Propietario> lista = new ArrayList<>();
    private DaoPropietario dao = new DaoPropietarioImpl();
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

    public void setPropietario(Propietario propietario) {
        this.propietario= propietario;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getProperty();
        propietario.setIdpropietario(lista.size() + 1);
    }

    public List<Propietario> getLista() {
        return lista;
    }

    public void setLista(List<Propietario> lista) {
        this.lista = lista;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public PropietarioJSFManagedBean() {
    }

    public void save() {

        dao.save(propietario);
        lista = dao.getProperty();
        propietario = new Propietario();
        propietario.setIdpropietario(lista.size() + 1);
    }
  
    public void delete(){
     dao.delete(propietario);
    lista=dao.getProperty();
    propietario = new Propietario();
    propietario.setIdpropietario(lista.size() + 1);
    modoEdit = true;
    modoInsert = false;
    }

    public void update() {

        dao.update(propietario);
        lista = dao.getProperty();
        propietario = new Propietario();
        propietario.setIdpropietario(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
} 
    
