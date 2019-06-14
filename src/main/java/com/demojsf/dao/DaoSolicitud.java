
package com.demojsf.dao;

import java.util.List;

public interface DaoSolicitud<Solicitud> {
    void save(Solicitud s);
    void update(Solicitud s);
    void delete(Solicitud s);
    List<Solicitud> getSolicitud();
}
