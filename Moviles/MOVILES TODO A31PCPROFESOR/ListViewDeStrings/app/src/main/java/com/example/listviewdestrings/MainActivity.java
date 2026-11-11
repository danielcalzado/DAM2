package com.example.listviewdestrings;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[]nombres={"Pedro", "Juan", "Ana", "Rosa", "Mario", "Colegio", "Academia", "Noelia", "Hugo", "Vega", "Ana María", "Carlos", "Gema", "María José", "Alfredo", "Pedrito", "Bryan"};
    private String[]sexos={"V", "V", "M", "M", "V", "X", "X", "M", "V", "M", "M", "V", "M", "M", "V", "V", "V"};
    private String[]telefonos={"11111111", "222222222", "333333333", "444444444","555555555", "666666666", "777777777", "888888888","999999999", "000000000", "11112222", "3333344444","55555666", "7777788888", "7777788882", "7777788881", "7777788880"};

    private ListView lvAgenda;
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

        lvAgenda=(ListView)findViewById(R.id.lvAgenda);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, nombres);
        lvAgenda.setAdapter(arrayAdapter);

        lvAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "El teléfono elegido es: " + telefonos[position], Toast.LENGTH_LONG).show();
            }
        });

        lvAgenda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "El sexo es: " + sexos[position], Toast.LENGTH_LONG).show();
                //return false; //Lo comento para que no haga implicita/ el clic corto
                return true;
            }
        });

    }
}