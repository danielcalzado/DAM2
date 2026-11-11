package com.example.simulacroexamen1ev;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private String nacionalidad;
    private int puntuacion;
    private int banderaResId; // Guarda la ID de la imagen (R.drawable.xxxx)

    public Jugador(String nombre, String nacionalidad, int puntuacion, int banderaResId) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.puntuacion = puntuacion;
        this.banderaResId = banderaResId;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public int getBanderaResId() { return banderaResId; }
    public void setBanderaResId(int banderaResId) { this.banderaResId = banderaResId; }
}
