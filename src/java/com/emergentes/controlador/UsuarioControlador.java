
package com.emergentes.controlador;

import com.emergentes.modelo.nBlog;
import com.emergentes.modelo.nUsuario;
import com.emergentes.modeloDAO.nUsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UsuarioControlador extends HttpServlet {

    nUsuario nU = new nUsuario();
    nUsuarioDAO nUDAO = new nUsuarioDAO();
    
    nBlog nB = new nBlog();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  action = (request.getParameter("action") == null) ? "view" :request.getParameter("action");
        String acceso="";
        
        if(action.equalsIgnoreCase("edita"))
            {
                request.setAttribute("Id", request.getParameter("IdB"));
  
                RequestDispatcher vista=request.getRequestDispatcher("editar.jsp");
                vista.forward(request, response);
                
            }
        if(action.equalsIgnoreCase("borra"))
            {
                int IdBl = Integer.parseInt(request.getParameter("IdB"));
                
                nB.setIdB(IdBl);
                nUDAO.eliminar(IdBl);
  
                response.sendRedirect("blogs.jsp");
                
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            String  action = (request.getParameter("action") == null) ? "view" :request.getParameter("action");
            
            
            if(action.equalsIgnoreCase("registrar"))
            {
            String NombreU = request.getParameter("txtnombreU");
            String ContraseniaU = request.getParameter("txtcontraseniaU");
            
            nUsuario nUs = new nUsuario();
            nUs.setNombreU(NombreU);
            nUs.setContraseniaU(ContraseniaU);
            nUDAO.añadir(nUs);
  
            response.sendRedirect("login.jsp");
            }
            else if(action.equalsIgnoreCase("subir")) 
            {
            String FechaB = request.getParameter("txtfechaB");
            String TituloB = request.getParameter("txttituloB");
            String ContenidoB = request.getParameter("txtcontenidoB");
            String NombreU=  request.getParameter("txtNombreU");
            
            
            nBlog nB = new nBlog();
            nB.setNombreU(NombreU);
            nB.setNombreB(TituloB);
            nB.setContenidoB(ContenidoB);
            nB.setFechaB(FechaB);
            nUDAO.subir(nB);
  
            response.sendRedirect("panel.jsp");
            }
            
            else if(action.equalsIgnoreCase("cambiar")) 
            {
                int IdBl = Integer.parseInt(request.getParameter("txtIdB"));
                
                String FechaB = request.getParameter("txtfechaB");
                String TituloB = request.getParameter("txttituloB");
                String ContenidoB = request.getParameter("txtcontenidoB");
                String NombreU=  request.getParameter("txtNombreU");
            
            nBlog nblog = new nBlog();
            nblog.setIdB(IdBl);
            nblog.setNombreU(NombreU) ;
            nblog.setNombreB(TituloB);
            nblog.setContenidoB(ContenidoB);
            nblog.setFechaB(FechaB);
            nUDAO.editar(nblog);
  
            response.sendRedirect("blogs.jsp");
            }
        
    }

}
