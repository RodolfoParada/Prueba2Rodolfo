package com.example.actividad18;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CrudProducto {
    public ListView verDatos;
    // public ArrayList<String> Productos;
    public ArrayList<String> listaInfoProd;
    public ArrayList<Producto> listtaProductos;
    private BaseDeDato Base_datos;
    private SQLiteDatabase db;
    private ContentValues values = new ContentValues();

    public CrudProducto(Context context) {
        Base_datos = new BaseDeDato(context);
    }


    public CrudProducto() {
    }


    public void Guardar(Producto n) {
        db = Base_datos.getWritableDatabase();
        values.clear();
        values.put(ProductContract.ProductoEntry.NOMPRODUCTO, n.getnombreProducto());
        values.put(ProductContract.ProductoEntry.NOMPRECIO, n.getPrecioProducto());
        db.insert(ProductContract.ProductoEntry.TABLE_NAME, null, values);
        //  db.close();
    }

    public void editar(Producto n) {
        db = Base_datos.getWritableDatabase();
        values.clear();
        values.put(ProductContract.ProductoEntry.NOMPRODUCTO, n.getnombreProducto());
        values.put(ProductContract.ProductoEntry.NOMPRECIO, n.getPrecioProducto());
                //db.update(ProductoContract.ProductoEntry.TABLE_NAME, "MARCA=?", new String[]{String.valueOf(n.getMarca())});
        //  db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, new String[]{ProductoContract.ProductoEntry.MARCA});
        // db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, ProductoContract.ProductoEntry.MARCA + "=" + n.getMarca(), null);
        String[] args = new String[]{n.getnombreProducto()};
        db.update(ProductContract.ProductoEntry.TABLE_NAME, values, ProductContract.ProductoEntry.NOMPRODUCTO + "=?", args);
        // db.close();
    }

    public void borrar(String n) {
        db = Base_datos.getWritableDatabase();
        //  values.clear();
        //    values.put(ProductoContract.ProductoEntry.COLOR, n.getColor());
        //   values.put(ProductoContract.ProductoEntry.TALLA, n.getTalla());
        //  values.put(ProductoContract.ProductoEntry.MARCA, n.getMarca());
        //db.update(ProductoContract.ProductoEntry.TABLE_NAME, "MARCA=?", new String[]{String.valueOf(n.getMarca())});
        //  db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, new String[]{ProductoContract.ProductoEntry.MARCA});
        // db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, ProductoContract.ProductoEntry.MARCA + "=" + n.getMarca(), null);
        String[] args1 = new String[]{n};
        db.delete(ProductContract.ProductoEntry.TABLE_NAME, ProductContract.ProductoEntry.NOMPRODUCTO + "=?", args1);
        //   db.close();


    }

    public ArrayList listProduc(){
        ArrayList<String> listaprodu = new ArrayList<>();
        db = Base_datos.getWritableDatabase();
        Cursor registros = db.rawQuery("SELECT * FROM " + ProductContract.ProductoEntry.TABLE_NAME, null);
        if (registros.moveToFirst()){
            do {
                listaprodu.add(registros.getString(0) + "  -  "
                        + String.valueOf (  registros.getString(1)).toString());  // + " " + registro.getString(1))
            }while(registros.moveToNext());
        }
        //db1.close();
        return listaprodu;
    }  // Fin Metodo que Rellena los Nombres

    public ArrayList<Producto> ListaCompleta() {
        ArrayList<Producto> arrayProd = new ArrayList<Producto>();
        db = Base_datos.getWritableDatabase();
        Cursor registros = db.rawQuery("select * from " + ProductContract.ProductoEntry.TABLE_NAME, null);
        if (registros.moveToFirst()) {
            do {
                arrayProd.add(new Producto(registros.getString(0), registros.getInt(1)));
            } while(registros.moveToNext());
        }
        //db1.close();
        return arrayProd;
    }  // Fin del metodo que carga todos los datos


}  //  Fin FuncionesCRUD
