
package com.demojsf.dao;

import java.util.List;

public interface DaoPropietario<Propietario> {
    void save(Propietario p);
    void update(Propietario p);
    void delete(Propietario p);
    List<Propietario> getProperty();

    
}
