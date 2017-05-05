
package frontcontroller;

import controllers.CvsController;
import entities.Cvs;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class SearchCVPersona extends FrontCommand{

    @Override
    public void process() {
        CvsController cvsController = new CvsController();
        List<Cvs> lista = cvsController.obtenerCVsDeUsuario((String) request.getParameter("id"));
        request.setAttribute("lista", lista);
        try {
            forward("/MuestraDocs.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
