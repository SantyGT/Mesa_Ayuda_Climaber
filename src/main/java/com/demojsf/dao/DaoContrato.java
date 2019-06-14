
package com.demojsf.dao;

import java.util.List;

public interface DaoContrato<Contrato> {
    void save(Contrato c);
    void update(Contrato c);
    void delete(Contrato c);
    List<Contrato> getContrato();
}
