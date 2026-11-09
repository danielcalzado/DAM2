package primitivos;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * EJ22 - Inserta en un fichero los datos de dos arrays, uno con el nombre de una serie de personas y otro con sus edades
 */

public class EJ22 {
    public static void main(String[] args) {
        String destino = "src/primitivos/archivos/destino.dat";
        String[] personas = {"Dani", "Belen", "Sasha", "Cristina", "Dario"};
        int[] edades = {20, 19, 4, 50, 12};

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(destino))) {
            for (int i = 0; i < personas.length; i++) {
                dos.writeUTF(personas[i]);
                dos.writeInt(edades[i]);
            }
            System.out.println("Datos de los arrays insertados con exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   
