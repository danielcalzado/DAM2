package com.example.danielcalzado;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private AlumnoAdapter adapter;
    private ListView lvAlumnos;
    private ArrayList<Alumno> listaAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar los datos
        cargarDatos();

        lvAlumnos = findViewById(R.id.lvAlumnos);

        // Conectar el adaptador
        adapter = new AlumnoAdapter(this, listaAlumnos);
        lvAlumnos.setAdapter(adapter);
    }

    private void cargarDatos() {
        // CARGA DE DATOS
        // Alumno 1
        Map<String, Double> notas1 = new HashMap<>();
        notas1.put("Matemáticas", 8.5);
        notas1.put("Programación", 9.0);
        notas1.put("Bases de Datos", 7.5);
        listaAlumnos.add(new Alumno("Carlos Pérez", "12345678A", R.drawable.a01, notas1));

        // Alumno 2
        Map<String, Double> notas2 = new HashMap<>();
        notas2.put("Matemáticas", 6.0);
        notas2.put("Programación", 7.0);
        notas2.put("Bases de Datos", 6.5);
        listaAlumnos.add(new Alumno("Ana Gómez", "87654321B", R.drawable.a02, notas2));

        // Alumno 3
        Map<String, Double> notas3 = new HashMap<>();
        notas3.put("Matemáticas", 9.5);
        notas3.put("Programación", 10.0);
        notas3.put("Bases de Datos", 9.0);
        listaAlumnos.add(new Alumno("Luis Martínez", "45678912C", R.drawable.a03, notas3));

        // Alumno 4
        Map<String, Double> notas4 = new HashMap<>();
        notas4.put("Matemáticas", 5.0);
        notas4.put("Programación", 6.0);
        notas4.put("Bases de Datos", 4.5);
        listaAlumnos.add(new Alumno("María Rodríguez", "32165498D", R.drawable.a04, notas4));

        // Alumno 5
        Map<String, Double> notas5 = new HashMap<>();
        notas5.put("Matemáticas", 7.0);
        notas5.put("Programación", 8.0);
        notas5.put("Bases de Datos", 8.5);
        listaAlumnos.add(new Alumno("Jorge Sánchez", "78912345E", R.drawable.a05, notas5));

        // Alumno 6
        Map<String, Double> notas6 = new HashMap<>();
        notas6.put("Matemáticas", 8.0);
        notas6.put("Programación", 7.5);
        notas6.put("Bases de Datos", 9.0);
        listaAlumnos.add(new Alumno("Lucía Fernández", "65432187F", R.drawable.a06, notas6));

        // Alumno 7
        Map<String, Double> notas7 = new HashMap<>();
        notas7.put("Matemáticas", 4.5);
        notas7.put("Programación", 5.5);
        notas7.put("Bases de Datos", 6.0);
        listaAlumnos.add(new Alumno("David López", "14725836G", R.drawable.a07, notas7));

        // Alumno 8
        Map<String, Double> notas8 = new HashMap<>();
        notas8.put("Matemáticas", 9.0);
        notas8.put("Programación", 9.5);
        notas8.put("Bases de Datos", 9.5);
        listaAlumnos.add(new Alumno("Elena Gómez", "36925814H", R.drawable.a08, notas8));

        // Alumno 9
        Map<String, Double> notas9 = new HashMap<>();
        notas9.put("Matemáticas", 6.5);
        notas9.put("Programación", 6.0);
        notas9.put("Bases de Datos", 7.0);
        listaAlumnos.add(new Alumno("Pablo Torres", "95175385I", R.drawable.a09, notas9));

        // Alumno 10
        Map<String, Double> notas10 = new HashMap<>();
        notas10.put("Matemáticas", 7.5);
        notas10.put("Programación", 8.5);
        notas10.put("Bases de Datos", 8.0);
        listaAlumnos.add(new Alumno("Sofía Ruiz", "75395124J", R.drawable.a10, notas10));


    }
}