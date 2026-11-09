package primerosEjercicios;

import java.io.File;
import java.io.IOException;

public class ejercicio4 {
    public static void main(String[] args) throws IOException {
        File f = new File(".");
        f.mkdir();

        File f1 = new File(f, "/d1");
        f1.mkdir();

        File a1 = new File(f1, "f11.txt");
        a1.createNewFile();

        File f2 = new File(f, "/d2");
        f2.mkdir();

        File a2 = new File(a1, "f21.txt");
        a2.createNewFile();


        f.delete();
        //crazy
    }
}
