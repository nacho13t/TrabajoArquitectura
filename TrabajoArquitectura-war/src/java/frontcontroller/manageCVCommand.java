
package frontcontroller;

import controllers.CvsController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class manageCVCommand extends FrontCommand{

    @Override
    public void process() {
        String[] datos = new String[14];
        datos[0] = request.getParameter("firstname");
        datos[1] = request.getParameter("lastname");
        datos[2] = request.getParameter("country");
        datos[3] = request.getParameter("provincia");
        datos[4] = request.getParameter("codigopostal");
        datos[5] = request.getParameter("exlab");
        datos[6] = request.getParameter("edyfor");
        datos[7] = request.getParameter("lengmat");
        datos[8] = request.getParameter("idiomas");
        datos[9] = request.getParameter("comcom");
        datos[10] = request.getParameter("comorg");
        datos[11] = request.getParameter("comemp");
        datos[12] = request.getParameter("comdig");
        datos[13] = (String) request.getSession().getAttribute("name");
        CvsController cvsController = new CvsController();
        cvsController.insertarCV(datos);
        try {
            forward("/PaginaPrincipal.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
