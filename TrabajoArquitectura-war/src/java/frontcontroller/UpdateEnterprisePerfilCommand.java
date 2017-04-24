
package frontcontroller;

import controllers.EnterpriseController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


public class UpdateEnterprisePerfilCommand extends FrontCommand{

    @Override
    public void process() {
        String[] datos = new String[6];
        datos[0] = request.getParameter("perfil");
        datos[1] = request.getParameter("objetivo");
        datos[2] = request.getParameter("mision");
        datos[3] = request.getParameter("vision");
        datos[4] = request.getParameter("valores");
        datos[5] = request.getParameter("empresa");
        
        EnterpriseController enterpriseController = new EnterpriseController();
        enterpriseController.actualizar(datos);
        
        try {
            forward("/EnterprisesPerfil.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
