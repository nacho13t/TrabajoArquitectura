/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Valoraciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nacho
 */
@Stateless
public class ValoracionesFacade extends AbstractFacade<Valoraciones> {

    @PersistenceContext(unitName = "logins")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValoracionesFacade() {
        super(Valoraciones.class);
    }
    
}
