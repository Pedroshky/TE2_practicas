
package com.emergentes.controlador;

import com.emergentes.modelo.nUsuario;
import com.emergentes.modeloDAO.nUsuarioDAO;
import com.emergentes.utilles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {
    
    nUsuario nU = new nUsuario();
    nUsuarioDAO nUDAO = new nUsuarioDAO();
    int r=1;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String  action = (request.getParameter("action") == null) ? "view" :request.getParameter("action");
        String acceso="";
        if(action.equals("view"))
        {
            response.sendRedirect("login.jsp");
        }
        else if(action.equals("ver"))
        {
            response.sendRedirect("blogs.jsp");    
        }
       
            
            
        else if(action.equals("subeB"))
        {
            response.sendRedirect("sube.jsp");
        }
        else if(action.equals("registra"))
        {
            response.sendRedirect("registra.jsp");
        }
        else if (action.equalsIgnoreCase("registrar"))
        {
            String NombreU = request.getParameter("txtnombreU");
            String ContraseniaU = request.getParameter("txtcontraseniaU");
            
            nU.setNombreU(NombreU);
            nU.setContraseniaU(ContraseniaU);
            nUDAO.añadir(nU);
  
            response.sendRedirect("login.jsp");
        }
        else if(action.equals("logout"))
        {
            HttpSession ses = request.getSession();
            ses.setAttribute("logeado", null);
                ses.setAttribute("nombreU", null);
            ses.invalidate();
            response.sendRedirect("login.jsp");
        }
        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        String  action = (request.getParameter("action") == null) ? "view" :request.getParameter("action");
        String acceso="";
        
        
        if(action.equals("ingresar"))
        {
            
    
            String nombreU = request.getParameter("nombreU");
            String contraseniaU = request.getParameter("contraseniaU");
            
                
            nU.setNombreU(nombreU);
            nU.setContraseniaU(contraseniaU);
            r=nUDAO.validar(nU);
            
            ResultSet rs;
            
            if(r==1)
                {
                    nUsuarioDAO dao=new nUsuarioDAO();
                    nUsuario u=(nUsuario)dao.listU(nU);
                    HttpSession session= request.getSession(true);
                    session.setAttribute("logeado", "OK");
                    session.setAttribute("nombreU", nombreU);
                    session.setAttribute("user",nombreU);
                    request.getSession().setAttribute("usuario", u);
                    
                    request.getRequestDispatcher("panel.jsp").forward(request, response);
                }
                else
                {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            else
            {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
            /*ConexionBD canal = new ConexionBD();
            Connection  cn = canal.conectar();
            String sql = "select * from usuarios where NombreU=? and ContraseniaU=? limit 1";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,nombreU);
            ps.setString(2,contraseniaU);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                HttpSession ses = request.getSession();
                ses.setAttribute("logeado", "OK");
                ses.setAttribute("nombreU", nombreU);
                
                
                response.sendRedirect("panel.jsp");
            }
            else
            {
                response.sendRedirect("login.jsp");
            }
        */
        
        }
       
    
}