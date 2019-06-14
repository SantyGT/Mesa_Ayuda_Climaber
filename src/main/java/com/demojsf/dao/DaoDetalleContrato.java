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
 * @param <DetalleContrato>
 */
public interface DaoDetalleContrato<DetalleContrato> {
    void save(DetalleContrato dc);
    void update(DetalleContrato dc);
    void delete(DetalleContrato dc);
    List<DetalleContrato> getDetalleContrato();
}
