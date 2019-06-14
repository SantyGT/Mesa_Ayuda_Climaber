
package com.demojsf.dao;

import java.util.List;

public interface DaoArea<Area> {
    void save(Area a);
    void update(Area a);
    void delete(Area a);
    List<Area> getArea();
}
