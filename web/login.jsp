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
        <h1>Login ${sessionScope.nombreU}</h1>
        <form action ="LoginControlador" method="post">
            <label>Usuario</label>
            <input type="text" name="nombreU">
            <br>
            <label>Password</label>
            <input type="password" name="contraseniaU">
            <br>
            <input type="submit" name="action" value="ingresar">
        </form>
        
        
        ${nU.getNombreU()}
        ${nU.getContraseniaU()}
        <a href="LoginControlador?action=registra">REGISTRATE</a>
    </body>
</html>
