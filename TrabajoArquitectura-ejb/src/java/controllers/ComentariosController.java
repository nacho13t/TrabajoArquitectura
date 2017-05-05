
package controllers;

import entities.Comentarios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ComentariosController {
    
    public List<String[]> obtenerComentarios (String empresa){
        List<String[]> resultado = new ArrayList();
        ComentariosFacade cf = lookupComentariosFacadeBean();
        List<Comentarios> comentarios = cf.findAll();
        for (Comentarios comentario : comentarios) {
            if(comentario.getEmpresa().equals(empresa)){
                String[] temp = new String[3];
                temp[0] = comentario.getUsuario();
                temp[1] = comentario.getComentario();
                temp[2] = comentario.getFecha();
                resultado.add(temp);
            }
        }
        return resultado;
    }
    
    public void dejarComentario(String empresa, String usuario, String contenido){
        ComentariosFacade cf = lookupComentariosFacadeBean();
        Comentarios comentario = new Comentarios();
        comentario.setUsuario(usuario);
        comentario.setComentario(contenido);
        comentario.setEmpresa(empresa);
        Date myDate = new Date();
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
        comentario.setFecha(fecha);
        cf.create(comentario);
        
    }
    
    private ComentariosFacade lookupComentariosFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ComentariosFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/ComentariosFacade!controllers.ComentariosFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
