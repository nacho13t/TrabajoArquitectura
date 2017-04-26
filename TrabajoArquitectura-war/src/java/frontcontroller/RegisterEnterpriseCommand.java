
package frontcontroller;

import controllers.EnterpriseController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class RegisterEnterpriseCommand extends FrontCommand{

    @Override
    public void process() {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        EnterpriseController log = new EnterpriseController();
        if(!log.validar(user, pass)){
            log.registrar(user,pass);
            if(log.validar(user,pass)){
                session.setAttribute("name", user);
            }
        }        
        try {
            forward("/Enterprises.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
