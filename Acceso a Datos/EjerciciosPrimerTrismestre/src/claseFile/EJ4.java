package claseFile;

import java.io.*;

public class EJ4 {
    public static void main(String[] args) throws IOException {
        File d = new File("./pruebas");
        
        File d1 = new File(d, "d1");
        d1.mkdir();
        File d2 = new File(d, "d2");
        d2.mkdir();
        File f11 = new File(d1, "f11");
        f11.createNewFile();
        File f21 = new File(d1, "f21");
        f21.createNewFile();
        

    }
}
