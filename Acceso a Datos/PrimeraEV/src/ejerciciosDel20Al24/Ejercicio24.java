package ejerciciosDel20Al24;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio24 {
    static final int LONG_APELLIDO = 15;
    static final int LONG_DEPTO = 9;
    static final int LONG_REGISTRO = 36;

    public static void main(String[] args) {
        String[] apellidos = {"Garcia", "López", "Martínez", "Fernández"};
        String[] departamentos = {"Ventas", "IT", "RRHH", "Finanzas"};
        double[] salarios = {1800.50, 2200.00, 1950.75, 2600.25};

        String fichero = "empleados.dat";

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            for (int i = 0; i < apellidos.length; i++) {
                int id = i + 1;

                raf.writeInt(id);
                raf.writeBytes(ajustar(apellidos[i], LONG_APELLIDO));
                raf.writeBytes(ajustar(departamentos[i], LONG_DEPTO));
                raf.writeDouble(salarios[i]);
            }

            System.out.println("Empleados insertados: " + apellidos.length);
            System.out.println("Tamaño del fichero: " + raf.length() + " bytes (esperado: " + (apellidos.length * LONG_REGISTRO) + ")");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        
    }
    static String ajustar(String texto, int longitud) {
        if (texto.length() > longitud) {
            return texto.substring(0, longitud);
        }
        StringBuilder sb = new StringBuilder(texto);
        while (sb.length() < longitud) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
