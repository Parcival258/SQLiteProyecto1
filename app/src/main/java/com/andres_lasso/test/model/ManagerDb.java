package com.andres_lasso.test.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ManagerDb {
    //creo una instancia para manejar la base de datos
    private DbHelper dbHelper;

    //creo un constructor
    public ManagerDb(Context context) {
        dbHelper = new DbHelper(context);
    }

    //ahora un metodo para insertar datos en una tabla especifica
    public long insertData(String tabName, int cod, String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cod", cod);
        values.put("name", name);

        //ahora inserto los datos en la tabla
        return db.insert(tabName, null, values);

    }


}