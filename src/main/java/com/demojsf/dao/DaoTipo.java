
package com.demojsf.dao;

import java.util.List;

public interface DaoTipo<Tipo> {
    void save(Tipo t);
    void update(Tipo t);
    void delete(Tipo t);
    List<Tipo> getTipo();
}
