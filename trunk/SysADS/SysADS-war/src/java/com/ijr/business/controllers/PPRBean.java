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

/**
 *
 * @author Carlos
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.ijr.model.ejb.UsuarioFacade;
import com.ijr.model.entities.Usuario;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class PPRBean implements Serializable {

	private String city;

	private String suburb;
	
	private Map<String,String> cities = new HashMap<String, String>();

	private Map<String,Map<String,String>> suburbsData = new HashMap<String, Map<String,String>>();
	
	private Map<String,String> suburbs = new HashMap<String, String>();

	public PPRBean() {
		cities.put("Tecnico en informatica", "Tecnico en informatica");
		cities.put("Digitacion", "Digitacion");
		
		
		Map<String,String> suburbsTecnico = new HashMap<String, String>();
		suburbsTecnico.put("MS-WINDOWS", "MS-WINDOWS");
		suburbsTecnico.put("MS-WORD", "MS-WORD");
                suburbsTecnico.put("MS-EXCEL", "MS-EXCEL");
		suburbsTecnico.put("MS-WORD", "MS-WORD");
                suburbsTecnico.put("MS-PWR POINT", "MS-PWR POINT");
		
		Map<String,String> suburbsDigit = new HashMap<String, String>();
		suburbsDigit.put("REDACCION", "REDACCION");
		suburbsDigit.put("WINDOW-WORD", "WINDOW-WORD");
		suburbsDigit.put("TECNICAS DE DIGITACION", "TECNICAS DE DIGITACION");
		
		
		
		suburbsData.put("Tecnico en informatica", suburbsTecnico);
		suburbsData.put("Digitacion", suburbsDigit);
		
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}
	
	public Map<String, Map<String, String>> getSuburbsData() {
		return suburbsData;
	}

	public void setSuburbsData(Map<String, Map<String, String>> suburbsData) {
		this.suburbsData = suburbsData;
	}
	
	public Map<String, String> getSuburbs() {
		return suburbs;
	}

	public void setSuburbs(Map<String, String> suburbs) {
		this.suburbs = suburbs;
	}
	
	public void handleCityChange() {
		if(city !=null && !city.equals(""))
			suburbs = suburbsData.get(city);
		else
			suburbs = new HashMap<String, String>();
	}

    public void displayLocation() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro Estudiantes", "Estudiante creado exitosamente"));
        
            }
}
