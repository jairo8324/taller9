package com.example.sistemas04.ventadecarros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadeCarros extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_de_carros);

        lista=(ListView)findViewById(R.id.lvListadoCarros);
        carros=Datos.getCarros();

        AdaptadorVentaCarro adapter=new AdaptadorVentaCarro(this,carros);
        lista.setAdapter(adapter);
    }
}
