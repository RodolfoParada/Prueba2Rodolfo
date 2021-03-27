package com.example.actividad18;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


// se declaran las constantes
public class BaseDeDato extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Productos.db";

    private BaseDeDato datos;
    private SQLiteDatabase db;

    public BaseDeDato (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override

      //se crea la tabla para almacenar datos
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ProductContract.ProductoEntry.TABLE_NAME + " ("

                + ProductContract.ProductoEntry.NOMPRODUCTO + " TEXT NOT NULL,"
                + ProductContract.ProductoEntry.NOMPRECIO + " INTEGER NOT NULL)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

}
