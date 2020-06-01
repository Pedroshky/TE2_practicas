<%
    if(session.getAttribute("logeado") !="OK")
    {
        response.sendRedirect("login.jsp");
    }
    
    
%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.nBlog"%>
<%@page import="com.emergentes.modeloDAO.nUsuarioDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page </title>
    </head>
    <body>
            <a href="LoginControlador?action=logout">SALIR (x)</a>
            <p>Usuario: ${sessionScope.nombreU}</p>
            
        
       
        <p>Bienvenido al panel de administracion </p>
        
        
        <a href="LoginControlador?action=ver">Blogs</a>
        
    </body>
</html>
