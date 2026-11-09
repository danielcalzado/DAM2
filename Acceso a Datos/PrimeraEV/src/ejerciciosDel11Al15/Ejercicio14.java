package ejerciciosDel11Al15;

import java.io.FileReader;
import java.io.IOException;

/**
 * Escribir un metodo que reciba el archivo "pruebaArrays.txt" e imprima las
 * cadenas que dicho archivo almacena (una cadena por linea). Se tendrá en
 * cuenta que las distintas cadenas se separan en el archivo por un asterisco
 * (que no se imprimirá).
 */
public class Ejercicio14 {

    public static void main(String[] args) {
        imprimirCadenas("pruebaArrays.txt");
    }

    public static void imprimirCadenas(String nombre) {
        try (FileReader fich = new FileReader(nombre)) {
            int letra = fich.read();

            while (letra != -1) {
                if (letra == '*') {
                    letra = '\n';
                }
                System.out.print((char) letra);
                letra = fich.read();
            }
            System.out.println(); // salto de línea final, opcional pero prolijo

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}