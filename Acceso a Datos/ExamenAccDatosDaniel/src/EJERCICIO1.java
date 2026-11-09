import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


/**
 * 
 * 1. Menu
 * 2. Introducir jugadores
 * 3. opcion 1: listar jugadores del fichero Jugadores.dat
 * 4. opcion 2: introducir nuevo jugador al final
 * 5. opcion 3: incrementar el salario de un jugador
 * 6. opcion 4: salir
 */

public class EJERCICIO1 {
    static Scanner sc = new Scanner(System.in);
    static String fichero = "src/Jugadores.dat";
    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) { 
            System.out.println("-------------------");
            System.out.println("GESTION DE JUGADORES");
            System.out.println("-------------------");
            System.out.println("1. Listar Jugadores desde archivo aleatorio");
            System.out.println("2. Nuevo Jugador al final de la lista");
            System.out.println("3. Modificar el salario del jugador de una posición");
            System.out.println("4. Salir");
            System.out.println("-------------------");
            System.out.print("Introduzca una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    listarJugadores();
                    break;
                case 2:
                    introducirJugador();
                case 3:
                    // Incrementar el salario de un jugador en la cantidad solicitada al usuario
                case 4:
                    System.out.println("Adios...");
                    seguir = false;
                    break;
            }

        }
    }

    public static void listarJugadores() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
            
            while (true) {
                String nombre = dis.readUTF();
                int dorsal = dis.readInt();
                double salario = dis.readDouble();

                System.out.println("Nombre: " + nombre);
                System.out.println(", Dorsal: " + dorsal);
                System.out.println(", Salario: " + salario);
            }


        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void introducirJugador() {
        String nombreApellidos;
        int dorsal;
        double salario;

        System.out.print("nombre y apellidos: ");
        nombreApellidos = sc.next();
        sc.nextLine();
        System.out.print("dorsal: ");
        dorsal = sc.nextInt();
        System.out.print("salario: ");
        salario = sc.nextDouble();

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            // Situarse al final del fichero
            raf.seek(raf.length());

            // Nombre y apellidos limitar
            StringBuffer buffer = new StringBuffer(nombreApellidos);
            buffer.setLength(20);
            raf.writeChars(buffer.toString());

            raf.writeInt(dorsal);
            raf.writeDouble(salario);

            System.out.println("Empleado añadido con exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
