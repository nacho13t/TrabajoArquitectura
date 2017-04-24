
package frontcontroller;

import controllers.CvsController;
import entities.Cvs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class DisplaySearchCommand extends FrontCommand{

    @Override
    public void process() {
        CvsController cvsController = new CvsController();
        Cvs cv = cvsController.obtenerCVEspecifico(Integer.parseInt(request.getParameter("id")));
        ArrayList<String> datos = new ArrayList();
        datos.add(cv.getNombre());
        datos.add(cv.getApellidos());
        datos.add(cv.getPais());
        datos.add(cv.getProvincia());
        if(cv.getCpos()!=null){
            datos.add(cv.getCpos().toString());
        }else{
            datos.add("");
        }
        datos.add(cv.getExlab());
        datos.add(cv.getEdyfor());
        datos.add(cv.getLengmat());
        datos.add(cv.getIdiomas());
        datos.add(cv.getComcom());
        datos.add(cv.getComorg());
        datos.add(cv.getComemp());
        datos.add(cv.getComdig());
        datos.add(cv.getUsername());
        request.setAttribute("datos", datos);
        try {
            forward("/ExploreCV.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
