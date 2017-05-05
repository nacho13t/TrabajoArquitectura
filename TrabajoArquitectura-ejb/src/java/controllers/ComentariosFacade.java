
package controllers;

import entities.Comentarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ComentariosFacade extends AbstractFacade<Comentarios> {

    @PersistenceContext(unitName = "logins")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentariosFacade() {
        super(Comentarios.class);
    }
    
}
