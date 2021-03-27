package com.example.actividad18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListaProductos extends AppCompatActivity {
    public ListView verDatos;
    public ArrayList<String> listaInfoProd;
    public ArrayList<Producto> listaProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);


        desplegar();
    }

    public void x (View view){

        Intent intent = new Intent( this, MainActivity.class);
        startActivity (intent);

            }

    public void desplegar(){
        CrudProducto leer = new CrudProducto( getApplicationContext());
        listaInfoProd = leer.listProduc();
        listaProductos =leer.ListaCompleta();
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaInfoProd);
        verDatos.setAdapter(a);

    } // Cierre Desplegar
}