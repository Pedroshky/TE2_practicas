
package com.emergentes.modeloDAO;

import com.emergentes.interfaces.CRUD;
import com.emergentes.modelo.nBlog;
import com.emergentes.modelo.nUsuario;
import com.emergentes.utilles.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class nUsuarioDAO implements CRUD
        
{
    ConexionBD cn = new ConexionBD(); 
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    nUsuario nU= new nUsuario();
    nBlog nB = new nBlog();
    
    
    
    @Override
    public List listar() {
        ArrayList<nBlog>list=new ArrayList<>();
        String sql="select * from blogs order by IdB";
        
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                nBlog nBl= new nBlog();
                nBl.setIdB(rs.getInt("IdB"));
                nBl.setNombreB(rs.getString("NombreB"));
                nBl.setContenidoB(rs.getString("ContenidoB"));
                nBl.setFechaB(rs.getString("FechaB"));
                nBl.setNombreU(rs.getString("NombreU"));
                list.add(nBl);
            }
        }
        catch(Exception e)
        { 
        
        }
        return list;
    }
    
    
    @Override
    public nUsuario listU(nUsuario nU) 
    {
        String sql="select * from usuarios where NombreU='"+nU.getNombreU()+"' and ContraseniaU='"+nU.getContraseniaU()+"'";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next())
                    {
                       nU.setNombreU(rs.getString("NombreU"));
                       nU.setContraseniaU(rs.getString("ContraseniaU"));
                    }
            }
        catch(Exception e)
            {
            }
        return nU;
    }
    
   
    
    @Override
    public nBlog list(int IdBg) {
        
        String sql="select * from blogs where IdB="+IdBg;
        
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                nB.setIdB(rs.getInt("IdB"));
                nB.setNombreB(rs.getString("NombreB"));
                nB.setContenidoB(rs.getString("ContenidoB"));
                nB.setFechaB(rs.getString("FechaB"));
                nB.setNombreU(rs.getString("NombreU"));
               
            }
        }
        catch(Exception e)
        {
        
        }
        return nB;
    }

    @Override
    public boolean añadir(nUsuario nUser) {
        
        String sql ="insert into usuarios (NombreU, ContraseniaU) values ('"+nUser.getNombreU()+"','"+nUser.getContraseniaU()+"')";
        
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
        
        }
        return false;
        
        
    }
    
    @Override
    public boolean subir(nBlog nB) {
        
        String sql ="insert into blogs (NombreU, NombreB, ContenidoB, FechaB) values ('"+nB.getNombreU()+"','"+nB.getNombreB()+"','"+nB.getContenidoB()+"','"+nB.getFechaB()+"')";
        
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
        
        }
        return false;
        
        
    }

    @Override
    public boolean editar(nBlog nB) {
        String sql ="update blogs set NombreB='"+nB.getNombreB()+"', ContenidoB='"+nB.getContenidoB()+"', FechaB='"+nB.getFechaB()+"'where IdB="+nB.getIdB();

        
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
        
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql ="delete from blogs where IdB="+id;    
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
        
        }
        return false;
    }
    
    @Override
    public int validar(nUsuario u)
    {
        int r=0;
        String sql="Select * from usuarios where NombreU='"+u.getNombreU()+"' and ContraseniaU='"+u.getContraseniaU()+"'";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
           
            rs=ps.executeQuery();
                while(rs.next())
                {
                    r=r+1;
                    u.setNombreU(rs.getString("NombreU"));
                    u.setContraseniaU(rs.getString("ContraseniaU"));        
                }
                if(r==1)
                {
                    return 1;
                }
                else
                    return 0;
            }
        catch(Exception e)
            {
                return 0;
            }
    }   
    
}
