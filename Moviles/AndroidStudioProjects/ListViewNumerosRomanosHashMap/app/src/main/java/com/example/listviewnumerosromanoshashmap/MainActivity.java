package com.example.listviewnumerosromanoshashmap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, View.OnClickListener {

    private TextView tvNumeroRomano;
    private ListView lvNumeros;
    private EditText etNumeroInsertarCardinal, etNumeroInsertarRomano;
    private Button btnInsertar;
    private String[] numerosCardinales = {"uno","dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte", "cincuenta", "cien"}; //Otra alternativa para construir la lista
    private String[] numerosRomanos = {"I", "II", "III", "IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII", "XIX", "XX", "L", "C"};

    private SimpleAdapter simpleAdapter;
    private List<Map<String, String>> listaMapaDatos;


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

        tvNumeroRomano=(TextView) findViewById(R.id.tvNumeroRomano);
        lvNumeros=(ListView) findViewById(R.id.lvNumeros);
        etNumeroInsertarCardinal=(EditText) findViewById(R.id.etNumeroInsertarCardinal);
        etNumeroInsertarRomano=(EditText) findViewById(R.id.etNumeroInsertarRomano);
        btnInsertar=(Button) findViewById(R.id.btnInsertar);
        btnInsertar.setOnClickListener(this);

        listaMapaDatos=new ArrayList<>();
        for(int i=0; i<numerosCardinales.length; i++){
            Map<String, String> mapaDatosNumeros = new HashMap<>();
            mapaDatosNumeros.put("numeroCardinalKey", numerosCardinales[i]);
            mapaDatosNumeros.put("numeroRomanoKey", numerosRomanos[i]);
            listaMapaDatos.add(mapaDatosNumeros);
        }

        //Definimos claves de origen (FROM) y los IDs de destino del XML (TO)
        String[] from = {"numeroCardinalKey", "numeroRomanoKey"};
        int[] to = {R.id.tvNumeroCardinal, R.id.tvNumeroRomano};

        simpleAdapter=new SimpleAdapter(this, listaMapaDatos, R.layout.item_layout_propio_complejo, from, to);
        lvNumeros.setAdapter(simpleAdapter);
        lvNumeros.setOnItemClickListener(this);

        lvNumeros.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvNumeroRomano.setText(listaMapaDatos.get(position).get("numeroRomanoKey"));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //Sin pedir confirmacion
        //listaMapaDatos.remove(position);
        //simpleAdapter.notifyDataSetChanged();
        //Pidiendo confirmacion (AlertDialog)
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Eliminación de dato");
        builder.setMessage("¿Desea borrrar el item?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listaMapaDatos.remove(position);
                simpleAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Lista intacta", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        return true;
    }

    @Override
    public void onClick(View v) {
        if(etNumeroInsertarCardinal.getText().toString().equals("") || etNumeroInsertarRomano.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Debe rellenar los dos campo de texto", Toast.LENGTH_LONG).show();
        else{
            Map<String, String> mapaDatosNumeros = new HashMap<>();
            mapaDatosNumeros.put("numeroCardinalKey", etNumeroInsertarCardinal.getText().toString());
            mapaDatosNumeros.put("numeroRomanoKey", etNumeroInsertarRomano.getText().toString());
            listaMapaDatos.add(mapaDatosNumeros);
            simpleAdapter.notifyDataSetChanged();
            etNumeroInsertarCardinal.setText("");
            etNumeroInsertarRomano.setText("");
        }
    }


}