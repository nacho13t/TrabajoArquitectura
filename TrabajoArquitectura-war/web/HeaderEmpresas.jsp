
<header>  
    <div class="empresas">
        <%  if(session.getAttribute("name") == null) {%>
        <a href="PaginaPrincipal.jsp">Particulares</a>
        <%}%> 
    </div>
    <div class="logins">
        <%  if(session.getAttribute("name") == null) {%>
        <a href="LoginScreenEnterprises.jsp" >Identificarse</a>
        <a href="RegisterScreenEnterprises.jsp">Registrar empresa</a>
        <% } else{ %>
        Identificado como:  
        <%=session.getAttribute("name")%>
        <form method='post' action='FrontServlet'>
        <input type='hidden' name='command' value='loginCommand'>
        <input type='submit' value='Cerrar sesión'></form> <%}%>
        
    </div>
    <h1>ArquiCV - Empresas</h1>
    
    <nav>
        <ul>
            <li><a title="Empresas" href="Enterprises.jsp">Página principal</a></li>
            <li><a title="PerfilEmpresas" href="EnterprisesPerfil.jsp">Gestionar perfil</a></li>
            <li><a title="BuscarPersonas" href="EnterprisesBuscarPersonas.jsp">Buscar personas</a></li>
            <li><a title="OfertarEmpleo" href="EnterprisesOfertar.jsp">Ofertas de empleo</a></li>
        </ul>
    </nav>
</header>