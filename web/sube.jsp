<%
    if(session.getAttribute("logeado") !="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="LoginControlador?action=logout">SALIR (x)</a>
        <h1>Nuevo Blog</h1>
        <form action ="UsuarioControlador" method="post">
            <label>Fecha:</label>
            <input type="text" name="txtfechaB">
            <br>
            <label>Titulo: </label>
            <input type="text" name="txttituloB">
            <br>
            <label>Contenido:</label>
            <input type="text" name="txtcontenidoB">
            <br>
            
            <input type="hidden" name="txtNombreU" value="${sessionScope.nombreU}">
            <input type="submit" name ="action" value="subir">
        </form>
        
       <a href="LoginControlador?action=ver">Blogs</a>
    </body>
</html>
