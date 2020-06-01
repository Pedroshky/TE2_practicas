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
        <title>JSP Page</title>
    </head>
    <body>
        <a href="LoginControlador?action=logout">SALIR (x)</a>
        <div>
            
        <h1>Blogs</h1>
        <a href="LoginControlador?action=subeB">Nueva Entrada</a>
        <br>
        <table border="1">
                <thead>
                    
                    
                </thead>
                <%
                    nUsuarioDAO nDAO = new nUsuarioDAO();
                    List<nBlog>list = nDAO.listar();
                    Iterator<nBlog>iter= list.iterator();
                    nBlog nBg=null;
                    
                    while(iter.hasNext()){
                        nBg=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        
                        <td><%= nBg.getFechaB()%><br><br>
                            
                            <h2><%= nBg.getNombreB()%></h2><br><br>
                            
                            <%= nBg.getContenidoB()%><br><br>
                        
                            <a href="UsuarioControlador?action=edita&IdB=<%= nBg.getIdB()%>">editar</a>
                            <a href="UsuarioControlador?action=borra&IdB=<%= nBg.getIdB()%>">eliminar</a>
                            <br><br>
                            Autor:<%= nBg.getNombreU()%>
                            
                        </td>
                        <td></td>
                        
                    </tr>
                    
                   <%
                   }
                   %> 
                </tbody>
            </table>

        </div>
    </body>
</html>
