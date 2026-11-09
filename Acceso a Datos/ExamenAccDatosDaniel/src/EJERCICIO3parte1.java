import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EJERCICIO3parte1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Articulo a = null;
        boolean disponible = true;
        int cantidad = 0;
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            while (cantidad <= 0) {
                System.out.print("Cantidad: ");
                cantidad = sc.nextInt();
                if (cantidad < 0) {
                    System.out.println("La cantidad no puede ser negativa.");
                }
            }
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
            System.out.print("Disponible: (s/n): ");
            String dis = sc.next();
            switch (dis) {
                case "s":
                    disponible = true;
                    break;
                case "n":
                    disponible = false;
                    break;
            }
            
            a = new Articulo(nombre, cantidad, precio, disponible);
        } catch (InputMismatchException e) {
            e.getMessage();
        }

        try (FileOutputStream fos = new FileOutputStream("src/articulos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                if (a != null) {
                    oos.writeObject(a);
                    System.out.println();

                    System.out.println("Articulo serializado con éxito.");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
