 package com.example.sistemas04.ventadecarros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Modelo extends AppCompatActivity {
    private TableLayout tabla;
    private String aux;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelo);

        tabla=(TableLayout)findViewById(R.id.tblCarros);
        carros=Datos.getCarros();

        for (int i=0;i<carros.size();i++){
            if (carros.get(i).getModelo()>=2010 && carros.get(i).getModelo()<=2015){
                TableRow fila=new TableRow(this);
                TextView c1=new TextView(this);
                TextView c2=new TextView(this);
                TextView c3=new TextView(this);
                TextView c4=new TextView(this);
                TextView c5=new TextView(this);
                int a=0;

                c1.setText(""+(a+1));
                c2.setText(carros.get(i).getPlaca());
                c3.setText(carros.get(i).getMarca());
                c4.setText(String.valueOf(carros.get(i).getModelo()));
                c5.setText(String.valueOf(carros.get(i).getPrecio()));

                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);
                fila.addView(c4);
                fila.addView(c5);

                tabla.addView(fila);
            }
        }
    }
}
