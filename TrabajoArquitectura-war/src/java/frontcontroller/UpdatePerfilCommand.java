
package frontcontroller;

import controllers.LoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


public class UpdatePerfilCommand extends FrontCommand{

    @Override
    public void process() {
        String[] datos = new String[4];
        datos[0] = request.getParameter("nombre");
        datos[1] = request.getParameter("apellidos");
        datos[2] = request.getParameter("profesion");
        datos[3] = request.getParameter("usuario");
        
        LoginController lc = new LoginController();
        lc.actualizar(datos);
        
        try {
            forward("/Perfil.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
