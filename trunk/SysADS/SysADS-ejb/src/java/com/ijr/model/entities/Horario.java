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
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByHroId", query = "SELECT h FROM Horario h WHERE h.hroId = :hroId"),
    @NamedQuery(name = "Horario.findByHroDiaSemana", query = "SELECT h FROM Horario h WHERE h.hroDiaSemana = :hroDiaSemana"),
    @NamedQuery(name = "Horario.findByHroHoraInicio", query = "SELECT h FROM Horario h WHERE h.hroHoraInicio = :hroHoraInicio"),
    @NamedQuery(name = "Horario.findByHroHoraFin", query = "SELECT h FROM Horario h WHERE h.hroHoraFin = :hroHoraFin"),
    @NamedQuery(name = "Horario.findByHroAnio", query = "SELECT h FROM Horario h WHERE h.hroAnio = :hroAnio"),
    @NamedQuery(name = "Horario.findByHroPeriodo", query = "SELECT h FROM Horario h WHERE h.hroPeriodo = :hroPeriodo"),
    @NamedQuery(name = "Horario.findByHroTipoHorario", query = "SELECT h FROM Horario h WHERE h.hroTipoHorario = :hroTipoHorario"),
    @NamedQuery(name = "Horario.findByHroAula", query = "SELECT h FROM Horario h WHERE h.hroAula = :hroAula"),
    @NamedQuery(name = "Horario.findByHroCampus", query = "SELECT h FROM Horario h WHERE h.hroCampus = :hroCampus")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "hro_id")
    private Integer hroId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hro_dia_semana")
    private String hroDiaSemana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hro_hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date hroHoraInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hro_hora_fin")
    @Temporal(TemporalType.TIME)
    private Date hroHoraFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hro_anio")
    @Temporal(TemporalType.DATE)
    private Date hroAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hro_periodo")
    private int hroPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hro_tipo_horario")
    private String hroTipoHorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hro_aula")
    private String hroAula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hro_campus")
    private String hroCampus;
    @JoinColumn(name = "sec_id", referencedColumnName = "sec_id")
    @ManyToOne(optional = false)
    private Seccion seccion;

    public Horario() {
    }

    public Horario(Integer hroId) {
        this.hroId = hroId;
    }

    public Horario(Integer hroId, String hroDiaSemana, Date hroHoraInicio, Date hroHoraFin, Date hroAnio, int hroPeriodo, String hroTipoHorario, String hroAula, String hroCampus) {
        this.hroId = hroId;
        this.hroDiaSemana = hroDiaSemana;
        this.hroHoraInicio = hroHoraInicio;
        this.hroHoraFin = hroHoraFin;
        this.hroAnio = hroAnio;
        this.hroPeriodo = hroPeriodo;
        this.hroTipoHorario = hroTipoHorario;
        this.hroAula = hroAula;
        this.hroCampus = hroCampus;
    }

    public Integer getHroId() {
        return hroId;
    }

    public void setHroId(Integer hroId) {
        this.hroId = hroId;
    }

    public String getHroDiaSemana() {
        return hroDiaSemana;
    }

    public void setHroDiaSemana(String hroDiaSemana) {
        this.hroDiaSemana = hroDiaSemana;
    }

    public Date getHroHoraInicio() {
        return hroHoraInicio;
    }

    public void setHroHoraInicio(Date hroHoraInicio) {
        this.hroHoraInicio = hroHoraInicio;
    }

    public Date getHroHoraFin() {
        return hroHoraFin;
    }

    public void setHroHoraFin(Date hroHoraFin) {
        this.hroHoraFin = hroHoraFin;
    }

    public Date getHroAnio() {
        return hroAnio;
    }

    public void setHroAnio(Date hroAnio) {
        this.hroAnio = hroAnio;
    }

    public int getHroPeriodo() {
        return hroPeriodo;
    }

    public void setHroPeriodo(int hroPeriodo) {
        this.hroPeriodo = hroPeriodo;
    }

    public String getHroTipoHorario() {
        return hroTipoHorario;
    }

    public void setHroTipoHorario(String hroTipoHorario) {
        this.hroTipoHorario = hroTipoHorario;
    }

    public String getHroAula() {
        return hroAula;
    }

    public void setHroAula(String hroAula) {
        this.hroAula = hroAula;
    }

    public String getHroCampus() {
        return hroCampus;
    }

    public void setHroCampus(String hroCampus) {
        this.hroCampus = hroCampus;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hroId != null ? hroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.hroId == null && other.hroId != null) || (this.hroId != null && !this.hroId.equals(other.hroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ijr.model.entities.Horario[ hroId=" + hroId + " ]";
    }
    
}
