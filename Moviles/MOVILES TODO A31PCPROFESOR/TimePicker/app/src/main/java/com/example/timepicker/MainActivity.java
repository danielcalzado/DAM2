package com.example.timepicker;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TimePicker tpHora;
    private TextView tvHora;

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

        tpHora=(TimePicker) findViewById(R.id.tpHora);
        tvHora=(TextView) findViewById(R.id.tvHora);

        tpHora.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String cadHora="", cadMin="";
                cadHora=""+hourOfDay;
                if(minute<10)
                    cadMin="0"+minute;
                else
                    cadMin=""+minute;

                tvHora.setText(cadHora + ":" + cadMin);
            }
        });

    }
}