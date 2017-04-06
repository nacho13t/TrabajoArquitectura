package controllers;

import entities.Login;
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
    
   
    private LoginFacade lookupLoginFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (LoginFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/LoginFacade!controllers.LoginFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
  
    
}