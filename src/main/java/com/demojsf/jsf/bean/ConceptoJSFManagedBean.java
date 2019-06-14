
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoConceptoImpl;
import com.demojsf.model.Concepto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.model.Propiedad;
import com.demojsf.dao.DaoConcepto;


@Named(value = "conceptoBean")
@ViewScoped

public class ConceptoJSFManagedBean implements Serializable {


    private Concepto concepto = new Concepto();
    private List<Concepto> lista = new ArrayList<>();
    private DaoConceptoImpl dao = new DaoConceptoImpl();
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

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getConcepto();
        concepto.setIdconcepto(lista.size() + 1);
    }

    public List<Concepto> getLista() {
        return lista;
    }

    public void setLista(List<Concepto> lista) {
        this.lista = lista;
    }

    public Concepto getConcepto() {
        return concepto;
    }

    public ConceptoJSFManagedBean() {
    }

    public void save() {

        dao.save(concepto);
        lista = dao.getConcepto();
        concepto = new Concepto();
        concepto.setIdconcepto(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(concepto);
        lista = dao.getConcepto();
        concepto = new Concepto();
        concepto.setIdconcepto(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(concepto);
        lista = dao.getConcepto();
        concepto = new Concepto();
        concepto.setIdconcepto(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
