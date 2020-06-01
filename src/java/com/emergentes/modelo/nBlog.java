
package com.emergentes.modelo;

public class nBlog {
    int IdB;
    String NombreU;
    String NombreB;
    String ContenidoB;
    String FechaB;

    public nBlog() {
    }

    public nBlog(String NombreU, String NombreB, String ContenidoB, String FechaB) {
        this.NombreU = NombreU;
        this.NombreB = NombreB;
        this.ContenidoB = ContenidoB;
        this.FechaB = FechaB;
    }

    public int getIdB() {
        return IdB;
    }

    public void setIdB(int IdB) {
        this.IdB = IdB;
    }

    public String getNombreU() {
        return NombreU;
    }

    public void setNombreU(String NombreU) {
        this.NombreU = NombreU;
    }

    public String getNombreB() {
        return NombreB;
    }

    public void setNombreB(String NombreB) {
        this.NombreB = NombreB;
    }

    public String getContenidoB() {
        return ContenidoB;
    }

    public void setContenidoB(String ContenidoB) {
        this.ContenidoB = ContenidoB;
    }

    public String getFechaB() {
        return FechaB;
    }

    public void setFechaB(String FechaB) {
        this.FechaB = FechaB;
    }
    
    
    
}
