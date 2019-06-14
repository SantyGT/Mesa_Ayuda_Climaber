
package com.demojsf.dao;

import java.util.List;

public interface DaoPropiedades<Propiedad> {
    void save(Propiedad p);
    void update(Propiedad p);
    void delete(Propiedad p);
    List<Propiedad> getPropiedad();
}
