package claseFile;

import java.io.File;

public class EJ2 {
    public static void main(String[] args) {
        File f = new File(".");

        String dirActualAbsolute = f.getAbsolutePath();
        String dirActualRelative = f.getPath();

        System.out.println("Directorio actual absoluto: " + dirActualAbsolute);
        System.out.println("Directorio actual relativo: " + dirActualRelative);

    }
}
