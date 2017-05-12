
package com.example.sistemas04.ventadecarros;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sistemas04 on 10/05/2017.
 */

public class DatosCarroC extends AppCompatActivity {
    private TextView placa,marca,modelo,precio;
    private ArrayList<Carro> carros;
    private Resources res;


    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_c);

        res=this.getResources();
        placa=(TextView)findViewById(R.id.txtPlacaCarroCaro);
        marca=(TextView)findViewById(R.id.txtMarcaCarroCaro);
        modelo=(TextView)findViewById(R.id.txtModeloCarroCaro);
        precio=(TextView)findViewById(R.id.txtPrecioCarroCaro);
        carros=Datos.getCarros();

        if (carros.size()!=0){
            placa.setText(res.getString(R.string.placa)+": "+carros.get(caro()).getPlaca());
            marca.setText(res.getString(R.string.marca)+": "+carros.get(caro()).getMarca());
            modelo.setText(res.getString(R.string.modelo)+": "+String.valueOf(carros.get(caro()).getModelo()));
            precio.setText(res.getString(R.string.precio)+": "+String.valueOf(carros.get(caro()).getPrecio()));
        }else {
            placa.setText(res.getString(R.string.no_hay_registro));
        }
    }

    public int caro(){
        int position=0;
        for (int i=1;i<carros.size();i++){
            if (carros.get(position).getPrecio()<carros.get(i).getPrecio()){
                position=i;
            }
        }
        return position;
    }
}
