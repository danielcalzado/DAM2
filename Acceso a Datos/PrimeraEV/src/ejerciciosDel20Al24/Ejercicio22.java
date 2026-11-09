package ejerciciosDel20Al24;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio22 {
    public static void main(String[] args) {
        String[] nombres = { "Ana", "Luis", "Maria", "Carlos", "Jaime" };
        int[] edades = { 23, 45, 18, 41, 68 };

        // Comprobación
        if (nombres.length != edades.length) {
            System.out.println("Los arrays no tienen el mismo tamaño.");
            return;
        }

        String fichero = "personas.dat";

        // Escritura
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))) {
            
            dos.writeInt(nombres.length);

            for (int i = 0; i < nombres.length; i++) {
                dos.writeUTF(nombres[i]);
                dos.writeInt(edades[i]);
            }

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
            return;
        }

        
    }
}
