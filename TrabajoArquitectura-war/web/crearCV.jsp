<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  if(session.getAttribute("name") == null) {%>
<jsp:forward page="loginWarning.jsp"/>
<%}%>

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
        <form action="FrontServlet">
            <input type='hidden' name='command' value='manageCVCommand'>
            
            <label for="fname">Nombre</label>
            <input type="text" id="fname" name="firstname" placeholder="Tu nombre..">

            <label for="lname">Apellidos</label>
            <input type="text" id="lname" name="lastname" placeholder="Tus apellidos..">

            <label for="country">País</label>
            <select id="country" name="country">
                <option value="esp">España</option>
                <option value="fra">Francia</option>
                <option value="ita">Italia</option>
                <option value="ita">Portugal</option>
                <option value="ita">Alemania</option>
                <option value="ita">Grecia</option>
                <option value="ita">Polonia</option>
            </select>

            <label for="prov">Provincia</label>
            <input type="text" id="prov" name="provincia" placeholder="Tu provincia..">
            
            <label for="cpos">Código postal</label>
            <input type="text" id="cpos" name="codigopostal" placeholder="Tu código postal"><br><hr>
            
            <label for="exlab">Experiencia laboral</label>
            <textarea id ="exlab" name="exlab" rows="20" placeholder="De 10/10/10 hasta 11/11/11 Cargo ocupado en Empleador"></textarea>
            
            <label for="edyfor">Educación y formación</label>
            <textarea id ="edyfor" name="edyfor" rows="20" placeholder="De 10/10/05 hasta 11/11/10 Título de cualificación obtenida en Organización"></textarea>
            
            <label for="lengmat">Lengua(s) materna(s)</label>
            <input type="text" id="lengmat" name="lengmat" placeholder="Español, inglés..">
    
            <label for="idiomas">Otros idiomas (ver nivel de idiomas en la pestaña recursos)</label>
            <textarea id ="idiomas" name="idiomas" rows="10" placeholder="Alemán. compresión escrita: A1, compresión auditiva A2, Interración oral A1, Expresión oral A2, Escribir A1 Título oficial: Diploma de estudios de lengua alemana A1"></textarea>
                
            <label for="comcom">Competencias comunicativas</label>
            <textarea id ="comcom" name="comcom" rows="20" placeholder="Buenas competencias comunicativas adquiridas a través de mi experiencia como responsable de ventas..."></textarea>
            
            <label for="comorg">Competencias de organización y gestión</label>
            <textarea id ="comorg" name="comorg" rows="20" placeholder="Capacidad de liderazgo (actualmente soy responsable de un equipo de diez personas)"></textarea>
            
            <label for="comemp">Competencias relacionadas con el empleo</label>
            <textarea id ="comemp" name="comemp" rows="20" placeholder="Dominio de los procesos de control de calidad (actualmente responsable de la auditoría de calidad)..."></textarea>
            
            <label for="comdig">Competencias digitales</label>
            <textarea id ="comdig" name="comdig" rows="20" placeholder="Dominio de software de edición fotográfica adquirido como fotógrafo aficionado..."></textarea>
            
            <input type="submit" value="Finalizar">
        </form>
        </div>
    </body>
</html>
