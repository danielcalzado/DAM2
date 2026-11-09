package claseFile;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * EJ10 -- BORRAR TODA LA ESTRUCTURA DE EJ8/9
 */

public class EJ10 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Apuntamos a la raíz de la estructura creada en el Ejercicio 8
        File raiz = new File("home");

        if (!raiz.exists()) {
            System.out.println("La estructura 'home' no existe.");
            return;
        }

        System.out.println("=== INICIO DEL PROCESO DE BORRADO DE LA ESTRUCTURA ===");
        borrarEstructura(raiz);
        System.out.println("Proceso finalizado.");
    }

    /**
     * Método recursivo para procesar y borrar archivos y directorios
     */
    public static void borrarEstructura(File elemento) {
        // 1. Si es un directorio, procesar primero todo su contenido
        if (elemento.isDirectory()) {
            File[] hijos = elemento.listFiles();
            if (hijos != null) {
                for (File hijo : hijos) {
                    borrarEstructura(hijo); // Llamada recursiva
                }
            }
        }

        // 2. Comprobar si es un directorio no vacío antes de preguntar
        if (elemento.isDirectory()) {
            String[] contenido = elemento.list();
            if (contenido != null && contenido.length > 0) {
                System.out.printf("El directorio '%s' NO está vacío. Se omite el borrado.%n", elemento.getPath());
                return;
            }
        }

        // 3. Solicitar confirmación al usuario
        if (confirmarBorrado(elemento)) {
            if (elemento.delete()) {
                System.out.printf("-> Eliminado con éxito: %s%n", elemento.getPath());
            } else {
                System.out.printf("-> No se pudo eliminar: %s%n", elemento.getPath());
            }
        } else {
            System.out.printf("-> Omitido por el usuario: %s%n", elemento.getPath());
        }
    }

    /**
     * Auxiliar para pedir confirmación por consola
     */
    private static boolean confirmarBorrado(File f) {
        String tipo = f.isDirectory() ? "directorio" : "fichero";
        System.out.printf("¿Deseas borrar el %s '%s'? (s/n): ", tipo, f.getPath());
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }
}
