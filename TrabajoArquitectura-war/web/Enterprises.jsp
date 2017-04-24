<%! HttpSession session;%>

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

        <jsp:include page="HeaderEmpresas.jsp" />
        
        <table>
            <tr>
                <td><h3>ArquiCV permite a las empresas registrarse y encontrar
                    personas que encajen con el perfil requerido para trabajar
                    en ellas.</h3>
                    
<!--                    <div class = "list-type3">
                        <ol>
                            <li><a href="crearCV.jsp">Crea tu CV ahora</a></li>
                            <li><a href="prueba.jsp">Descargar documentos</a></li>
                            <li><a href="http://alexking.org/projects/html-resume-template/demo/resume.php">Ejemplos</a></li>
                        </ol>
                    </div>-->
                </td> 
                <td><img src="images/foto6.jpg" alt="foto6"></td>
            </tr>
        </table>
</html>
