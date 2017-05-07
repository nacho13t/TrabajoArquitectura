
package frontcontroller;

import controllers.ComentariosController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


public class DejarComentarioCommand extends FrontCommand{

    @Override
    public void process() {
        ComentariosController cc = new ComentariosController();
        cc.dejarComentario(request.getParameter("empresa"), (String) request.getSession().getAttribute("name"), request.getParameter("coment"));
        try {
            forward("/Empresas.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
