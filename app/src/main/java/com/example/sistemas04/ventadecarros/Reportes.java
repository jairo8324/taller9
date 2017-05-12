package com.example.sistemas04.ventadecarros;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * Created by sistemas04 on 10/05/2017.
 */

public class Reportes extends AppCompatActivity {
    private ListView lv;
    private Resources res;
    private String[] op;
    private Intent i;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_reportes);

        carros=Datos.getCarros();



        lv=(ListView)findViewById(R.id.lvReportes);
        res=this.getResources();
        op=res.getStringArray(R.array.lista_reportes);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,op);
        lv.setAdapter(adapter);
        //creamos los casos
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        new AlertDialog.Builder(Reportes.this).setMessage(res.getString(R.string.app_name)+ "= "+String.valueOf(carros.size())).show();
                        break;
                    case 1:
                        new AlertDialog.Builder(Reportes.this).setMessage(marcas()).show();
                        break;
                    case 2:
                        new AlertDialog.Builder(Reportes.this).setMessage(colorC()).show();
                        break;

                }
            }
        }

        );
    }



    public String colorC(){
        String color1,color2,color3,color4,colores,roj,gris1,azu,verd;
        int rojo=0,gris=0,azul=0,verde=0;
        roj=res.getString(R.string.color_uno);
        gris1=res.getString(R.string.color_dos);
        azu=res.getString(R.string.color_tres);
        verd=res.getString(R.string.color_cuatro);;

        for (int i=0;i<carros.size();i++){
            if (carros.get(i).getColor().equals(roj)){rojo=rojo+1;}
            if (carros.get(i).getColor().equals(gris)){ gris=gris+1; }
            if (carros.get(i).getColor().equals(roj)){azul=azul+1;}
            if (carros.get(i).getColor().equals(verd)){verd=verd+1; }
        }

        color1=roj+": "+String.valueOf(rojo)+" ";
        color2=gris+": "+String.valueOf(gris)+" ";
        color3=azu+": "+String.valueOf(azul)+" ";
        color4=verd+": "+String.valueOf(verd);
        colores=color1+color2+color3+color4;
        return colores;
    }


    public String marcas(){
        String marca1,marca2,marca3,marca4,marcas,H1,C1,HON1,M1;
        int honda=0,chevrolet=0,HYUNDAY=0,minicooper=0;
        H1=res.getString(R.string.marca_uno);
        C1=res.getString(R.string.marca_dos);
        HON1=res.getString(R.string.marca_tres);
        M1=res.getString(R.string.marca_cuatro);

        for (int i=0;i<carros.size();i++){
            if (carros.get(i).getMarca().equals(H1)){
                minicooper=minicooper+1;
            }
            if (carros.get(i).getMarca().equals(C1)){
                chevrolet=chevrolet+1;
            }
            if (carros.get(i).getMarca().equals(HON1)){
                HYUNDAY=HYUNDAY+1;
            }
            if (carros.get(i).getMarca().equals(M1)){
                honda=honda+1;
            }
        }

        marca1=H1+": "+String.valueOf(honda)+" ";
        marca2=C1+": "+String.valueOf(chevrolet)+" ";
        marca3=HON1+": "+String.valueOf(HYUNDAY)+" ";
        marca4=M1+": "+String.valueOf(minicooper);
        marcas=marca1+marca2+marca3+marca4;
        return marcas;
    }
}
