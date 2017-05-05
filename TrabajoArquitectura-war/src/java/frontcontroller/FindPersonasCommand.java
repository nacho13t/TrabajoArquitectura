
package frontcontroller;

import controllers.LoginController;
import entities.Login;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class FindPersonasCommand extends FrontCommand{

    @Override
    public void process() {
        LoginController lc = new LoginController();
        List<Login> lista = lc.buscar(request.getParameter("busqueda"));
        if (!lista.isEmpty()) {
            request.setAttribute("lista", lista);
        }
        try {
            forward("/SeePersonasSearchResult.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
