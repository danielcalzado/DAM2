package lecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * EJ12 -  Escribe un programa que reciba el nombre de un archivo que almacena una serie de cantidades enteras positivas e imprima su suma.
 */
public class EJ12 {
    public static void main(String[] args) {
        int suma = 0;
        File archivo = new File("src/lecturaEscritura/text/numNaturales.txt");
        try (Scanner sc = new Scanner(archivo);) {
            while (sc.hasNextInt()) {
            int numero = sc.nextInt();
            suma += numero;
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        }

        System.out.println("La suma total es: " + suma);
    }
}
