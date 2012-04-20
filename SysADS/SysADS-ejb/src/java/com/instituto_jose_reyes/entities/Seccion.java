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
package com.instituto_jose_reyes.entities;

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
@Table(name = "secciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
    @NamedQuery(name = "Seccion.findBySecId", query = "SELECT s FROM Seccion s WHERE s.secId = :secId"),
    @NamedQuery(name = "Seccion.findBySecCodigo", query = "SELECT s FROM Seccion s WHERE s.secCodigo = :secCodigo"),
    @NamedQuery(name = "Seccion.findBySecCapacidad", query = "SELECT s FROM Seccion s WHERE s.secCapacidad = :secCapacidad"),
    @NamedQuery(name = "Seccion.findBySecStatus", query = "SELECT s FROM Seccion s WHERE s.secStatus = :secStatus")})
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "sec_id")
    private Integer secId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sec_capacidad")
    private int secCapacidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sec_status")
    private char secStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secId")
    private Collection<Horario> horarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccion")
    private Collection<EstudianteSeccion> estudianteSeccionCollection;
    @JoinColumn(name = "mdl_id", referencedColumnName = "mdl_id")
    @ManyToOne(optional = false)
    private Modulo mdlId;
    @JoinColumn(name = "prf_id", referencedColumnName = "prf_id")
    @ManyToOne(optional = false)
    private Profesor prfId;

    public Seccion() {
    }

    public Seccion(Integer secId) {
        this.secId = secId;
    }

    public Seccion(Integer secId, String secCodigo, int secCapacidad, char secStatus) {
        this.secId = secId;
        this.secCodigo = secCodigo;
        this.secCapacidad = secCapacidad;
        this.secStatus = secStatus;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public int getSecCapacidad() {
        return secCapacidad;
    }

    public void setSecCapacidad(int secCapacidad) {
        this.secCapacidad = secCapacidad;
    }

    public char getSecStatus() {
        return secStatus;
    }

    public void setSecStatus(char secStatus) {
        this.secStatus = secStatus;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    @XmlTransient
    public Collection<EstudianteSeccion> getEstudianteSeccionCollection() {
        return estudianteSeccionCollection;
    }

    public void setEstudianteSeccionCollection(Collection<EstudianteSeccion> estudianteSeccionCollection) {
        this.estudianteSeccionCollection = estudianteSeccionCollection;
    }

    public Modulo getMdlId() {
        return mdlId;
    }

    public void setMdlId(Modulo mdlId) {
        this.mdlId = mdlId;
    }

    public Profesor getPrfId() {
        return prfId;
    }

    public void setPrfId(Profesor prfId) {
        this.prfId = prfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secId != null ? secId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.secId == null && other.secId != null) || (this.secId != null && !this.secId.equals(other.secId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.Seccion[ secId=" + secId + " ]";
    }
    
}
