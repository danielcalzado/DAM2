package claseFile;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EJ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta del fichero o directorio: ");
        String ruta = sc.nextLine();

        File archivo = new File(ruta);

        // Validar primero si existe
        if (!archivo.exists()) {
            System.out.println("Error: El fichero o directorio especificado no existe.");
            sc.close();
            return;
        }

        System.out.println("\n=== ATRIBUTOS DEL ELEMENTO ===");
        System.out.println("Nombre del archivo: " + archivo.getName());
        System.out.println("Camino absoluto: " + archivo.getAbsolutePath());
        System.out.println("Tamaño: " + archivo.length() + " bytes");

        // Comprobación de tipo (fichero o directorio) -- equivalentes a if-else
        System.out.println("Es Fichero: " + (archivo.isFile() ? "Sí" : "No"));
        System.out.println("Es Directorio: " + (archivo.isDirectory() ? "Sí" : "No"));

        // Formateo de la última modificación
        long ms = archivo.lastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = sdf.format(new Date(ms));
        System.out.println("Última modificación: " + fechaFormateada);

        // Permisos de acceso
        System.out.println("Permiso de lectura: " + (archivo.canRead() ? "Sí" : "No"));
        System.out.println("Permiso de escritura: " + (archivo.canWrite() ? "Sí" : "No"));
        System.out.println("Permiso de ejecución: " + (archivo.canExecute() ? "Sí" : "No"));

        sc.close();
    }
}
