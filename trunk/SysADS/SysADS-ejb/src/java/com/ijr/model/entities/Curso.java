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
package com.ijr.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCsoId", query = "SELECT c FROM Curso c WHERE c.csoId = :csoId"),
    @NamedQuery(name = "Curso.findByCsoNombre", query = "SELECT c FROM Curso c WHERE c.csoNombre = :csoNombre"),
    @NamedQuery(name = "Curso.findByCsoDescripcion", query = "SELECT c FROM Curso c WHERE c.csoDescripcion = :csoDescripcion"),
    @NamedQuery(name = "Curso.findByCsoCategoria", query = "SELECT c FROM Curso c WHERE c.csoCategoria = :csoCategoria"),
    @NamedQuery(name = "Curso.findByCsoSectorProductivo", query = "SELECT c FROM Curso c WHERE c.csoSectorProductivo = :csoSectorProductivo"),
    @NamedQuery(name = "Curso.findByCsoRequisitosAdmision", query = "SELECT c FROM Curso c WHERE c.csoRequisitosAdmision = :csoRequisitosAdmision"),
    @NamedQuery(name = "Curso.findByCsoStatus", query = "SELECT c FROM Curso c WHERE c.csoStatus = :csoStatus")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "cso_id")
    private Integer csoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cso_nombre")
    private String csoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cso_descripcion")
    private String csoDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cso_categoria")
    private String csoCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cso_sector_productivo")
    private String csoSectorProductivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cso_requisitos_admision")
    private String csoRequisitosAdmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cso_status")
    private char csoStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<Modulo> moduloCollection;

    public Curso() {
    }

    public Curso(Integer csoId) {
        this.csoId = csoId;
    }

    public Curso(Integer csoId, String csoNombre, String csoDescripcion, String csoCategoria, String csoSectorProductivo, String csoRequisitosAdmision, char csoStatus) {
        this.csoId = csoId;
        this.csoNombre = csoNombre;
        this.csoDescripcion = csoDescripcion;
        this.csoCategoria = csoCategoria;
        this.csoSectorProductivo = csoSectorProductivo;
        this.csoRequisitosAdmision = csoRequisitosAdmision;
        this.csoStatus = csoStatus;
    }

    public Integer getCsoId() {
        return csoId;
    }

    public void setCsoId(Integer csoId) {
        this.csoId = csoId;
    }

    public String getCsoNombre() {
        return csoNombre;
    }

    public void setCsoNombre(String csoNombre) {
        this.csoNombre = csoNombre;
    }

    public String getCsoDescripcion() {
        return csoDescripcion;
    }

    public void setCsoDescripcion(String csoDescripcion) {
        this.csoDescripcion = csoDescripcion;
    }

    public String getCsoCategoria() {
        return csoCategoria;
    }

    public void setCsoCategoria(String csoCategoria) {
        this.csoCategoria = csoCategoria;
    }

    public String getCsoSectorProductivo() {
        return csoSectorProductivo;
    }

    public void setCsoSectorProductivo(String csoSectorProductivo) {
        this.csoSectorProductivo = csoSectorProductivo;
    }

    public String getCsoRequisitosAdmision() {
        return csoRequisitosAdmision;
    }

    public void setCsoRequisitosAdmision(String csoRequisitosAdmision) {
        this.csoRequisitosAdmision = csoRequisitosAdmision;
    }

    public char getCsoStatus() {
        return csoStatus;
    }

    public void setCsoStatus(char csoStatus) {
        this.csoStatus = csoStatus;
    }

    @XmlTransient
    public Collection<Modulo> getModuloCollection() {
        return moduloCollection;
    }

    public void setModuloCollection(Collection<Modulo> moduloCollection) {
        this.moduloCollection = moduloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoId != null ? csoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.csoId == null && other.csoId != null) || (this.csoId != null && !this.csoId.equals(other.csoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ijr.model.entities.Curso[ csoId=" + csoId + " ]";
    }
    
}
