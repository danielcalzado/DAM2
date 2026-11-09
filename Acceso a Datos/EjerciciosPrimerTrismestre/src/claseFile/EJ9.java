package claseFile;

import java.io.File;

public class EJ9 {
    public static void main(String[] args) {
        // 1. Validar que se ha pasado el argumento por la línea de comandos
        if (args.length == 0) {
            System.out.println("Error: Debes pasar la ruta de un directorio como argumento.");
            System.out.println("Uso: java Ejercicio9 <ruta_directorio>");
            return;
        }

        // 2. Crear el objeto File con el primer argumento
        File directorio = new File(args[0]);

        // 3. Comprobar existencia y que sea un directorio
        if (!directorio.exists()) {
            System.out.println("Error: La ruta especificada no existe.");
            return;
        }

        if (!directorio.isDirectory()) {
            System.out.println("Error: La ruta especificada no es un directorio.");
            return;
        }

        // 4. Obtener la lista de ficheros y subdirectorios como objetos File
        File[] contenido = directorio.listFiles();

        if (contenido == null) {
            System.out.println("No se pudo acceder al contenido del directorio (permisos insuficientes).");
            return;
        }

        System.out.printf("Contenido del directorio '%s':%n", directorio.getAbsolutePath());
        System.out.println("--------------------------------------------------");

        // 5. Recorrer la lista y mostrar los datos
        for (File elemento : contenido) {
            if (elemento.isDirectory()) {
                System.out.printf("[DIRECTORIO] %s%n", elemento.getName());
            } else if (elemento.isFile()) {
                System.out.printf("[FICHERO]    %s - %d bytes%n", elemento.getName(), elemento.length());
            }
        }
    }
}
