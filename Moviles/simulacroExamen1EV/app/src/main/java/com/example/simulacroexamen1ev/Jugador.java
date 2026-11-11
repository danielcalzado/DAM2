package com.example.simulacroexamen1ev;

import java.io.Serializable;

/*
 * Clase Modelo (POJO) que representa a un jugador del torneo Six Nations.
 * Implementa Serializable para permitir que el objeto pueda convertirse
 * en flujo de bytes/datos si se necesita pasar entre pantallas o guardar.
 */
public class Jugador implements Serializable {
    private String nombre;
    private String nacionalidad;
    private int puntuacion;
    private int banderaResId; // número identificador que Android le asigna en la clase R (ej. R.drawable.escocia)

    // Constructor: obliga a crear el jugador con todos sus datos iniciales
    public Jugador(String nombre, String nacionalidad, int puntuacion, int banderaResId) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.puntuacion = puntuacion;
        this.banderaResId = banderaResId;
    }

    // Métodos Getters y Setters: permiten leer y modificar los datos desde MainActivity y el Adapter
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public int getBanderaResId() { return banderaResId; }
    public void setBanderaResId(int banderaResId) { this.banderaResId = banderaResId; }
}
