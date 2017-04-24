
package frontcontroller;

import controllers.EnterpriseController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class RegisterEnterpriseCommand extends FrontCommand{

    @Override
    public void process() {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        EnterpriseController log = new EnterpriseController();
        if(!log.validar(user, pass)){
            log.registrar(user,pass);
        }        
        try {
            forward("/Enterprises.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
