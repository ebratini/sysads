/*
 * The MIT License
 *
 * Copyright 2012 Edwin Bratini.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ijr.business.controllers;

import com.ijr.model.ejb.RolFacade;
import com.ijr.model.ejb.UsuarioFacade;
import com.ijr.model.entities.Usuario;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Edwin Bratini
 */
@ManagedBean
@RequestScoped
public class UsuarioController {

    @EJB
    private RolFacade rolFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario = new Usuario();

    /**
     * Creates a new instance of UsuairoController
     */
    public UsuarioController() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String doCreateUser() {
        Date dte = new Date();
        usuario.setRol(rolFacade.getRolByNombre("estudiante"));
        usuario.setUsrUltimoAcceso(dte);
        usuario.setUsrFechaCreacion(dte);
        usuario.setUsrVerificado('n');
        usuario.setUsrUpdateBy("registro usuarios");
        usuario.setUsrUpdateDate(dte);
        usuario.setUsrStatus('p');
        usuarioFacade.create(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro Usuarios", "Usuario creado exitosamente"));
        return "/index.jsf";
    }

    public String cancelUserCreation() {
        return "/index.jsf";
    }
}
