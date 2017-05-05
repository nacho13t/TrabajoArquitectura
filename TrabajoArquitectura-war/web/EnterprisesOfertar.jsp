<%@page import="entities.Ofertas"%>
<%@page import="java.util.List"%>
<%@page import="controllers.OfertasController"%>
<%! HttpSession session;%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if (request.getSession().getAttribute("name") == null) {
                RequestDispatcher req = request.getRequestDispatcher("EnterpriseLoginWarning.jsp");
                req.forward(request, response);
    }
    OfertasController ofertasController = new OfertasController();
    List<Ofertas> ofertas = ofertasController.buscarMisOfertas((String) session.getAttribute("name"));

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <title>ArquiCV</title>
    </head>
    <body>

        <jsp:include page="HeaderEmpresas.jsp" />

        <table id = "tablaOferas">
            <tr>
                <td><h1>Actuales ofertas de empleo</h1>

                    <%if (ofertas.isEmpty()) {%><h2>La empresa no oferta empleo actualmente</h2><%} else {
                    %><div id = "oferts"><%
                        for (Ofertas oferta : ofertas) {
                            %><h2 id="oferts_titulo"><%=oferta.getCargo()%></h2>
                            <div id="oferts_contenido"><%=oferta.getDescripcion()%>
                                <br><form action="FrontServlet">
                                <input type="hidden" name="command" value="EliminarOfertaCommand">
                                <input type="hidden" name="idoferta" value=<%=oferta.getId()%>>
                                <input type="submit" value="Eliminar"></form>
                            </div><%
                        }
                    }%>
                    
                        <h2 id="oferts_titulo_dos">Nueva oferta de empleo</h2>
                        <div id="oferts_contenido">
                            <form action="FrontServlet" name="ofertasForm" onsubmit="return validarOfertas()">
                            <input type="hidden" name="command" value="NuevaOfertaCommand">
                            Cargo:<br><input type="text" name="cargo"><br>
                            Descripción:<br> <textarea rows="5" cols="60" name="descripcion"></textarea><br>
                            <input type="submit" value="Aceptar">
                            </form>
                        </div>
                        </div>
                    

                <td><img src="images/foto3.jpg" alt="foto6"></td>
            </tr>
        </table>
    <footer>
        <script src="scripts.js"></script>
    </footer>
</html>
