
package com.demojsf.jsf.bean;

import com.demojsf.dao.DaoConfiguracion;
import com.demojsf.impl.DaoConfiguracionImpl;
import com.demojsf.model.Configuracion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "configBean")
@ViewScoped
public class ConfigJSFManagedBean implements Serializable {

    private Configuracion configuracion = new Configuracion();
    private List<Configuracion> lista = new ArrayList<>();
    private DaoConfiguracion dao = new DaoConfiguracionImpl();
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

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getConfigs();
        configuracion.setIdconfig(lista.size() + 1);
    }

    public List<Configuracion> getLista() {
        return lista;
    }

    public void setLista(List<Configuracion> lista) {
        this.lista = lista;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public ConfigJSFManagedBean() {
    }

    public void save() {

        dao.save(configuracion);
        lista = dao.getConfigs();
        configuracion = new Configuracion();
        configuracion.setIdconfig(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(configuracion);
        lista = dao.getConfigs();
        configuracion = new Configuracion();
        configuracion.setIdconfig(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(configuracion);
        lista = dao.getConfigs();
        configuracion = new Configuracion();
        configuracion.setIdconfig(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
