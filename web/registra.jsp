<%
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrate</h1>
        <form action ="UsuarioControlador" method="post">
            <label>Usuario</label>
            <input type="text" name="txtnombreU">
            <br>
            <label>Password</label>
            <input type="password" name="txtcontraseniaU">
            <br>
            <input type="submit" name ="action" value="registrar">
        </form>
        
        <a href="LoginControlador?action=view">Inicia Sesion</a>
    </body>
</html>