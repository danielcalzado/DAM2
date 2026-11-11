package com.example.simulacroexamen1ev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * Adaptador personalizado que extiende BaseAdapter para conectar la lista
 * en memoria (ArrayList<Jugador>) con la interfaz gráfica del ListView.
 *
 * Responsabilidades:
 * 1. Inflar el diseño personalizado de la celda (item_jugador.xml).
 * 2. Reciclar las vistas de las celdas (convertView) para no saturar la memoria al hacer scroll.
 * 3. Extraer los datos de cada objeto Jugador y mapearlos a sus controles visuales
 *    correspondientes (Nombre, Nacionalidad, Puntuación e Imagen de la bandera).
 */
public class JugadorAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Jugador> jugadores;

    public JugadorAdapter(Context context, ArrayList<Jugador> jugadores) {
        this.context = context;
        this.jugadores = jugadores;
    }

    @Override
    public int getCount() {
        return jugadores.size();
    }

    @Override
    public Jugador getItem(int position) {
        return jugadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_jugador, parent, false);
        }

        Jugador jugador = getItem(position);

        TextView tvNombre = convertView.findViewById(R.id.tvNombreItem);
        TextView tvNacionalidad = convertView.findViewById(R.id.tvNacionalidadItem);
        TextView tvPuntuacion = convertView.findViewById(R.id.tvPuntuacionItem);
        ImageView imgBandera = convertView.findViewById(R.id.imgBanderaItem);

        if (jugador != null) {
            tvNombre.setText(jugador.getNombre());
            tvNacionalidad.setText(jugador.getNacionalidad());
            tvPuntuacion.setText(jugador.getPuntuacion() + " puntos");
            imgBandera.setImageResource(jugador.getBanderaResId());
        }

        return convertView;
    }
}
