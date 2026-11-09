package ejerciciosDel20Al24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Copiar el contenido de un fichero en otro
 */
public class Ejercicio20 {
    public static void main(String[] args) throws FileNotFoundException {

        File origen = new File("numNaturales.txt");
        File destino = new File("numNaturales2.txt");

        try (DataInputStream dis = new DataInputStream(new FileInputStream(origen));
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(destino))) {
            while (true) {
                dos.writeByte(dis.readByte());
            }
        } catch (EOFException e) {
            System.out.println("Copia terminada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
