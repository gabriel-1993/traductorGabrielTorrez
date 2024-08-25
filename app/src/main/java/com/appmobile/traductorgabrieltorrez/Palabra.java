package com.appmobile.traductorgabrieltorrez;

import java.io.Serializable;

public class Palabra implements Serializable{
    private String español;
    private String ingles;
    private int imagen;

    public Palabra(String español, String ingles, int imagen) {
        this.español = español;
        this.ingles = ingles;
        this.imagen = imagen;
    }

    public String getEspañol() {
        return español;
    }

    public void setEspañol(String español) {
        this.español = español;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
