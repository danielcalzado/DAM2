package ejerciciosDel11Al15;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribir un método que reciba un array de cadenas de caracteres y vuelque
 * su contenido a un archivo de nombre "pruebaArrays.txt". Las cadenas
 * quedarán separadas en el archivo por un asterisco.
 * 
 * Ejercicio13
 */
public class Ejercicio13 {

    public static void main(String[] args) {
        String[] palabras = { "hola", "adios", "buenos" };
        escribirArray(palabras);
    }

    public static void escribirArray(String[] palabras) {
        try (FileWriter fich = new FileWriter("pruebaArrays.txt")) {
            for (int i = 0; i < palabras.length; i++) {
                fich.write(palabras[i]);
                // Condición que evita insertar un * al final del todo
                if (i + 1 != palabras.length) {
                    fich.write("*");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}