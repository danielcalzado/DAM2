import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EJERCICIO3parte2 {
    public static void main(String[] args) {
        String ruta = "src/articulos.dat";

        try (FileInputStream fis = new FileInputStream(ruta);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            System.out.println("--- Contenido del archivo ---");
            
            // Bucle por si hay más de una Persona grabada en el archivo
            while (true) {
                Articulo a = (Articulo) ois.readObject();
                System.out.println(a);
            }

        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró la clase Persona.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
