<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if(session.getAttribute("name") == null) {%>
<jsp:forward page="loginWarning.jsp"/>
<%}%>
<%ArrayList datos = (ArrayList)request.getAttribute("datos");%>
<%String[] titulos = {"Empresa","Cargo","Descripción"};%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="newcss1.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta</title>
    </head>
    <body>
        <div><ol>
        <%  int i = 0;
            for (Object dato : datos) {
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
