package com.example.listviewadaptadorpersonalizado;

import java.io.Serializable;

public class ModeloPersona implements Serializable {
    private String nombre;
    private String descripcion;
    private int codigo;
    private int foto;

    public ModeloPersona() {
    }

    public ModeloPersona(String nombre, String descripcion, int codigo, int foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
