

<%@page import="timer.MuestraHora"%>
<header>  
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <div id="timerDiv">
    <h4 id="hora">Hora</h4>
        <div id="horaContenido">
            <div id="textoHora">
            <%=MuestraHora.hora%>
            </div>
        </div>
    </div>
    <div class="empresas">
        <%if(session.getAttribute("name") == null) {%>
        <a href="Enterprises.jsp">Empresas</a>
        <%}%> 
    </div>
    <div class="logins">
        <%  if(session.getAttribute("name") == null) {%>
        <a href="loginScreen.jsp" >Iniciar sesión</a>
        <a href="registerScreen.jsp">Registrarse</a>
        <% } else{ %>
        Bienvenido 
        <%=session.getAttribute("name")%>
        <form method='post' action='FrontServlet'>
        <input type='hidden' name='command' value='loginCommand'>
        <input type='submit' value='Cerrar sesión'></form> <%}%>
        
    </div>
    <h1>ArquiCV - Currículum online</h1>
    
    <nav>
        <ul>
            <li><a title="PaginaPrincipal" href="PaginaPrincipal.jsp">Página principal</a></li>
            <li><a title="Empresas" href="Empresas.jsp">Empresas registradas</a></li>
            <li><a title="Documentos" href="MisDocumentos.jsp">Mis documentos</a></li>
            <li><a title="Perfil" href="Perfil.jsp">Perfil</a></li>
            <li><a title="Recursos" href="Recursos.jsp">Recursos</a></li>
            <li><a title="Social" href="Social.jsp">Social</a></li>
        </ul>
    </nav>
    <script src="scripts.js"></script>
</header>