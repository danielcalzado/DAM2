package ejerciciosDel20Al24;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio23 {
    public static void main(String[] args) {
        
        String fichero = "personas.dat";

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)))) {
            int total = dis.readInt();
            System.out.println("Registros leídos: " + total);

            for (int i = 0; i < total; i++) {
                String nombre = dis.readUTF();
                int edad = dis.readInt();
                System.out.println(nombre + " - " + edad + " años");
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
