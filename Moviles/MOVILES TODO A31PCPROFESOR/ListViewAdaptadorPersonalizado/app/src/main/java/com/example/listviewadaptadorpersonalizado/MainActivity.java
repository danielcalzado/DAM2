package com.example.listviewadaptadorpersonalizado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvAgenda;
    private ArrayList <ModeloPersona> personas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvAgenda=(ListView) findViewById(R.id.lvAgenda);
        personas=new ArrayList<ModeloPersona>();

        ModeloPersona m1=new ModeloPersona();
        m1.setNombre("Pepe");
        m1.setDescripcion("Tranquilo y con ganas de vivir");
        m1.setCodigo(1);
        m1.setFoto(R.drawable.capitancavernicola);

        ModeloPersona m2=new ModeloPersona();
        m2.setNombre("Rosa");
        m2.setDescripcion("Ambiciosa y sin complejos");
        m2.setCodigo(2);
        m2.setFoto(R.drawable.hongkongphooey);

        ModeloPersona m3=new ModeloPersona();
        m3.setNombre("Chiky");
        m3.setDescripcion("Capaz de todo por amor");
        m3.setCodigo(3);
        m3.setFoto(R.drawable.pablo);

        ModeloPersona m4=new ModeloPersona();
        m4.setNombre("Piluca");
        m4.setDescripcion("Herida pero dispuesta a perdonar");
        m4.setCodigo(4);
        m4.setFoto(R.drawable.pierre);

        personas.add(m1);
        personas.add(m2);
        personas.add(m3);
        personas.add(m4);

        Adaptador adaptador = new Adaptador(getApplicationContext(), personas);

        lvAgenda.setAdapter(adaptador);
        lvAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetallePersona.class);
                intent.putExtra("persona", personas.get(position));
                startActivity(intent);
            }
        });


    }
}