import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class creacionJugadores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "src/Jugadores.dat";
        File fichero = new File(ruta);

        // Arrays de datos
        String[] nombres = {"Andrés Iniesta", "Pau Cubarsí", "Lamine Yamal"};
        int[] dorsales = {8, 12, 10};
        double[] salarios = {1000.00, 2000.00, 3000.00};

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {

            for (int i = 0; i < nombres.length; i++) {
                raf.writeChars(nombres[i]);

                raf.writeInt(dorsales[i]);

                raf.writeDouble(salarios[i]);
            }

            System.out.println("Fichero creado con exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
