package com.example.actividad18;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   //Declaracion de Variables
    Button Guardar;
    Button mostrar;
    public EditText nomProducto;
    public EditText preProducto;
    BaseDeDato Permiso;
    SQLiteDatabase db;
    public ListView verDatos;
    public ArrayList<String> listaInfoProd;
    public ArrayList<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          //Conversion por cast
        nomProducto = (EditText) findViewById(R.id.etnombre);
        preProducto = (EditText) findViewById(R.id.etproducto);
        verDatos = (ListView) findViewById(R.id.list_Datos);

        Guardar = (Button) findViewById(R.id.Boton2);

        mostrar = (Button) findViewById(R.id.Boton4);

        //este boton inserta informacion
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Producto prod = new Producto();
                CrudProducto Halcon = new CrudProducto(getApplicationContext());

                prod.setnombreProducto(nomProducto.getText().toString());
                prod.setPrecioProducto(Integer.parseInt(preProducto.getText().toString()));

                Halcon.Guardar(prod);

            }
        });
        //muestra los datos de los productos y precios guardador.
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               desplegar();
            }
        });
        // muestra la informacion en el listview
        verDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nomProducto.setText(listaProductos.get(position).getnombreProducto().toString());
                preProducto.setText(String.valueOf(listaProductos.get(position).getPrecioProducto()).toString());
             }
          });
        }
        // busca la informcion en los array list que estan en la clase CrudProducto
        public void desplegar(){
        CrudProducto leer = new CrudProducto( getApplicationContext());
        listaInfoProd = leer.listProduc();
        listaProductos =leer.ListaCompleta();
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaInfoProd);
        verDatos.setAdapter(a);
        limpiar();
        }

    public void limpiar(){
        nomProducto.setText(null);
        preProducto.setText(null);
    }

} //fin