
<%@page import="entities.Cvs"%>
<%@page import="controllers.LoginController"%>
<%@page import="java.util.Base64"%>
<%@page import="entities.Login"%>
<%@page import="java.util.List"%>
<%! HttpSession session;%>
<%List<Cvs> lista = (List<Cvs>) request.getAttribute("lista");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <title>Búsqueda</title>
    </head>
    <body>

        <%if (request.getParameter("tipo").equals("empresas")){%>
        <jsp:include page="HeaderEmpresas.jsp" />
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>
        <%for (Cvs cv : lista) {%>
            Documento del dia: <%=cv.getFechora()%>
            <form action="FrontServlet">
                <input type="hidden" name="command" value="DisplaySearchCommand">
                <input type="hidden" name="id" value=<%=cv.getId()%>>
                <input type="submit" value="Detalles">       
            </form>

        <%}%>
        <a onclick="goBack()" id ="volver">Volver</a>
        
        <script>
            function goBack() {
                window.history.back();
            }   
        </script>

    </body>
</html>

