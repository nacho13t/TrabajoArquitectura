
package controllers;

import entities.Valoraciones;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ValoracionesController {
    
    public boolean registrarValoracion(String usuario, String empresa, int valor){
        ValoracionesFacade vf = lookupValoracionesFacadeLocal();
        List<Valoraciones> valoraciones = vf.findAll();
        for (Valoraciones valoracion : valoraciones) {
            if((valoracion.getEmpresa().equals(empresa))&&(valoracion.getUsuario().equals(usuario)))return false;
        }
        Valoraciones val = new Valoraciones();
        val.setEmpresa(empresa);
        val.setUsuario(usuario);
        val.setValoracion(1);
        vf.create(val);
        return true;
    }
    
    public boolean comprobarValoracion(String usuario, String empresa){
        ValoracionesFacade vf = lookupValoracionesFacadeLocal();
        List<Valoraciones> valoraciones = vf.findAll();
        for (Valoraciones valoracion : valoraciones) {
            if((valoracion.getEmpresa().equals(empresa))&&(valoracion.getUsuario().equals(usuario)))return false;
        }
        return true;
    }
    
    public int obtenerValoracion(String usuario, String empresa){
        ValoracionesFacade vf = lookupValoracionesFacadeLocal();
        List<Valoraciones> valoraciones = vf.findAll();
        for (Valoraciones valoracion : valoraciones) {
            if((valoracion.getEmpresa().equals(empresa))&&(valoracion.getUsuario().equals(usuario)))return valoracion.getValoracion();
        }
        return 2;
    }
    
    public void cambiarValoracion(String usuario, String empresa){
        ValoracionesFacade vf = lookupValoracionesFacadeLocal();
        List<Valoraciones> valoraciones = vf.findAll();
        EnterpriseController ec = new EnterpriseController();
        for (Valoraciones valoracion : valoraciones) {
            if((valoracion.getEmpresa().equals(empresa))&&(valoracion.getUsuario().equals(usuario))){
                int val = valoracion.getValoracion();
                if(val == 0){
                    ec.corregirValoracion(empresa, true);
                    valoracion.setValoracion(1);
                    vf.edit(valoracion);
                }else{
                    ec.corregirValoracion(empresa, false);
                    valoracion.setValoracion(0);
                    vf.edit(valoracion);
                }
                
            }
        }
    }
    
    
     private ValoracionesFacade lookupValoracionesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ValoracionesFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/ValoracionesFacade!controllers.ValoracionesFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
