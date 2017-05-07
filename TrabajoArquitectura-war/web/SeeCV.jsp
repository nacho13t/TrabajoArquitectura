<%@page import="java.sql.Timestamp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if(session.getAttribute("name") == null) {%>
<jsp:forward page="loginWarning.jsp"/>
<%}%>
<%ArrayList datos = (ArrayList)request.getAttribute("datos");%>
<html>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        textarea{
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="newcss.css" media="screen" />
        <title>Crea tu CV</title>
    </head>
    <body>
        <h1 style="text-align: center">Currículum Vítae</h1>
        <div>
        <form action="FrontServlet" name="cvForm" onsubmit="return validateCVForm()" method="post">
            <input type="hidden" name="command" value="UpdateCVCommand">
            <input type="hidden" name="id" value="<%=(String)datos.get(14)%>">
            
            <label for="fname">Nombre</label>
            <input type="text" id="fname" name="firstname" value="<%=(String)datos.get(0)%>">

            <label for="lname">Apellidos</label>
            <input type="text" id="lname" name="lastname" value="<%=(String)datos.get(1)%>">

            <label for="country">País</label>
            <select id="country" name="country" value="<%=(String)datos.get(2)%>">
                <option value="esp">España</option>
                <option value="fra">Francia</option>
                <option value="ita">Italia</option>
                <option value="ita">Portugal</option>
                <option value="ita">Alemania</option>
                <option value="ita">Grecia</option>
                <option value="ita">Polonia</option>
            </select>

            <label for="prov">Provincia</label>
            <input type="text" id="prov" name="provincia" value="<%=(String)datos.get(3)%>">
            
            <label for="cpos">Código postal</label>
            <input type="text" id="cpos" name="codigopostal" value="<%=(String)datos.get(4)%>"><br><hr>
            
            <label for="exlab">Experiencia laboral</label>
            <textarea id ="exlab" name="exlab" rows="20"><%=(String)datos.get(5)%></textarea>
            
            <label for="edyfor">Educación y formación</label>
            <textarea id ="edyfor" name="edyfor" rows="20"><%=(String)datos.get(6)%></textarea>
            
            <label for="lengmat">Lengua(s) materna(s)</label>
            <input type="text" id="lengmat" name="lengmat" value="<%=(String)datos.get(7)%>">
    
            <label for="idiomas">Otros idiomas (ver nivel de idiomas en la pestaña recursos)</label>
            <textarea id ="idiomas" name="idiomas" rows="10" ><%=(String)datos.get(8)%></textarea>
                
            <label for="comcom">Competencias comunicativas</label>
                <textarea id ="comcom" name="comcom" rows="20"><%=(String)datos.get(9)%></textarea>
            
            <label for="comorg">Competencias de organización y gestión</label>
                <textarea id ="comorg" name="comorg" rows="20"><%=(String)datos.get(10)%></textarea>
            
            <label for="comemp">Competencias relacionadas con el empleo</label>
            <textarea id ="comemp" name="comemp" rows="20"><%=(String)datos.get(11)%></textarea>
            
            <label for="comdig">Competencias digitales</label>
            <textarea id ="comdig" name="comdig" rows="20"><%=(String)datos.get(12)%></textarea>
            
            <input type="submit" value="Finalizar">
        </form>
        </div>
        <script src="scripts.js"></script>
    </body>
</html>
