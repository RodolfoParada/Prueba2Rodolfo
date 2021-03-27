package com.example.actividad18;

import android.provider.BaseColumns;

public class ProductContract {

     // se instancian las constantes y la tabla
    public static abstract class ProductoEntry implements BaseColumns {

        public static final String TABLE_NAME ="productos";
        public static final String NOMPRODUCTO  = "NOMPRODUCTO";
        public static final String NOMPRECIO = "NOMPRECIO";

    }
}
