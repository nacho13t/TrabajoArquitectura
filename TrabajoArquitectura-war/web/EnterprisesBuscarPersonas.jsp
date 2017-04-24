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
        <%if(request.getSession().getAttribute("name") == null) {
                RequestDispatcher req = request.getRequestDispatcher("loginWarning.jsp");
                req.forward(request, response);
        }%>
        <table>
            <tr>
                <td><h3>Busca personas.</h3>
                </td> 
                <td><img src="images/foto8.jpg" alt="foto8"></td>
            </tr>
        </table>
</html>
