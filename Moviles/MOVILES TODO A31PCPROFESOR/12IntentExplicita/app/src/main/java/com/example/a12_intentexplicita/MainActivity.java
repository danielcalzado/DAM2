package com.example.a12_intentexplicita;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private Button btnIrASergundaActividad;

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

        etNombre=(EditText) findViewById(R.id.etNombre);
        btnIrASergundaActividad=(Button) findViewById(R.id.btnIrASegundaActivad);
        btnIrASergundaActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadenaNombre="";
                cadenaNombre=etNombre.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SegundaActividad.class);
                intent.putExtra("nombre", cadenaNombre);
                startActivity(intent);
            }
        });

    }
}