package primerosEjercicios;

import java.io.File;
import java.util.Scanner;

/**
 * Escribir un programa que liste el contenido de un directorio pasado como argumento, de cada elemento debe mostrar:
tipo (fichero o directorio)., nombre y si es fichero, el tamaño.
 */
public class ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una ruta: ");
        String argumento = sc.nextLine();

        File dir = new File(argumento);

        File[] contenido = dir.listFiles(); 

        for (File f : contenido) {
            System.out.println("Nombre: " + f.getName());

            if (f.isFile()) {
                System.out.println("Tipo: fichero");
                long size = f.length();
                System.out.println("Tamaño: " + size);
            } else {
                System.out.println("Tipo: directorio");
            }
            System.out.println();
        }
    }
}
