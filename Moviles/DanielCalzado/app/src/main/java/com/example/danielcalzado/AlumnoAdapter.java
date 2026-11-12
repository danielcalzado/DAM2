package com.example.danielcalzado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlumnoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Alumno> alumnos;

    public AlumnoAdapter(Context context, ArrayList<Alumno> alumnos) {
        this.context = context;
        this.alumnos = alumnos;
    }

    @Override
    public int getCount() {
        return alumnos.size();
    }

    @Override
    public Alumno getItem(int position) {
        return alumnos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_alumno, parent, false);
        }

        Alumno alumno = getItem(position);

        TextView tvNombre = convertView.findViewById(R.id.tvNombre);
        TextView tvDNI = convertView.findViewById(R.id.tvDNI);
        TextView tvNota = convertView.findViewById(R.id.tvNotaMedia);
        ImageView imgFotoAlumno = convertView.findViewById(R.id.imgFotoAlumno);

        if (alumno != null) {
            tvNombre.setText(alumno.getNombre());
            tvDNI.setText(alumno.getDni());
            tvNota.setText("Nota media: ");
            imgFotoAlumno.setImageResource(alumno.getFotoResld());
        }

        return convertView;
    }
}
