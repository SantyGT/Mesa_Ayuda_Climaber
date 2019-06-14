
package com.demojsf.jsf.bean;

import com.demojsf.dao.DaoPropiedades;
import com.demojsf.impl.DaoPropiedadImpl;
import com.demojsf.model.Propiedad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "propiedadBean")
@ViewScoped

public class PropiedadJSFManagedBean implements Serializable {

    private Propiedad propiedad = new Propiedad();
    private List<Propiedad> lista = new ArrayList<>();
    private DaoPropiedades dao = new DaoPropiedadImpl();
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
    
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getPropiedad();
        propiedad.setIdpropiedad(lista.size() + 1);
    }

    public List<Propiedad> getLista() {
        return lista;
    }

    public void setLista(List<Propiedad> lista) {
        this.lista = lista;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public PropiedadJSFManagedBean() {
    }

    public void save() {

        dao.save(propiedad);
        lista = dao.getPropiedad();
        propiedad = new Propiedad();
        propiedad.setIdpropiedad(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(propiedad);
        lista = dao.getPropiedad();
        propiedad = new Propiedad();
        propiedad.setIdpropiedad(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(propiedad);
        lista = dao.getPropiedad();
        propiedad = new Propiedad();
        propiedad.setIdpropiedad(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
