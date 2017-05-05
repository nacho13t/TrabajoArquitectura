<%@page import="controllers.ComentariosController"%>
<%@page import="java.util.List"%>
<%@page import="controllers.EnterpriseController"%>
<%! HttpSession session;
    List<String> lista;
    String[] titulos = {"Perfil de la empresa", "Nuestro objetivo", "Misión", "Visión", "Valores"};
    ComentariosController cc = new ComentariosController();%>
<%   List<String[]> comentarios = cc.obtenerComentarios((String) request.getSession().getAttribute("name"));%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <title>ArquiCV</title>
    </head>
    <body>

        <jsp:include page="HeaderEmpresas.jsp" />
        <%!EnterpriseController enterpriseController;%>
        <%if (request.getSession().getAttribute("name") == null) {
                RequestDispatcher req = request.getRequestDispatcher("EnterpriseLoginWarning.jsp");
                req.forward(request, response);
            } else {
                enterpriseController = new EnterpriseController();
                lista = enterpriseController.getPerfil((String) request.getSession().getAttribute("name"));
            }
        String val = enterpriseController.obtenerValoracion((String) request.getSession().getAttribute("name"));
        if(!val.equals("Sin valoraciones")){
            Double valor = Double.valueOf(val)*100;
            val = String.valueOf(valor)+"/100";
        }
        
        %>
        <table>
            <tr>
                <td><h1>Gestiona el perfil de tu empresa</h1>
                    <h3>Valoración de los usuarios: <%=val%></h3>
                    <div id="oferts">
                        <%  int i = 0;
                            for (String item : lista) {%>
                        <h2 id="oferts_titulo"><%=titulos[i]%></h2>
                        <p id="oferts_contenido"><%=item%></p>
                        <% i++;
                            }%>
                        <h2 id="oferts_titulo_comentarios">Comentarios de usuarios</h2>
                        <div id="comentarios">
                            <% for (String[] string : comentarios) {%>

                            <p>De: <%=string[0]%></p>
                            <p>Día: <%=string[2]%></p>
                            <p><%=string[1]%></p>
                            <hr>

                            <%}%>
                        </div>
                    </div>
                    <form action="FrontServlet">
                        <input type="hidden" name="command" value="EditarPerfilEnterpriseCommand">
                        <input type="submit" value="Editar perfil">
                    </form></td>
                <td><img src="images/foto7.jpg" alt="foto7"></td>
            </tr>
        </table>

    </body>
    <footer>
        <script src="scripts.js"></script>
    </footer>
</html>
