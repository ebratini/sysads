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

import com.ijr.model.ejb.EstudianteFacade;
import com.ijr.model.entities.ContactoEmergencia;
import com.ijr.model.entities.Estudiante;
import com.ijr.model.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Edwin Bratini
 */
@ManagedBean
@SessionScoped
public class EstudianteController {

    @EJB
    private EstudianteFacade estudianteFacade;
    private Estudiante estudiante = new Estudiante();
    private ContactoEmergencia currentCE = new ContactoEmergencia();
    private List<ContactoEmergencia> contactosEmergencia = new ArrayList<ContactoEmergencia>();
    @ManagedProperty(value = "#{loginController.usuario}")
    private Usuario usuario;

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteController() {
    }

    public List<ContactoEmergencia> getContactosEmergencia() {
        return contactosEmergencia;
    }

    public void setContactosEmergencia(List<ContactoEmergencia> contactosEmergencia) {
        this.contactosEmergencia = contactosEmergencia;
    }

    public ContactoEmergencia getCurrentCE() {
        return currentCE;
    }

    public void setCurrentCE(ContactoEmergencia currentCE) {
        this.currentCE = currentCE;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void addContactoEmergencia(ContactoEmergencia contactoEmergencia) {
        contactosEmergencia.add(contactoEmergencia);
    }

    public void removeCEFromList(ContactoEmergencia contactoEmergencia) {
        contactosEmergencia.remove(contactoEmergencia);
    }

    public String save() {
        //Persist estudiante then contacto(s) emergencia if any
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // binding estudiante with user
            estudiante.setUsuario(usuario);
            for (ContactoEmergencia ce : contactosEmergencia) {
                ce.setCemStatus('a');
            }

            estudiante.setContactoEmergenciaCollection(contactosEmergencia);
            estudianteFacade.create(estudiante);
            
            FacesMessage msg = new FacesMessage("Registro Estudiantes", "Estudiante registrado exitosamente");
            context.addMessage(null, msg);
            return "estudiantes_inscr.jsf";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Registro Estudiantes", "El proceso de creacion de estudiante fallo. Intentelo luego o contacte al administrador.");
            context.addMessage(null, msg);
            return "#";
        }
    }

    public String cancelEstudiantePersistation() {
        return "index.jsf";
    }
}
