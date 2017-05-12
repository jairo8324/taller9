package com.example.sistemas04.ventadecarros;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * Created by sistemas04 on 10/05/2017.
 */
public class Registrar extends AppCompatActivity {

    private Spinner combmarca,combmodelo,combocolor;
    private EditText cajplaca, cajprecio;
    private ArrayAdapter<String> adapter_marca,adapter_modelo,color;
    private String[] op_marca,op_modelo,op_color;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        res=this.getResources();
        cajplaca=(EditText)findViewById(R.id.txtPlaca);
        cajprecio=(EditText)findViewById(R.id.txtPrecio);
        combmarca=(Spinner)findViewById(R.id.cmdMarca);
        combmodelo=(Spinner)findViewById(R.id.cmdModelo);
        combocolor=(Spinner)findViewById(R.id.cmdColor);
        op_marca=res.getStringArray(R.array.opc_marca);
        adapter_marca=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,op_marca);
        op_modelo=res.getStringArray(R.array.opc_modelo);
        adapter_modelo=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,op_modelo);
        op_color=res.getStringArray(R.array.opc_color);
        color=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,op_color);

        combmarca.setAdapter(adapter_marca);        combmodelo.setAdapter(adapter_modelo);        combocolor.setAdapter(color);
    }

    public void registrar(View v){
        //el guardar
        if (validar()){
            String placa,marca,color,foto;
            int modelo,precio;
            placa=cajplaca.getText().toString().trim();
            marca=combmarca.getSelectedItem().toString();
            modelo=Integer.parseInt(combmodelo.getSelectedItem().toString());
            color=combocolor.getSelectedItem().toString();
            precio=Integer.parseInt(cajprecio.getText().toString().trim());


           //colocamos la foto aleatoria
            foto=String.valueOf(fotoAleatoria());

            Carro c=new Carro(foto,placa,marca,modelo,color,precio);
            c.guardar(); new AlertDialog.Builder(this).setMessage(R.string.guardar_registro).show();
            limpiar();
        }
    }





   //colocamos las fotos
        public int fotoAleatoria(){ int fotos[]={R.drawable.imagenes1,R.drawable.imagenes2,R.drawable.imagenes3},numero;


        numero=(int)(Math.random()*3);



            return fotos[numero];
    }

    //validacion
    public boolean validar(){

        if (cajplaca.getText().toString().isEmpty()){ cajplaca.requestFocus(); cajplaca.setError(res.getString(R.string.error_placa));
            return false;
        }
        if (cajprecio.getText().toString().isEmpty()){ cajprecio.requestFocus();cajprecio.setError(res.getString(R.string.error_precio));
            return false;
        }
        return true;
    }




    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        cajplaca.setText("");
        cajprecio.setText("");
        combmarca.setSelection(0);
        combmodelo.setSelection(0);
        combocolor.setSelection(0);
        cajplaca.requestFocus();
    }


}
