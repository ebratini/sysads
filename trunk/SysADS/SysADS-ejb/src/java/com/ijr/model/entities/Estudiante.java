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
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstId", query = "SELECT e FROM Estudiante e WHERE e.estudiantePK.estId = :estId"),
    @NamedQuery(name = "Estudiante.findByUsrId", query = "SELECT e FROM Estudiante e WHERE e.estudiantePK.usrId = :usrId"),
    @NamedQuery(name = "Estudiante.findByEstMatricula", query = "SELECT e FROM Estudiante e WHERE e.estMatricula = :estMatricula"),
    @NamedQuery(name = "Estudiante.findByEstDni", query = "SELECT e FROM Estudiante e WHERE e.estDni = :estDni"),
    @NamedQuery(name = "Estudiante.findByEstTipoDni", query = "SELECT e FROM Estudiante e WHERE e.estTipoDni = :estTipoDni"),
    @NamedQuery(name = "Estudiante.findByEstPrimerNombre", query = "SELECT e FROM Estudiante e WHERE e.estPrimerNombre = :estPrimerNombre"),
    @NamedQuery(name = "Estudiante.findByEstSegundoNombre", query = "SELECT e FROM Estudiante e WHERE e.estSegundoNombre = :estSegundoNombre"),
    @NamedQuery(name = "Estudiante.findByEstPrimerApellido", query = "SELECT e FROM Estudiante e WHERE e.estPrimerApellido = :estPrimerApellido"),
    @NamedQuery(name = "Estudiante.findByEstSegundoApellido", query = "SELECT e FROM Estudiante e WHERE e.estSegundoApellido = :estSegundoApellido"),
    @NamedQuery(name = "Estudiante.findByEstApodo", query = "SELECT e FROM Estudiante e WHERE e.estApodo = :estApodo"),
    @NamedQuery(name = "Estudiante.findByEstImagenPerfilUrl", query = "SELECT e FROM Estudiante e WHERE e.estImagenPerfilUrl = :estImagenPerfilUrl"),
    @NamedQuery(name = "Estudiante.findByEstTelefono", query = "SELECT e FROM Estudiante e WHERE e.estTelefono = :estTelefono"),
    @NamedQuery(name = "Estudiante.findByEstDireccion", query = "SELECT e FROM Estudiante e WHERE e.estDireccion = :estDireccion"),
    @NamedQuery(name = "Estudiante.findByEstEmail", query = "SELECT e FROM Estudiante e WHERE e.estEmail = :estEmail"),
    @NamedQuery(name = "Estudiante.findByEstNacionalidad", query = "SELECT e FROM Estudiante e WHERE e.estNacionalidad = :estNacionalidad"),
    @NamedQuery(name = "Estudiante.findByEstGenero", query = "SELECT e FROM Estudiante e WHERE e.estGenero = :estGenero"),
    @NamedQuery(name = "Estudiante.findByEstFechaNacimiento", query = "SELECT e FROM Estudiante e WHERE e.estFechaNacimiento = :estFechaNacimiento"),
    @NamedQuery(name = "Estudiante.findByEstLugarNacimiento", query = "SELECT e FROM Estudiante e WHERE e.estLugarNacimiento = :estLugarNacimiento"),
    @NamedQuery(name = "Estudiante.findByEstStatus", query = "SELECT e FROM Estudiante e WHERE e.estStatus = :estStatus")})
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiantePK estudiantePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_matricula")
    private String estMatricula;
    @Size(max = 45)
    @Column(name = "est_dni")
    private String estDni;
    @Size(max = 45)
    @Column(name = "est_tipo_dni")
    private String estTipoDni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_primer_nombre")
    private String estPrimerNombre;
    @Size(max = 45)
    @Column(name = "est_segundo_nombre")
    private String estSegundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_primer_apellido")
    private String estPrimerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_segundo_apellido")
    private String estSegundoApellido;
    @Size(max = 45)
    @Column(name = "est_apodo")
    private String estApodo;
    @Size(max = 60)
    @Column(name = "est_imagen_perfil_url")
    private String estImagenPerfilUrl;
    @Size(max = 10)
    @Column(name = "est_telefono")
    private String estTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_direccion")
    private String estDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_email")
    private String estEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_nacionalidad")
    private String estNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_genero")
    private char estGenero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date estFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_lugar_nacimiento")
    private String estLugarNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_status")
    private char estStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<EstudianteSeccion> estudianteSeccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<ContactoEmergencia> contactoEmergenciaCollection;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<Calificacion> calificacionCollection;

    public Estudiante() {
    }

    public Estudiante(EstudiantePK estudiantePK) {
        this.estudiantePK = estudiantePK;
    }

    public Estudiante(EstudiantePK estudiantePK, String estMatricula, String estPrimerNombre, String estPrimerApellido, String estSegundoApellido, String estDireccion, String estEmail, String estNacionalidad, char estGenero, Date estFechaNacimiento, String estLugarNacimiento, char estStatus) {
        this.estudiantePK = estudiantePK;
        this.estMatricula = estMatricula;
        this.estPrimerNombre = estPrimerNombre;
        this.estPrimerApellido = estPrimerApellido;
        this.estSegundoApellido = estSegundoApellido;
        this.estDireccion = estDireccion;
        this.estEmail = estEmail;
        this.estNacionalidad = estNacionalidad;
        this.estGenero = estGenero;
        this.estFechaNacimiento = estFechaNacimiento;
        this.estLugarNacimiento = estLugarNacimiento;
        this.estStatus = estStatus;
    }

    public Estudiante(int estId, int usrId) {
        this.estudiantePK = new EstudiantePK(estId, usrId);
    }

    public EstudiantePK getEstudiantePK() {
        return estudiantePK;
    }

    public void setEstudiantePK(EstudiantePK estudiantePK) {
        this.estudiantePK = estudiantePK;
    }

    public String getEstMatricula() {
        return estMatricula;
    }

    public void setEstMatricula(String estMatricula) {
        this.estMatricula = estMatricula;
    }

    public String getEstDni() {
        return estDni;
    }

    public void setEstDni(String estDni) {
        this.estDni = estDni;
    }

    public String getEstTipoDni() {
        return estTipoDni;
    }

    public void setEstTipoDni(String estTipoDni) {
        this.estTipoDni = estTipoDni;
    }

    public String getEstPrimerNombre() {
        return estPrimerNombre;
    }

    public void setEstPrimerNombre(String estPrimerNombre) {
        this.estPrimerNombre = estPrimerNombre;
    }

    public String getEstSegundoNombre() {
        return estSegundoNombre;
    }

    public void setEstSegundoNombre(String estSegundoNombre) {
        this.estSegundoNombre = estSegundoNombre;
    }

    public String getEstPrimerApellido() {
        return estPrimerApellido;
    }

    public void setEstPrimerApellido(String estPrimerApellido) {
        this.estPrimerApellido = estPrimerApellido;
    }

    public String getEstSegundoApellido() {
        return estSegundoApellido;
    }

    public void setEstSegundoApellido(String estSegundoApellido) {
        this.estSegundoApellido = estSegundoApellido;
    }

    public String getEstApodo() {
        return estApodo;
    }

    public void setEstApodo(String estApodo) {
        this.estApodo = estApodo;
    }

    public String getEstImagenPerfilUrl() {
        return estImagenPerfilUrl;
    }

    public void setEstImagenPerfilUrl(String estImagenPerfilUrl) {
        this.estImagenPerfilUrl = estImagenPerfilUrl;
    }

    public String getEstTelefono() {
        return estTelefono;
    }

    public void setEstTelefono(String estTelefono) {
        this.estTelefono = estTelefono;
    }

    public String getEstDireccion() {
        return estDireccion;
    }

    public void setEstDireccion(String estDireccion) {
        this.estDireccion = estDireccion;
    }

    public String getEstEmail() {
        return estEmail;
    }

    public void setEstEmail(String estEmail) {
        this.estEmail = estEmail;
    }

    public String getEstNacionalidad() {
        return estNacionalidad;
    }

    public void setEstNacionalidad(String estNacionalidad) {
        this.estNacionalidad = estNacionalidad;
    }

    public char getEstGenero() {
        return estGenero;
    }

    public void setEstGenero(char estGenero) {
        this.estGenero = estGenero;
    }

    public Date getEstFechaNacimiento() {
        return estFechaNacimiento;
    }

    public void setEstFechaNacimiento(Date estFechaNacimiento) {
        this.estFechaNacimiento = estFechaNacimiento;
    }

    public String getEstLugarNacimiento() {
        return estLugarNacimiento;
    }

    public void setEstLugarNacimiento(String estLugarNacimiento) {
        this.estLugarNacimiento = estLugarNacimiento;
    }

    public char getEstStatus() {
        return estStatus;
    }

    public void setEstStatus(char estStatus) {
        this.estStatus = estStatus;
    }

    @XmlTransient
    public Collection<EstudianteSeccion> getEstudianteSeccionCollection() {
        return estudianteSeccionCollection;
    }

    public void setEstudianteSeccionCollection(Collection<EstudianteSeccion> estudianteSeccionCollection) {
        this.estudianteSeccionCollection = estudianteSeccionCollection;
    }

    @XmlTransient
    public Collection<ContactoEmergencia> getContactoEmergenciaCollection() {
        return contactoEmergenciaCollection;
    }

    public void setContactoEmergenciaCollection(Collection<ContactoEmergencia> contactoEmergenciaCollection) {
        this.contactoEmergenciaCollection = contactoEmergenciaCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (estudiantePK != null ? estudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudiantePK == null && other.estudiantePK != null) || (this.estudiantePK != null && !this.estudiantePK.equals(other.estudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ijr.model.entities.Estudiante[ estudiantePK=" + estudiantePK + " ]";
    }
    
}
