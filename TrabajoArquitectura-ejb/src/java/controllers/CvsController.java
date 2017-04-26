package controllers;

import entities.Cvs;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CvsController {

    
    
    public boolean insertarCV(String[] datos){
        CvsFacade cvsFacade = lookupCvsFacadeBean();
        Cvs cv = new Cvs();
        cv.setNombre(datos[0]);
        cv.setApellidos(datos[1]);
        cv.setPais(datos[2]);
        cv.setProvincia(datos[3]);
        if(!datos[4].equals(""))cv.setCpos(Integer.valueOf(datos[4]));
        cv.setExlab(datos[5]);
        cv.setEdyfor(datos[6]);
        cv.setLengmat(datos[7]);
        cv.setIdiomas(datos[8]);
        cv.setComcom(datos[9]);
        cv.setComorg(datos[10]);
        cv.setComemp(datos[11]);
        cv.setComdig(datos[12]);
        cv.setUsername(datos[13]);
        cv.setFechora(new Timestamp(new Date().getTime()));
        cvsFacade.create(cv);
        return true;
    }
    
    public List<Cvs> obtenerCVsDeUsuario(String user){
        CvsFacade cvsFacade = lookupCvsFacadeBean();
        List<Cvs> lista = new ArrayList();
        for (Cvs cvs : cvsFacade.findAll()) {
            if((cvs.getUsername()!=null)&&(cvs.getUsername().equals(user)))lista.add(cvs);
        }
        return lista;
    }
    
    public Cvs obtenerCVEspecifico(int id){
        CvsFacade cvsFacade = lookupCvsFacadeBean();
        return cvsFacade.find(id);
    }
    
    public void actualizarCV(String[] datos) {
        CvsFacade cvsFacade = lookupCvsFacadeBean();
        Cvs cv = new Cvs(Integer.parseInt(datos[14]));
        cv.setNombre(datos[0]);
        cv.setApellidos(datos[1]);
        cv.setPais(datos[2]);
        cv.setProvincia(datos[3]);
        if(!datos[4].equals(""))cv.setCpos(Integer.valueOf(datos[4]));
        cv.setExlab(datos[5]);
        cv.setEdyfor(datos[6]);
        cv.setLengmat(datos[7]);
        cv.setIdiomas(datos[8]);
        cv.setComcom(datos[9]);
        cv.setComorg(datos[10]);
        cv.setComemp(datos[11]);
        cv.setComdig(datos[12]);
        cv.setUsername(datos[13]);
        cv.setFechora(new Timestamp(new Date().getTime()));
        cvsFacade.edit(cv);
        
    }
    public List<Cvs> buscar(String text){
        CvsFacade cvsFacade = lookupCvsFacadeBean();
        List<Cvs> lista = cvsFacade.lookText(text);
        return lista;
    }
    
    public void borrar(int id){
        CvsFacade cvsFacade = lookupCvsFacadeBean();
        cvsFacade.remove(new Cvs(id));
    }

    private CvsFacade lookupCvsFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CvsFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/CvsFacade!controllers.CvsFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}
