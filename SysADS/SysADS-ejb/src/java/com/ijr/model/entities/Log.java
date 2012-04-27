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
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByLogId", query = "SELECT l FROM Log l WHERE l.logId = :logId"),
    @NamedQuery(name = "Log.findByLogFecha", query = "SELECT l FROM Log l WHERE l.logFecha = :logFecha"),
    @NamedQuery(name = "Log.findByLogFuente", query = "SELECT l FROM Log l WHERE l.logFuente = :logFuente"),
    @NamedQuery(name = "Log.findByLogCategoria", query = "SELECT l FROM Log l WHERE l.logCategoria = :logCategoria"),
    @NamedQuery(name = "Log.findByLogDescripcion", query = "SELECT l FROM Log l WHERE l.logDescripcion = :logDescripcion")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "log_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "log_fuente")
    private String logFuente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "log_categoria")
    private String logCategoria;
    @Size(max = 45)
    @Column(name = "log_descripcion")
    private String logDescripcion;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Usuario usrId;

    public Log() {
    }

    public Log(Integer logId) {
        this.logId = logId;
    }

    public Log(Integer logId, Date logFecha, String logFuente, String logCategoria) {
        this.logId = logId;
        this.logFecha = logFecha;
        this.logFuente = logFuente;
        this.logCategoria = logCategoria;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogFecha() {
        return logFecha;
    }

    public void setLogFecha(Date logFecha) {
        this.logFecha = logFecha;
    }

    public String getLogFuente() {
        return logFuente;
    }

    public void setLogFuente(String logFuente) {
        this.logFuente = logFuente;
    }

    public String getLogCategoria() {
        return logCategoria;
    }

    public void setLogCategoria(String logCategoria) {
        this.logCategoria = logCategoria;
    }

    public String getLogDescripcion() {
        return logDescripcion;
    }

    public void setLogDescripcion(String logDescripcion) {
        this.logDescripcion = logDescripcion;
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
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instituto_jose_reyes.entities.Log[ logId=" + logId + " ]";
    }
    
}
