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
import java.util.Date;
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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByPerId", query = "SELECT p FROM Permiso p WHERE p.perId = :perId"),
    @NamedQuery(name = "Permiso.findByPerNombre", query = "SELECT p FROM Permiso p WHERE p.perNombre = :perNombre"),
    @NamedQuery(name = "Permiso.findByPerDescripcion", query = "SELECT p FROM Permiso p WHERE p.perDescripcion = :perDescripcion"),
    @NamedQuery(name = "Permiso.findByPerUpdateBy", query = "SELECT p FROM Permiso p WHERE p.perUpdateBy = :perUpdateBy"),
    @NamedQuery(name = "Permiso.findByPerUpdateDate", query = "SELECT p FROM Permiso p WHERE p.perUpdateDate = :perUpdateDate"),
    @NamedQuery(name = "Permiso.findByPerStatus", query = "SELECT p FROM Permiso p WHERE p.perStatus = :perStatus")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "per_nombre")
    private String perNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "per_descripcion")
    private String perDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "per_update_by")
    private String perUpdateBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perUpdateDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_status")
    private char perStatus;
    @JoinTable(name = "roles_permisos", joinColumns = {
        @JoinColumn(name = "per_id", referencedColumnName = "per_id")}, inverseJoinColumns = {
        @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")})
    @ManyToMany
    private Collection<Rol> rolCollection;

    public Permiso() {
    }

    public Permiso(Integer perId) {
        this.perId = perId;
    }

    public Permiso(Integer perId, String perNombre, String perDescripcion, String perUpdateBy, Date perUpdateDate, char perStatus) {
        this.perId = perId;
        this.perNombre = perNombre;
        this.perDescripcion = perDescripcion;
        this.perUpdateBy = perUpdateBy;
        this.perUpdateDate = perUpdateDate;
        this.perStatus = perStatus;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
    }

    public String getPerUpdateBy() {
        return perUpdateBy;
    }

    public void setPerUpdateBy(String perUpdateBy) {
        this.perUpdateBy = perUpdateBy;
    }

    public Date getPerUpdateDate() {
        return perUpdateDate;
    }

    public void setPerUpdateDate(Date perUpdateDate) {
        this.perUpdateDate = perUpdateDate;
    }

    public char getPerStatus() {
        return perStatus;
    }

    public void setPerStatus(char perStatus) {
        this.perStatus = perStatus;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ijr.model.entities.Permiso[ perId=" + perId + " ]";
    }
    
}
