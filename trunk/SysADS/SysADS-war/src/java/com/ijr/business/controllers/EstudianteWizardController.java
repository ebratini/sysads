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

import com.ijr.model.ejb.ContactoEmergenciaFacade;
import com.ijr.model.ejb.EstudianteFacade;
import com.ijr.model.entities.ContactoEmergencia;
import com.ijr.model.entities.Estudiante;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Edwin Bratini
 */
@ManagedBean
@SessionScoped
public class EstudianteWizardController {

    @EJB
    private ContactoEmergenciaFacade contactoEmergenciaFacade;
    @EJB
    private EstudianteFacade estudianteFacade;
    private Estudiante estudiante = new Estudiante();
    private ContactoEmergencia currentCE = new ContactoEmergencia();
    private List<ContactoEmergencia> contactosEmergencia = new ArrayList<ContactoEmergencia>();
    private static final Logger logger = Logger.getLogger(UserWizard.class.getName());

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteWizardController() {
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
    
    public void addContactoEmergencia(ContactoEmergencia contactoEmergencia) {
        contactosEmergencia.add(contactoEmergencia);
    }
    
    public void removeCEFromList(ContactoEmergencia contactoEmergencia) {
        contactosEmergencia.remove(contactoEmergencia);
    }

    public String save() {
        //Persist estudiante then contacto(s) emergencia if any

        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + estudiante.getEstPrimerNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        return "estudiantes_inscr.jsf";
    }
    
    public String cancelEstudiantePersistation() {
        return "index.jsf";
    }

    public String onFlowProcess(FlowEvent event) {
//        logger.info("Current wizard step:" + event.getOldStep());
//        logger.info("Next step:" + event.getNewStep());
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());

        return event.getNewStep();
    }
}
