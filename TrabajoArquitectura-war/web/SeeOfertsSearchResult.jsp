<%@page import="java.util.List"%>
<%@page import="entities.Ofertas"%>
<%@page import="entities.Ofertas"%>
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
            List<Ofertas> lista = (List<Ofertas>)request.getAttribute("lista");
            for (Ofertas oferta : lista){%>
                Empresa: <%if(oferta.getEmpresa()!=null){%>
                    <%=oferta.getEmpresa()%>
                <%}else{%>
                    Anónima
                <%}%>
                <br>Cargo: <%if(oferta.getCargo()!=null){%>
                    <%=oferta.getCargo()%>
                <%}else{%>
                    Ver descripción
                <%}%>
                <form action="FrontServlet">
                    <input type="hidden" name="command" value="DisplayOfertaCommand">
                    <input type="hidden" name="id" value=<%=oferta.getId()%>>
                    <input type="submit" value="Ver oferta">       
                </form>
                <form action="FrontServlet">
                    <input type="hidden" name="command" value="DisplayEnterprisePerfilCommand">
                    <input type="hidden" name="oferta" value=<%=oferta.getId()%>>
                    <input type="submit" value="Ver empresa" id="verEmpresa">       
                </form>
            <%}%>
        <%};%>
</html>

