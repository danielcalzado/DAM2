package primitivos;

import java.io.File;

public class EJ28 {
    public static void main(String[] args) {
        File carpeta = new File("src/lecturaEscritura");

        // Filtrar archivos que terminen en .java
        String[] archivosJava = carpeta.list((dir, name) -> name.endsWith(".java"));

        if (archivosJava != null && archivosJava.length > 0) {
            System.out.println("--- Archivos .java encontrados ---");
            for (String archivo : archivosJava) {
                System.out.println(archivo);
            }
        } else {
            System.out.println("No se encontraron archivos .java en esa carpeta.");
        }
    }
}
