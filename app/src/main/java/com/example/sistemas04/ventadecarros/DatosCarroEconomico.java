package com.example.sistemas04.ventadecarros;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by sistemas04 on 10/05/2017.
 */

public class DatosCarroEconomico extends AppCompatActivity {
    private TextView placa,marca,modelo,precio;
    private ArrayList<Carro> carros;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_carro_b);

        res=this.getResources();
        placa=(TextView)findViewById(R.id.txtPlacaCarroEconomico);
        marca=(TextView)findViewById(R.id.txtMarcaCarroEconomico);
        modelo=(TextView)findViewById(R.id.txtModeloCarroEconomico);
        precio=(TextView)findViewById(R.id.txtPrecioCarroEconomico);
        carros=Datos.getCarros();

        if (carros.size()!=0){
            placa.setText(res.getString(R.string.placa)+": "+carros.get(economico()).getPlaca());
            marca.setText(res.getString(R.string.marca)+": "+carros.get(economico()).getMarca());
            modelo.setText(res.getString(R.string.modelo)+": "+String.valueOf(carros.get(economico()).getModelo()));
            precio.setText(res.getString(R.string.precio)+": "+String.valueOf(carros.get(economico()).getPrecio()));
        }else {
            placa.setText(res.getString(R.string.no_hay_registro));
        }
    }

    public int economico(){
        int position=0;
        for (int i=1;i<carros.size();i++){
            if (carros.get(position).getPrecio()>carros.get(i).getPrecio()){
                position=i;
            }
        }
        return position;
    }
}
