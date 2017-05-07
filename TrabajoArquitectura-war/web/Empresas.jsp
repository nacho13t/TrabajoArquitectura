<%@page import="entities.Enterprises"%>
<%@page import="java.util.List"%>
<%@page import="controllers.EnterpriseController"%>
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
        <%EnterpriseController ec = new EnterpriseController();
        List<Enterprises> empresas = ec.obtenerTodas();%>
        <jsp:include page="header.jsp" />
        <h2 id="tituloEmpresas">Lista de empresas registradas</h2>
        <table>
            <tr>
                <td>
                    <div id="scrollParaEmpresas">
                    <%for (Enterprises empresa : empresas) {%>
                    <p><h2 id="tituloEmpresa"><%=empresa.getEnterprise()%></h2></p>
                    <%String val = ec.obtenerValoracion(empresa.getEnterprise());
                    if(!val.equals("Sin valoraciones")){
                        Double valor = Double.valueOf(val)*100;
                        val = String.valueOf(valor)+"/100";
                    }%>
                    <p><h2>Valoración: <%=val%></h2></p>
                    <form action="FrontServlet">
                    <input type="hidden" name="command" value="DisplayEnterprisePerfilCommandFromEmpresas">
                    <input type="hidden" name="empresa" value="<%=empresa.getEnterprise()%>">
                    <input type="submit" value="Ver empresa" id="verEmpresa2">       
                </form>
                        <%}
                    %>
                    </div>
                    </td>
                <td><img src="images/foto2.jpg" alt="foto2" class="fotosGrandes"></td>
            </tr>
        </table>
