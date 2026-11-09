package primitivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EJ20 {
    public static void main(String[] args) {
        String origen = "src/lecturaEscritura/text/numNaturales.txt";
        String destino = "src/primitivos/archivos/output.dat";

        try (FileOutputStream fos = new FileOutputStream(destino);
            FileInputStream fis = new FileInputStream(origen)) {

                int byteLeido;
                while ((byteLeido = fis.read()) != -1) {
                    fos.write(byteLeido);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
