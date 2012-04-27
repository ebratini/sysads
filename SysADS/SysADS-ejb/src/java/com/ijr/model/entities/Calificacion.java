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
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edwin Bratini
 */
@Entity
@Table(name = "calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c"),
    @NamedQuery(name = "Calificacion.findByCalId", query = "SELECT c FROM Calificacion c WHERE c.calId = :calId"),
    @NamedQuery(name = "Calificacion.findByCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacion = :calificacion"),
    @NamedQuery(name = "Calificacion.findByCalAnio", query = "SELECT c FROM Calificacion c WHERE c.calAnio = :calAnio"),
    @NamedQuery(name = "Calificacion.findByCalPeriodo", query = "SELECT c FROM Calificacion c WHERE c.calPeriodo = :calPeriodo"),
    @NamedQuery(name = "Calificacion.findByCalFechaPublicacion", query = "SELECT c FROM Calificacion c WHERE c.calFechaPublicacion = :calFechaPublicacion"),
    @NamedQuery(name = "Calificacion.findByCalUpdateBy", query = "SELECT c FROM Calificacion c WHERE c.calUpdateBy = :calUpdateBy"),
    @NamedQuery(name = "Calificacion.findByCalUpdateDate", query = "SELECT c FROM Calificacion c WHERE c.calUpdateDate = :calUpdateDate")})
public class Calificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "cal_id")
    private Integer calId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cal_anio")
    @Temporal(TemporalType.DATE)
    private Date calAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cal_periodo")
    private int calPeriodo;
    @Column(name = "cal_fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calFechaPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cal_update_by")
    private String calUpdateBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cal_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calUpdateDate;
    @JoinColumn(name = "mdl_id", referencedColumnName = "mdl_id")
    @ManyToOne(optional = false)
    private Modulo mdlId;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private Estudiante estId;

    public Calificacion() {
    }

    public Calificacion(Integer calId) {
        this.calId = calId;
    }

    public Calificacion(Integer calId, int calificacion, Date calAnio, int calPeriodo, String calUpdateBy, Date calUpdateDate) {
        this.calId = calId;
        this.calificacion = calificacion;
        this.calAnio = calAnio;
        this.calPeriodo = calPeriodo;
        this.calUpdateBy = calUpdateBy;
        this.calUpdateDate = calUpdateDate;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getCalAnio() {
        return calAnio;
    }

    public void setCalAnio(Date calAnio) {
        this.calAnio = calAnio;
    }

    public int getCalPeriodo() {
        return calPeriodo;
    }

    public void setCalPeriodo(int calPeriodo) {
        this.calPeriodo = calPeriodo;
    }

    public Date getCalFechaPublicacion() {
        return calFechaPublicacion;
    }

    public void setCalFechaPublicacion(Date calFechaPublicacion) {
        this.calFechaPublicacion = calFechaPublicacion;
    }

    public String getCalUpdateBy() {
        return calUpdateBy;
    }

    public void setCalUpdateBy(String calUpdateBy) {
        this.calUpdateBy = calUpdateBy;
    }

    public Date getCalUpdateDate() {
        return calUpdateDate;
    }

    public void setCalUpdateDate(Date calUpdateDate) {
        this.calUpdateDate = calUpdateDate;
    }

    public Modulo getMdlId() {
        return mdlId;
    }

    public void setMdlId(Modulo mdlId) {
        this.mdlId = mdlId;
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
        hash += (calId != null ? calId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.calId == null && other.calId != null) || (this.calId != null && !this.calId.equals(other.calId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.Calificacion[ calId=" + calId + " ]";
    }
    
}
