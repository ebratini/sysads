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
@Table(name = "profesores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByPrfId", query = "SELECT p FROM Profesor p WHERE p.prfId = :prfId"),
    @NamedQuery(name = "Profesor.findByPrfDni", query = "SELECT p FROM Profesor p WHERE p.prfDni = :prfDni"),
    @NamedQuery(name = "Profesor.findByPrfTipoDni", query = "SELECT p FROM Profesor p WHERE p.prfTipoDni = :prfTipoDni"),
    @NamedQuery(name = "Profesor.findByPrfPrimerNombre", query = "SELECT p FROM Profesor p WHERE p.prfPrimerNombre = :prfPrimerNombre"),
    @NamedQuery(name = "Profesor.findByPrfSegundoNombre", query = "SELECT p FROM Profesor p WHERE p.prfSegundoNombre = :prfSegundoNombre"),
    @NamedQuery(name = "Profesor.findByPrfPrimerApellido", query = "SELECT p FROM Profesor p WHERE p.prfPrimerApellido = :prfPrimerApellido"),
    @NamedQuery(name = "Profesor.findByPrfSegundoApellido", query = "SELECT p FROM Profesor p WHERE p.prfSegundoApellido = :prfSegundoApellido"),
    @NamedQuery(name = "Profesor.findByPrfTelefono", query = "SELECT p FROM Profesor p WHERE p.prfTelefono = :prfTelefono"),
    @NamedQuery(name = "Profesor.findByPrfDireccion", query = "SELECT p FROM Profesor p WHERE p.prfDireccion = :prfDireccion"),
    @NamedQuery(name = "Profesor.findByPrfEmail", query = "SELECT p FROM Profesor p WHERE p.prfEmail = :prfEmail"),
    @NamedQuery(name = "Profesor.findByPrfNacionalidad", query = "SELECT p FROM Profesor p WHERE p.prfNacionalidad = :prfNacionalidad"),
    @NamedQuery(name = "Profesor.findByPrfGenero", query = "SELECT p FROM Profesor p WHERE p.prfGenero = :prfGenero"),
    @NamedQuery(name = "Profesor.findByPrfEstadoCivil", query = "SELECT p FROM Profesor p WHERE p.prfEstadoCivil = :prfEstadoCivil"),
    @NamedQuery(name = "Profesor.findByPrfFechaNacimiento", query = "SELECT p FROM Profesor p WHERE p.prfFechaNacimiento = :prfFechaNacimiento"),
    @NamedQuery(name = "Profesor.findByPrfLugarNacmiento", query = "SELECT p FROM Profesor p WHERE p.prfLugarNacmiento = :prfLugarNacmiento"),
    @NamedQuery(name = "Profesor.findByPrfStatus", query = "SELECT p FROM Profesor p WHERE p.prfStatus = :prfStatus")})
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "prf_id")
    private Integer prfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_dni")
    private String prfDni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_tipo_dni")
    private String prfTipoDni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_primer_nombre")
    private String prfPrimerNombre;
    @Size(max = 45)
    @Column(name = "prf_segundo_nombre")
    private String prfSegundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_primer_apellido")
    private String prfPrimerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_segundo_apellido")
    private String prfSegundoApellido;
    @Size(max = 10)
    @Column(name = "prf_telefono")
    private String prfTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_direccion")
    private String prfDireccion;
    @Size(max = 45)
    @Column(name = "prf_email")
    private String prfEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_nacionalidad")
    private String prfNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prf_genero")
    private char prfGenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_estado_civil")
    private String prfEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prf_fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prfFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prf_lugar_nacmiento")
    private String prfLugarNacmiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prf_status")
    private char prfStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prfId")
    private Collection<Seccion> seccionCollection;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Usuario usrId;

    public Profesor() {
    }

    public Profesor(Integer prfId) {
        this.prfId = prfId;
    }

    public Profesor(Integer prfId, String prfDni, String prfTipoDni, String prfPrimerNombre, String prfPrimerApellido, String prfSegundoApellido, String prfDireccion, String prfNacionalidad, char prfGenero, String prfEstadoCivil, Date prfFechaNacimiento, String prfLugarNacmiento, char prfStatus) {
        this.prfId = prfId;
        this.prfDni = prfDni;
        this.prfTipoDni = prfTipoDni;
        this.prfPrimerNombre = prfPrimerNombre;
        this.prfPrimerApellido = prfPrimerApellido;
        this.prfSegundoApellido = prfSegundoApellido;
        this.prfDireccion = prfDireccion;
        this.prfNacionalidad = prfNacionalidad;
        this.prfGenero = prfGenero;
        this.prfEstadoCivil = prfEstadoCivil;
        this.prfFechaNacimiento = prfFechaNacimiento;
        this.prfLugarNacmiento = prfLugarNacmiento;
        this.prfStatus = prfStatus;
    }

    public Integer getPrfId() {
        return prfId;
    }

    public void setPrfId(Integer prfId) {
        this.prfId = prfId;
    }

    public String getPrfDni() {
        return prfDni;
    }

    public void setPrfDni(String prfDni) {
        this.prfDni = prfDni;
    }

    public String getPrfTipoDni() {
        return prfTipoDni;
    }

    public void setPrfTipoDni(String prfTipoDni) {
        this.prfTipoDni = prfTipoDni;
    }

    public String getPrfPrimerNombre() {
        return prfPrimerNombre;
    }

    public void setPrfPrimerNombre(String prfPrimerNombre) {
        this.prfPrimerNombre = prfPrimerNombre;
    }

    public String getPrfSegundoNombre() {
        return prfSegundoNombre;
    }

    public void setPrfSegundoNombre(String prfSegundoNombre) {
        this.prfSegundoNombre = prfSegundoNombre;
    }

    public String getPrfPrimerApellido() {
        return prfPrimerApellido;
    }

    public void setPrfPrimerApellido(String prfPrimerApellido) {
        this.prfPrimerApellido = prfPrimerApellido;
    }

    public String getPrfSegundoApellido() {
        return prfSegundoApellido;
    }

    public void setPrfSegundoApellido(String prfSegundoApellido) {
        this.prfSegundoApellido = prfSegundoApellido;
    }

    public String getPrfTelefono() {
        return prfTelefono;
    }

    public void setPrfTelefono(String prfTelefono) {
        this.prfTelefono = prfTelefono;
    }

    public String getPrfDireccion() {
        return prfDireccion;
    }

    public void setPrfDireccion(String prfDireccion) {
        this.prfDireccion = prfDireccion;
    }

    public String getPrfEmail() {
        return prfEmail;
    }

    public void setPrfEmail(String prfEmail) {
        this.prfEmail = prfEmail;
    }

    public String getPrfNacionalidad() {
        return prfNacionalidad;
    }

    public void setPrfNacionalidad(String prfNacionalidad) {
        this.prfNacionalidad = prfNacionalidad;
    }

    public char getPrfGenero() {
        return prfGenero;
    }

    public void setPrfGenero(char prfGenero) {
        this.prfGenero = prfGenero;
    }

    public String getPrfEstadoCivil() {
        return prfEstadoCivil;
    }

    public void setPrfEstadoCivil(String prfEstadoCivil) {
        this.prfEstadoCivil = prfEstadoCivil;
    }

    public Date getPrfFechaNacimiento() {
        return prfFechaNacimiento;
    }

    public void setPrfFechaNacimiento(Date prfFechaNacimiento) {
        this.prfFechaNacimiento = prfFechaNacimiento;
    }

    public String getPrfLugarNacmiento() {
        return prfLugarNacmiento;
    }

    public void setPrfLugarNacmiento(String prfLugarNacmiento) {
        this.prfLugarNacmiento = prfLugarNacmiento;
    }

    public char getPrfStatus() {
        return prfStatus;
    }

    public void setPrfStatus(char prfStatus) {
        this.prfStatus = prfStatus;
    }

    @XmlTransient
    public Collection<Seccion> getSeccionCollection() {
        return seccionCollection;
    }

    public void setSeccionCollection(Collection<Seccion> seccionCollection) {
        this.seccionCollection = seccionCollection;
    }

    public Usuario getUsrId() {
        return usrId;
    }

    public void setUsrId(Usuario usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prfId != null ? prfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.prfId == null && other.prfId != null) || (this.prfId != null && !this.prfId.equals(other.prfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.Profesor[ prfId=" + prfId + " ]";
    }
    
}
