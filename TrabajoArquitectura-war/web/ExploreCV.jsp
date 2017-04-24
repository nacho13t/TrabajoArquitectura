<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if(session.getAttribute("name") == null) {%>
<jsp:forward page="loginWarning.jsp"/>
<%}%>
<%ArrayList datos = (ArrayList)request.getAttribute("datos");%>
<%String[] titulos = {"Nombre","Apellidos","País","Provincia","Código postal","Experiencia laboral","Educación y formación","Lengua materna","Idiomas","Competencias comunicativas","Competencias organizativas","Competencias relacionadas con el empleo","Competencias digitales","Nombre de usuario"};%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="newcss1.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CV</title>
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
    </body>
</html>
