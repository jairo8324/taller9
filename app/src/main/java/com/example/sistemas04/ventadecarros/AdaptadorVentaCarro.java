package com.example.sistemas04.ventadecarros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sistemas04 on 10/05/2017.
 */

public class AdaptadorVentaCarro extends BaseAdapter {
    private Context contexto;
    private ArrayList<Carro> carros;

    public AdaptadorVentaCarro(Context contexto, ArrayList<Carro> carros) {
        this.contexto=contexto;
        this.carros=carros;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        TextView placa,marca,modelo,precio;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;


        inflater=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView=inflater.inflate(R.layout.muestra_carros,null);


        placa=(TextView)itemView.findViewById(R.id.txtPlacaCarro);
        marca=(TextView)itemView.findViewById(R.id.txtMarcaCarro);
        modelo=(TextView)itemView.findViewById(R.id.txtModeloCarro);
        precio=(TextView)itemView.findViewById(R.id.txtPrecioCarro);
        foto=(ImageView)itemView.findViewById(R.id.imgFoto);

        placa.setText(carros.get(position).getPlaca());
        marca.setText(carros.get(position).getMarca());
        modelo.setText(""+carros.get(position).getModelo());
        precio.setText(""+carros.get(position).getPrecio());
        foto.setImageResource(Integer.parseInt(carros.get(position).getFoto()));

        return itemView;
    }
}
