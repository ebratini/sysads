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
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    private String usrLogin;
    private String usrRol;
    private String usrPass;
    private Usuario usuario = new Usuario();

    /**
     * Creates a new instance of loginController
     */
    public LoginController() {
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return usrPass;
    }

    public void setPass(String pass) {
        this.usrPass = pass;
    }

    public String getUsrRol() {
        return usrRol;
    }

    public void setUsrRol(String usrRol) {
        this.usrRol = usrRol;
    }
    
    public String login() {
        Usuario usr = usuarioFacade.getUsuarioByLogin(usrLogin);
        FacesContext context = FacesContext.getCurrentInstance();
        if (usr != null) {
            if (usr.getUsrPassword().equals(securityServiceEJB.encrypt(usrPass))) {
                this.usuario = usr;
                context.addMessage(null, new FacesMessage("Login", "Bienvenid@ " + usrLogin));
                if (usrRol.equalsIgnoreCase("estudiante") && usr.getRol().getRolNombre().equalsIgnoreCase("estudiante")) {
                    return "estudiantes/index.jsf";
                } else if (usrRol.equalsIgnoreCase("docente") && usr.getRol().getRolNombre().equalsIgnoreCase("docente")) {
                    return "profesores/index.jsf";
                }
            }
        }
        context.addMessage(null, new FacesMessage("Login", "Usuario/Contraseña Invalidos"));
        return "/index.jsf";
    }

    public String doLogout() {

        return null;
    }

    public String validateSecQuestion() {
        return null;
    }

    public String sendNewPass() {
        return null;
    }
}
