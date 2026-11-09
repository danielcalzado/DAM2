package serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import serializacion.Persona;

/**
 * 
 * EJ29 - Escribe objetos Persona en un fichero. Puedes tener los nombres y edades almacenados en arrays o bien solicitarlos por teclado.
 */

public class EJ29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona p = null;
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();

            p = new Persona(nombre, edad);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream("src/serializacion/obj/personas.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                
            if (p != null) {
                oos.writeObject(p);
                System.out.println("Objeto Persona guardado con exito.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
