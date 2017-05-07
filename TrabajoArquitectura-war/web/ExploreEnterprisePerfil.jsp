<%@page import="controllers.EnterpriseController"%>
<%@page import="controllers.ValoracionesController"%>
<%@page import="controllers.ComentariosController"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%ArrayList lista = (ArrayList) request.getAttribute("lista");%>
<%String[] titulos = {"Perfil", "Objetivo", "Misión", "Visión", "Valores"};%>
<%List<String[]> comentarios = (List<String[]>) request.getAttribute("comentarios");%>
<%ValoracionesController vc = new ValoracionesController();%>
<%EnterpriseController enterpriseController = new EnterpriseController();%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="newcss1.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <%if (request.getSession().getAttribute("name") == null) {
                request.setAttribute("tipoUsuario", "particular");
                RequestDispatcher req = request.getRequestDispatcher("loginWarning.jsp");
                req.forward(request, response);
            }
        String val = enterpriseController.obtenerValoracion((String) request.getAttribute("empresa"));
        if(!val.equals("Sin valoraciones")){
            Double valor = Double.valueOf(val)*100;
            val = String.valueOf(valor)+"/100";
        }%>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <div><ol>
                <li><%=request.getAttribute("empresa")%></li>
                    <%  int i = 0;
                        for (Object dato : lista) {
                    %><li><span><%=titulos[i]%>:</span><p><%=(String) dato%></p></li><%
                            i++;
                        }
                    %>
            </ol></div>    
        <a onclick="goBack()" id ="volver">Volver</a>
        <div id="coments">
            <h2>Valoración: <%=val%></h2>
            <h2>Comentarios de los usuarios</h2>
            <% for (String[] string : comentarios) {%>
            <p>"<%=string[1]%>"</p>
            <%}%>
            <button id="botonDejarComentario">Dejar comentario</button>
            <%if (vc.comprobarValoracion((String) request.getSession().getAttribute("name"), (String) request.getAttribute("empresa"))) {%>
            
            <form action="FrontServlet">
                <input type="hidden" name="command" value="ValorarCommand">
                <input type="hidden" name="empresa" value="<%=request.getAttribute("empresa")%>">
                <input type="hidden" name="valor" value="1">
                <input type="submit" value="Valorar positivamente" id="positivo">
            </form>
            <form action="FrontServlet">
                <input type="hidden" name="command" value="ValorarCommand">
                <input type="hidden" name="empresa" value="<%=request.getAttribute("empresa")%>">
                <input type="hidden" name="valor" value="0">
                <input type="submit" value="Valorar negativamente" id="negativo">
            </form>
            <%} else {
                int valoracion = vc.obtenerValoracion((String) request.getSession().getAttribute("name"), (String) request.getAttribute("empresa"));
                if (valoracion == 0) {%>
            <h3>Has valorado negativamente a la empresa</h3>
            <%} else {%>
            <h3>Has valorado positivamente a la empresa</h3>
            <%}%> 
            <form action="FrontServlet">
                <input type="hidden" name="command" value="ValorarCommand">
                <input type="hidden" name="empresa" value="<%=request.getAttribute("empresa")%>">
                <input type="hidden" name="valor" value="cambio">
                <input type="submit" value="Cambiar mi valoración" id="cambiar">
            </form>
            <%}%>
            <div id="dejarComentario">
                <form action="FrontServlet">
                    <textarea name="coment" cols="50" rows="6"></textarea><br>
                    <input type="hidden" name="command" value="DejarComentarioCommand">
                    <input type="hidden" name="empresa" value="<%=request.getAttribute("empresa")%>">
                    <input type="submit">
                </form>

            </div>
        </div>
        <script>
            $('#botonDejarComentario').on("click", function () {
                $('#dejarComentario').slideToggle()();
            });
            function goBack() {
                window.history.back();
            }
        </script>
    </body>
</html>
