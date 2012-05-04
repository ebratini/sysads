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

import com.ijr.model.ejb.SecurityServiceEJB;
import com.ijr.model.ejb.UsuarioFacade;
import com.ijr.model.entities.Usuario;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edwin Bratini
 */
@ManagedBean
@SessionScoped
public class LoginController {

    @EJB
    private SecurityServiceEJB securityServiceEJB;
    @EJB
    private UsuarioFacade usuarioFacade;
    private String login = "";
    private String pass = "";
    private String rol = "";
    private Usuario usuario = new Usuario();

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String doLogin() {
        boolean validUser = false;
        String viewToRender = "./SysADS-war/index.jsf";

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Usuario usr = usuarioFacade.getUsuarioByLogin(login);
            if (usr.getUsrPassword().equals(securityServiceEJB.encrypt(pass))) {
                if (rol.equalsIgnoreCase("estudiante") && usr.getRol().getRolNombre().equalsIgnoreCase("estudiante")) {
                    validUser = true;
                    viewToRender = "/estudiantes/index.jsf";
                } else if (rol.equalsIgnoreCase("docente") && usr.getRol().getRolNombre().equalsIgnoreCase("docente")) {
                    validUser = true;
                    viewToRender = "/profesores/index.jsf";
                }
            }

            if (validUser) {
                context.addMessage(null, new FacesMessage("Login", "Bienvenid@ " + login));
                usr.setUsrUltimoAcceso(new Date());
                this.usuario = usr;
            } else {
                context.addMessage(null, new FacesMessage("Login", "Usuario/Contraseña Invalidos"));
            }
        } catch (Exception exc) {
            context.addMessage(null, new FacesMessage("Login", "Usuario/Contraseña Invalidos"));
        }

        return viewToRender;
    }

    public void doLogout() {
        // do logout invalidating session and returning user to login page
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession httpSession = (HttpSession) ec.getSession(false);
        httpSession.invalidate();
        try {
            ec.redirect("/SysADS-war/index.jsf?faces-redirect=true");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
