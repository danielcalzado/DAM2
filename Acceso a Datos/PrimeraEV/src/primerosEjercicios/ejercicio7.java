package primerosEjercicios;

import java.io.File;
import java.util.Scanner;

/**
 * Realiza un programa que compruebe si se tiene acceso de ejecución y lectura a un fichero (pasado como argumento) y después modifique sus atributos
 * denegando estos permisos
 */
public class ejercicio7 {
    public static void main(String[] args) {

        // Falta preguntar con Scanner el archivo (argumento) -> cambiar programa
        Scanner sc = new Scanner(System.in);
        
        File fichero = new File("/home/alumnom/Escritorio/pruebaEJ7");

        if (fichero.canExecute()) {
            System.out.println("El fichero es ejecutable.");
            fichero.setExecutable(false);
        } else {
            System.out.println("Ya se ha eliminado el permiso de ejecución");
        }
        
        if (fichero.canRead()) {
            System.out.println("El fichero se lee.");
            fichero.setReadable(false);
        } else {
            System.out.println("Ya se ha eliminado el permiso de lectura");
        }
    }
}
