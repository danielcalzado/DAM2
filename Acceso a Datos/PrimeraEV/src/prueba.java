import java.io.File;
import java.io.IOException;

public class prueba {
    public static void main(String[] args) {
        try {
        File f = new File("fichero.txt");
        f.createNewFile(); //para poderlo renombrar debe existir
        File f2 = new File("nuevo_nombre.txt");
        f.renameTo(f2); //renombra "fichero.txt" a "nuevo_nombre.txt"
        } catch (IOException e) { 
            System.out.println("Error: " + e.getMessage());
        }
    }
}
