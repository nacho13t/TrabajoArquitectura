
package frontcontroller;

import controllers.OfertasController;
import entities.Ofertas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class DisplayOfertaCommand extends FrontCommand{

    @Override
    public void process() {
        OfertasController ofc = new OfertasController();
        Ofertas oferta = ofc.obtenerOferta(Integer.parseInt(request.getParameter("id")));
        ArrayList<String> datos = new ArrayList();
        datos.add(oferta.getEmpresa());
        datos.add(oferta.getCargo());
        datos.add(oferta.getDescripcion());
        request.setAttribute("datos", datos);
        try {
            forward("/ExploreOferta.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
