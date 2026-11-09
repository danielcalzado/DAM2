package primerosEjercicios;

import java.io.File;
import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero: ");
        String fichUser = sc.nextLine();

        File f = new File(fichUser);

        if (f.exists()) {
            System.out.println("Ruta absoluta del fichero: ");
            System.out.println(" - " + f.getAbsolutePath());
            if (f.isFile()) {
                System.out.println("Es un fichero");
            } else {
                System.out.println("Es un directorio");
            }
            if (f.canWrite()) {
                System.out.println(f.lastModified());
            }
            if (f.canRead()) {
                System.out.println("Tiene permisos de lectura");
            } else {
                System.out.println("No tiene permisos de lectura");
            }
            if (f.canExecute()) {
                System.out.println("Tiene permisos de ejecución");
            } else {
                System.out.println("No tiene permisos de ejecución");
            }
        } else {
            System.out.println("El fichero no existe");
        }
    }
}
