
package frontcontroller;

import controllers.CvsController;
import entities.Cvs;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


public class FindTextCommand extends FrontCommand{

    @Override
    public void process() {
        CvsController cvsController = new CvsController();
        List<Cvs> lista = cvsController.buscar(request.getParameter("busqueda"));
        if(!lista.isEmpty())request.setAttribute("lista", lista);
        if(request.getParameter("tipo").equals("empresas")){
            request.removeAttribute("empresas");
            try {
                forward("/EnterprisesSeeFindResults.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            forward("/SeeFindResults.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
