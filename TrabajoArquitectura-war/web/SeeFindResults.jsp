<%@page import="java.util.List"%>
<%@page import="entities.Cvs"%>
<%@page import="entities.Cvs"%>
<%! HttpSession session;%>

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

        <jsp:include page="header.jsp" />
        
        <% if(request.getAttribute("lista")!=null){
            List<Cvs> lista = (List<Cvs>)request.getAttribute("lista");
            for (Cvs cv : lista){%>
                Usuario: <%if(cv.getNombre()!=null){%>
                    <%=cv.getNombre()%>
                <%}else{%>
                    Anónimo
                <%}%>
                <form action="FrontServlet">
                    <input type="hidden" name="command" value="DatosBusqueda">
                    <input type="hidden" name="id" value=<%=cv.getId()%>>
                    <input type="submit" value="Ver">       
                </form>
            <%}%>
        <%};%>
</html>
