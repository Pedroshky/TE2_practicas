
package com.emergentes.modelo;

public class nUsuario 
{
    int id;
    String nombreU;
    String contraseniaU;

    public nUsuario() {
    }

    public nUsuario(String nombreU, String contraseniaU) {
        this.nombreU = nombreU;
        this.contraseniaU = contraseniaU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getContraseniaU() {
        return contraseniaU;
    }

    public void setContraseniaU(String contraseniaU) {
        this.contraseniaU = contraseniaU;
    }
    
}
