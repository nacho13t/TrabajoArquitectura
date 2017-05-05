<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String[] lista = (String[])request.getAttribute("perfil");%>
<html>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        textarea{
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <title>Perfil de usuario</title>
    </head>
    <body>
        <h2 style="text-align: center">Perfil de usuario</h2>
        <form action="FrontServlet">
            <input type="hidden" name="command" value="UpdatePerfilCommand">
            
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" value="<%=lista[0]%>">
            
            <label for="apellidos">Apellidos</label>
            <input type="text" name="apellidos" value="<%=lista[1]%>">
            
            <label for="profesion">Profesión</label>
            <input type="text" name="profesion" value="<%=lista[2]%>">

            <input type="hidden" id="usuario" name="usuario" value="<%=request.getSession().getAttribute("name")%>">
            
            <input type="submit" value="Actualizar">
        </form>
        <script src="scripts.js"></script>
    </body>
</html>
