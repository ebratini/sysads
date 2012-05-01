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

import com.ijr.model.entities.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edwin Bratini
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @EJB
    private SecurityServiceEJB securityServiceEJB;
    @PersistenceContext(unitName = "SysADS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public void create(Usuario entity) {
        String encryptedPassword = securityServiceEJB.encrypt(entity.getUsrPassword(), SecurityServiceEJB.EncryptionMethod.SHA);
        if (encryptedPassword != null) {
            if (encryptedPassword.length() > 45) {
                encryptedPassword = encryptedPassword.substring(0, 45);
            }
            entity.setUsrPassword(encryptedPassword);
        }
        super.create(entity);
    }

    public Usuario getUsuarioByLogin(String login) {
        Query query = em.createNamedQuery("Usuario.findByUsrLogin");
        query.setParameter("usrLogin", login);
        return (Usuario) query.getSingleResult();
    }
}
