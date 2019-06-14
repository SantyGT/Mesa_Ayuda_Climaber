
package com.demojsf.dao;

import java.util.List;

public interface DaoConfiguracion<Configuracion> {
    void save(Configuracion c);
    void update(Configuracion c);
    void delete(Configuracion c);
    List<Configuracion> getConfigs();
}
