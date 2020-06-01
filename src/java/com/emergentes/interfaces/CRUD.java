
package com.emergentes.interfaces;

import com.emergentes.modelo.nBlog;
import com.emergentes.modelo.nUsuario;
import java.util.List;


public interface CRUD 
{
    public int validar(nUsuario u);
    public nUsuario listU(nUsuario nU);
   
    
    public nBlog list(int IdBg);
    
    public List listar();
    public boolean añadir (nUsuario pUser);
    public boolean subir (nBlog nB);
    public boolean editar (nBlog nB);
    public boolean eliminar (int Id);
}
