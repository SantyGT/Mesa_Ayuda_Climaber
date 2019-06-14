
package com.demojsf.dao;

import java.util.List;

public interface DaoSoftware<Software> {
    void save(Software s);
    void update(Software s);
    void delete(Software s);
    List<Software> getSoftware();
}
