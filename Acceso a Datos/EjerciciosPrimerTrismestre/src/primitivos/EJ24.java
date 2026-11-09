package primitivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * EJ24 -  Insertar el apellido, departamento y salario de empleados en un fichero aleatorio. Se obtienen de arrays y se
insertan de forma secuencial, por lo que no será necesario usar el método seek(). Por cada empleado se insertará
también un identificador, que comenzará en 1. La longitud del registro de cada empleado es 36 bytes:
 */
public class EJ24 {
    public static void main(String[] args) {
        String ruta = "src/primitivos/archivos/AleatorioEmple.dat";
        File fichero = new File(ruta);

        // Arrays de datos origen
        String[] apellidos = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "CALZADO", "CASILLAS", "REY"};
        int[] departamentos = {10, 20, 10, 10, 30, 30, 20};
        double[] salarios = {1000.45, 2400.60, 3000.00, 1500.00, 2200.00, 1430.00, 2000.00};

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            
            for (int i = 0; i < apellidos.length; i++) {
                // 1. ID: entero autoincremental empezando en 1 (4 bytes)
                raf.writeInt(i + 1); 

                // 2. APELLIDO: Ajustar a exactamente 10 caracteres (20 bytes)
                StringBuffer buffer = new StringBuffer(apellidos[i]);
                buffer.setLength(10); // Rellena con caracteres nulos o recorta si supera 10
                raf.writeChars(buffer.toString()); 

                // 3. DEPARTAMENTO: entero (4 bytes)
                raf.writeInt(departamentos[i]); 

                // 4. SALARIO: double (8 bytes)
                raf.writeDouble(salarios[i]); 
            }

            System.out.println("Fichero AleatorioEmple.dat creado y poblado con éxito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
