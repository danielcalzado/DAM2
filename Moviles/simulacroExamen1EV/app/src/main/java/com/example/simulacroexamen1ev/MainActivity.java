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

/*
 * Controlador principal de la aplicación.
 * Gestiona el ciclo de vida de la pantalla, los eventos de usuario (clics y menús),
 * la manipulación de la lista en memoria y la apertura de los cuadros de diálogo.
 */

public class MainActivity extends AppCompatActivity {

    // Lista dinámica en memoria que almacena los objetos Jugador
    private ArrayList<Jugador> listaJugadores;
    // Puente entre listaJugadores y la interfaz visual del ListView
    private JugadorAdapter adapter;
    private ListView listView;

    // Opciones que mostrará el desplegable (Spinner). La posición 0 actúa como texto por defecto.
    private final String[] naciones = {"Seleccione nación...", "Inglaterra", "Escocia", "Gales", "Irlanda", "Francia", "Italia"};
    // Diccionario (Clave -> Valor) para asociar el nombre de cada país (String) con el ID de su bandera (Integer)
    private Map<String, Integer> mapaBanderas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Configuramos nuestra Toolbar personalizada como la barra de acción oficial de la pantalla
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. Rellenamos el diccionario de países y banderas
                inicializarMapaBanderas();
        // 3. Vinculamos los elementos visuales del XML con variables Java
        listView = findViewById(R.id.listViewJugadores);
        ImageButton fabAgregar = findViewById(R.id.fabAgregar);

        // 4. Inicializamos la lista vacía y le conectamos el adaptador al ListView
        listaJugadores = new ArrayList<>();
        adapter = new JugadorAdapter(this, listaJugadores);
        listView.setAdapter(adapter);

        // 5. Habilitamos el menú contextual (Eliminar/Actualizar) al mantener pulsada una fila del ListView
        registerForContextMenu(listView);

        // 6. Al pulsar el botón '+', abrimos el diálogo en modo CREACIÓN (pasando null)
        fabAgregar.setOnClickListener(v -> mostrarDialogoAgregarEditar(null, -1));
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

    /*
     * Construye y muestra el AlertDialog para crear o modificar un jugador.
     * @param jugadorExistente Objeto a editar (null si se va a crear uno nuevo).
     * @param posicion Índice del jugador en la lista (-1 si es nuevo).
     */
    private void mostrarDialogoAgregarEditar(Jugador jugadorExistente, int posicion) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // "Inflamos" el archivo dialog_jugador.xml para convertirlo en una vista manipulable
        View view = getLayoutInflater().inflate(R.layout.dialog_jugador, null);
        builder.setView(view);

        // Referenciamos los controles que están DENTRO del diálogo (por eso usamos view.findViewById)
        EditText etNombre = view.findViewById(R.id.etNombre);
        EditText etValoracion = view.findViewById(R.id.etValoracion);
        Spinner spinnerNacionalidad = view.findViewById(R.id.spinnerNacionalidad);
        ImageView imgPreview = view.findViewById(R.id.imgBanderaPreview);

        // Asignamos la imagen genérica del torneo por defecto
        imgPreview.setImageResource(R.drawable.espana);

        // Cargamos el array 'naciones' dentro del Spinner usando un adaptador estándar de Android
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, naciones);
        spinnerNacionalidad.setAdapter(spinnerAdapter);

        // Escuchador del Spinner: cada vez que el usuario elige un país, cambia la imagen de vista previa
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

        // Diferenciamos si estamos editando o creando
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

        // Ponemos 'null' en el botón Guardar para programarlo después y evitar que cierre el diálogo si hay errores
        builder.setPositiveButton("Guardar", null);
        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        // Programamos el comportamiento del botón Guardar una vez el diálogo ya es visible
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String valoracionStr = etValoracion.getText().toString().trim();
            int seleccionPos = spinnerNacionalidad.getSelectedItemPosition();

            // Validación 1: Comprobar que no haya campos vacíos ni esté marcada la opción 0 ("Seleccione nación...")
            if (nombre.isEmpty() || valoracionStr.isEmpty() || seleccionPos == 0) {
                Toast.makeText(MainActivity.this, "Debe rellenar todos los campos y seleccionar nacionalidad", Toast.LENGTH_SHORT).show();
                return; // Corta la ejecución y mantiene el diálogo abierto
            }

            // Validación 2: Comprobar que la puntuación esté en el rango permitido (0 a 10)
            int valoracion = Integer.parseInt(valoracionStr);
            if (valoracion < 0 || valoracion > 10) {
                Toast.makeText(MainActivity.this, "La valoración debe estar entre 0 y 10", Toast.LENGTH_SHORT).show();
                return;
            }

            String nacionalidad = naciones[seleccionPos];
            int resBandera = mapaBanderas.get(nacionalidad);

            if (jugadorExistente == null) {
                // MODO CREACIÓN: Añadimos un nuevo objeto al ArrayList
                listaJugadores.add(new Jugador(nombre, nacionalidad, valoracion, resBandera));
            } else {
                // MODO EDICIÓN: Actualizamos los atributos del objeto que ya estaba en la lista
                jugadorExistente.setNombre(nombre);
                jugadorExistente.setNacionalidad(nacionalidad);
                jugadorExistente.setPuntuacion(valoracion);
                jugadorExistente.setBanderaResId(resBandera);
            }

            // Avisamos al adaptador de que los datos han cambiado para que redibuje el ListView
            adapter.notifyDataSetChanged();
            dialog.dismiss(); // Cerramos el diálogo manualmente
        });
    }

    // --- 1. MENÚ CONTEXTUAL (Mantener pulsado para Eliminar / Actualizar) ---

    // Infla el diseño context_menu.xml cuando el usuario mantiene pulsado un elemento
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Gestiona qué opción eligió el usuario en el menú flotante (Eliminar o Actualizar)
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

    // Muestra un diálogo de seguridad antes de borrar definitivamente al jugador
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

    // --- MENÚ SUPERIOR DE LA TOOLBAR ---

    // Infla el botón de ordenar (main_menu.xml) dentro de la barra superior
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Se ejecuta al pulsar el icono de ordenar en la barra superior
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

