
<header>  
    
    <div class="logins">
        <%  if(session.getAttribute("name") == null) {%>
        <a href="loginScreen.jsp" >Iniciar sesi�n</a>
        <a href="registerScreen.jsp">Registrarse</a>
        <% } else{ %>
        Bienvenido 
        <%=session.getAttribute("name")%>
        <form method='post' action='FrontServlet'>
        <input type='hidden' name='command' value='loginCommand'>
        <input type='submit' value='Cerrar sesi�n'></form> <%}%>
        
    </div>
    <h1>ArquiCV - Curr�culum online</h1>
    
    <nav>
        <ul>
            <li><a title="PaginaPrincipal" href="PaginaPrincipal.jsp">P�gina principal</a></li>
            <li><a title="AcercaDeArquiCV" href="AcercaDeArquiCV.jsp">Acerca de ArquiCV</a></li>
            <li><a title="Documentos" href="MisDocumentos.jsp">Mis documentos</a></li>
            <li><a title="Ventajas" href="Ventajas.jsp">Ventajas</a></li>
            <li><a title="Recursos" href="Recursos.jsp">Recursos</a></li>
            <li><a title="Social" href="Social.jsp">Social</a></li>
        </ul>
    </nav>
</header>