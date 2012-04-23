/*
 * The MIT License
 *
 * Copyright 2012 Edwin Bratini <edwin.bratini@gmail.com>.
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
package com.instituto_jose_reyes.model.ejb;

import com.instituto_jose_reyes.model.entities.Curso;
import com.instituto_jose_reyes.model.entities.Estudiante;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author Edwin Bratini
 */
@Stateful
@LocalBean
public class SchoolEnrollmentEJB {

    private List<Curso> cursos;
    private Estudiante estudiante;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void addCurso(Curso curso) {
    }

    public void removeCurso(Curso curso) {
    }

    public void proceedEnrollment() {
    }
}
