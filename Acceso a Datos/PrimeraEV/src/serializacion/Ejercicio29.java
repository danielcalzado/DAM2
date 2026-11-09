package serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio29 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        FileOutputStream fs = new FileOutputStream("datos.obj");
        ObjectOutputStream os = new ObjectOutputStream(fs);

        String nombres[] = {"Dani" , "Sheyla", "Darius"};
        int edades[] = {19, 20, 21};


        for (int i = 0; i < edades.length; i++) {
            Persona persona = new Persona(edades[i], nombres[i]);
            os.writeObject(persona);
            System.out.println("Se han grabado los datos de la persona.");
        }
        os.close();
    }
}
