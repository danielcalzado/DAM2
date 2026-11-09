import java.io.File;
import java.io.IOException;

public class ConversorRutas {
    public static void main(String[] args) throws IOException {
        // 1. Ruta base simulada usando un array de carpetas para construirla de forma
        // limpia
        String[] componentesRuta = { "usuarios", "documentos", "proyecto", "archivo.txt" };
        // 2. Construir la ruta usando File.separator
        StringBuilder rutaConstruida = new StringBuilder();
        for (int i = 0; i < componentesRuta.length; i++) {
            rutaConstruida.append(componentesRuta[i]);
            if (i < componentesRuta.length - 1) {
                rutaConstruida.append(File.separator);
            }
        }
        System.out.println("Ruta generada para el SO actual: " + rutaConstruida.toString());
        // 3. Crear el objeto File con la ruta adaptada
        File archivo = new File(rutaConstruida.toString());
        // archivo.createNewFile(); //Generación en disco
        // 4. Mostrar información del archivo/directorio
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        // 5. Ejemplo de normalización si recibes una ruta con separadores incorrectos
        String rutaMixta = "carpeta/subcarpeta\\archivo2.txt";
        String rutaNormalizada = rutaMixta.replace("/", File.separator).replace("\\", File.separator);
        System.out.println("Ruta normalizada automáticamente: " + rutaNormalizada);
    }
}