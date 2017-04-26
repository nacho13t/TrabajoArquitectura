<%-- 
    Document   : loginWarning
    Created on : 18-mar-2017, 13:16:40
    Author     : nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <title>Aviso</title>
    </head>
    <body>
        <div style="text-align: center"><p><h4>Debes de iniciar sesión para realizar para poder realizar esta acción</h4></p>
        <p><a href="loginScreen.jsp" >Iniciar sesión</a>
        <a href="registerScreen.jsp">Registrarse</a>
        <a onclick="goBack()" style="text-decoration: underline; cursor: pointer">Volver</a></p></div>
        
        <script>
            function goBack() {
                window.history.back();
            }   
        </script>
        
    </body>
</html>
