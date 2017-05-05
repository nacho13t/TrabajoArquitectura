
package frontcontroller;

import controllers.LoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class EditarPerfilCommand extends FrontCommand{

    @Override
    public void process() {
        LoginController lc = new LoginController();
        String[] perfil = lc.obtenerPerfil((String) request.getSession().getAttribute("name"));
        request.setAttribute("perfil", perfil);
        try {
            forward("/EditarPerfil.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
