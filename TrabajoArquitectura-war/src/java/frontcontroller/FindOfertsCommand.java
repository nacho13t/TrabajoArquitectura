/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontcontroller;

import controllers.OfertasController;
import entities.Ofertas;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author nacho
 */
public class FindOfertsCommand extends FrontCommand {

    @Override
    public void process() {
        OfertasController ofc = new OfertasController();
        List<Ofertas> lista = ofc.buscar(request.getParameter("busqueda"));
        if (!lista.isEmpty()) {
            request.setAttribute("lista", lista);
        }
        try {
            forward("/SeeOfertsSearchResult.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(loginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
