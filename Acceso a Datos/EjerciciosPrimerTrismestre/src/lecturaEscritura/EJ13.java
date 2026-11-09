package lecturaEscritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * EJ13 -  Escribir un método que reciba un array de cadenas de caracteres y vuelque su contenido a un archivo de nombre "pruebaArrays.txt". Las cadenas quedarán separadas en el archivo por un asterisco.
 */
public class EJ13 {

    public static void main(String[] args) {
        String[] array = {"Hola", "Adios","Buenos dias", "Buenas noches"};
        volcarCadenaAArchivo(array);
    }

    public static void volcarCadenaAArchivo(String[] cadena) {
        try (FileWriter fw = new FileWriter("src/lecturaEscritura/text/pruebaArrays.txt");
                PrintWriter pw = new PrintWriter(fw)) {

            for (int i = 0; i < cadena.length; i++) {
                pw.print(cadena[i]);
                pw.print("*");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
