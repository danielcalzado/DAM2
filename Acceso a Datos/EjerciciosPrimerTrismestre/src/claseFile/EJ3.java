package claseFile;

import java.io.File;

public class EJ3 {
    public static void main(String[] args) {
        File f = new File(".");

        File archivo[] = f.listFiles();

        System.out.println(archivo[4]);

        for (int i = 0; i < archivo.length; i++) {
            System.out.println(archivo[i]);
            if (archivo[i].isDirectory()) {
                File subArchivo[] = archivo[i].listFiles();
                for (int j = 0; j < subArchivo.length; j++) {
                    System.out.print("  --- " + subArchivo[j].getName());
                    if (subArchivo[j].isFile()) {
                        System.out.println(" | Tipo: fichero");
                    } else {
                        System.out.println(" | Tipo: directorio");
                    }
                }

            }
        }
    }
}
