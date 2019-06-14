
package com.demojsf.dao;

import java.util.List;

public interface DaoUsuario<Usuario> {
    void save(Usuario u);
    void update(Usuario u);
    void delete(Usuario u);
    List<Usuario> getUsuario();
}
