package com.example.togglebuttonswitchswitchcompact;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ToggleButton tb;
    private Switch sw;
    private SwitchCompat swc;
    private TextView tv1, tv2, tv3;

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

        tb=(ToggleButton) findViewById(R.id.tb);
        sw=(Switch) findViewById(R.id.sw);
        swc=(SwitchCompat) findViewById(R.id.swc);
        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
        tv3=(TextView) findViewById(R.id.tv3);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv1.setText("Control seleccionado");
                    tv1.setTextColor(getResources().getColor(R.color.mirojo));
                }
                else {
                    tv1.setText("Control no seleccionado");
                    tv1.setTextColor(getResources().getColor(R.color.gris));
                }
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv2.setText("Control seleccionado");
                    tv2.setTextColor(getResources().getColor(R.color.miverde));
                }
                else {
                    tv2.setText("Control no seleccionado");
                    tv2.setTextColor(getResources().getColor(R.color.gris));
                }
            }
        });

        swc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv3.setText("Control seleccionado");
                    tv3.setTextColor(getResources().getColor(R.color.miazul));
                }
                else {
                    tv3.setText("Control no seleccionado");
                    tv3.setTextColor(getResources().getColor(R.color.gris));
                }
            }
        });

    }
}