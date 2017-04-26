
<%@page import="entities.Cvs"%>
<%@page import="java.util.List"%>
<%@page import="controllers.CvsController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Documentos</title>
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
    </head>
    <body>
        <%if(request.getSession().getAttribute("name") == null) {
                RequestDispatcher req = request.getRequestDispatcher("loginWarning.jsp");
                req.forward(request, response);
            }
        CvsController cvsController = new CvsController();
        List<Cvs> lista = cvsController.obtenerCVsDeUsuario((String) request.getSession().getAttribute("name"));
        for (Cvs cv : lista){
            %>
            Documento del dia: <%=cv.getFechora()%>
            <form action="FrontServlet">
                <input type="hidden" name="command" value="DisplayCVCommand">
                <input type="hidden" name="id" value=<%=cv.getId()%>>
                <input type="submit" value="Ver o editar">       
            </form>
            <form action="FrontServlet">
                <input type="hidden" name="command" value="DeleteCVCommand">
                <input type="hidden" name="id" value=<%=cv.getId()%>>
                <input type="submit" value="Eliminar" id="eliminar">       
            </form>
            <%
        };
        %>
        <a href="PaginaPrincipal.jsp" id="volver">Volver</a>
    </body>
</html>
     