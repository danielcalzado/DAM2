package lecturaEscritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EJ15 {
    public static void main(String[] args) {
        // Ejemplo de uso: Marzo (3) empezando en Martes ('M')
        generarCalendarioMes(3, 'M');
    }

    public static void generarCalendarioMes(int numMes, char diaSemanaInicio) {
        // 1. Validar el número de mes (debe ser entre 1 y 12)
        if (numMes < 1 || numMes > 12) {
            System.err.println("Error: El número de mes debe estar entre 1 y 12.");
            return;
        }

        // Convertir la letra introducida a mayúscula para simplificar
        diaSemanaInicio = Character.toUpperCase(diaSemanaInicio);

        // 2. Validar que la letra del día de la semana sea correcta
        char[] diasValidos = {'L', 'M', 'X', 'J', 'V', 'S', 'D'};
        int indiceDia = -1;

        for (int i = 0; i < diasValidos.length; i++) {
            if (diasValidos[i] == diaSemanaInicio) {
                indiceDia = i; // Guardamos la posición del día inicial (0 para 'L', 1 para 'M', etc.)
                break;
            }
        }

        if (indiceDia == -1) {
            System.err.println("Error: El día inicial debe ser 'L', 'M', 'X', 'J', 'V', 'S' o 'D'.");
            return;
        }

        // 3. Obtener el número de días que tiene el mes
        int totalDias = obtenerDiasDelMes(numMes);

        // 4. Construir el nombre del archivo: "mes" + numMes + ".txt"
        String nombreArchivo = "src/lecturaEscritura/text/mes" + numMes + ".txt";

        // 5. Escribir el contenido en el archivo
        try (FileWriter fw = new FileWriter(nombreArchivo);
             PrintWriter pw = new PrintWriter(fw)) {

            for (int dia = 1; dia <= totalDias; dia++) {
                // Escribir el día actual y la letra correspondiente del día de la semana
                pw.print(dia + "" + diasValidos[indiceDia]);

                // Avanzar al siguiente día de la semana (y reiniciar a 'L' si llegamos a 'D')
                indiceDia = (indiceDia + 1) % 7;
            }

            System.out.println("Calendario generado con éxito en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error de E/S al escribir el fichero: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar para calcular la cantidad de días según el número de mes.
     * (Asumimos año no bisiesto, febrero = 28 días)
     */
    private static int obtenerDiasDelMes(int mes) {
        switch (mes) {
            case 2:
                return 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }
}
