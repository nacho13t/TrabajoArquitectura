package frontcontroller;

import controllers.EnterpriseController;
import controllers.ValoracionesController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class ValorarCommand extends FrontCommand {

    @Override
    public void process() {
        ValoracionesController vc = new ValoracionesController();
        EnterpriseController ec = new EnterpriseController();
        if((request.getParameter("valor").equals("cambio"))){
            vc.cambiarValoracion((String) request.getSession().getAttribute("name"), request.getParameter("empresa"));
        }else{
            vc.registrarValoracion((String) request.getSession().getAttribute("name"), request.getParameter("empresa"), Integer.valueOf(request.getParameter("valor")));
            ec.registrarValoraciones(request.getParameter("empresa"), Integer.valueOf(request.getParameter("valor")));
        }
        try {
            forward("/Social.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
