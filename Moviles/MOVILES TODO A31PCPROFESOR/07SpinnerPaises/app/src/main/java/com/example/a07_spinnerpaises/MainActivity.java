package com.example.a07_spinnerpaises;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spPaises;
    private ImageView imgvBanderas;
    private TextView tvPoblacion;

    String []nombres={"Seleccione país", "Alemania", "China", "España", "Francia", "Reino Unido"};
    int []banderas={0 , R.drawable.alemania, R.drawable.china, R.drawable.espana, R.drawable.francia, R.drawable.reino_unido};
    String []poblaciones={"", "83.020.000", "1.400.000.000", "46.940.000", "67.060.000", "67.000.000"};
    String []urls={"", "https://es.wikipedia.org/wiki/Alemania", "https://es.wikipedia.org/wiki/China", "https://es.wikipedia.org/wiki/España", "https://es.wikipedia.org/wiki/Francia", "https://es.wikipedia.org/wiki/Reino_Unido"};


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

        spPaises=(Spinner) findViewById(R.id.spPaises);
        imgvBanderas=(ImageView) findViewById(R.id.imgvBanderas);
        tvPoblacion=(TextView) findViewById(R.id.tvPoblacion);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, nombres);
        spPaises.setAdapter(arrayAdapter);

        spPaises.setSelection(arrayAdapter.NO_SELECTION, false);

        spPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "posicion: "+position, Toast.LENGTH_LONG).show();
                imgvBanderas.setImageResource(banderas[position]);

                imgvBanderas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(position!=0) {
                            Intent i = new Intent("android.intent.action.VIEW", Uri.parse(urls[position]));
                            startActivity(i);
                        }
                    }
                });


                tvPoblacion.setText("La población es " +poblaciones[position] + " personas");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}











