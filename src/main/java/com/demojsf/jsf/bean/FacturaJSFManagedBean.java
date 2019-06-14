
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoFacturaImpl;
import com.demojsf.model.Factura;
import com.demojsf.dao.DaoFactura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "facturaBean")
@ViewScoped

public class FacturaJSFManagedBean implements Serializable {


    private Factura factura = new Factura();
    private List<Factura> lista = new ArrayList<>();
    private List<Factura> listafactu = new ArrayList<>();
    private List<Factura> listarecau = new ArrayList<>();
    private DaoFacturaImpl dao = new DaoFacturaImpl();
    private List<Factura> filteredFactura;
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

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getFact();
        listafactu = dao.getListFact();
        listarecau = dao.getListRecau();
        factura.setIdfactura(lista.size() + 1);
    }

    public List<Factura> getFilteredFactura() {
        return filteredFactura;
    }

    public void setFilteredFactura(List<Factura> filteredFactura) {
        this.filteredFactura = filteredFactura;
    }
    
  
    public List<Factura> getListarecau() {
        return listarecau;
    }

    public void setListarecau(List<Factura> listarecau) {
        this.listarecau = listarecau;
    }
    
    public List<Factura> getListafactu() {
        return listafactu;
    }
    
    public void setListafactu(List<Factura> listafactu) {
        this.listafactu = listafactu;
    }

    public List<Factura> getLista() {
        return lista;
    }

    public void setLista(List<Factura> lista) {
        this.lista = lista;
    }

    public Factura getFactura() {
        return factura;
    }

    public FacturaJSFManagedBean() {
    }

    public void save() {

        dao.save(factura);
        lista = dao.getFact();
        factura = new Factura();
        factura.setIdfactura(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(factura);
        lista = dao.getFact();
        factura = new Factura();
        factura.setIdfactura(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(factura);
        lista = dao.getFact();
        factura = new Factura();
        factura.setIdfactura(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }
    
    public void updateComision() {

        dao.updateComision(factura);
        filteredFactura.clear();
        listafactu = dao.getListFact();
        factura = new Factura();
        factura.setIdfactura(listafactu.size() + 1);
        
        

    }
    
    public void updateRecaudo() {

        dao.updateRecaudo(factura);       
        filteredFactura.clear();       
        listarecau = dao.getListRecau();
        factura = new Factura();
        factura.setIdfactura(listarecau.size() + 1);

    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
