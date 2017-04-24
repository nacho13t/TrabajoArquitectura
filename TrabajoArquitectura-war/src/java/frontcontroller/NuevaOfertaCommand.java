
package frontcontroller;

import controllers.OfertasController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


public class NuevaOfertaCommand extends FrontCommand{

    @Override
    public void process() {
        OfertasController ofc = new OfertasController();
        String[] datos = new String[4];
        datos[0] = (String) request.getSession().getAttribute("name");
        datos[1] = request.getParameter("cargo");
        datos[2] = request.getParameter("descripcion");
        ofc.addOferta(datos);
        
        try {
            forward("/EnterprisesOfertar.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
