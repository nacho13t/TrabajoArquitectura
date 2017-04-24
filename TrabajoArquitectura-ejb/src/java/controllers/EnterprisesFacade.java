
package controllers;

import entities.Enterprises;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nacho
 */
@Stateless
public class EnterprisesFacade extends AbstractFacade<Enterprises> {

    @PersistenceContext(unitName = "logins")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnterprisesFacade() {
        super(Enterprises.class);
    }
    
}
