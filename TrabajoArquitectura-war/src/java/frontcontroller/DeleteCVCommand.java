
package frontcontroller;

import controllers.CvsController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class DeleteCVCommand extends FrontCommand{

    @Override
    public void process() {
        CvsController cvc = new CvsController();
        cvc.borrar(Integer.valueOf(request.getParameter("id")));
        try {
            forward("/MisDocumentos.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
