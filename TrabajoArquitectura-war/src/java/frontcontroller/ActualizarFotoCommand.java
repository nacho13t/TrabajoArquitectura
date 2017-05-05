
package frontcontroller;

import controllers.LoginController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;



public class ActualizarFotoCommand extends FrontCommand{

    @Override
    public void process() {
        LoginController lc = new LoginController();
        File fi = new File(request.getParameter("path"));
        try {
            byte[] fileContent = Files.readAllBytes(fi.toPath());
            lc.actualizarFoto(fileContent, (String) request.getSession().getAttribute("name"));
        } catch (IOException ex) {
            Logger.getLogger(ActualizarFotoCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            forward("/Perfil.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
