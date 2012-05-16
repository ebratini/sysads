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
package com.ijr.model.ejb;

import com.ijr.model.entities.Estudiante;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Edwin Bratini
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "SysADS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    @Override
    public void create(Estudiante entity) {
        Date now = new Date();
        String tmpMatricula = String.valueOf(now.getTime());
        entity.setEstMatricula(tmpMatricula);
        super.create(entity);
        getEntityManager().flush();
        generateMatricula(entity);
    }

    private void generateMatricula(Estudiante entity) {
        Date now = new Date();
        String matricula = String.format("%1$tY-%2$d", now, entity.getEstudiantePK().getEstId());
        entity.setEstMatricula(matricula);
        edit(entity);
    }
}
