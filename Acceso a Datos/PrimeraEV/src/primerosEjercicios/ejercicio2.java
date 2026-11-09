package primerosEjercicios;

import java.io.File;
import java.io.IOException;

/**
 * Programa que diga cuál es el directorio actual.
 */
public class ejercicio2 {
    public static void main(String[] args) {
        File actual = new File(".");

        try {
            System.out.println(actual.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
