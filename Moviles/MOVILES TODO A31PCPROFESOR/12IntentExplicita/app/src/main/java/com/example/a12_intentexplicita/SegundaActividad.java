package com.example.a12_intentexplicita;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaActividad extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSaludo;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_actividad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvSaludo=(TextView) findViewById(R.id.tvSaludo);
        btnSalir=(Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(this);

        Bundle bundle=getIntent().getExtras();
        if(bundle!= null) {
            tvSaludo.setText("Hola " + bundle.getString("nombre") + "!!!" );
        }


    }

    @Override
    public void onClick(View v) {
        finishAffinity();
    }
}