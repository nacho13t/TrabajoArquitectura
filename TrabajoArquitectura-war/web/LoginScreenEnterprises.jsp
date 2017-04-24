
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Identificarse</title>
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
    </head>
    <body>
        <form method='post' action='FrontServlet'>
        <div class='login'> <p>Usuario: </p> <p><input type='text' name='user'></p>
        <input type='hidden' name='command' value='LoginEnterpriseCommand'>
        <p>Clave: </p> <p><input type='password' name='pass'></p>
        <p><input type='submit' value='Iniciar sesión'></p></div></form>
    </body>
</html>
      