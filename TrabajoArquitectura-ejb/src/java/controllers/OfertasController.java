
package controllers;
import entities.Ofertas;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class OfertasController {
    
    public List<Ofertas> buscarMisOfertas(String empresa){
        OfertasFacade ofertasFacade = lookupLoginFacadeLocal();
        List<Ofertas> result = new ArrayList();
        List<Ofertas> lista = ofertasFacade.findAll();
        lista.stream().filter((ofertas) -> (ofertas.getEmpresa() == null ? empresa == null : ofertas.getEmpresa().equals(empresa))).forEachOrdered((ofertas) -> {
            result.add(ofertas);
        });
        return result;
    }
    
    public void addOferta(String[] info){
        OfertasFacade ofertasFacade = lookupLoginFacadeLocal();
        Ofertas oferta = new Ofertas();
        oferta.setEmpresa(info[0]);
        oferta.setCargo(info[1]);
        oferta.setDescripcion(info[2]);
        ofertasFacade.create(oferta);
    }
    
    private OfertasFacade lookupLoginFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (OfertasFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/OfertasFacade!controllers.OfertasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
