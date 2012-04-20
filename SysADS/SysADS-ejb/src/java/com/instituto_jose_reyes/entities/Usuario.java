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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsrId", query = "SELECT u FROM Usuario u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "Usuario.findByUsrLogin", query = "SELECT u FROM Usuario u WHERE u.usrLogin = :usrLogin"),
    @NamedQuery(name = "Usuario.findByUsrNombre", query = "SELECT u FROM Usuario u WHERE u.usrNombre = :usrNombre"),
    @NamedQuery(name = "Usuario.findByUsrApellido", query = "SELECT u FROM Usuario u WHERE u.usrApellido = :usrApellido"),
    @NamedQuery(name = "Usuario.findByUsrPassword", query = "SELECT u FROM Usuario u WHERE u.usrPassword = :usrPassword"),
    @NamedQuery(name = "Usuario.findByUsrEmail", query = "SELECT u FROM Usuario u WHERE u.usrEmail = :usrEmail"),
    @NamedQuery(name = "Usuario.findByUsrUltimoAcceso", query = "SELECT u FROM Usuario u WHERE u.usrUltimoAcceso = :usrUltimoAcceso"),
    @NamedQuery(name = "Usuario.findByUsrFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.usrFechaCreacion = :usrFechaCreacion"),
    @NamedQuery(name = "Usuario.findByUsrVerificado", query = "SELECT u FROM Usuario u WHERE u.usrVerificado = :usrVerificado"),
    @NamedQuery(name = "Usuario.findByUsrUpdateBy", query = "SELECT u FROM Usuario u WHERE u.usrUpdateBy = :usrUpdateBy"),
    @NamedQuery(name = "Usuario.findByUsrUpdateDate", query = "SELECT u FROM Usuario u WHERE u.usrUpdateDate = :usrUpdateDate"),
    @NamedQuery(name = "Usuario.findByUsrStatus", query = "SELECT u FROM Usuario u WHERE u.usrStatus = :usrStatus")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private Integer usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_login")
    private String usrLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_nombre")
    private String usrNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_apellido")
    private String usrApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_password")
    private String usrPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_email")
    private String usrEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_ultimo_acceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrUltimoAcceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_verificado")
    private char usrVerificado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_update_by")
    private String usrUpdateBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrUpdateDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_status")
    private char usrStatus;
    @JoinTable(name = "usuarios_roles", joinColumns = {
        @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")}, inverseJoinColumns = {
        @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")})
    @ManyToMany
    private Collection<Rol> rolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<Log> logCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<Estudiante> estudianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<Profesor> profesorCollection;

    public Usuario() {
    }

    public Usuario(Integer usrId) {
        this.usrId = usrId;
    }

    public Usuario(Integer usrId, String usrLogin, String usrNombre, String usrApellido, String usrPassword, String usrEmail, Date usrUltimoAcceso, Date usrFechaCreacion, char usrVerificado, String usrUpdateBy, Date usrUpdateDate, char usrStatus) {
        this.usrId = usrId;
        this.usrLogin = usrLogin;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
        this.usrPassword = usrPassword;
        this.usrEmail = usrEmail;
        this.usrUltimoAcceso = usrUltimoAcceso;
        this.usrFechaCreacion = usrFechaCreacion;
        this.usrVerificado = usrVerificado;
        this.usrUpdateBy = usrUpdateBy;
        this.usrUpdateDate = usrUpdateDate;
        this.usrStatus = usrStatus;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public Date getUsrUltimoAcceso() {
        return usrUltimoAcceso;
    }

    public void setUsrUltimoAcceso(Date usrUltimoAcceso) {
        this.usrUltimoAcceso = usrUltimoAcceso;
    }

    public Date getUsrFechaCreacion() {
        return usrFechaCreacion;
    }

    public void setUsrFechaCreacion(Date usrFechaCreacion) {
        this.usrFechaCreacion = usrFechaCreacion;
    }

    public char getUsrVerificado() {
        return usrVerificado;
    }

    public void setUsrVerificado(char usrVerificado) {
        this.usrVerificado = usrVerificado;
    }

    public String getUsrUpdateBy() {
        return usrUpdateBy;
    }

    public void setUsrUpdateBy(String usrUpdateBy) {
        this.usrUpdateBy = usrUpdateBy;
    }

    public Date getUsrUpdateDate() {
        return usrUpdateDate;
    }

    public void setUsrUpdateDate(Date usrUpdateDate) {
        this.usrUpdateDate = usrUpdateDate;
    }

    public char getUsrStatus() {
        return usrStatus;
    }

    public void setUsrStatus(char usrStatus) {
        this.usrStatus = usrStatus;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.Usuario[ usrId=" + usrId + " ]";
    }
    
}
