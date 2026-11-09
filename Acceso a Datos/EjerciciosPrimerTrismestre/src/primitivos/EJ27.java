package primitivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * EJ27 - Añadir un nuevo empleado al final.
 */

public class EJ27 {
    public static void main(String[] args) {
        String ruta = "src/primitivos/archivos/AleatorioEmple.dat";
        File fichero = new File(ruta);

        // Datos del nuevo empleado a insertar
        String nuevoApellido = "GARCIA";
        int nuevoDepartamento = 40;
        double nuevoSalario = 1850.50;

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            
            // 1. Nos posicionamos justo al final del archivo
            raf.seek(raf.length());

            // 2. Calculamos el nuevo ID autoincremental según el número de registros existentes
            int nuevoId = (int) (raf.length() / 36) + 1;

            // 3. Escribimos los datos respetando los 36 bytes del registro
            // ID (4 bytes)
            raf.writeInt(nuevoId);

            // Apellido: exactamente 10 caracteres (20 bytes)
            StringBuffer buffer = new StringBuffer(nuevoApellido);
            buffer.setLength(10);
            raf.writeChars(buffer.toString());

            // Departamento (4 bytes)
            raf.writeInt(nuevoDepartamento);

            // Salario (8 bytes)
            raf.writeDouble(nuevoSalario);

            System.out.println("Empleado añadido con éxito al final del archivo con ID: " + nuevoId);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
