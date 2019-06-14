
package com.demojsf.dao;

import java.util.List;

public interface DaoHardware<Hardware> {
    void save(Hardware h);
    void update(Hardware h);
    void delete(Hardware h);
    List<Hardware> getHardware();
}
