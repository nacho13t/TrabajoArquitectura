
package frontcontroller;

import controllers.EnterpriseController;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class EditarPerfilEnterpriseCommand extends FrontCommand{

    @Override
    public void process() {
        EnterpriseController enterpriseController = new EnterpriseController();
        List<String> lista = enterpriseController.getPerfil((String) request.getSession().getAttribute("name"));
        System.out.println(request.getSession().getAttribute("name"));
        request.setAttribute("perfil", lista);
        try {
            forward("/EditarPerfilEmpresa.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
