
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PruebaFileWriter {
    public static void main(String[] args) {
        try {
            PrintWriter out = null;
            out = new PrintWriter(new FileWriter("c:\\salida.txt", true));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while (!(s = br.readLine()).equals("salir")){
                out.println(s);
            }
            out.close();
            } catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }
}
