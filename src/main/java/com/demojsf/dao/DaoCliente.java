
package com.demojsf.dao;

import java.util.List;

public interface DaoCliente<Cliente> {
    void save(Cliente c);
    void update(Cliente c);
    void delete(Cliente c);
    List<Cliente> getCliente();
}
