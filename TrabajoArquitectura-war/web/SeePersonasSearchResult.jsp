
<%@page import="controllers.LoginController"%>
<%@page import="java.util.Base64"%>
<%@page import="entities.Login"%>
<%@page import="java.util.List"%>
<%! HttpSession session;%>
<%!LoginController lg = new LoginController();%>

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

        <%if (request.getParameter("tipo").equals("empresas")){%>
        <jsp:include page="HeaderEmpresas.jsp" />
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>

        <h3>Búsqueda de usuarios</h3>
        <% if (request.getAttribute("lista") != null) {
                List<Login> lista = (List<Login>) request.getAttribute("lista");
                for (Login login : lista) {
                    byte[] foto = lg.obtenerFoto(login.getUsername());
                    String fotografia = "";
                    if (foto != null) {
                        fotografia = Base64.getEncoder().encodeToString(foto);
                    }%>
        <table style="padding: 50px 25px 0px">
            <tr>    
                <td>
                    <img class="fotitos" id="fotoPerf<%=login.getUsername()%>" src="" alt="Sin foto de perfil"/>
                    <script>
                        document.getElementById("fotoPerf<%=login.getUsername()%>").src = "data:image/png;base64,<%=fotografia%>";
                    </script>
                </td>
                <td>
                    Nombre: <%if (login.getNombre() != null) {%>
                    <%=login.getNombre()%>
                    <%} else {%>
                    Anónimo
                    <%}%>
                    <%if (login.getApellidos() != null) {%>
                    <%=login.getApellidos()%>
                    <%} else {%>
                     
                    <%}%>
                    <br>
                    <button id="boton<%=login.getUsername()%>">Ver perfil</button>
                    <script>
                        $('#boton<%=login.getUsername()%>').on("click", function () {
                            $('#nombrePerfil').text("<%=login.getNombre()%>");
                            $('#apellidosPerfil').text("<%=login.getApellidos()%>");
                            $('#profesionPerfil').text("<%=login.getProfesion()%>");
                            $('#informacionUsuarioEnBusqueda').show();
                            document.getElementById("id").value="<%=login.getUsername()%>"
                        })
                    </script>
                </td>
            </tr>
        </table>
        <div id="informacionUsuarioEnBusqueda">
            <p id="datosPerfil">Nombre</p>
            <p id="nombrePerfil"></p>
            <p id="datosPerfil">Apellidos</p>
            <p id="apellidosPerfil"></p>
            <p id="datosPerfil">Profesión</p>
            <p id="profesionPerfil"></p>
            <form action="FrontServlet">
                <input type="hidden" name="command" value="SearchCVPersona">
                <input type="hidden" id ="id" name="id" >
                <input type="hidden" name="tipo" value="<%=request.getParameter("tipo")%>">
                <input type="submit" value="Ver currículums">       
            </form>
        </div>
        <%}%>
        <%};%>
    </body>
</html>

