package primitivos;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class EJ21 {
    public static void main(String[] args) {
        String ruta = "src/lecturaEscritura/text/numNaturales.txt";

        int contPalabras = 0;
        int contNumeros = 0;

        // StreamTokenizer se monta sobre un FileReader
        try (FileReader fr = new FileReader(ruta)) {
            StreamTokenizer sTokenizer = new StreamTokenizer(fr);

            // Recorremos el fichero token a token hasta llegar al final (TT_EOF)
            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (sTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    contPalabras++;
                } else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    contNumeros++;
                }
            }

            System.out.println("Número de palabras: " + contPalabras);
            System.out.println("Número de números: " + contNumeros);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
