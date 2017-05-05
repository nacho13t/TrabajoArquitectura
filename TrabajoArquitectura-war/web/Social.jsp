
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <title>ArquiCV</title>
    </head>
    <body>
        
        <jsp:include page="header.jsp" />
        
        <table>
            <tr>
                <td><h3>Encuentra la información que necesitas</h3><br>
                    <ul>
                        <li>
                            <% if(request.getParameter("nombre") != null){%>
                            <% String nombre = request.getParameter("nombre");
                            URL url = new URL("https://scholar.google.es/scholar?hl=es&q="+nombre+"&btnG=&lr=");%>
                            <%response.sendRedirect(url.toString());%>
                            <%}%>
                            Búsqueda en Google Scholar:
                            <form action="Social.jsp">
                                <input type="text" name="nombre">
                                <input type="submit" value="Buscar">
                            </form>
                        </li>
                        <li>
                            Buscar currículums:
                            <form action="FrontServlet">
                                <input type="text" name="busqueda">
                                <input type="hidden" name="command" value="FindTextCommand">
                                <input type="hidden" name="tipo" value="personas">
                                <input type="submit" value="Buscar">
                            </form>
                        </li> 
                        <li>
                            Buscar ofertas de empleo de empresas:
                            <form action="FrontServlet">
                                <input type="text" name="busqueda">
                                <input type="hidden" name="command" value="FindOfertsCommand">
                                <input type="submit" value="Buscar">
                            </form>
                        </li>
                        <li>
                            Buscar personas:
                            <form action="FrontServlet">
                                <input type="text" name="busqueda">
                                <input type="hidden" name="command" value="FindPersonasCommand">
                                <input type="hidden" name="tipo" value="usuarios">
                                <input type="submit" value="Buscar">
                            </form>
                        </li>
                    </ul>
                </td> 
                <td><img src="images/foto5.jpg" alt="foto2"></td>
            </tr>
        </table>
