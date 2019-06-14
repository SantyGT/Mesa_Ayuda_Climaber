/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demojsf.jsf.bean;

import com.demojsf.impl.DaoUsuarioImpl;
import com.demojsf.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.demojsf.dao.DaoUser;



/**
 *
 * @author docente
 */


@Named(value = "usuarioBean")
@ViewScoped

public class UsuarioJSFManagedBean implements Serializable {

    
    
    /**
     * Creates a new instance of ClientJSFManagedBean
     */
    private Usuario usuario = new Usuario();
    private List<Usuario> lista = new ArrayList<>();
    private DaoUser dao = new DaoUsuarioImpl();
    private boolean modoInsert = false;
    private boolean modoEdit = true;

    public boolean isModoInsert() {
        return modoInsert;
    }

    public void setModoInsert(boolean modoInsert) {
        this.modoInsert = modoInsert;
    }

    public boolean isModoEdit() {
        return modoEdit;
    }

    public void setModoEdit(boolean modoEdit) {
        this.modoEdit = modoEdit;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getUsuario();
        usuario.setIduser(lista.size() + 1);
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioJSFManagedBean() {
    }

    public void save() {

        dao.save(usuario);
        lista = dao.getUsuario();
        usuario = new Usuario();
        usuario.setIduser(lista.size() + 1);
    }
    
    public void delete() {

        dao.delete(usuario);
        lista = dao.getUsuario();
        usuario = new Usuario();
        usuario.setIduser(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(usuario);
        lista = dao.getUsuario();
        usuario = new Usuario();
        usuario.setIduser(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
}
