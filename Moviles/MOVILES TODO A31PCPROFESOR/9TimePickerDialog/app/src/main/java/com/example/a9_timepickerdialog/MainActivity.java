package com.example.a9_timepickerdialog;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnHora;
    private TextView tvHora;
    private int hora, minutos;

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

        btnHora=(Button) findViewById(R.id.btnHora);
        tvHora=(TextView) findViewById(R.id.tvHora);
        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                hora=calendar.get(Calendar.HOUR_OF_DAY);
                minutos=calendar.get(Calendar.MINUTE);
                Toast.makeText(getApplicationContext(), hora+":"+minutos, Toast.LENGTH_LONG).show();

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(minute<10)
                            tvHora.setText(hourOfDay+":0" + minute);
                        else
                            tvHora.setText(hourOfDay+":" + minute);
                    }
                }, hora, minutos, true);
                timePickerDialog.show();
            }
        });
    }
}