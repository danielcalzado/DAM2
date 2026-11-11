package com.example.listviewadaptadorpersonalizado;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetallePersona extends AppCompatActivity {

    private TextView tvDetalleNombre, tvDetalleDescricion, tvDetalleCodigo;
    private ImageView imgvDetalleFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_persona);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvDetalleNombre=(TextView) findViewById(R.id.tvDetalleNombre);
        tvDetalleDescricion=(TextView) findViewById(R.id.tvDetalleDescripcion);
        imgvDetalleFoto=(ImageView) findViewById(R.id.imgvDetalleFoto);
        tvDetalleCodigo=(TextView) findViewById(R.id.tvDetalleCodigo);

        Bundle bundle=getIntent().getExtras();
        ModeloPersona persona = (ModeloPersona) bundle.getSerializable("persona");
        tvDetalleNombre.setText(persona.getNombre());
        tvDetalleDescricion.setText(persona.getDescripcion());
        imgvDetalleFoto.setImageResource(persona.getFoto());
        tvDetalleCodigo.setText(persona.getCodigo()+"");

    }
}