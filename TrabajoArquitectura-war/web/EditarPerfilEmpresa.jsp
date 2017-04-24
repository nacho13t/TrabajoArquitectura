<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%ArrayList lista = (ArrayList)request.getAttribute("perfil");%>
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
        <title>Perfil empresa</title>
    </head>
    <body>
        <h2 style="text-align: center">Perfil empresa</h2>
        <form action="FrontServlet">
            <input type="hidden" name="command" value="UpdateEnterprisePerfilCommand">
            
            <label for="perf">Perfil</label>
            <textarea rows="10" cols="70" name="perfil"><%=(String)lista.get(0)%></textarea>
            
            <label for="fname">Objetivo</label>
            <textarea rows="10" cols="70" name="objetivo"><%=(String)lista.get(1)%></textarea>
            
            <label for="fname">Misión</label>
            <textarea rows="10" cols="70" name="mision"><%=(String)lista.get(2)%></textarea>
            
            <label for="fname">Visión</label>
            <textarea rows="10" cols="70" name="vision"><%=(String)lista.get(3)%></textarea>
            
            <label for="fname">Valores</label>
            <textarea rows="10" cols="70" name="valores"><%=(String)lista.get(4)%></textarea>
            
            <input type="hidden" id="empresa" name="empresa" value="<%=request.getSession().getAttribute("name")%>">
            
            <input type="submit" value="Actualizar">
        </form>
    </body>
</html>
