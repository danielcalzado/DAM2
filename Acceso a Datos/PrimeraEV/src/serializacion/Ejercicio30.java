package serializacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio30 {
    public static void main(String[] args) {
        int contador = 0;

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("datos.obj"))) {

            while (true) {
                Persona p = (Persona) is.readObject();
                System.out.println(p);
                contador++;
            }

        } catch (EOFException e) {
            // Fin normal del fichero: no es un error
            System.out.println("Fin del fichero. Personas leídas: " + contador);
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase del objeto: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}