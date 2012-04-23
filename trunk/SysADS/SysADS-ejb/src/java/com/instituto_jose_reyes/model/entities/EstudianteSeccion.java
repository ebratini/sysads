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
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "estudiantes_secciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteSeccion.findAll", query = "SELECT e FROM EstudianteSeccion e"),
    @NamedQuery(name = "EstudianteSeccion.findByEstId", query = "SELECT e FROM EstudianteSeccion e WHERE e.estudianteSeccionPK.estId = :estId"),
    @NamedQuery(name = "EstudianteSeccion.findBySecId", query = "SELECT e FROM EstudianteSeccion e WHERE e.estudianteSeccionPK.secId = :secId"),
    @NamedQuery(name = "EstudianteSeccion.findByEscAnio", query = "SELECT e FROM EstudianteSeccion e WHERE e.escAnio = :escAnio"),
    @NamedQuery(name = "EstudianteSeccion.findByEscPeriodo", query = "SELECT e FROM EstudianteSeccion e WHERE e.escPeriodo = :escPeriodo"),
    @NamedQuery(name = "EstudianteSeccion.findByEscFechaInicio", query = "SELECT e FROM EstudianteSeccion e WHERE e.escFechaInicio = :escFechaInicio"),
    @NamedQuery(name = "EstudianteSeccion.findByEscFechaTermino", query = "SELECT e FROM EstudianteSeccion e WHERE e.escFechaTermino = :escFechaTermino")})
public class EstudianteSeccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudianteSeccionPK estudianteSeccionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esc_anio")
    @Temporal(TemporalType.DATE)
    private Date escAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esc_periodo")
    private int escPeriodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esc_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date escFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esc_fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date escFechaTermino;
    @JoinColumn(name = "sec_id", referencedColumnName = "sec_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Seccion seccion;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public EstudianteSeccion() {
    }

    public EstudianteSeccion(EstudianteSeccionPK estudianteSeccionPK) {
        this.estudianteSeccionPK = estudianteSeccionPK;
    }

    public EstudianteSeccion(EstudianteSeccionPK estudianteSeccionPK, Date escAnio, int escPeriodo, Date escFechaInicio, Date escFechaTermino) {
        this.estudianteSeccionPK = estudianteSeccionPK;
        this.escAnio = escAnio;
        this.escPeriodo = escPeriodo;
        this.escFechaInicio = escFechaInicio;
        this.escFechaTermino = escFechaTermino;
    }

    public EstudianteSeccion(int estId, int secId) {
        this.estudianteSeccionPK = new EstudianteSeccionPK(estId, secId);
    }

    public EstudianteSeccionPK getEstudianteSeccionPK() {
        return estudianteSeccionPK;
    }

    public void setEstudianteSeccionPK(EstudianteSeccionPK estudianteSeccionPK) {
        this.estudianteSeccionPK = estudianteSeccionPK;
    }

    public Date getEscAnio() {
        return escAnio;
    }

    public void setEscAnio(Date escAnio) {
        this.escAnio = escAnio;
    }

    public int getEscPeriodo() {
        return escPeriodo;
    }

    public void setEscPeriodo(int escPeriodo) {
        this.escPeriodo = escPeriodo;
    }

    public Date getEscFechaInicio() {
        return escFechaInicio;
    }

    public void setEscFechaInicio(Date escFechaInicio) {
        this.escFechaInicio = escFechaInicio;
    }

    public Date getEscFechaTermino() {
        return escFechaTermino;
    }

    public void setEscFechaTermino(Date escFechaTermino) {
        this.escFechaTermino = escFechaTermino;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteSeccionPK != null ? estudianteSeccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteSeccion)) {
            return false;
        }
        EstudianteSeccion other = (EstudianteSeccion) object;
        if ((this.estudianteSeccionPK == null && other.estudianteSeccionPK != null) || (this.estudianteSeccionPK != null && !this.estudianteSeccionPK.equals(other.estudianteSeccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.EstudianteSeccion[ estudianteSeccionPK=" + estudianteSeccionPK + " ]";
    }
    
}
