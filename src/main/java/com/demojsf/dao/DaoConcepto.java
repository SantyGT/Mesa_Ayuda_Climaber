/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demojsf.dao;

import java.util.List;

/**
 *
 * @author docente
 * @param <Concepto>
 */
public interface DaoConcepto<Concepto> {
    void save(Concepto c);
    void update(Concepto c);
    void delete(Concepto c);
    List<Concepto> getConcepto();
}
