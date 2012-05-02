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
@Table(name = "modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByMdlId", query = "SELECT m FROM Modulo m WHERE m.mdlId = :mdlId"),
    @NamedQuery(name = "Modulo.findByMdlNombre", query = "SELECT m FROM Modulo m WHERE m.mdlNombre = :mdlNombre"),
    @NamedQuery(name = "Modulo.findByMdlDescripcion", query = "SELECT m FROM Modulo m WHERE m.mdlDescripcion = :mdlDescripcion"),
    @NamedQuery(name = "Modulo.findByMdlCostoTotal", query = "SELECT m FROM Modulo m WHERE m.mdlCostoTotal = :mdlCostoTotal"),
    @NamedQuery(name = "Modulo.findByMdlDuracion", query = "SELECT m FROM Modulo m WHERE m.mdlDuracion = :mdlDuracion"),
    @NamedQuery(name = "Modulo.findByMdlPrerequisitos", query = "SELECT m FROM Modulo m WHERE m.mdlPrerequisitos = :mdlPrerequisitos"),
    @NamedQuery(name = "Modulo.findByMdlStatus", query = "SELECT m FROM Modulo m WHERE m.mdlStatus = :mdlStatus")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdl_id")
    private Integer mdlId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mdl_nombre")
    private String mdlNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mdl_descripcion")
    private String mdlDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdl_costo_total")
    private short mdlCostoTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdl_duracion")
    private int mdlDuracion;
    @Size(max = 45)
    @Column(name = "mdl_prerequisitos")
    private String mdlPrerequisitos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdl_status")
    private char mdlStatus;
    @JoinColumn(name = "cso_id", referencedColumnName = "cso_id")
    @ManyToOne(optional = false)
    private Curso curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private Collection<Seccion> seccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private Collection<Calificacion> calificacionCollection;

    public Modulo() {
    }

    public Modulo(Integer mdlId) {
        this.mdlId = mdlId;
    }

    public Modulo(Integer mdlId, String mdlNombre, String mdlDescripcion, short mdlCostoTotal, int mdlDuracion, char mdlStatus) {
        this.mdlId = mdlId;
        this.mdlNombre = mdlNombre;
        this.mdlDescripcion = mdlDescripcion;
        this.mdlCostoTotal = mdlCostoTotal;
        this.mdlDuracion = mdlDuracion;
        this.mdlStatus = mdlStatus;
    }

    public Integer getMdlId() {
        return mdlId;
    }

    public void setMdlId(Integer mdlId) {
        this.mdlId = mdlId;
    }

    public String getMdlNombre() {
        return mdlNombre;
    }

    public void setMdlNombre(String mdlNombre) {
        this.mdlNombre = mdlNombre;
    }

    public String getMdlDescripcion() {
        return mdlDescripcion;
    }

    public void setMdlDescripcion(String mdlDescripcion) {
        this.mdlDescripcion = mdlDescripcion;
    }

    public short getMdlCostoTotal() {
        return mdlCostoTotal;
    }

    public void setMdlCostoTotal(short mdlCostoTotal) {
        this.mdlCostoTotal = mdlCostoTotal;
    }

    public int getMdlDuracion() {
        return mdlDuracion;
    }

    public void setMdlDuracion(int mdlDuracion) {
        this.mdlDuracion = mdlDuracion;
    }

    public String getMdlPrerequisitos() {
        return mdlPrerequisitos;
    }

    public void setMdlPrerequisitos(String mdlPrerequisitos) {
        this.mdlPrerequisitos = mdlPrerequisitos;
    }

    public char getMdlStatus() {
        return mdlStatus;
    }

    public void setMdlStatus(char mdlStatus) {
        this.mdlStatus = mdlStatus;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @XmlTransient
    public Collection<Seccion> getSeccionCollection() {
        return seccionCollection;
    }

    public void setSeccionCollection(Collection<Seccion> seccionCollection) {
        this.seccionCollection = seccionCollection;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdlId != null ? mdlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.mdlId == null && other.mdlId != null) || (this.mdlId != null && !this.mdlId.equals(other.mdlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ijr.model.entities.Modulo[ mdlId=" + mdlId + " ]";
    }
    
}
