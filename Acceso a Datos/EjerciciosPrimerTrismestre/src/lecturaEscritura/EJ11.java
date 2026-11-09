package lecturaEscritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * EJ11 - programa que escribie los 100 primeros números naturales en un archivo numNaturales.txt
 */

public class EJ11 {
    public static void main(String[] args) {
        // Al meter las declaraciones en el try se cierran solas cuando termine
        try (FileWriter fw = new FileWriter("src/lecturaEscritura/text/numNaturales.txt");
            PrintWriter pw = new PrintWriter(fw)) {
        ;
        for (int i = 1; i <= 100; i++) {
            pw.println(i);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

