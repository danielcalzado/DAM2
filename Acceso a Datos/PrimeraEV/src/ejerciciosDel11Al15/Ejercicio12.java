package ejerciciosDel11Al15;

import java.io.File;
import java.util.Scanner;

/**
 * Escribe un programa que reciba el nombre de un archivo que almacena una serie de cantidades enteras positivas e imprima
su suma
 */
public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = null;
        File fichero;
        int total = 0;

        try {
            System.out.println("Escribe el fichero a leer: ");
            sc = new Scanner(System.in);
            fichero = new File(sc.nextLine());
            sc.close();

            sc = new Scanner(fichero);
            while (sc.hasNext()) {
                total += sc.nextInt();
            }

            System.out.println("Total: " + total);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }




        

        

    }
}
