
package com.demojsf.dao;

import java.util.List;


public interface DaoFactura<Factura> {
    void save(Factura f);
    void update(Factura f);
    void updateComision(Factura f);
    void updateRecaudo(Factura f);
    void delete(Factura f);
    List<Factura> getFact();
    List<Factura> getListFact();
    List<Factura> getListRecau();
}
