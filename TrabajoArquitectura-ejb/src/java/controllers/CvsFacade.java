/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Cvs;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nacho
 */
@Stateless
public class CvsFacade extends AbstractFacade<Cvs> {

    @PersistenceContext(unitName = "logins")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CvsFacade() {
        super(Cvs.class);
    }
    
    public List<Cvs> lookText(String text){
        List<Cvs> lista = new ArrayList();
        for (Cvs cvs : super.findAll()) {
            if((cvs.contiene(text))&&(lista.size()<20))lista.add(cvs);
        }
        for (Cvs cvs : lista) {
            System.out.println(cvs.getId());
        }
        return lista;
    }
}
