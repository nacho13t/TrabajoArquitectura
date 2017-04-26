
package frontcontroller;

import controllers.OfertasController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class EliminarOfertaCommand extends FrontCommand{

    @Override
    public void process() {
        OfertasController ofc = new OfertasController();
        ofc.eliminarOferta(Integer.valueOf(request.getParameter("idoferta")));
        try {
            forward("/EnterprisesOfertar.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
