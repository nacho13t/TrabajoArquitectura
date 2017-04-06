/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontcontroller;

import controllers.LoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nacho
 */
public class registerCommand extends FrontCommand{

    @Override
    public void process() {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        LoginController log = new LoginController();
        if(!log.validar(user, pass)){
            log.registrar(user,pass);
        }        
        try {
            forward("/PaginaPrincipal.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
