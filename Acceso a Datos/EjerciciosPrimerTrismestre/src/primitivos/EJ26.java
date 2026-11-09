package primitivos;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * EJ26 - Consultar los datos del empleado con identificador 5. No es necesario recorrer todos los
registros anteriores, para acceder a su posición, tener en cuenta que cada empleado ocupa 36
bytes.
 */

public class EJ26 {
    public static void main(String[] args) {
        String ruta = "src/primitivos/archivos/AleatorioEmple.dat";
        int idBuscado = 5;
        int tamanoRegistro = 36;

        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            
            // Calculamos la posición: (ID - 1) * 36 bytes
            long posicion = (idBuscado - 1) * (long) tamanoRegistro;

            // Comprobamos que esa posición no sobrepase la longitud del archivo
            if (posicion >= raf.length()) {
                System.out.println("El empleado con ID " + idBuscado + " no existe.");
                return;
            }

            // Mover el puntero directamente a la posición 144
            raf.seek(posicion);

            // Leer los datos en el orden exacto del registro:
            int id = raf.readInt();
            
            // Apellido: 10 caracteres (20 bytes)
            char[] apellidoChars = new char[10];
            for (int i = 0; i < apellidoChars.length; i++) {
                apellidoChars[i] = raf.readChar();
            }
            String apellido = new String(apellidoChars).trim();

            int departamento = raf.readInt();
            double salario = raf.readDouble();

            // Mostrar los datos consultados
            System.out.println("--- Datos del Empleado " + idBuscado + " ---");
            System.out.println("ID: " + id);
            System.out.println("Apellido: " + apellido);
            System.out.println("Departamento: " + departamento);
            System.out.println("Salario: " + salario);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
