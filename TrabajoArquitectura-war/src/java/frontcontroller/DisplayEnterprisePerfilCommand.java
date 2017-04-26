
package frontcontroller;

import controllers.EnterpriseController;
import controllers.OfertasController;
import entities.Ofertas;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class DisplayEnterprisePerfilCommand extends FrontCommand{

    @Override
    public void process() {
        EnterpriseController ec = new EnterpriseController();
        OfertasController ofc = new OfertasController();
        List<String> lista = ec.getPerfil(ofc.obtenerEmpresa(Integer.valueOf(request.getParameter("oferta"))));
        request.setAttribute("lista", lista);
        request.setAttribute("empresa", ofc.obtenerEmpresa(Integer.valueOf(request.getParameter("oferta"))));
        try {
            forward("/ExploreEnterprisePerfil.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
