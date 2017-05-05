<%@page import="java.util.Base64"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.Serializable"%>
<%@page import="java.sql.Blob"%>
<%@page import="controllers.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <title>ArquiCV</title>
    </head>
    <body>
        <%if(request.getSession().getAttribute("name") == null) {
                request.setAttribute("tipoUsuario", "particular");
                RequestDispatcher req = request.getRequestDispatcher("loginWarning.jsp");
                req.forward(request, response);
        }
        LoginController lg = new LoginController();
        String[] datos = lg.obtenerPerfil((String) request.getSession().getAttribute("name"));
        byte[] foto = lg.obtenerFoto((String) request.getSession().getAttribute("name"));
        String fotografia = "";
        if(foto!=null){
            fotografia = Base64.getEncoder().encodeToString(foto);
        }
        
        %>
        <jsp:include page="header.jsp" />
        <h2 id="tuperfil">Tu perfil</h2>
        <div id="perfil">
            <img id="fotoPerf" src="" alt="Añade una foto a tu perfil"/>
            <p id ="datosPerfil">Nombre: </p><%=datos[0]%>
            <p id ="datosPerfil">Apellidos:</p><%=datos[1]%>
            <p id ="datosPerfil">Profesión</p><%=datos[2]%>
            <form action="FrontServlet">
                        <input type="hidden" name="command" value="EditarPerfilCommand">
                        <input type="submit" value="Modificar datos" id="botonEditarPerfilUsuario">
            </form></td>
            <button id="cambiarFotoBoton">Cambiar foto</button>
            <div id="cambiarFoto">
                <form action="FrontServlet" method="post">
                    <input type="hidden" name="command" value="ActualizarFotoCommand">
                    <input type="text" name="path" placeholder="URI de la foto">
                    <input type="submit" value="Modificar">
                </form>
            </div>
        </div>
        <img src="images/foto3.jpg" id="foto" alt="foto2">
        <script>
            document.getElementById("fotoPerf").src = "data:image/png;base64,<%=fotografia%>";
        </script>
        <script src="scripts.js"></script>
    </body>
</html>