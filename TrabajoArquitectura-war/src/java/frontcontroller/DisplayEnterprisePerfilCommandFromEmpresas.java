
package frontcontroller;

import controllers.ComentariosController;
import controllers.EnterpriseController;
import controllers.OfertasController;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


public class DisplayEnterprisePerfilCommandFromEmpresas extends FrontCommand{
    @Override
    public void process() {
        EnterpriseController ec = new EnterpriseController();
        ComentariosController cc = new ComentariosController();
        List<String[]> comentarios = cc.obtenerComentarios(request.getParameter("empresa"));
        List<String> lista = ec.getPerfil(request.getParameter("empresa"));
        request.setAttribute("lista", lista);
        request.setAttribute("comentarios", comentarios);
        request.setAttribute("empresa", (request.getParameter("empresa")));
        try {
            forward("/ExploreEnterprisePerfil.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
