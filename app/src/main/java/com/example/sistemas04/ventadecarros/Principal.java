package com.example.sistemas04.ventadecarros;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView ls;
    private Resources res;
    private String[] op;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ls=(ListView)findViewById(R.id.lvOpciones);
        res=this.getResources();



        op=res.getStringArray(R.array.opc_principal);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,op);
        ls.setAdapter(adapter);




        // COLOCAMOS LOS CASOS REGISTRAR LISTRA
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:i=new Intent(Principal.this, Registrar.class);startActivity(i);break;
                    case 1:i=new Intent(Principal.this, ListadeCarros.class);startActivity(i);break;
                    case 2:i=new Intent(Principal.this, Reportes.class);startActivity(i);break;
                }
            }
        }



        );
    }
}
