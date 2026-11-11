package com.example.a06_checkboxcomidas;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox cbDesayuno, cbComida, cbCena;
    private TextView tvPrecio;
    private double precio;

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

        cbDesayuno=(CheckBox) findViewById(R.id.cbDesayuno);
        cbComida=(CheckBox) findViewById(R.id.cbComida);
        cbCena=(CheckBox) findViewById(R.id.cbCena);
        tvPrecio=(TextView) findViewById(R.id.tvPrecio);

        cbDesayuno.setOnCheckedChangeListener(this);
        cbComida.setOnCheckedChangeListener(this);
        cbCena.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
       precio=0.;
       if(cbDesayuno.isChecked())
           precio+=10;
       if(cbComida.isChecked())
           precio+=25;
       if(cbCena.isChecked())
            precio+=30;

       tvPrecio.setText(precio+"");

    }
}