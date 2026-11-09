package primitivos;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 * EJ23 - Visualiza los datos guardados en el ejercicio anterior en el mismo orden que se escribieron, es decir, primero el nombre y luego la edad.
 */

public class EJ23 {
    public static void main(String[] args) {
        
        try (DataInputStream dis = new DataInputStream(new FileInputStream("src/primitivos/archivos/destino.dat"))) {
            while (true) {
                String nombre = dis.readUTF();
                int edad = dis.readInt();
                System.out.println("Nombre: " + nombre);
                System.out.println("Edad: " + edad);
            }
        } catch (EOFException e) {
            System.out.println("Datos leidos con exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
