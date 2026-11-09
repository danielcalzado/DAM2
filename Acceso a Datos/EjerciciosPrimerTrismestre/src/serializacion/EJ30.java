package serializacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * EJ30 - Lee y muestra por pantalla los datos de las personas almacenadas en el fichero anterior[cite: 61].
 */
public class EJ30 {
    public static void main(String[] args) {
        String ruta = "src/serializacion/obj/personas.obj";
        
        try (FileInputStream fis = new FileInputStream(ruta);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            System.out.println("--- Contenido del archivo ---");
            
            // Bucle por si hay más de una Persona grabada en el archivo
            while (true) {
                Persona p = (Persona) ois.readObject();
                System.out.println(p);
            }

        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró la clase Persona.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}