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
package com.instituto_jose_reyes.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "contactos_emergencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoEmergencia.findAll", query = "SELECT c FROM ContactoEmergencia c"),
    @NamedQuery(name = "ContactoEmergencia.findByCemId", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemId = :cemId"),
    @NamedQuery(name = "ContactoEmergencia.findByCemPrimerNombre", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemPrimerNombre = :cemPrimerNombre"),
    @NamedQuery(name = "ContactoEmergencia.findByCemSegundoNombre", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemSegundoNombre = :cemSegundoNombre"),
    @NamedQuery(name = "ContactoEmergencia.findByCemPrimerApellido", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemPrimerApellido = :cemPrimerApellido"),
    @NamedQuery(name = "ContactoEmergencia.findByCemSegundoApellido", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemSegundoApellido = :cemSegundoApellido"),
    @NamedQuery(name = "ContactoEmergencia.findByCemTelefono", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemTelefono = :cemTelefono"),
    @NamedQuery(name = "ContactoEmergencia.findByCemDireccion", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemDireccion = :cemDireccion"),
    @NamedQuery(name = "ContactoEmergencia.findByCemParentesco", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemParentesco = :cemParentesco"),
    @NamedQuery(name = "ContactoEmergencia.findByCemStatus", query = "SELECT c FROM ContactoEmergencia c WHERE c.cemStatus = :cemStatus")})
public class ContactoEmergencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "cem_id")
    private Integer cemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cem_primer_nombre")
    private String cemPrimerNombre;
    @Size(max = 45)
    @Column(name = "cem_segundo_nombre")
    private String cemSegundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cem_primer_apellido")
    private String cemPrimerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cem_segundo_apellido")
    private String cemSegundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cem_telefono")
    private String cemTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cem_direccion")
    private String cemDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cem_parentesco")
    private String cemParentesco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cem_status")
    private char cemStatus;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private Estudiante estId;

    public ContactoEmergencia() {
    }

    public ContactoEmergencia(Integer cemId) {
        this.cemId = cemId;
    }

    public ContactoEmergencia(Integer cemId, String cemPrimerNombre, String cemPrimerApellido, String cemSegundoApellido, String cemTelefono, String cemDireccion, String cemParentesco, char cemStatus) {
        this.cemId = cemId;
        this.cemPrimerNombre = cemPrimerNombre;
        this.cemPrimerApellido = cemPrimerApellido;
        this.cemSegundoApellido = cemSegundoApellido;
        this.cemTelefono = cemTelefono;
        this.cemDireccion = cemDireccion;
        this.cemParentesco = cemParentesco;
        this.cemStatus = cemStatus;
    }

    public Integer getCemId() {
        return cemId;
    }

    public void setCemId(Integer cemId) {
        this.cemId = cemId;
    }

    public String getCemPrimerNombre() {
        return cemPrimerNombre;
    }

    public void setCemPrimerNombre(String cemPrimerNombre) {
        this.cemPrimerNombre = cemPrimerNombre;
    }

    public String getCemSegundoNombre() {
        return cemSegundoNombre;
    }

    public void setCemSegundoNombre(String cemSegundoNombre) {
        this.cemSegundoNombre = cemSegundoNombre;
    }

    public String getCemPrimerApellido() {
        return cemPrimerApellido;
    }

    public void setCemPrimerApellido(String cemPrimerApellido) {
        this.cemPrimerApellido = cemPrimerApellido;
    }

    public String getCemSegundoApellido() {
        return cemSegundoApellido;
    }

    public void setCemSegundoApellido(String cemSegundoApellido) {
        this.cemSegundoApellido = cemSegundoApellido;
    }

    public String getCemTelefono() {
        return cemTelefono;
    }

    public void setCemTelefono(String cemTelefono) {
        this.cemTelefono = cemTelefono;
    }

    public String getCemDireccion() {
        return cemDireccion;
    }

    public void setCemDireccion(String cemDireccion) {
        this.cemDireccion = cemDireccion;
    }

    public String getCemParentesco() {
        return cemParentesco;
    }

    public void setCemParentesco(String cemParentesco) {
        this.cemParentesco = cemParentesco;
    }

    public char getCemStatus() {
        return cemStatus;
    }

    public void setCemStatus(char cemStatus) {
        this.cemStatus = cemStatus;
    }

    public Estudiante getEstId() {
        return estId;
    }

    public void setEstId(Estudiante estId) {
        this.estId = estId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cemId != null ? cemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoEmergencia)) {
            return false;
        }
        ContactoEmergencia other = (ContactoEmergencia) object;
        if ((this.cemId == null && other.cemId != null) || (this.cemId != null && !this.cemId.equals(other.cemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.ContactoEmergencia[ cemId=" + cemId + " ]";
    }
    
}
