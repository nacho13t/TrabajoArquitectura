package frontcontroller;

import controllers.EnterpriseController;
import controllers.LoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;


public class LoginEnterpriseCommand extends FrontCommand {
    @Override
    public void process() {
        if(request.getSession().getAttribute("name")!=null){
            request.getSession().invalidate();
        }else{
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            HttpSession session = request.getSession();
            EnterpriseController log = new EnterpriseController();
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
