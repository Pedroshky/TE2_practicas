<%
    if(session.getAttribute("logeado") !="OK")
    {
        response.sendRedirect("login.jsp");
    }
%>

<%@page import="com.emergentes.modelo.nBlog"%>
<%@page import="com.emergentes.modeloDAO.nUsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
               
                int idB=Integer.parseInt((String)request.getAttribute("Id"));
                //nBlog nB=(nBlog)DAO.list(idB);
                
                nUsuarioDAO uDAO = new nUsuarioDAO();
               
                nBlog nB=(nBlog)uDAO.list(idB);  
                
            %>
        <a href="LoginControlador?action=logout">SALIR (x)</a>
        <div>
           
        <h1>Editar Blog</h1>
        <form action ="UsuarioControlador" method="post">
            <label>Fecha:</label>
            <input type="text" name="txtfechaB" value="<%=nB.getFechaB()%>">
            <br>
            <label>Titulo: </label>
            <input type="text" name="txttituloB" value="<%=nB.getNombreB()%>">
            <br>
            <label>Contenido:</label>
            <input type="text" name="txtcontenidoB" value="<%=nB.getContenidoB()%>">
            <br>
            <input type="hidden" name="txtNombreU" value="<%=nB.getNombreU()%>">
            <input type="hidden" name="txtIdB" value="<%=nB.getIdB()%>">
            <input type="submit" name ="action" value="cambiar">
        </form>
        
      
        </div>
    </body>   
</html>
