
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <title>Aviso</title>
    </head>
    <body>
        <div style="text-align: center"><p><h4>Debes identificarte para realizar para poder realizar esta acción</h4></p>
        <p><a href="LoginScreenEnterprises.jsp" >Iniciar sesión</a>
        <a href="RegisterScreenEnterprises.jsp">Registrarse</a>
        <a onclick="goBack()" style="text-decoration: underline; cursor: pointer">Volver</a></p></div>
        
        <script>
            function goBack() {
                window.history.back();
            }   
        </script>
        
    </body>
</html>
