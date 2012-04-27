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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByRolId", query = "SELECT r FROM Rol r WHERE r.rolId = :rolId"),
    @NamedQuery(name = "Rol.findByRolNombre", query = "SELECT r FROM Rol r WHERE r.rolNombre = :rolNombre"),
    @NamedQuery(name = "Rol.findByRolDescripcion", query = "SELECT r FROM Rol r WHERE r.rolDescripcion = :rolDescripcion"),
    @NamedQuery(name = "Rol.findByRolUpdateBy", query = "SELECT r FROM Rol r WHERE r.rolUpdateBy = :rolUpdateBy"),
    @NamedQuery(name = "Rol.findByRolUpdateDate", query = "SELECT r FROM Rol r WHERE r.rolUpdateDate = :rolUpdateDate"),
    @NamedQuery(name = "Rol.findByRolStatus", query = "SELECT r FROM Rol r WHERE r.rolStatus = :rolStatus")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_id")
    private Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rol_descripcion")
    private String rolDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rol_update_by")
    private String rolUpdateBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolUpdateDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_status")
    private char rolStatus;
    @JoinTable(name = "roles_permisos", joinColumns = {
        @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")}, inverseJoinColumns = {
        @JoinColumn(name = "per_id", referencedColumnName = "per_id")})
    @ManyToMany
    private Collection<Permiso> permisoCollection;
    @ManyToMany(mappedBy = "rolCollection")
    private Collection<Usuario> usuarioCollection;

    public Rol() {
    }

    public Rol(Integer rolId) {
        this.rolId = rolId;
    }

    public Rol(Integer rolId, String rolNombre, String rolDescripcion, String rolUpdateBy, Date rolUpdateDate, char rolStatus) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.rolDescripcion = rolDescripcion;
        this.rolUpdateBy = rolUpdateBy;
        this.rolUpdateDate = rolUpdateDate;
        this.rolStatus = rolStatus;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public String getRolUpdateBy() {
        return rolUpdateBy;
    }

    public void setRolUpdateBy(String rolUpdateBy) {
        this.rolUpdateBy = rolUpdateBy;
    }

    public Date getRolUpdateDate() {
        return rolUpdateDate;
    }

    public void setRolUpdateDate(Date rolUpdateDate) {
        this.rolUpdateDate = rolUpdateDate;
    }

    public char getRolStatus() {
        return rolStatus;
    }

    public void setRolStatus(char rolStatus) {
        this.rolStatus = rolStatus;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.Rol[ rolId=" + rolId + " ]";
    }
    
}
