/*
 * The MIT License
 *
 * Copyright 2012 Carlos.
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


import javax.faces.bean.RequestScoped;
import com.ijr.model.ejb.UsuarioFacade;
import com.ijr.model.entities.Usuario;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Carlos
 */
@ManagedBean
@RequestScoped
public class UserWizard {

	private User user = new User();
	
	private boolean skip;
	
	private static Logger logger = Logger.getLogger(UserWizard.class.getName());

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void save(ActionEvent actionEvent) {
		//Persist user
		
		FacesMessage msg = new FacesMessage("Successful", "Welcome usuario");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
}
