package com.example.listviewadaptadorpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context miContexto;
    private ArrayList<ModeloPersona> miArrayList;

    public Adaptador(Context miContexto, ArrayList<ModeloPersona> miArrayList) {
        this.miContexto = miContexto;
        this.miArrayList = miArrayList;
    }

    @Override
    public int getCount() {
        //return 0;
        return miArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        //return null;
        return miArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(miContexto);
        convertView=layoutInflater.inflate(R.layout.item, null);
        TextView tvNombre=(TextView) convertView.findViewById(R.id.tvNombre);
        TextView tvDescripcion=(TextView) convertView.findViewById(R.id.tvDescripcion);
        ImageView imgvFoto=(ImageView) convertView.findViewById(R.id.imgvFoto);

        tvNombre.setText(miArrayList.get(position).getNombre());
        tvDescripcion.setText(miArrayList.get(position).getDescripcion());
        imgvFoto.setImageResource(miArrayList.get(position).getFoto());

        return convertView;

        //return null;
    }
}
