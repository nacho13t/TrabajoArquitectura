
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
        OfertasFacade ofertasFacade = lookupOfertasFacadeLocal();
        List<Ofertas> result = new ArrayList();
        List<Ofertas> lista = ofertasFacade.findAll();
        lista.stream().filter((ofertas) -> (ofertas.getEmpresa() == null ? empresa == null : ofertas.getEmpresa().equals(empresa))).forEachOrdered((ofertas) -> {
            result.add(ofertas);
        });
        return result;
    }
    
    public void addOferta(String[] info){
        OfertasFacade ofertasFacade = lookupOfertasFacadeLocal();
        Ofertas oferta = new Ofertas();
        oferta.setEmpresa(info[0]);
        oferta.setCargo(info[1]);
        oferta.setDescripcion(info[2]);
        ofertasFacade.create(oferta);
    }
    
    public void eliminarOferta(int id){
        OfertasFacade ofertasFacade = lookupOfertasFacadeLocal();
        Ofertas oferta = ofertasFacade.find(id);
        ofertasFacade.remove(oferta);
    }
    
    private OfertasFacade lookupOfertasFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (OfertasFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/OfertasFacade!controllers.OfertasFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Ofertas> buscar(String text){
        OfertasFacade ofertasFacade = lookupOfertasFacadeLocal();
        List<Ofertas> lista = ofertasFacade.lookText(text);
        return lista;
    }
    
    public Ofertas obtenerOferta(int id){
        OfertasFacade ofertasFacade = lookupOfertasFacadeLocal();
        return ofertasFacade.find(id);
    }
    
    public String obtenerEmpresa(int id){
        OfertasFacade ofertasFacade = lookupOfertasFacadeLocal();
        return ofertasFacade.find(id).getEmpresa();
    }
}
