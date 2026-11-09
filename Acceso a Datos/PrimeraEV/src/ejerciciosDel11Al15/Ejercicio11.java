package ejerciciosDel11Al15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribe un programa que escriba los 100 primeros números naturales en un archivo numNaturales.txt.
 */
public class Ejercicio11 {
    public static void main(String[] args) {
        
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("numNaturales.txt"))) {
        for (int i = 0; i <= 100; i++) {
            bw.write(i + " ");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


    try (FileWriter fich = new FileWriter("numNaturales2.txt")) {
        for (int i = 0; i <= 100; i++) {
            fich.write(i + " "); // Esto escribe en bytes pero en cuando lo concadenas con un String se vuelve legible
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

}
