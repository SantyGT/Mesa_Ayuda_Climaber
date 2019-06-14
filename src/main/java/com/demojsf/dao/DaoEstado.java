
package com.demojsf.dao;

import java.util.List;

public interface DaoEstado<Estado> {
    void save(Estado e);
    void update(Estado e);
    void delete(Estado e);
    List<Estado> getEstado();
}
