package primerosEjercicios;

import java.io.File;
import java.io.IOException;

/**
 * Realiza un programa que cree una estructura de directorios como la siguiente, donde fx son ficheros y dx son directorios
 */
public class ejercicio8 {
    public static void main(String[] args) throws IOException {
        // Se crea a partir del directorio actual (raíz del proyecto)
        File d1 = new File(".");
        d1.mkdir();
        File d2 = new File(d1, "usr1");
        d2.mkdir();
        File f1 = new File(d2, "f1.txt");
        f1.createNewFile();
        File d3 = new File(d1, "usr2");
        d3.mkdir();
        File d4 = new File(d1, "d1");
        d4.mkdir();
        File f2 = new File(d4, "f2.txt");
        f2.createNewFile();
        File d5 = new File(d1, "d2");
        d5.mkdir();
        File f3 = new File(d5, "f3.txt");
        f3.createNewFile();
        File f4 = new File(d5, "f4.txt");
        f4.createNewFile();
        File d6 = new File(d1, "d3");
        d6.mkdir();
    }
}
