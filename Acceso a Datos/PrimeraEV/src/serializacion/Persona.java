package serializacion;

import java.io.Serializable;

public class Persona implements Serializable {
    private int edad;
    private String nombre;

    public Persona(int edad, String nombre) {
        edad = this.edad;
        nombre = this.nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}
