package claseFile;

import java.io.File;
import java.io.IOException;

public class EJ8 {
    public static void main(String[] args) {
        // Directorios principales
        File usr1 = new File("home" + File.separator + "usr1");
        File usr2 = new File(usr1, "usr2");
        File d1 = new File(usr2, "d1");
        File d2 = new File(usr2, "d2");
        File d3 = new File(d2, "d3");

        // Ficheros
        File f1 = new File(usr1, "f1");
        File f2 = new File(d1, "f2");
        File f3 = new File(d2, "f3");
        File f4 = new File(d2, "f4");

        try {
            // 1. Crear toda la jerarquía de directorios primero con mkdirs()
            if (d1.mkdirs()) {
                System.out.println("Ruta hasta d1 creada.");
            }
            if (d3.mkdirs()) {
                System.out.println("Ruta hasta d3 creada.");
            }

            // 2. Crear los ficheros físicamente en el disco
            crearFichero(f1);
            crearFichero(f2);
            crearFichero(f3);
            crearFichero(f4);

            System.out.println("Estructura creada correctamente.");

        } catch (IOException e) {
            System.err.println("Error al crear la estructura: " + e.getMessage());
        }
    }

    // Método auxiliar para no repetir try-catch ni sysos
    private static void crearFichero(File f) throws IOException {
        if (f.createNewFile()) {
            System.out.println("Fichero creado: " + f.getPath());
        } else {
            System.out.println("El fichero ya existía: " + f.getPath());
        }
    }
}
