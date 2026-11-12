package com.example.danielcalzado;

import java.util.Map;

public class Alumno {
    String nombre;
    String dni;
    int fotoResld;
    Map<String, Double> notas;

    public Alumno(String nombre, String dni, int fotoResld, Map notas) {
        this.nombre = nombre;
        this.dni = dni;
        this.fotoResld = fotoResld;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getFotoResld() {
        return fotoResld;
    }

    public void setFotoResld(int fotoResld) {
        this.fotoResld = fotoResld;
    }

    public Map getNotas() {
        return notas;
    }

    public void setNotas(Map notas) {
        this.notas = notas;
    }
}
