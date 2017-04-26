/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Ofertas;
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
public class OfertasFacade extends AbstractFacade<Ofertas> {

    @PersistenceContext(unitName = "logins")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfertasFacade() {
        super(Ofertas.class);
    }
    
    public List<Ofertas> lookText(String text){
        List<Ofertas> lista = new ArrayList();
        for (Ofertas ofertas : super.findAll()) {
            if((ofertas.contiene(text))&&(lista.size()<10))lista.add(ofertas);
        }
        return lista;
    }
    
}
