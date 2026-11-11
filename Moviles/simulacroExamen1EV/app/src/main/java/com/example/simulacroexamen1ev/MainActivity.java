package com.example.simulacroexamen1ev;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Jugador> listaJugadores;
    private JugadorAdapter adapter;
    private ListView listView;

    // Países del desplegable y mapa para vincular cada país con su imagen
    private final String[] naciones = {"Seleccione nación...", "Inglaterra", "Escocia", "Gales", "Irlanda", "Francia", "Italia"};
    private Map<String, Integer> mapaBanderas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Mapeamos los nombres de los países con sus banderas de drawable
                inicializarMapaBanderas();
        // 2. Vinculamos componentes visuales de activity_main.xml
        listView = findViewById(R.id.listViewJugadores);
        ImageButton fabAgregar = findViewById(R.id.fabAgregar);

        // 3. Inicializamos la lista y el adaptador
        listaJugadores = new ArrayList<>();
        adapter = new JugadorAdapter(this, listaJugadores);
        listView.setAdapter(adapter);

        // 4. Registramos el ListView para que detecte el menú contextual al dejar pulsado
        registerForContextMenu(listView);

        // 5. Evento del botón de añadir jugador (+)
        fabAgregar.setOnClickListener(v -> mostrarDialogoAgregarEditar(null, -1));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void inicializarMapaBanderas() {
        mapaBanderas = new HashMap<>();
        // IMPORTANTE: Sustituye R.drawable.flag_xxxx por los nombres reales de las imágenes en tu carpeta res/drawable
        mapaBanderas.put("Inglaterra", R.drawable.reinounido);
        mapaBanderas.put("Escocia", R.drawable.escocia);
        mapaBanderas.put("Gales", R.drawable.gales);
        mapaBanderas.put("Irlanda", R.drawable.irlanda);
        mapaBanderas.put("Francia", R.drawable.francia);
        mapaBanderas.put("Italia", R.drawable.italia);
    }

    // Metodo único para AGREGAR (jugadorExistente == null) o ACTUALIZAR (jugadorExistente != null)
    private void mostrarDialogoAgregarEditar(Jugador jugadorExistente, int posicion) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_jugador, null);
        builder.setView(view);

        EditText etNombre = view.findViewById(R.id.etNombre);
        EditText etValoracion = view.findViewById(R.id.etValoracion);
        Spinner spinnerNacionalidad = view.findViewById(R.id.spinnerNacionalidad);
        ImageView imgPreview = view.findViewById(R.id.imgBanderaPreview);

        // Imagen generica inicial
        imgPreview.setImageResource(R.drawable.espana);

        // Adaptador para rellenar el Spinner con los países
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, naciones);
        spinnerNacionalidad.setAdapter(spinnerAdapter);

        // Al cambiar la selección del Spinner, cambia la imagen automáticamente
        spinnerNacionalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()  {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String seleccion = naciones[pos];
                if (mapaBanderas.containsKey(seleccion)) {
                    imgPreview.setImageResource(mapaBanderas.get(seleccion));
                } else {
                    imgPreview.setImageResource(R.drawable.espana);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Si estamos actualizando, precargamos los datos del jugador en los campos
        if(jugadorExistente != null) {
            builder.setTitle("Actualizar jugador");
            etNombre.setText(jugadorExistente.getNombre());
            etValoracion.setText(String.valueOf(jugadorExistente.getPuntuacion()));
            for (int i = 0; i < naciones.length; i++) {
                if (naciones[i].equals(jugadorExistente.getNacionalidad())) {
                    spinnerNacionalidad.setSelection(i);
                    break;
                }
            }
        } else {
            builder.setTitle("Agregar jugador");
        }

        builder.setPositiveButton("Guardar", null);
        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        // Controlamos el botón Guardar manualmente para validar campos sin cerrar el diálogo si hay errores
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String valoracionStr = etValoracion.getText().toString().trim();
            int seleccionPos = spinnerNacionalidad.getSelectedItemPosition();

            // Validación de campos vacíos o selección nula
            if (nombre.isEmpty() || valoracionStr.isEmpty() || seleccionPos == 0) {
                Toast.makeText(MainActivity.this, "Debe rellenar todos los campos y seleccionar nacionalidad", Toast.LENGTH_SHORT).show();
                return;
            }

            int valoracion = Integer.parseInt(valoracionStr);
            if (valoracion < 0 || valoracion > 10) {
                Toast.makeText(MainActivity.this, "La valoración debe estar entre 0 y 10", Toast.LENGTH_SHORT).show();
                return;
            }

            String nacionalidad = naciones[seleccionPos];
            int resBandera = mapaBanderas.get(nacionalidad);

            if (jugadorExistente == null) {
                // Nuevo registro
                listaJugadores.add(new Jugador(nombre, nacionalidad, valoracion, resBandera));
            } else {
                // Edición de registro existente
                jugadorExistente.setNombre(nombre);
                jugadorExistente.setNacionalidad(nacionalidad);
                jugadorExistente.setPuntuacion(valoracion);
                jugadorExistente.setBanderaResId(resBandera);
            }

            adapter.notifyDataSetChanged();
            dialog.dismiss();
        });
    }

    // --- 1. MENÚ CONTEXTUAL (Mantener pulsado para Eliminar / Actualizar) ---

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int posicion = info.position;
        Jugador jugador = listaJugadores.get(posicion);

        if (item.getItemId() == R.id.opcion_eliminar) {
            confirmarEliminacion(jugador, posicion);
            return true;
        } else if (item.getItemId() == R.id.opcion_actualizar) {
            mostrarDialogoAgregarEditar(jugador, posicion);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private void confirmarEliminacion(Jugador jugador, int posicion) {
        new AlertDialog.Builder(this)
                .setTitle("Eliminar Registro")
                .setMessage("¿Seguro que deseas eliminar el registro: \"" + jugador.getNombre() + "\"?")
                .setPositiveButton("Confirmar", (dialog, which) -> {
                    listaJugadores.remove(posicion);
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    // --- 2. MENÚ SUPERIOR DE ORDENACIÓN ---

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_ordenar) {
            // Ordena la lista de mayor a menor según la puntuación
            Collections.sort(listaJugadores, (j1, j2) -> Integer.compare(j2.getPuntuacion(), j1.getPuntuacion()));
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

