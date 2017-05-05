package controllers;

import entities.Login;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class LoginController{
    
    
    public boolean validar(String user, String pass){
        LoginFacade loginFacade = lookupLoginFacadeLocal();
        if((loginFacade.find(user)!=null)&&(loginFacade.find(user).getPassword().equals(pass)))return true;
        return false;
    }
    
    public boolean registrar(String user, String pass){
        LoginFacade loginFacade = lookupLoginFacadeLocal();
        Login login = new Login(user);
        login.setPassword(pass);
        loginFacade.create(login);
        return true;
    }
    
    public String[] obtenerPerfil(String user){
        LoginFacade loginFacade = lookupLoginFacadeLocal();
        Login login = loginFacade.find(user);
        String[] datos = new String[3];
        if(login.getNombre()==null){
            datos[0] = " ";
        }else{
            datos[0] = login.getNombre();
        }
        if(login.getApellidos()==null){
            datos[1] = " ";
        }else{
            datos[1] = login.getApellidos();
        }
        if(login.getProfesion()==null){
            datos[2] = " ";
        }else{
            datos[2] = login.getProfesion();
        }
        return datos;
    }
   
    public byte[] obtenerFoto(String user){
        LoginFacade loginFacade = lookupLoginFacadeLocal();
        Login login = loginFacade.find(user);
        byte[] foto = login.getFoto();
        return foto;
    }
    
    private LoginFacade lookupLoginFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (LoginFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/LoginFacade!controllers.LoginFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void actualizar(String[] datos) {
        LoginFacade loginFacade = lookupLoginFacadeLocal();
        Login login = loginFacade.find(datos[3]);
        login.setNombre(datos[0]);
        login.setApellidos(datos[1]);
        login.setProfesion(datos[2]);
        loginFacade.edit(login);
        
    }
  
    public void actualizarFoto(byte[] foto, String user){
        LoginFacade loginFacade = lookupLoginFacadeLocal();
        Login login = loginFacade.find(user);
        login.setFoto(foto);
        loginFacade.edit(login);
    }
    
    public List<Login> buscar(String text){
        LoginFacade loginFacade = lookupLoginFacadeLocal();
        List<Login> lista = loginFacade.lookText(text);
        return lista;
    }
    
}