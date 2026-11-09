package primerosEjercicios;

import java.io.File;

/**
 * 
 * Programa que muestra todas las entradas del directorio “c:\windows” o "/home/usuario"
 */
public class ejercicio1 {
    public static void main(String[] args) {
        File home = new File("/home/alumnom");
        int i = 0;

        File[] ficheros = home.listFiles();

        for (File fichero : ficheros) {
            System.out.println(fichero.getName());
        }

        // Otra solución
    }
}
