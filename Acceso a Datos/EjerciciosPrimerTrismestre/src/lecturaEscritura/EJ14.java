package lecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * EJ14 - Escribir un método que reciba el archivo "pruebaArrays.txt" e imprima las cadenas que dicho archivo almacena (una
cadena por línea). Se tendrá en cuenta que las distintas cadenas se separan en el archivo por un asterisco (que no se
imprimirá).
 */

public class EJ14 {
    
    public static void main(String[] args) {
        leerYMostrarArchivo("src/lecturaEscritura/text/pruebaArrays.txt");
    }

    public static void leerYMostrarArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\*");
                for (String palabra : palabras) {
                    System.out.println(palabra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
