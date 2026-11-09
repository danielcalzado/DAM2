package claseFile;

import java.io.*;

public class EJ1 {
    public static void main(String[] args) {
        File f = new File("C:\\Windows");

        String archivos[] = f.list();

        for (int i = 0; i <= archivos.length; i++) {
            System.out.println(archivos[i]);
        }
    }
}
