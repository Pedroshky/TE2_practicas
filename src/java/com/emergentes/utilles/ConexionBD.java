package com.emergentes.utilles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD 
{
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_practica4";
    static String usuario = "root";
    static String password = "";
    
    public Connection conn = null;
    
    public ConexionBD()
    {
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            
            if(conn!=null)
            {
                System.out.println("Conexion OK");
            }
        }
        catch (ClassNotFoundException e)
                {
                   System.out.println("Falta especificar Driver "+e.getMessage()); 
                }
        catch (SQLException e)
                {
                   System.out.println("Error al abrir la BD "+e.getMessage()); 
                }
    }
    
    public Connection conectar()
    {
        return conn;
    }
    
    public void desconectar()
    {
        try
        {
            conn.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Error al cerrar la BD "+ex.getMessage()); 

        }
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
