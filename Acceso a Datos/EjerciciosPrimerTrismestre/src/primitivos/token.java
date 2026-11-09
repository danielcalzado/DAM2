package primitivos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class token {
    public static void contarPalabrasYNumeros(String nombre_fichero) {
        StreamTokenizer sTokenizer = null;
        int contapal = 0, numNumeros = 0;
        try { // nunca se cierra el FileReader, por lo que poner un try-with-resources seria lo ideal
            sTokenizer = new StreamTokenizer(new FileReader(nombre_fichero));
            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (sTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    contapal++;
                } else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    numNumeros++;
                }
            }
            System.out.println("Numero de palabras en el fichero: " + contapal);
            System.out.println("Numero de numeros en el fichero: " + numNumeros);
        } catch (FileNotFoundException ex) { // esto se puede unificar ya que FileNotFoundException hereda de IOException
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        contarPalabrasYNumeros("src/lecturaEscritura/text/pruebaArrays.txt");
    }
}
