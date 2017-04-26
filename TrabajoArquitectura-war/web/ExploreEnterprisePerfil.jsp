<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%ArrayList lista = (ArrayList)request.getAttribute("lista");%>
<%String[] titulos = {"Perfil","Objetivo","Misión","Visión","Valores"};%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="newcss1.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta</title>
    </head>
    <body>
        <div><ol>
            <li><%=request.getAttribute("empresa")%></li>
        <%  int i = 0;
            for (Object dato : lista) {
                %><li><span><%=titulos[i]%>:</span><p><%=(String)dato%></p></li><%
                i++;
            }
        %>
        </ol></div>    
        <a onclick="goBack()" id ="volver">Volver</a>
        
        <script>
            function goBack() {
                window.history.back();
            }   
        </script>
    </body>
</html>
