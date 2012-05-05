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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Edwin Bratini
 */
@Embeddable
public class ProfesorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "prf_id")
    private int prfId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;

    public ProfesorPK() {
    }

    public ProfesorPK(int prfId, int usrId) {
        this.prfId = prfId;
        this.usrId = usrId;
    }

    public int getPrfId() {
        return prfId;
    }

    public void setPrfId(int prfId) {
        this.prfId = prfId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prfId;
        hash += (int) usrId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesorPK)) {
            return false;
        }
        ProfesorPK other = (ProfesorPK) object;
        if (this.prfId != other.prfId) {
            return false;
        }
        if (this.usrId != other.usrId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ijr.model.entities.ProfesorPK[ prfId=" + prfId + ", usrId=" + usrId + " ]";
    }
    
}
